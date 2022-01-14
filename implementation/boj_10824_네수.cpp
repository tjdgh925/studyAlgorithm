#include <iostream>
#include <string>

using namespace std;

int a, b, c, d;
string ab, cd;
long long result;

int main() {
  cin >> a >> b >> c >> d;
  ab = to_string(a) + to_string(b);
  cd = to_string(c) + to_string(d);
  result = stoll(ab) + stoll(cd);
  cout << result << "\n";
}