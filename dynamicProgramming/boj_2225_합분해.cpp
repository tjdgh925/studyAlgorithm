#include <iostream>

using namespace std;

const int MAX = 201;
const int mod = 1000000000;
int N, K;
long long dp[MAX][MAX];

int main() {
  cin >> N >> K;

  for (int i = 0; i <= N; i++) {
    dp[1][i] = 1;
  }
  for (int i = 2; i <= K; i++) {
    for (int j = 0; j <= N; j++) {
      for (int k = 0; k <= j; k++) {
        dp[i][j] = dp[i][j] + dp[i - 1][k];
      }
      dp[i][j] %= mod;
    }
  }
  cout << dp[K][N] << "\n";
}