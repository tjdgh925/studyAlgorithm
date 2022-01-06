#include <algorithm>
#include <iostream>

using namespace std;

const int MAX = 1000001;

int n;
int arr[MAX];

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);
  for (int i = 0; i < n; i++) {
    cout << arr[i] << "\n";
  }
}