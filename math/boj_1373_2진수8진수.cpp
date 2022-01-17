#include <cmath>
#include <iostream>

using namespace std;

string n, result;
int tmp;

int main() {
  cin >> n;
  while (n.size() % 3 != 0)
    n = '0' + n;
  for (int i = 0; i < n.size(); i += 3) {
    tmp = 0;
    for (int j = i; j < i + 3; j++)
      tmp += (n[j] - '0') * pow(2, 2 - (j % 3));
    cout << tmp;
  }
}