#include <iostream>

using namespace std;

string result[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
int main() {
  int x, y;
  cin >> x >> y;

  int days = 0;
  for (int i = 1; i < x; i++) {
    if (x == 1)
      break;
    if (i == 2)
      days += 28;
    else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 ||
             i == 12)
      days += 31;
    else
      days += 30;
  }
  days += y;
  days %= 7;

  cout << result[days] << endl;
}