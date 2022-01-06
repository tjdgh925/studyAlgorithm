#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int n;
int a, b, c;
string s;

struct GPA {
  string name;
  int korean;
  int english;
  int math;
};

vector<GPA> arr;

bool compare(GPA a, GPA b) {
  if (a.korean == b.korean)
    if (a.english == b.english)
      if (a.math == b.math)
        return a.name < b.name;
      else
        return a.math > b.math;
    else
      return a.english < b.english;
  else
    return a.korean > b.korean;
}

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    GPA temp;
    cin >> temp.name >> temp.korean >> temp.english >> temp.math;
    arr.push_back(temp);
  }

  sort(arr.begin(), arr.end(), compare);

  for (int i = 0; i < n; i++) {
    cout << arr[i].name << "\n";
  }
}