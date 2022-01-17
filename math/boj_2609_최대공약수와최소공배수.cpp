#include <iostream>

using namespace std;

int a, b;
int gcd(int x, int y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}

int main() {
  cin >> a >> b;
  if (a > b)
    cout << gcd(a, b) << "\n" << (a * b) / gcd(a, b);
  else
    cout << gcd(b, a) << "\n" << (a * b) / gcd(b, a);
}