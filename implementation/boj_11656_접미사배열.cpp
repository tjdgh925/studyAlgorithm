#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

const int MAX = 1001;

int length;
string s;
string arr[MAX];

int main() {
  cin >> s;
  length = s.size();
  for (int i = 0; i < length; i++) {
    arr[i] = s.substr(i, length);
  }
  sort(arr, arr + length);

  for (int i = 0; i < length; i++) {
    cout << arr[i] << "\n";
  }
}
