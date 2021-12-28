#include <iostream>

using namespace std;

int dp[100001][11] = {};
int main() {
  int T;
  cin >> T;
  for (int i = 0; i < T; i++) {
    int n;
    cin >> n;
    dp[n][1] = 1;
    dp[n][2] = 2;
    dp[n][3] = 4;
    for (int i = 4; i <= n; i++) {
      dp[n][i] = (dp[n][i - 1] + dp[n][i - 2] + dp[n][i - 3]) % 10007;
    }
    cout << dp[n][n] << "\n";
  }
}