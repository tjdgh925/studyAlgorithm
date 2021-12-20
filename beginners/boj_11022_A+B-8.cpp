#include <iostream>

using namespace std;

int main() {
  int N, A, B;
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> A >> B;
    cout << "Case #" << i + 1 << ": " << A << " + " << B << " = " << A + B
         << endl;
  }

  return 0;
}