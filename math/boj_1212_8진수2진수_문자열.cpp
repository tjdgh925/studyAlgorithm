#include <cmath>
#include <iostream>
#include <string.h>

using namespace std;

string n, result = "";

int main() {
  cin >> n;
    if(n=="0")
        cout <<0;
    else{
        
    
  for (int i = 0; i < n.size(); i++) {
    int tmp = n[i] - '0';

    for (int j = 2; j >= 0; j--) {
      if (tmp >= pow(2, j)) {
        result += "1";
        tmp -= pow(2, j);
      } else {
        if (i == 0 && j == 2)
          continue;
        else
          result += "0";
      }
    }
  }
  while (result[0] != '1')
    result = result.substr(1);

  cout << result;
    }
}