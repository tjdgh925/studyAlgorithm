#include <iostream>

using namespace std;

const int MAX = 31;
int n, dp[MAX];

int main() {
  cin >> n;

  dp[0] = 1;
  dp[2] = 3;
  if (n % 2 == 0) {
    for (int i = 4; i <= n; i += 2) {
      dp[i] = 3 * dp[i - 2];
      for (int j = 4; i - j >= 0; j += 2) {
        dp[i] += dp[i - j] * 2;
      }
    }
  }

  cout << dp[n] << "\n";
}