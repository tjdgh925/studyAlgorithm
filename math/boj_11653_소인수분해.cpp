#include <iostream>
#include <vector>

using namespace std;

const int MAX = 10000001;
int arr[MAX] = {
    0,
};
int n;
vector<int> idx;
vector<int> result;
int main() {

  for (int i = 2; i < MAX; i++) {
    arr[i] = i;
  }

  for (int i = 2; i < MAX; i++) {
    if (arr[i] == 0)
      continue;
    for (int j = 2 * i; j < MAX; j += i) {
      arr[j] = 0;
    }
  }
  for (int i = 2; i < MAX; i++) {
    if (arr[i] != 0)
      idx.push_back(arr[i]);
  }

  cin >> n;

  for (int i = 0; i < idx.size();) {
    if (n == 0)
      break;
    if (n % idx[i] == 0) {
      result.push_back(idx[i]);
      n /= idx[i];
    } else
      i++;
  }
  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << "\n";
  }
}