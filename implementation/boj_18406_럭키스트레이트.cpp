#include <iostream>

using namespace std;

string N;

int main() {
  cin >> N;
  int sumLeft = 0;
  int sumRight = 0;
  for (int i = 0; i < N.size() / 2; i++) {
    sumLeft += N[i] - '0';
  }
  for (int i = N.size() / 2; i < N.size(); i++) {
    sumRight += N[i] - '0';
  }
  if (sumLeft == sumRight)
    cout << "LUCKY" << endl;
  else
    cout << "READY" << endl;
}