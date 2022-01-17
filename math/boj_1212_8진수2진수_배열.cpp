#include <iostream>
#include <string>

using namespace std;

string n;
string arr[] = {"000", "001", "010", "011", "100", "101", "110", "111"};
string first[] = {"", "1", "10", "11", "100", "101", "110", "111"};

int main() {
  cin >> n;
  for (int i = 0; i < n.size(); i++) {
    int tmp = n[i] - '0';
    if (i == 0)
      cout << first[tmp];
    else
      cout << arr[tmp];
  }
  if (n == "0")
    cout << 0;
}