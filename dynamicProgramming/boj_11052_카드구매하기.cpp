#include <iostream>

using namespace std;

const int MAX = 1001;
int n;
int dp[MAX], card[MAX];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> card[i];
  }
  dp[1] = card[1];
  for (int i = 2; i <= n; i++) {
    for (int j = 0; j < i; j++) {
      dp[i] = max(dp[i], dp[j] + card[i - j]);
    }
  }
  cout << dp[n] << "\n";
}