#!/usr/bin/env python3
from pathlib import Path
import requests
import os
import json
from typing import Union

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

        for detail in details:
            idx = detail['questionFrontendId']
            print(f"#{idx}: {detail['title']}")
            if detail['isPaidOnly']:
                print('Is paid only, skipping')
                continue
            code, path = make_problem_dir(detail)
            slug = detail['titleSlug']
            url = f'https://leetcode-cn.com/problems/{slug}/'
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

PROBLEM_CACHE = None
@retried(5)
def fetch_all_problems():
    global PROBLEM_CACHE
    if PROBLEM_CACHE:
        return PROBLEM_CACHE
    result = requests.get('https://leetcode-cn.com/api/problems/all/').json()['stat_status_pairs']
    
    PROBLEM_CACHE = {
        q['stat']['frontend_question_id']: {
            'id': q['stat']['frontend_question_id'],
            'slug': q['stat']['question__title_slug'],
        }
        for q in result
    }
    return PROBLEM_CACHE

@retried(5)
def fetch_detail_by_id(idx: int):
    slug = fetch_all_problems()[str(idx)]['slug']
    return fetch_detail_by_slug(slug)

def get_leetcode_description(url: Union[str, int]):
    if isinstance(url, str):
        title_slug = [x for x in url.split('/') if x][-1]
        return fetch_detail_by_slug(title_slug)
    else:
        return fetch_detail_by_id(url)

def get_file_name(detail: dict):
    meta_data = json.loads(detail['metaData'])
    name = meta_data.get('name', meta_data.get('classname', detail['title'].replace(' ', '').capitalize()))
    return f'{name}.{FILE_EXT}'

def find_code_snippet(detail: dict, target: str):
    for snippet in detail['codeSnippets']:
        if snippet['lang'] == target or snippet['langSlug'] == target:
            return snippet
    return None

def make_problem_dir(detail: dict):
    dir_name = f"{detail['questionFrontendId']}-{detail['titleSlug']}"
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
    # from week3 import week_num, problem_urls
    week_num = 1 # type: Int
    problem_urls = [] # type: List[Union[str, int]]

    make_week_dir(week_num, problem_urls)
    