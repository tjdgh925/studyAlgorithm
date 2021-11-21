#include <algorithm>
#include <iostream>
#include <queue>
#include <stdio.h>
#include <vector>

using namespace std;

void dfs(int start, vector<int> graph[], bool check[]) {
  check[start] = true;
  cout << start << " ";

  for (int i = 0; i < graph[start].size(); i++) {
    int next = graph[start][i];

    if (check[next] == false) {
      dfs(next, graph, check);
    }
  }
}

void bfs(int start, vector<int> graph[], bool check[]) {
  queue<int> que;

  que.push(start);
  check[start] = true;

  while (!que.empty()) {
    int tmp = que.front();
    que.pop();
    cout << tmp << " ";

    for (int i = 0; i < graph[tmp].size(); i++) {
      if (check[graph[tmp][i]] == false) {

        que.push(graph[tmp][i]);
        check[graph[tmp][i]] = true;
      }
    }
  }
}

int main() {
  int n, m, start;
  cin >> n >> m >> start;
  vector<int> graph[n + 1];

  bool DFS[n + 1];
  bool BFS[n + 1];
  fill(DFS, DFS + n + 1, false);
  fill(BFS, BFS + n + 1, false);

  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;

    graph[u].push_back(v);
    graph[v].push_back(u);
  }

  for (int i = 1; i <= n; i++) {
    sort(graph[i].begin(), graph[i].end());
  }

  dfs(start, graph, DFS);
  cout << endl;
  bfs(start, graph, BFS);
  cout << endl;

  return 0;
}