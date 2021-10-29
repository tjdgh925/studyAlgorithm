#include <iostream>
#include <vector>

using namespace std;

vector<string> croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

int main() {
  string input;
  int temp;
  cin >> input;
  int result = 0;
  for (int i = 0; i < croatian.size(); i++) {
    while (1) {
      temp = input.find(croatian[i]);
      if (temp == string::npos)
        break;
      input.replace(temp, croatian[i].length(), "#");
    }
  }
  cout << input.length() << endl;
}