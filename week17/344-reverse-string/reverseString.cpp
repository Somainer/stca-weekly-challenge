class Solution {
public:
    void reverseString(vector<char>& s) {
        for (auto first = s.begin(), last = s.end(); first != last && first != --last; ++first)
            iter_swap(first, last);
    }
};