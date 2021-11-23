#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int n, m;
int result = 0;

void bfs(int start, vector<int> graph[], bool check[]) {
  queue<int> que;

  que.push(start);
  check[start] = true;

  while (!que.empty()) {
    int tmp = que.front();
    que.pop();

    for (int i = 0; i < graph[tmp].size(); i++) {
      if (check[graph[tmp][i]] == false) {
        que.push(graph[tmp][i]);
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
    int a, b;
    cin >> a >> b;

    graph[a].push_back(b);
    graph[b].push_back(a);
  }

  for (int i = 1; i <= n; i++) {
    sort(graph[i].begin(), graph[i].end());
  }

  bfs(1, graph, check);

  for (int i = 1; i <= n; i++) {
    if (check[i] == true)
      result++;
  }
  cout << result - 1 << endl;

  return 0;
}