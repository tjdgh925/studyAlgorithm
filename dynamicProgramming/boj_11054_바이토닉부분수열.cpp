#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 1001;
int dp[2][MAX], seq[MAX];
int N, result = 0, temp;

int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> seq[i];
    dp[0][i] = 1;
    dp[1][i] = 1;
  }

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < i; j++) {
      if (seq[j] < seq[i]) {
        dp[0][i] = max(dp[0][i], dp[0][j] + 1);
      }
    }
  }
  for (int i = N - 1; i >= 0; i--) {
    for (int j = N - 1; j > i; j--) {
      if (seq[j] < seq[i]) {
        dp[1][i] = max(dp[1][i], dp[1][j] + 1);
      }
    }
  }
  for (int i = 0; i < N; i++) {
    temp = dp[0][i] + dp[1][i] - 1;
    result = max(result, temp);
  }

  cout << result << "\n";
}
