#include <iostream>

using namespace std;

long long n, m;

long long div5(long long n) {
  long long cnt = 0;
  for (long long i = 5; i <= n; i *= 5)
    cnt += n / i;

  return cnt;
}

long long div2(long long n) {
  long long cnt = 0;
  for (long long i = 2; i <= n; i *= 2)
    cnt += n / i;

  return cnt;
}

int main() {
  cin >> n >> m;
  long long five = div5(n) - div5(n - m) - div5(m);
  long long two = div2(n) - div2(n - m) - div2(m);
  cout << min(five, two) << "\n";
}