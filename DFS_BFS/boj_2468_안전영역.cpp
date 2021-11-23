#include <algorithm>
#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

const int MAX = 101;
int n, maxHeight = 0, lowHeight = 101, result = 1;

int map[MAX][MAX];
int temp[MAX][MAX];
bool visited[MAX][MAX];

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

void copy() {
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      temp[i][j] = map[i][j];
}

void dfs(int y, int x, int height) {
  temp[y][x] = MAX;
  visited[y][x] = true;

  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (ny >= 1 && ny <= n && nx >= 1 && ny <= n && !visited[ny][nx] &&
        map[ny][nx] > height)
      dfs(ny, nx, height);
  }
}

int main() {
  cin >> n;

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      cin >> map[i][j];
      lowHeight = min(lowHeight, map[i][j]);
      maxHeight = max(maxHeight, map[i][j]);
    }
  }

  for (int h = 0; h < maxHeight; h++) {
    int cnt = 0;
    memset(visited, false, sizeof(visited));
    copy();

    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++)
        if (!visited[i][j] && map[i][j] > h) {
          dfs(i, j, h);
          cnt++;
        }
    result = max(result, cnt);
  }
  cout << result << endl;
  return 0;
}