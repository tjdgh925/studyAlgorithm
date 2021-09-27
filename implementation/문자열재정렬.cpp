#include <iostream>
#include <vector>
using namespace std;

string str;
vector<char> arr;
int sum = 0;

int main() {
  cin >> str;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] - '0' >= 0 && str[i] - '0' <= 9)
      sum += str[i] - '0';
    else
      arr.push_back(str[i]);
  }
  sort(arr.begin(), arr.end());
  for (int i = 0; i < arr.size(); i++) {
    cout << arr[i];
  }
  cout << sum << endl;
}