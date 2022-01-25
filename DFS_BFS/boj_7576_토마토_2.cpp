#include <cstring>
#include <iostream>
#include <queue>

using namespace std;

const int MAX = 1001;

int M, N;
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
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      if (nextX < 0 || nextX > M - 1 || nextY < 0 || nextY > N - 1)
        continue;
      if (dist[nextY][nextX] == -1 && box[nextY][nextX] == 0) {
        que.push({nextY, nextX});
        dist[nextY][nextX] = dist[y][x] + 1;
      }
    }
  }
}
int main() {
  cin >> M >> N;

  memset(dist, -1, sizeof(dist));
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      cin >> box[i][j];
      if (box[i][j] == 1) {
        que.push({i, j});
        dist[i][j] = 0;
      }
    }
  }

  bfs();

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      if (dist[i][j] == -1 && box[i][j] == 0) {
        cout << -1;
        return 0;
      }
      result = max(result, dist[i][j]);
    }
  }

  cout << result;
}