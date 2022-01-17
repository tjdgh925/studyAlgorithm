#include <iostream>

using namespace std;

int arr[1001] = {
    0,
};
int n, tmp, result = 0;

int main() {
  for (int i = 2; i <= 1000; i++) {
    arr[i] = i;
  }

  for (int i = 2; i <= 1000; i++) {
    if (arr[i] == 0)
      continue;
    for (int j = 2 * i; j <= 1000; j += i) {
      arr[j] = 0;
    }
  }

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    if (arr[tmp] != 0)
      result++;
  }
  cout << result;
}