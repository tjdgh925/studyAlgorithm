#include <algorithm>
#include <iostream>

using namespace std;

int main() {

  int n, MAX = -1000001, MIN = 1000001;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int tmp;
    cin >> tmp;
    MAX = max(tmp, MAX);
    MIN = min(tmp, MIN);
  }
  cout << MIN << " " << MAX << "\n";
}