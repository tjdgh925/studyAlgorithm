#include <algorithm>
#include <deque>
#include <iostream>
#include <string.h>

using namespace std;

deque<int> arr;

int n;
int result;
string temp;

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp == "push_front") {
      cin >> result;
      arr.push_front(result);
    } else if (temp == "push_back") {
      cin >> result;
      arr.push_back(result);
    } else if (temp == "pop_front") {
      if (arr.empty())
        cout << "-1"
             << "\n";
      else {
        result = arr.front();
        cout << result << "\n";
        arr.pop_front();
      }
    } else if (temp == "pop_back") {
      if (arr.empty())
        cout << "-1"
             << "\n";
      else {
        result = arr.back();
        cout << result << "\n";
        arr.pop_back();
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