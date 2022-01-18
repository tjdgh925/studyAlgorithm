
#include <iostream>

using namespace std;

int n, result = 1;
int main() {
  cin >> n;
  if (n != 0)
    for (int i = 1; i <= n; i++)
      result *= i;

  cout << result;
}
