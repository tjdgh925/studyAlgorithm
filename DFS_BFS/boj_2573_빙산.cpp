#include <algorithm>
#include <iostream>
#include <string.h>
#include <vector>

using namespace std;

int n, m;
bool visit[301][301];
int map[301][301];

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

void dfs(int y, int x) {
  visit[y][x] = true;

  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (map[ny][nx] < 0)
      map[ny][nx] = 0;
    if (ny < 0 || nx < 0 || ny >= n || nx >= m)
      continue;
    if (!map[ny][nx] || visit[ny][nx])
      continue;
    dfs(ny, nx);
  }
}

void melt(int y, int x) {
  int melting = 0;
  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    if (nx < 0 || nx >= m || ny < 0 || ny >= n)
      continue;
    if (map[ny][nx] == 0)
      melting++;
  }

  int value = map[y][x] - melting;
  if (value == 0)
    map[y][x] = -1;
  else
    map[y][x] -= melting;
}

int main() {

  cin >> n >> m;

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> map[i][j];
    }
  }

  int result = 0;
  while (1) {
    result++;
    int ice = 0;
    memset(visit, false, sizeof(visit));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] != 0)
          melt(i, j);
        if (map[i][j] > 0)
          ice++;
      }
    }
    if (ice == 0) {
      cout << 0;
      return 0;
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] < 0)
          map[i][j] = 0;
        if (map[i][j] == 0 || visit[i][j])
          continue;
        cnt++;
        dfs(i, j);
      }
    }

    if (cnt > 1) {
      cout << result << endl;
      return 0;
    }
  }
}