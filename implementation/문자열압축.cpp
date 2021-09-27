#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
  int size = s.size();
  int answer = s.size(), count, sum;
  int min = 1000;
  for (int i = 1; i <= s.size() / 2; i++) {
    string temp, result;
    sum = 1;

    temp = s.substr(0, i);
    for (int j = i; j < size; j += i) {
      if (temp == s.substr(j, i))
        sum++;
      else {
        if (sum > 1)
          result += to_string(sum);
        result += temp;
        temp = s.substr(j, i);
        sum = 1;
      }
    }
    if (sum > 1)
      result += to_string(sum);

    result += temp;
    (answer < result.size()) ?: answer = result.size();
  }
  return answer;
}

int main() { cout << solution("aabbaccc"); }