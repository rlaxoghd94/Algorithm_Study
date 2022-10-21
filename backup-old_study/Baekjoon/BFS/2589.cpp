#include <iostream>
#include <algorithm>  // std:max()
#include <cstring>    // std:memset()
#include <queue>
using namespace std;

#define MAX_RANGE 51

char map[MAX_RANGE][MAX_RANGE];
int depth[MAX_RANGE][MAX_RANGE];
bool visit[MAX_RANGE][MAX_RANGE] = { false };

int dy[] = {1, 0, -1, 0};
int dx[] = {0, 1, 0, -1};

int N, M;
int maxDepth;

/*
 * [+] Approach [+]
 * This problem is not given with a starting point, but we are to find the maximum distance on land.
 * Therefore, we must do BFS for all coordinate with a 'L'(Land) value; calculating
 * and updating the maximum depth among all the possibilities calculatable.
 */

void BFS(int yy, int xx){
  visit[yy][xx] = true;
  queue< pair<int, int> > q;
  q.push(make_pair(yy, xx));

  while (!q.empty()){
    int cy = q.front().first;
    int cx = q.front().second;
    q.pop();

    for (int i = 0; i < 4; i++){
      int ny = cy + dy[i];
      int nx = cx + dx[i];

      if (ny < 0 || nx < 0 || ny >= N || nx >= M)
        continue;

      if (map[ny][nx] == 'W')
        continue;

      if (visit[ny][nx])
        continue;

      q.push(make_pair(ny, nx));
      visit[ny][nx] = true;

      depth[ny][nx] = depth[cy][cx] + 1;
      maxDepth = max(maxDepth, depth[ny][nx]);  // calculate max depth HERE
    }
  }
}

int main(){
  // take input HERE
  cin >> N >> M;
  string input = "";
  for (int i = 0; i < N; i++){
    cin >> input;
    for (int j = 0; j < M; j++){
      map[i][j] = input[j];
    }
  }

  for (int i = 0; i < N; i++){
    for (int j = 0; j < M; j++){
      if (map[i][j] == 'L'){
        BFS(i, j);
        // reset visit and depth HERE
        memset(visit, false, sizeof(visit));
        memset(depth, 0, sizeof(depth));
      }
    }
  }

  cout << maxDepth << endl;
  return 0;
}
