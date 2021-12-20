#include <iostream>

using namespace std;

int main() {
  string temp;
  int cnt = 0;
  cin >> temp;
  for (int i = 0; i < temp.length(); i++) {
    cnt++;
    cout << temp[i];
    if (cnt % 10 == 0) {
      cout << endl;
    }
  }
  return 0;
}