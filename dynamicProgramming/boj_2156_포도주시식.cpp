#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 100001;
int dp[MAX];
int wine[MAX];

int main() {
  int N;
  cin >> N;

  for (int i = 1; i <= N; i++)
    cin >> wine[i];

  dp[1] = wine[1];
  dp[2] = wine[1] + wine[2];
  for (int i = 3; i <= N; i++) {
    dp[i] = dp[i - 1];
    dp[i] = max(dp[i], dp[i - 2] + wine[i]);
    dp[i] = max(dp[i], dp[i - 3] + wine[i - 1] + wine[i]);
  }
  cout << dp[N] << "\n";
}
