#include <iostream>
#include <string.h>

using namespace std;

string s;
int small = 0;
int big = 0;
int num = 0;
int space = 0;

int main() {
  while (getline(cin, s)) {
    if (s == "")
      break;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] >= 'A' && s[i] <= 'Z')
        big++;
      else if (s[i] >= 'a' && s[i] <= 'z')
        small++;
      else if (s[i] == ' ')
        space++;
      if (s[i] - '0' >= 0 && s[i] - '0' <= 9)
        num++;
    }
    cout << small << " " << big << " " << num << " " << space << "\n";
    small = 0;
    big = 0;
    num = 0;
    space = 0;
  }
}