#include <iostream>

using namespace std;

const int MAX = 1000001;
int arr[MAX] = {
    0,
};
int a, b, result = 0;

int main() {
  for (int i = 2; i <= MAX; i++) {
    arr[i] = i;
  }

  for (int i = 2; i <= MAX; i++) {
    if (arr[i] == 0)
      continue;
    for (int j = 2 * i; j <= MAX; j += i) {
      arr[j] = 0;
    }
  }

  cin >> a >> b;
  for (int i = a; i <= b; i++) {
    if (arr[i] != 0)
      cout << i << "\n";
  }
}