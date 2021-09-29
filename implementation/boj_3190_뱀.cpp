#include <deque>
#include <iostream>
#include <vector>

using namespace std;

struct Coordinate {
  int second;
  char direction;
};

int N, K, L;
int board[101][101];
vector<Coordinate> rotation;
deque<pair<int, int>> dq;
int dy[4] = {0, -1, 0, 1};
int dx[4] = {1, 0, -1, 0};
Coordinate temp;
int main() {
  cin >> N;
  cin >> K;
  for (int i = 1; i <= K; i++) {
    int tempA;
    int tempB;
    cin >> tempA >> tempB;
    board[tempA][tempB] = 1;
  }
  cin >> L;
  for (int i = 1; i <= L; i++) {
    int s;
    char d;
    cin >> s >> d;
    temp.second = s;
    temp.direction = d;
    rotation.push_back(temp);
  }

  int count = 0;
  int time = 0;
  int xy = 0;
  int x = 1, y = 1;
  dq.push_back({y, x});
  board[y][x] = 2;
  while (1) {
    count++;
    int bx = x;
    int by = y;
    x = x + dx[xy];
    y = y + dy[xy];
    if (x < 1 || x > N || y < 1 || y > N || board[y][x] == 2)
      break;
    else if (board[y][x] == 0) {
      board[y][x] = 2;
      board[dq.back().first][dq.back().second] = 0;
      dq.pop_back();
      dq.push_front({y, x});
    } else if (board[y][x] == 1) {
      board[y][x] = 2;
      dq.push_front({y, x});
    }
    if (time < rotation.size()) {
      if (count == rotation[time].second) {
        if (rotation[time].direction == 'L')
          xy = (xy + 1) % 4;
        else if (rotation[time].direction == 'D')
          xy = (xy + 3) % 4;
        time++;
      }
    }
  }

  cout << count;
}