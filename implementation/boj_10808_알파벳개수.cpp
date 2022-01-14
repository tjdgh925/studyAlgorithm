#include <iostream>

using namespace std;

int alphabet[26] = {0};
string s;
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    alphabet[s[i] - '0' - 49]++;
  }
  for (int i = 0; i < 26; i++) {
    cout << alphabet[i] << " ";
  }
}
