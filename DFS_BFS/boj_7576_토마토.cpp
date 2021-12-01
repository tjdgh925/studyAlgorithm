#include <iostream>
#include <queue>
#include <string.h>

using namespace std;

const int MAX = 1001;
int m, n, cnt = 1;
int result = 0;

int box[MAX][MAX];
int dist[MAX][MAX];

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

struct tomato {
  int y, x;
};
queue<tomato> que;

void bfs() {
  while (!que.empty()) {
    int y = que.front().y;
    int x = que.front().x;
    que.pop();

    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (nx < 0 || nx >= m || ny < 0 || ny >= n)
        continue;
      if (box[ny][nx] == 0 && dist[ny][nx] == -1) {
        que.push({ny, nx});
        dist[ny][nx] = dist[y][x] + 1;
      }
    }
  }
}

int main() {
  cin >> m >> n;
  int x, y;

  memset(dist, -1, sizeof(dist));

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> box[i][j];
      if (box[i][j] == 1) {
        que.push({i, j});
        dist[i][j] = 0;
      }
    }
  }

  bfs();

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      result = max(result, dist[i][j]);
      if (box[i][j] == 0 && dist[i][j] == -1) {
        cout << -1 << "\n";
        return 0;
      }
    }
  }

  cout << result << "\n ";
  return 0;
}