class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> result(num + 1, 0);
        int highBit = 0;
        for (int i = 1; i <= num; ++i) {
            if ((i & -i) == i) {
                highBit = i;
                result[i] = 1;
            } else result[i] = result[i & ~highBit] + 1;
        }
        return result;
    }
};