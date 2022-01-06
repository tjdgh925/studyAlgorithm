#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int n;
int age;
string name;
vector<pair<int, string>> arr;

bool compare(pair<int, string> a, pair<int, string> b) {
  return a.first < b.first;
}

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> age >> name;
    arr.push_back(pair<int, string>(age, name));
  }

  stable_sort(arr.begin(), arr.end(), compare);

  for (int i = 0; i < n; i++) {
    cout << arr[i].first << " " << arr[i].second << "\n";
  }
}