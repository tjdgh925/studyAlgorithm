#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;
int N, M, sizeBoard;
vector<vector<int>> rotate(vector<vector<int>> board) {
  int sizeB = board[0].size();
  vector<vector<int>> temp(sizeB, vector<int>(sizeB, 0));

  for (int i = 0; i < M; i++) {
    for (int j = 0; j < M; j++) {
      temp[i][j] = board[M - j - 1][i];
    }
  }

  return temp;
}
bool putKey(int x, int y, vector<vector<int>> key, vector<vector<int>> board) {

  for (int i = x; i < x + M; i++) {
    for (int j = y; j < y + M; j++) {
      board[i][j] += key[i - x][j - y];
    }
  }

  for (int i = M - 1; i <= sizeBoard - M; i++) {
    for (int j = M - 1; j <= sizeBoard - M; j++) {
      if (board[i][j] == 1)
        continue;

      return false;
    }
  }

  return true;
}
bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
  bool answer = false;
  M = key.size();
  N = lock.size();
  sizeBoard = N + (M - 1) * 2;
  vector<vector<int>> board(sizeBoard, vector<int>(sizeBoard, 0));

  for (int i = M - 1; i <= sizeBoard - M; i++) {
    for (int j = M - 1; j <= sizeBoard - M; j++) {
      board[i][j] = lock[i - M + 1][j - M + 1];
    }
  }

  for (int k = 0; k < 4; k++) {
    for (int i = 0; i <= sizeBoard - M; i++) {
      for (int j = 0; j <= sizeBoard - M; j++) {

        if (putKey(i, j, key, board)) {
          answer = true;
          return answer;
        }
      }
    }

    key = rotate(key);
  }

  return answer;
}

int main() {
  vector<vector<int>> key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
  vector<vector<int>> lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
  cout << solution(key, lock);
}