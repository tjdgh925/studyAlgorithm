#include <iostream>

using namespace std;

const int MAX = 100001;

int n, dp[MAX];

int main() {
  cin >> n;

  for (int i = 1; i <= n; i++) {
    dp[i] = i;
    for (int j = 1; j * j <= i; j++) {
      dp[i] = min(dp[i], dp[i - j * j] + 1);
    }
  }

  cout << dp[n] << "\n";
}