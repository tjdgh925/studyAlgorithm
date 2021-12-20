#include <iostream>

using namespace std;

int main() {
  int N, A, B;
  string temp;
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> temp;
    A = temp[0] - '0';
    B = temp[2] - '0';
    cout << A + B << endl;
  }

  return 0;
}