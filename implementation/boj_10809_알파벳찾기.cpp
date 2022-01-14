#include <iostream>

using namespace std;

int alphabet[26] = {0};
string s;
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (alphabet[s[i] - '0' - 49] != 0)
      continue;
    alphabet[s[i] - '0' - 49] = i + 1;
  }
  for (int i = 0; i < 26; i++) {
    if (alphabet[i] == 0)
      cout << "-1 ";
    else
      cout << alphabet[i] - 1 << " ";
  }
}
