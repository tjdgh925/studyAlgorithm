#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;

  for (int i = 0; i < n - 1; i++) {
    for (int k = 0; k < i; k++) {
      cout << " ";
    }

    for (int j = (n - 1) * 2; j >= i * 2; j--) {
      cout << "*";
    }
    cout << "\n";
  }
  for (int i = n; i > 0; i--) {
    for (int k = 0; k < i - 1; k++) {
      cout << " ";
    }

    for (int j = n * 2; j >= i * 2; j--) {
      cout << "*";
    }
    cout << "\n";
  }
}