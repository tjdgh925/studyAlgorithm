#include <algorithm>
#include <iostream>

using namespace std;

int N;
int arr[1000];
int result = 1;

int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> arr[i];
  }

  sort(arr, arr + N);

  for (int i = 0; i < N; i++) {
    if (arr[i] > result)
      break;
    result += arr[i];
  }

  cout << result << endl;
}