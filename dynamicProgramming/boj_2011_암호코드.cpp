#include <iostream>
#include <string>

using namespace std;

const int MAX = 5001;
const int mod = 1000000;

long long dp[MAX];
int num[MAX];

string code;
int length;

int main() {

  cin >> code;
  length = code.length();

  for (int i = 0; i < length; i++)
    num[i + 1] = code[i] - '0';

  if (num[1] == 0)
    cout << 0 << "\n";

  else {
    dp[0] = 1;

    for (int i = 1; i <= length; i++) {
      if (num[i] >= 1 && num[i] <= 9)
        dp[i] = (dp[i - 1] + dp[i]) % mod;

      int temp = num[i - 1] * 10 + num[i];
      if (temp >= 10 && temp <= 26)
        dp[i] = (dp[i - 2] + dp[i]) % mod;
    }
    cout << dp[length] << endl;
  }
}

// 0일 때의 예외처리에 대해서 생각하지 못 했음