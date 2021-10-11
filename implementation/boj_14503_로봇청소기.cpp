#include <iostream>

using namespace std;

int N, M, r, c, d;
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, -0, -1};

int main() {

  cin >> N >> M;
  cin >> r >> c >> d;
  int arr[N][M];

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      cin >> arr[i][j];
      if (i == r && j == c)
        arr[i][j] = 2;
    }
  }

  while (1) {
  }
}