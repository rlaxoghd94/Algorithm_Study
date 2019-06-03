#include <iostream>

using namespace std;
#define MAX_N 101

int N;
char map[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N] = { false };
int dy[] = {1, 0, -1, 0};
int dx[] = {0, 1, 0, -1};
int cntBefore = 0, cntAfter = 0;
bool isColorBlind = false;

void resetVisited(){
  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      visited[i][j] = false;
}

void DFS(int yy, int xx, char refVal) {
  visited[yy][xx] = true;
  int ny, nx;

  for (int i = 0; i < 4; i++){
    ny = yy + dy[i];
    nx = xx + dx[i];

    if (ny < 0 || nx < 0 || ny >= N || nx >= N)
      continue;

    if (visited[ny][nx])
      continue;

    if (!isColorBlind){
      if (map[ny][nx] == refVal){
        DFS(ny, nx, refVal);
      }
    } else {
     /*
      * if colorblind, 'R' and 'G' is dealt as if they're the same
      * which means as long as (char: map[ny][nx]) is not 'B',
      * all values should be dealt the same
      */
      if (refVal == 'B'){
        if (map[ny][nx] == 'B')
          DFS(ny, nx, refVal);
      } else {
        if (map[ny][nx] != 'B')
          DFS(ny, nx, refVal);
      }
    }
  }
}

int main(){
  cin >> N;

  for (int i = 0; i < N; i++){
    for (int j = 0; j < N; j++){
      cin >> map[i][j];
    }
  }

  for (int i = 0; i < N; i++){
    for (int j = 0; j < N; j++){
      if (!visited[i][j]){
        cntBefore++;
        DFS(i, j, map[i][j]);
      }
    }
  }

  resetVisited();
  isColorBlind = true;
  for (int i = 0; i < N; i++){
    for (int j = 0; j < N; j++){
      if (!visited[i][j]){
        cntAfter++;
        DFS(i, j, map[i][j]);
      }
    }
  }

  cout << cntBefore << " " << cntAfter << endl;

  return 0;
}
