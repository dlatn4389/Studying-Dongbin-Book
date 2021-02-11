#include <iostream>
using namespace std;

char board[1000][1000];
int N, M;

bool dfs(int row, int col) {
    if (row<0 || col<0 || row>=N || col>=M) return false;

    if (board[row][col]=='0') {
        board[row][col] = '1';
        dfs(row-1, col);
        dfs(row+1, col);
        dfs(row, col-1);
        dfs(row, col+1);
        return true;
    }
    return false;
}

int main() {
    cin >> N >> M;

    for (int i=0; i<N; i++) {
        cin >> board[i];
    }

    int answer = 0;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (dfs(i, j)) {
                answer++;
            }
        }
    }

    cout << answer;
}
