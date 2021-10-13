#include <iostream>

using namespace std;

int s, e, MIN = 10000, SUM = 0;

int main() {
  cin >> s >> e;
  for (int i = s; i <= e; i++) {
    int cnt = 0;
    for (int j = 1; j <= i; j++) {
      if (i % j == 0)
        cnt++;
    }
    if (cnt == 2) {
      SUM += i;
      if (MIN > i)
        MIN = i;
    }
  }
  if (SUM == 0)
    cout << "-1" << endl;
  else
    cout << SUM << endl << MIN << endl;
}