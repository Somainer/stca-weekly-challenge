#!/usr/bin/env python3
from pathlib import Path
import requests
import os
import json

TARGET_LANGUAGE = 'scala'
FILE_EXT = 'scala'

REPO = 'https://github.com/Somainer/stca-weekly-challenge/tree/master/'

QUERY_DETAIL = '''
query questionData($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    questionId
    questionFrontendId
    boundTopicId
    title
    titleSlug
    difficulty
    metaData
    isPaidOnly
    codeSnippets {
      lang
      langSlug
      code
      __typename
    }
    __typename
  }
}
'''

root_dir = Path(__file__).absolute().parent.parent

week_dir = None

def make_week_dir(week: int, problem_urls: list):
    global week_dir
    dir_name = f'week{week}'
    week_dir = root_dir / dir_name
    os.mkdir(week_dir)
    week_repo = f'{REPO}week{week}/'
    details = map(get_leetcode_description, problem_urls)
    with open(week_dir / 'README.md', 'w') as f:
        f.write(f'## Week {week}\n\n\n')
        f.write('| # | Title | Source Code | Difficulty |\n|:---:|:---:|:---:|:---:|\n')

        for detail, url in zip(details, problem_urls):
            print(f"#{detail['questionId']}: {detail['title']}")
            if detail['isPaidOnly']:
                print('Is paid only, skipping')
                continue
            code, path = make_problem_dir(detail)
            idx = detail['questionId']
            title = f"[{detail['title']}]({url})"
            source = f"[{code['lang']}]({week_repo + path})"
            difficulty = detail['difficulty']
            f.write(f'|{"|".join(map(lambda s: f" {s} ",[idx, title, source, difficulty]))}|\n')

def retried(n: int):
    import functools
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            nonlocal n
            while True:
                try:
                    return func(*args, **kwargs)
                except Exception as e:
                    if n > 0:
                        n = n - 1
                    else:
                        raise e
        return wrapper
    return decorator

@retried(5)
def fetch_detail_by_slug(slug):
    return requests.post('https://leetcode-cn.com/graphql/', json={
        'operationName': 'questionData',
        'variables': {
            'titleSlug': slug
        },
        'query': QUERY_DETAIL
    }, headers={
        'Referer': f'https://leetcode-cn.com/{slug}/'
    }).json()['data']['question']

def get_leetcode_description(url: str):
    title_slug = [x for x in url.split('/') if x][-1]
    return fetch_detail_by_slug(title_slug)

def get_file_name(detail: dict):
    name = json.loads(detail['metaData'])['name']
    return f'{name}.{FILE_EXT}'

def find_code_snippet(detail: dict, target: str):
    for snippet in detail['codeSnippets']:
        if snippet['lang'] == target or snippet['langSlug'] == target:
            return snippet
    return None

def make_problem_dir(detail: dict):
    dir_name = f"{detail['questionId']}-{detail['titleSlug']}"
    problem_dir = week_dir / dir_name
    os.mkdir(problem_dir)
    file_name = get_file_name(detail)
    code = find_code_snippet(detail, TARGET_LANGUAGE)
    if code is None:
        print(f'Does not support {TARGET_LANGUAGE}, falling back to cpp.')
        code = find_code_snippet(detail, 'cpp')
        stem, _ = file_name.split('.')
        file_name = f'{stem}.cpp'
    with open(problem_dir / file_name, 'w') as f:
        f.write(code['code'])
    return code, f'{dir_name}/{file_name}'

if __name__ == "__main__":
    from week2 import week_num, problem_urls

    make_week_dir(week_num, problem_urls)
    