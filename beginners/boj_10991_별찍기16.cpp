#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    for (int j = n - 1; j > i; j--) {
      cout << " ";
    }
    for (int k = 0; k <= i * 2; k++) {
      if (k % 2 == 0)
        cout << "*";
      else
        cout << " ";
    }

    cout << "\n";
  }
}