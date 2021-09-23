#include <iostream>

using namespace std;

string str;
int main() {
  cin >> str;

  int result = str[0] - '0';

  for (int i = 1; i < str.size(); i++) {

    int num = str[i] - '0';
    if (result > 0 && num > 0) {
      result *= num;
    } else
      result += num;
  }
  cout << result;
}