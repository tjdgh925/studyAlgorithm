#include <iostream>

using namespace std;

int main() {
  int cost, remain = 0;
  int coins[] = {500, 100, 50, 10, 5, 1};

  cin >> cost;
  cost = 1000 - cost;

  for (int i = 0; i < 6; ++i) {
    remain += cost / coins[i];
    cost %= coins[i];
  }
  cout << remain;
}