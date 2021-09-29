#include <iostream>
#include <vector>

using namespace std;

struct Coordinate {
  int second;
  char direction;
};

int N, K, L;
bool board[101][101];
vector<Coordinate> rotation;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
Coordinate temp;
int main() {
  cin >> N;
  cin >> K;
  for (int i = 1; i <= K; i++) {
    int tempA;
    int tempB;
    cin >> tempA >> tempB;
    board[tempA][tempB] = true;
  }
  cin >> L;
  for (int i = 0; i < L; i++) {
    int s;
    char d;
    cin >> s >> d;
    temp.second = s;
    temp.direction = d;
    rotation.push_back(temp);
  }
  temp = rotation[0];

  bool flag = true;
  int count = 0;
  int xy = 0;
  int x = 1, y = 1;
  while (flag) {
    count++;
    if (count == temp.second && temp.direction == 'D') {
      xy += 1;
    } else if (count == temp.second && temp.direction == 'L') {
      xy -= 1;
    }
    if (x + dx[xy] < 1 || x + dx[xy] > K || y + dy[xy] < 1 || y + dy[xy] > K)
      flag = false;
    if (board[x + dx[xy]][y + dy[xy]] == 1) {
      board[x + dx[xy]][y + dy[xy]] = true;
    } else {
      board[x][y] = false;
      board[x + dx[xy]][y + dy[xy]] = true;
    }
    x = x + dx[xy];
    y = y + dy[xy];
    xy = xy % 4;
  }

  cout << count;
}