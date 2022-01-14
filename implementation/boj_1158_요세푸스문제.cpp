#include <iostream>
#include <list>

using namespace std;

list<int> table;
int n, k;

int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    table.push_back(i);
  }

  list<int>::iterator it = table.begin();
  cout << "<";
  while (table.size()) {
    for (int i = 1; i < k; i++) {
      it++;
      if (it == table.end())
        it = table.begin();
    }
    if (table.size() == 1)
      cout << *it;
    else
      cout << *it << ", ";
    it = table.erase(it);
    if (it == table.end())
      it = table.begin();
  }

  cout << ">\n";
}
