#include <cstring>
#include <iostream>
#include <math.h>
#include <queue>

using namespace std;
const int MAX = 101;
int map[MAX][MAX];
int dist[MAX][MAX];
int N, idx = 2;
int result = int(1e9);
struct Coordinate {
  int y, x;
};

queue<Coordinate> que;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

void dfs(int y, int x) {
  map[y][x] = idx;

  for (int i = 0; i < 4; i++) {
    int nextY = y + dy[i];
    int nextX = x + dx[i];

    if (nextX < 0 || nextY < 0 || nextX > N - 1 || nextY > N - 1)
      continue;

    if (map[nextY][nextX] == 1) {
      dfs(nextY, nextX);
    }
  }
}

void bfs(int idx) {
  memset(dist, -1, sizeof(dist));
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      if (map[i][j] == idx) {
        que.push({i, j});
        dist[i][j] = 0;
      }
    }
  }

  while (!que.empty()) {
    int y = que.front().y;
    int x = que.front().x;
    que.pop();

    for (int i = 0; i < 4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1)
        continue;
      if (map[nextY][nextX] != idx && map[nextY][nextX]) {
        result = min(result, dist[y][x]);
      }
      if (dist[nextY][nextX] == -1 && !map[nextY][nextX]) {
        dist[nextY][nextX] = dist[y][x] + 1;
        que.push({nextY, nextX});
      }
    }
  }
}

int main() {
  cin >> N;
  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      cin >> map[i][j];

  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      if (map[i][j] == 1) {
        dfs(i, j);
        idx++;
      }

  for (int i = 2; i < idx; i++)
    bfs(i);

  cout << result;
}