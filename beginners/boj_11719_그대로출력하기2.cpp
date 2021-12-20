#include <iostream>

using namespace std;

int main() {
  string temp;
  while (1) {
    getline(cin, temp);
    if (temp == "")
      break;
    cout << temp << "\n";
  }
  return 0;
}