#include <iostream>

using namespace std;

int main() {
  string temp;
  for (int i = 0; i < 100 && !cin.eof(); i++) {
    getline(cin, temp);
    cout << temp << "\n";
  }
  return 0;
}