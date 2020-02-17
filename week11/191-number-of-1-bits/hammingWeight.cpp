class Solution {
public:
    int hammingWeight(uint32_t n) {
        int c = 0;
        for(; n; ++c) n ^= (n & -n);
        return c;
    }
};