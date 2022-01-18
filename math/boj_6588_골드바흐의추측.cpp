#include <iostream>

using namespace std;

const int MAX = 1000001;
int arr[MAX] = {
    0,
};
int n, a, b, result = 0;

int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  //에라스토테네스의 체
  for (int i = 2; i < MAX; i++) {
    arr[i] = i;
  }

  for (int i = 2; i < MAX; i++) {
    if (arr[i] == 0)
      continue;
    for (int j = 2 * i; j < MAX; j += i) {
      arr[j] = 0;
    }
  }

  while (1) {
    cin >> n;
    if (n == 0)
      break;
    for (int i = 3; i < MAX; i++) {
      if ((arr[i] != 0)) {
        if (arr[n - arr[i]] != 0) {
          a = i;
          b = n - arr[i];
          break;
        }
      }
    }

    cout << n << " = " << a << " + " << b << "\n";
  }
}