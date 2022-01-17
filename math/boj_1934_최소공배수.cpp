#include <iostream>

using namespace std;

int n, a, b;
int gcd(int x, int y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    if (a > b)
      cout << (a * b) / gcd(a, b) << "\n";
    else
      cout << (a * b) / gcd(b, a) << "\n";
  }
}