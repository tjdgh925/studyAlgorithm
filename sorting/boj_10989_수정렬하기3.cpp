#include <iostream>
#include <algorithm>

using namespace std;

const int MAX = 10001;

int n;
int arr[MAX] = { 0 };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		arr[temp]++;
	}
	for (int i = 0; i < 10001; i++)
		for (int j = 0; j < arr[i]; j++)
			cout << i << "\n";
}
