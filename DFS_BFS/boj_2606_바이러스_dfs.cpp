#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int n, m;
int result = 0;

void dfs(int start, vector<int> graph[], bool check[]) {
  check[start] = true;

  for (int i = 0; i < graph[start].size(); i++) {

    if (check[graph[start][i]] == false) {
      dfs(graph[start][i], graph, check);
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

  dfs(1, graph, check);

  for (int i = 1; i <= n; i++) {
    if (check[i] == true)
      result++;
  }
  cout << result - 1 << endl;

  return 0;
}