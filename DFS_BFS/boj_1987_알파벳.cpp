#include <algorithm>
#include <iostream>
#include <string.h>

using namespace std;

const int MAX = 21;

char map[MAX][MAX];
bool visit[26];

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int R, C, result = 0;

void dfs(int y, int x, int path) {

  result = max(path, result);
  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (ny > R || ny <= 0 || nx > C || nx <= 0)
      continue;
    if (!visit[(int)map[ny][nx] - 65]) {
      // 백트래킹
      visit[(int)map[ny][nx] - 65] = true;
      dfs(ny, nx, path + 1);
      visit[(int)map[ny][nx] - 65] = false;
    }
  }
}

int main() {
  cin >> R >> C;
  string temp;
  memset(visit, false, sizeof(visit));

  for (int i = 1; i <= R; i++) {
    cin >> temp;
    for (int j = 1; j <= C; j++) {
      map[i][j] = temp.at(j - 1);
    }
  }

  visit[int(map[1][1]) - 65] = true;
  dfs(1, 1, 1);

  cout << result << endl;
}