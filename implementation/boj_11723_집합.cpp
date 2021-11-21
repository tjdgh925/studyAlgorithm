#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int M, x;
  string command;

  bool arr[21] = {0};

  cin >> M;
  for (int i = 0; i < M; i++) {
    cin >> command;
    if (command == "add") {
      cin >> x;
      arr[x] = true;
    } else if (command == "remove") {
      cin >> x;
      arr[x] = false;
    } else if (command == "check") {
      cin >> x;
      if (arr[x])
        cout << "1\n";
      else
        cout << "0\n";
    } else if (command == "toggle") {
      cin >> x;
      if (arr[x])
        arr[x] = false;
      else
        arr[x] = true;

    } else if (command == "all") {
      memset(arr, true, sizeof(arr));
    } else {
      memset(arr, false, sizeof(arr));
    }
  }
}
