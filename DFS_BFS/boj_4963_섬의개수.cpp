#include <cstring>
#include <iostream>

using namespace std;

const int MAX = 51;
int map[MAX][MAX];
int W, H, cnt;
int dx[] = {-1, 0, 1, 1, 1, 0, -1, -1};
int dy[] = {1, 1, 1, 0, -1, -1, -1, 0};

void dfs(int y, int x) {
  map[y][x] = 0;

  for (int i = 0; i < 8; i++) {
    int nextY = y + dy[i];
    int nextX = x + dx[i];

    if (nextX < 0 || nextY < 0 || nextX > W - 1 || nextY > H - 1)
      continue;
    if (map[nextY][nextX] != 0)
      dfs(nextY, nextX);
  }
}

int main() {
  while (1) {
    cin >> W >> H;
    if (W == 0 && H == 0)
      break;
    cnt = 0;
    memset(map, 0, sizeof(map));
    for (int i = 0; i < H; i++)
      for (int j = 0; j < W; j++)
        cin >> map[i][j];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (map[i][j] != 0) {
          dfs(i, j);
          cnt++;
        }
      }
    }
    cout << cnt << "\n";
  }
}