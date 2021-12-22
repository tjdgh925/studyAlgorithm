#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;

  for (int i = 0; i < n - 1; i++) {
    for (int j = n - 1; j > i; j--) {
      cout << " ";
    }
    for (int k = 0; k <= i * 2; k++) {
      if (k == 0 || k == i * 2)
        cout << "*";
      else
        cout << " ";
    }
    cout << "\n";
  }
  for (int i = 0; i < (n * 2) - 1; i++) {
    cout << "*";
  }
  cout << "\n";
}