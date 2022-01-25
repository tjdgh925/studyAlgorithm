#include <algorithm>
#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 26;

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};
int map[MAX][MAX];
int N, cnt;
vector<int> result;

void dfs(int x, int y) {
  map[x][y] = 0;
  cnt++;

  for (int i = 0; i < 4; i++) {
    int nextX = x + dx[i];
    int nextY = y + dy[i];

    if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1)
      continue;
    if (map[nextX][nextY] != 0) {
      dfs(nextX, nextY);
    }
  }
}

int main() {
  cin >> N;
  memset(map, 0, sizeof(map));
  for (int i = 0; i < N; i++) {
    string temp;
    cin >> temp;
    for (int j = 0; j < N; j++) {
      map[i][j] = temp[j] - '0';
    }
  }
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      if (map[i][j] != 0) {
        cnt = 0;
        dfs(i, j);
        result.push_back(cnt);
      }
    }
  }

  sort(result.begin(), result.end());
  cout << result.size() << "\n";
  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << "\n";
  }
}