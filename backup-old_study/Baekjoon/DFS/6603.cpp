#include <iostream>
#include <string>
#include <vector>

using namespace std;

int S[13];
int K;
int cnt;
vector<string> outputList;

/*
 * This is a mixture of a DFS and Backtracking algorithm.
 * Take a close look at how the 'cnt' value is being used within this method.
 */
void DFS(int v, string str){
  if (cnt == 6){
    outputList.push_back(str);
  } else {
      for (int i = v + 1; i <= K; i++){
        ++cnt;
        DFS(i, str + to_string(S[i]) + " ");
      }
  }
  // --cnt is used as a 'backtracking' measurement
  --cnt;
}

int main(){
  // Take inputs until 0 is received
  while (true){
    outputList.clear();
    scanf("%d", &K);

    if (K == 0)
      return 0;

    for (int i = 1; i <= K; i++){
      scanf("%d", &S[i]);
    }

    // Since this is an ordered single dimentional problem, visited[] is not necessary
    for (int i = 1 ; i <= K; i++){
      cnt = 1;
      string singleOutput = to_string(S[i]) + " ";
      DFS(i, singleOutput);
    }

    for (int i = 0 ; i < outputList.size(); i++){
      cout << outputList[i] << endl;
    }
    cout << endl;
  }

  return 0;
}
