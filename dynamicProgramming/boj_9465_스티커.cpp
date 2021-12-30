#include <iostream>

using namespace std;

const int MAX = 100001;
int T, N;
int stickers[2][MAX];
int dp[2][MAX];

int main() {

  cin >> T;
  for (int i = 0; i < T; i++) {
    cin >> N;
    for (int j = 0; j < 2; j++) {
      for (int k = 0; k < N; k++) {
        cin >> stickers[j][k];
      }
    }
    dp[0][0] = stickers[0][0];
    dp[1][0] = stickers[1][0];
    dp[0][1] = dp[1][0] + stickers[0][1];
    dp[1][1] = dp[0][0] + stickers[1][1];
    for (int j = 2; j < N; j++) {
      dp[0][j] = max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
      dp[1][j] = max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
    }
    cout << max(dp[0][N - 1], dp[1][N - 1]) << "\n";
  }
}
