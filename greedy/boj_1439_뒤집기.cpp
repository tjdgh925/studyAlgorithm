#include <iostream>

using namespace std;

string str;

int main() {
  cin >> str;
  int result = 0;

  for (int i = 0; i < str.length(); i++) {
    if (str[i] != str[i + 1])
      result++;
  }

  cout << result / 2 << endl;
}