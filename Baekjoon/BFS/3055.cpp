#include <iostream>
#include <queue>

#define MAX_RANGE 51

using namespace std;

/*
 *  [MAP LEGEND]
 * '.'  - empty space
 * '*'  - water
 * 'X'  - stone
 * 'D'  - beaver
 * 'S'  - hedgehog
 * 
 *  [PURPOSE]
 * Get from 'S' to 'D' while water floods the entire map
 */

int R, C;
char board[MAX_RANGE][MAX_RANGE];
queue<pair<int, int> > water;
queue<pair<int, int> > hedgehog;
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

void floodOnce(){
    int size = water.size();

    int xx, yy;
    for (int i = 0; i < size; i++){
        yy = water.front().first;
        xx = water.front().second;
        water.pop();

        int ny, nx;
        for (int j = 0; j < 4; j++){
            ny = yy + dy[j];
            nx = xx + dx[j];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                continue;
            
            if (board[ny][nx] == '.'){
                board[ny][nx] = '*';
                water.push(make_pair(ny, nx));
            }
        }
    }
}

bool moveHedgehog(){
    int size = hedgehog.size();

    int xx, yy;
    for (int i = 0; i < size; i++){
        yy = hedgehog.front().first;
        xx = hedgehog.front().second;
        hedgehog.pop();

        int nx, ny;
        for (int j = 0; j < 4; j++){
            ny = yy + dy[j];
            nx = xx + dx[j];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R)
                continue;
            
            if (board[ny][nx] == 'D'){
                // hedgehog.push(make_pair(ny, nx));
                return true;
            } else if (board[ny][nx] == '.'){
                board[ny][nx] = 'S';
                hedgehog.push(make_pair(ny, nx));
            }
        }
    }
    return false;
}

int main(){
    cin >> R >> C;

    for(int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            cin >> board[i][j];
            if (board[i][j] == 'S')
                hedgehog.push(make_pair(i, j));
            if (board[i][j] == '*')
                water.push(make_pair(i, j));
        }
    }

    /*
     * Basically, the approach here is that since we have to move the hedgehog and spread the flood every minute,
     * do BFS each; one for the hedgehog movement, and the other for the flooding.
     * BUT, the trick here is that they both have to have a synchronized BFS;
     * therefore, ( void: floodOnce() ) and ( bool: moveHedgehog() ) must occur in the same cycle.
     */
    int ans = 0;
    while (true) {
        ans++;
        if (hedgehog.size() == 0) {
            cout << "KACTUS" << endl;
            return 0;
        }

        floodOnce();
        if (moveHedgehog() == true) {
            cout << ans << endl;
            return 0;
        }
    }
    return 0;
}