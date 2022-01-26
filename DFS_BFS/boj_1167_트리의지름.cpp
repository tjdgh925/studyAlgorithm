#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 100001;
int N, maxDist, maxNode;
;

struct Node {
  int index;
  int distance;
};

bool visit[MAX];
vector<Node> tree[MAX];

void dfs(int idx, int dist) {
  if (visit[idx])
    return;

  if (maxDist < dist) {
    maxDist = dist;
    maxNode = idx;
  }
  visit[idx] = true;

  for (int i = 0; i < tree[idx].size(); i++) {
    int next = tree[idx][i].index;
    int nextDist = tree[idx][i].distance;
    dfs(next, dist + nextDist);
  }
}

int main() {
  cin >> N;

  for (int i = 0; i < N; i++) {
    int n, p, d;
    cin >> n;
    while (1) {
      cin >> p;
      if (p == -1)
        break;
      cin >> d;
      tree[n].push_back({p, d});
    }
  }
  dfs(1, 0);
  memset(visit, false, sizeof(visit));
  maxDist = 0;
  dfs(maxNode, 0);

  cout << maxDist;
}