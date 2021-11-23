#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n, m, cnt = 0;

void bfs(int start, vector<int> graph[], bool check[]) {
  queue<int> q;

  q.push(start);
  check[start] = true;

  while (!q.empty()) {
    int tmp = q.front();
    q.pop();

    for (int i = 0; i < graph[tmp].size(); i++) {
      if (check[graph[tmp][i]] == false) {
        q.push(graph[tmp][i]);
        check[graph[tmp][i]] = true;
      }
    }
  }
}

int main() {
  cin >> n >> m;

  vector<int> graph[n + 1];

  bool check[n + 1];
  fill(check, check + n + 1, false);

  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    graph[u].push_back(v);
    graph[v].push_back(u);
  }

  for (int i = 1; i <= n; i++) {
    sort(graph[i].begin(), graph[i].end());
  }

  int flag = n + 1;
  while (flag >= 0) {
    for (int i = 1; i < n + 1; i++) {
      if (check[i] == false) {
        bfs(i, graph, check);
        cnt++;
      } else
        flag--;
    }
  }

  cout << cnt << endl;

  return 0;
}