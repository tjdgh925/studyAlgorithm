#include <iostream>

using namespace std;

int n, b;
string result = "";

int main() {
  cin >> n >> b;
  while (n > 0) {
    if (n % b < 10) {
      result += char((n % b) + '0');
    } else {
      result += char('A' + ((n % b) - 10));
    }
    n /= b;
  }

  for (int i = result.size() - 1; i >= 0; i--) {
    cout << result[i];
  }
}