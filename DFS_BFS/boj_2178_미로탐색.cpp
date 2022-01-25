#include <iostream>
#include <queue>

using namespace std;

const int MAX = 101;
int N, M;
int maze[MAX][MAX];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
struct XY {
  int y, x;
};
queue<XY> que;

void bfs(int y, int x) {
  que.push({y, x});
  while (!que.empty()) {
    int y = que.front().y;
    int x = que.front().x;
    que.pop();

    for (int i = 0; i < 4; i++) {
      int nextY = y + dy[i];
      int nextX = x + dx[i];

      if (nextX < 0 || nextY < 0 || nextX > M - 1 || nextY > N - 1)
        continue;
      if (maze[nextY][nextX] == 1) {
        que.push({nextY, nextX});
        maze[nextY][nextX] = maze[y][x] + 1;
      }
    }
  }
}

int main() {
  cin >> N >> M;
  for (int i = 0; i < N; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < M; j++)
      maze[i][j] = s[j] - '0';
  }
  bfs(0, 0);

  cout << maze[N - 1][M - 1];
}