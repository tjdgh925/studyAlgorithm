#include <iostream>

using namespace std;

int main() {
  int N;
  string temp;
  cin >> N;
  cin >> temp;
  int result = 0;
  for (int i = 0; i < N; i++) {

    result += temp[i] - '0';
  }
  cout << result << endl;
  return 0;
}