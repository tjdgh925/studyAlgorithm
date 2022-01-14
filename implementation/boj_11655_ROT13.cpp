#include <iostream>
#include <string.h>

using namespace std;

string s;

int main() {
  getline(cin, s);
  for (int i = 0; i < s.size(); i++) {
    char temp = s[i];

    if (temp >= 'A' && temp <= 'Z') {
      if (temp - 'A' < 13)
        s[i] += 13;
      else
        s[i] -= 13;
    }
    if (temp >= 'a' && temp <= 'z') {
      if (temp - 'a' < 13)
        s[i] += 13;
      else
        s[i] -= 13;
    }
  }
  cout << s;
}
