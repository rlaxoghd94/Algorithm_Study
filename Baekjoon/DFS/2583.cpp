#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, K;
int map[101][101];
bool visited[101][101];
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int cnt;
vector<int> ans;

void printMap(){
	for (int i = M-1; i >= 0; i--){
		for (int j = 0; j < N; j++){
			cout << map[i][j] << " ";
		}
		cout << "\n";
	}
}

/*
 * @DESC - increase global variable cnt++ whenever a recursive occurs (counting all the number of blocks per area)
 */
void DFS(int x, int y){
	visited[y][x] = true;

	for (int i = 0; i < 4; i++){
		int newX = x + dx[i];
		int newY = y + dy[i];

		if (newX >= 0 && newY >= 0 && newX < N && newY < M){
			if (!visited[newY][newX] && map[newY][newX] == 0){
				cnt++;
				DFS(newX, newY);
			}
		}
	}
}

int main(){

	scanf("%d %d %d", &M, &N, &K);

	for (int i = 0; i < M; i++){
		for (int j = 0; j < N; j++){
			map[i][j] = 0;
			visited[i][j] = false;
		}
	}


	for (int i = 0; i < K; i++){
		int startX, startY, endX, endY;
		scanf("%d %d %d %d", &startX, &startY, &endX, &endY);
		for (int j = startY; j < endY; j++){
			for (int k = startX; k < endX; k++){
				map[j][k]++;
			}
		}
	}

	// printMap();
	cnt = 0;
	for (int i = 0; i < M; i++){
		for (int j = 0; j < N; j++){
			if (!visited[i][j] && map[i][j] == 0){
                /*
                 * Since this block is only executed IF ONLY a new area has been met during the traversing sequence, cnt value is set to 1
                 * When DFS(j, i) is finished, it'll have traversed throughout the entire area while counting the number of blocks per area; therefore, you can just add the cnt value in to the 'vector<int> ans' for later use.
                 */
				cnt = 1;
				DFS(j, i);
				ans.push_back(cnt);
			}
		}
	}
	
	sort(ans.begin(), ans.end());
	
	cout << ans.size() << endl;
	for (int i = 0; i < ans.size(); i++){
		cout << ans[i] << " ";
	}

	return 0;
}
