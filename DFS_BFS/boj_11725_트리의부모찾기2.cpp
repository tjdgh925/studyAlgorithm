
#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 100001;

int N;
bool visit[MAX];
int parent[MAX];
vector<int> tree[MAX];

void dfs(int idx) {
  visit[idx] = true;

  for (int i = 0; i < tree[idx].size(); i++) {
    int next = tree[idx][i];

    if (!visit[next]) {
      parent[next] = idx;
      dfs(next);
    }
  }
}

int main() {
  cin >> N;
  for (int i = 0; i < N - 1; i++) {
    int a, b;
    cin >> a >> b;
    tree[a].push_back(b);
    tree[b].push_back(a);
  }
  memset(visit, false, sizeof(visit));

  dfs(1);

  for (int i = 2; i <= N; i++) {
    cout << parent[i] << "\n";
  }
}