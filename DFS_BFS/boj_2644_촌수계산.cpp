#include <iostream>
#include <queue>
#include <vector>

using namespace std;

const int MAX = 101;
int n, m, start, destination;
int result = 0;

int dist[MAX] = {
    0,
};
vector<int> family[MAX];

int bfs(int start) {
  queue<int> que;
  que.push(start);

  while (!que.empty()) {
    int tmp = que.front();
    que.pop();

    if (tmp == destination)
      return dist[destination];

    for (int i = 0; i < family[tmp].size(); i++) {

      if (!dist[family[tmp][i]]) {
        que.push(family[tmp][i]);
        dist[family[tmp][i]] = dist[tmp] + 1;
      }
    }
  }
  return -1;
}

int main() {
  cin >> n;
  cin >> start >> destination;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int p, c;
    cin >> p >> c;
    family[p].push_back(c);
    family[c].push_back(p);
  }

  cout << bfs(start) << "\n";

  return 0;
}