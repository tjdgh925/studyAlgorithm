#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 201;
int n, result = 0;
int children[MAX], dp[MAX];

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> children[i];
    dp[i] = 1;
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++)
      if (children[j] < children[i]) {
        dp[i] = max(dp[i], dp[j] + 1);
      }
    result = max(result, dp[i]);
  }
  cout << n - result << "\n";
}