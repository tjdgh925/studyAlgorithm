#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

bool result = false;
string S, T;

int main() {
  cin >> S >> T;
  while (1) {
    if (S.length() == T.length()) {
      if (S == T)
        result = 1;
      break;
    }
    if (T[T.size() - 1] == 'A')
      T.pop_back();
    else {
      T.pop_back();
      reverse(T.begin(), T.end());
    }
  }
  cout << result << endl;
}