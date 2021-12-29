#include <iostream>

using namespace std;

int dp[1001][11];
const int mod = 10007;

int main() {
  int n;
  long long result = 0;
  cin >> n;

  for (int i = 0; i <= 9; i++)
    dp[1][i] = 1;

  for (int i = 2; i <= n; i++)
    for (int j = 0; j <= 9; j++)
      for (int k = 0; k <= j; k++) {
        dp[i][j] += dp[i - 1][k];
        dp[i][j] %= mod;
      }

  for (int i = 0; i <= 9; i++) {
    result += dp[n][i];
  }

  cout << result % mod << "\n";
}