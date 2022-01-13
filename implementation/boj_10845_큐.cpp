#include <algorithm>
#include <iostream>
#include <queue>
#include <string.h>

using namespace std;

queue<int> arr;

int n;
int result;
string temp;

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp == "push") {
      cin >> result;
      arr.push(result);
    } else if (temp == "pop") {
      if (arr.empty())
        cout << "-1"
             << "\n";
      else {
        result = arr.front();
        cout << result << "\n";
        arr.pop();
      }
    } else if (temp == "size") {
      result = arr.size();
      cout << result << "\n";
    } else if (temp == "empty") {
      if (arr.empty())
        cout << "1"
             << "\n";
      else
        cout << "0"
             << "\n";
    } else if (temp == "front") {
      if (arr.empty())
        cout << "-1"
             << "\n";
      else {
        result = arr.front();
        cout << result << "\n";
      }
    } else if (temp == "back") {
      if (arr.empty())
        cout << "-1"
             << "\n";
      else {
        result = arr.back();
        cout << result << "\n";
      }
    }
  }
}