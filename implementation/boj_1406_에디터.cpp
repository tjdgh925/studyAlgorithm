#include <iostream>
#include <list>

using namespace std;

list<char> arr;
string s;
char command;
int n;

int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++)
    arr.push_back(s[i]);

  cin >> n;
  list<char>::iterator cursor = arr.end();

  for (int i = 0; i < n; i++) {
    cin >> command;
    if (command == 'L') {
      if (cursor != arr.begin())
        cursor--;
    } else if (command == 'D') {
      if (cursor != arr.end())
        cursor++;
    } else if (command == 'B') {
      if (cursor != arr.begin())
        cursor = arr.erase(--cursor);
    } else if (command == 'P') {
      char c;
      cin >> c;
      arr.insert(cursor, c);
    }
  }

  for (list<char>::iterator it = arr.begin(); it != arr.end(); it++) {
    cout << *it;
  }
}