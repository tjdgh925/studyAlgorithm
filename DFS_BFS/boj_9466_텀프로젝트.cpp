#include <cstring>
#include <iostream>
#include <vector>

using namespace std;
const int MAX = 100001;

int T, N, cnt = 0;
int team[MAX];
bool visited[MAX];
bool done[MAX];

void dfs(int start) {
  visited[start] = true;
  int next = team[start];
  if (!visited[next])
    dfs(next);
  else {
    if (!done[next]) {
      for (int i = next; i != start; i = team[i])
        cnt++;
      cnt++;
    }
  }
  done[start] = true;
}

int main() {
  cin >> T;
  for (int i = 0; i < T; i++) {
    cin >> N;
    cnt = 0;
    memset(visited, false, sizeof(visited));
    memset(done, false, sizeof(done));
    for (int j = 1; j <= N; j++)
      cin >> team[j];
    for (int j = 1; j <= N; j++) {
      if (!visited[j])
        dfs(j);
    }
    cout << N - cnt << "\n";
  }
}