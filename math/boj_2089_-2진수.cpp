#include <algorithm>
#include <iostream>

using namespace std;

int n;
string result = "";

int main() {
  cin >> n;
  if (n == 0) {
    cout << "0\n";
    return 0;
  }
  while (n != 0) {
    if (n % -2 == 0) {
      result += '0';
      n /= -2;
    } else {
      result += '1';
      n = (n - 1) / -2;
    }
  }
  reverse(result.begin(), result.end());
  cout << result;
}