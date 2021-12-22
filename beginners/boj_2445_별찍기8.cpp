#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < i; j++) {
      cout << "*";
    }
    for (int l = n * 2; l > i * 2; l--) {
      cout << " ";
    }

    for (int k = 0; k < i; k++) {
      cout << "*";
    }
    cout << "\n";
  }
  for (int i = n - 1; i > 0; i--) {
    for (int j = 0; j < i; j++) {
      cout << "*";
    }
    for (int l = n * 2; l > i * 2; l--) {
      cout << " ";
    }

    for (int k = 0; k < i; k++) {
      cout << "*";
    }
    cout << "\n";
  }
}