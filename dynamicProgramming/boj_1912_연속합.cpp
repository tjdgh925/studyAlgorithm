
#include <iostream>

using namespace std;

const int MAX = 100001;

int n;
int dp[MAX], seq[MAX], result = -1001;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> seq[i];
    dp[i] = seq[i];
  }

  for (int i = 0; i < n; i++) {
    dp[i] = max(dp[i], dp[i - 1] + seq[i]);
    dp[i] = max(dp[i], seq[i - 1] + seq[i]);

    result = max(result, dp[i]);
  }

  cout << result << "\n";
}
