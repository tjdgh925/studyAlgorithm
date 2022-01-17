#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 1000001;

int n, n2;
long long result = 0;
int arr[MAX];

bool compare(int a, int b) { return a > b; }
int gcd(int x, int y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> n2;
    for (int j = 0; j < n2; j++) {
      cin >> arr[j];
    }

    result = 0;
    for (int k = 0; k < n2; k++) {
      for (int l = k + 1; l < n2; l++) {
        result += gcd(arr[k], arr[l]);
      }
    }
    cout << result << "\n";
  }
}