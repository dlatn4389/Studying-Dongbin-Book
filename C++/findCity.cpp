#include <iostream>
using namespace std;
#include <vector>
#include <queue>

vector<int> graph[300001];
int cities[300001] = {0,};
int visited[300001];

void bfs(int X) {
    visited[X] = true;
    queue<int> q;
    q.push(X);

    while (!q.empty()) {
        int k = q.front();
        q.pop();

        for (int i : graph[k]) {
            if (!visited[i]) {
                visited[i] = true;
                cities[i] = cities[k]+1;
                q.push(i);
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K, X;
    cin >> N >> M >> K >> X;

    while (M--) {
        int from, to;
        cin >> from >> to;
        graph[from].push_back(to);
    }

    bfs(X);

    int num = 0;
    for (int i=1; i<=N; i++) {
        if (cities[i]==K) num++;
    }

    if (num==0) {
        cout << -1;
        return 0;
    }
    for (int i=1; i<=N; i++) {
        if (cities[i]==K) {
            cout << i << " ";
        }
    }
}

