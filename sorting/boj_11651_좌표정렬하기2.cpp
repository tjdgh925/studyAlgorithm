#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int n;
vector<pair<int, int>> arr;

bool compare(pair<int, int> a, pair<int, int> b) {
  if (a.second == b.second)
    return a.first < b.first;
  else
    return a.second < b.second;
}

int main() {
  cin >> n;

  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a >> b;
    arr.push_back(pair<int, int>(a, b));
  }
  sort(arr.begin(), arr.end(), compare);

  for (int i = 0; i < n; i++) {
    cout << arr[i].first << " " << arr[i].second << "\n";
  }
}
