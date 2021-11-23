#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int n, m, cnt = 0;

void dfs(int start, vector<int> graph[], bool check[]) {
  check[start] = true;

  for (int i = 0; i < graph[start].size(); i++) {
    int next = graph[start][i];

    if (check[next] == false)
      dfs(next, graph, check);
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
        dfs(i, graph, check);
        cnt++;
      } else
        flag--;
    }
  }

  cout << cnt << endl;

  return 0;
}