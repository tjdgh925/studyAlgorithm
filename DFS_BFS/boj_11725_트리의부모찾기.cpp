#include <iostream>
#include <vector>
using namespace std;

const int MAX = 100001;

int N;
bool visit[MAX];
int parent[MAX];
vector<int> tree[MAX];

void dfs(int start) {
  visit[start] = true;

  for (int i = 0; i < tree[start].size(); i++) {
    int next = tree[start][i];

    if (!visit[next]) {
      parent[next] = start;
      dfs(next);
    }
  }
}

int main() {

  ios_base::sync_with_stdio(0);
  cin.tie(0);

  cin >> N;

  for (int i = 0; i < N - 1; i++) {
    int x, y;
    cin >> x >> y;
    tree[x].push_back(y);
    tree[y].push_back(x);
  }

  dfs(1);

  for (int i = 2; i <= N; i++) {
    cout << parent[i] << "\n";
    // endl 사용시에 시간 초과 발생!!
  }
  return 0;
}