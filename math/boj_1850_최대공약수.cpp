#include <iostream>

using namespace std;

long long a, b, c;
long long gcd(long long x, long long y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}

int main() {
  cin >> a >> b;
  if (a > b)
    c = gcd(a, b);
  else
    c = gcd(b, a);

  for (int i = 0; i < c; i++) {
    cout << "1";
  }
}