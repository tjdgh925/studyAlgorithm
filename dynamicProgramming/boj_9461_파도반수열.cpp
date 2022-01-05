#include <iostream>

using namespace std;

const int MAX = 101;
long long dp[MAX];
int T, n;

int main() {
  cin >> T;

  dp[1] = 1;
  dp[2] = 1;
  dp[3] = 1;
  for (int i = 4; i < MAX; i++) {
    dp[i] = dp[i - 3] + dp[i - 2];
  }
  for (int i = 0; i < T; i++) {
    cin >> n;
    cout << dp[n] << "\n";
  }
}