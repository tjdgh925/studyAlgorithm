#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

const int MAX = 100001;

int cnt = 0;
int result = 0;
long long card;

int n;
long long arr[MAX];

int main() {

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + n);

	card = arr[0];
	for (int i = 1; i < n; i++)
	{
		if (arr[i - 1] == arr[i])
			cnt++;
		else
			cnt = 0;
		if (cnt > result) {
			result = cnt;
			card = arr[i];
		}
	}
	cout << card << "\n";
}
