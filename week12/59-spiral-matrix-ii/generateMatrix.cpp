class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> board(n, vector<int>(n));
        int g = 1;
        for (int up = 0, down = n - 1; up < n; ++up, --down) {
            for (int i = up; i <= down; ++i) board[up][i] = g++;
            for (int i = up + 1; i <= down; ++i) board[i][down] = g++;
            for (int i = down - 1; i >= up; --i) board[down][i] = g++;
            for (int i = down - 1; i > up; --i) board[i][up] = g++;
        }
        return board;
    }
};
