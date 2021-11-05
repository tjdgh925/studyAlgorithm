#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
  vector<int> answer;
  int best = 7, worst = 7, missing = 0;

  for (int i = 0; i < lottos.size(); i++) {
    if (lottos[i] == 0) {
      missing++;
      continue;
    }
    for (int j = 0; j < lottos.size(); j++) {
      if (win_nums[j] == lottos[i])
        worst--;
    }
  }
  best = worst - missing;

  if (best >= 6)
    best = 6;
  if (worst >= 6)
    worst = 6;

  answer.push_back(best);
  answer.push_back(worst);

  return answer;
}
int main(void) {
  vector<int> lottos = {44, 1, 0, 0, 31, 25};
  vector<int> win_nums = {31, 10, 45, 1, 6, 19};
  vector<int> answers = solution(lottos, win_nums);
  for (int answer : answers) {
    cout << answer << " ";
  }
  cout << "\n";
  return 0;
}
