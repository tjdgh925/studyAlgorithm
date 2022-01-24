#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 20001;

int K, V, E;
vector<int> graph[MAX];
int visited[MAX];

void dfs(int start) {
  if (!visited[start])
    visited[start] = 1;

  for (int i = 0; i < graph[start].size(); i++) {
    int next = graph[start][i];

    if (!visited[next]) {
      if (visited[start] == 1)
        visited[next] = 2;
      else if (visited[start] == 2)
        visited[next] = 1;
      dfs(next);
    }
  }
}

bool isBipartiteGraph() {
  for (int i = 1; i <= V; i++) {
    for (int j = 0; j < graph[i].size(); j++) {
      int next = graph[i][j];
      if (visited[i] == visited[next])
        return 0;
    }
  }
  return 1;
}

int main() {
  cin >> K;
  for (int i = 0; i < K; i++) {
    cin >> V >> E;
    for (int j = 0; j < E; j++) {
      int u, v;
      cin >> u >> v;
      graph[u].push_back(v);
      graph[v].push_back(u);
    }

    for (int k = 1; k <= V; k++)
      if (!visited[k])
        dfs(k);

    if (isBipartiteGraph())
      printf("YES\n");
    else
      printf("NO\n");

    for (int i = 0; i <= V; i++)
      graph[i].clear();

    memset(visited, false, sizeof(visited));
  }
}