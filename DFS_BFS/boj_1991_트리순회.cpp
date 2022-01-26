#include <iostream>

using namespace std;

int N;
struct Node {
  int left;
  int right;
};

Node tree[26];
void preorder(int idx) {
  cout << char('A' + idx);
  if (tree[idx].left > 0) {
    preorder(tree[idx].left);
  }
  if (tree[idx].right > 0) {
    preorder(tree[idx].right);
  }
}

void inorder(int idx) {
  if (tree[idx].left > 0) {
    inorder(tree[idx].left);
  }
  cout << char('A' + idx);
  if (tree[idx].right > 0) {
    inorder(tree[idx].right);
  }
}

void postorder(int idx) {
  if (tree[idx].left > 0) {
    postorder(tree[idx].left);
  }
  if (tree[idx].right > 0) {
    postorder(tree[idx].right);
  }
  cout << char('A' + idx);
}
int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    char parent, left, right;
    cin >> parent >> left >> right;
    tree[parent - 65].left = left - 65;
    tree[parent - 65].right = right - 65;
  }
  preorder(0);
  cout << "\n";
  inorder(0);
  cout << "\n";
  postorder(0);
}