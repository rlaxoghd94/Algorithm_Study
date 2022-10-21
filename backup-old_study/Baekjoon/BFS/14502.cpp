#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int board[9][9];
int temp_board[9][9];
int N, M;
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
// queue< pair<int, int> > q;

vector<pair<int, int> > virus;
int ans = 0;
/*  [Board Value Legend]
 *  0 : empty space
 *  1 : wall
 *  2 : virus
 */

void copyBoard(int (*a)[9], int (*b)[9])
{
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            a[i][j] = b[i][j];

    return;
}

void BFS()
{
    int afterWall[9][9];
    copyBoard(afterWall, temp_board);

    queue<pair<int, int> > q;
    // 초기 바이러스 좌표를 큐에 넣는다
    for (int i = 0; i < virus.size(); i++) q.push(virus[i]);

    while (!q.empty())
    {
        int yy = q.front().first;
        int xx = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int ny = yy + dy[i], nx = xx + dx[i];

            if (ny >= 0 && nx >= 0 && ny < N && nx < M)
            {
                // Infect an empty space HERE
                if (afterWall[ny][nx] == 0)
                {
                    afterWall[ny][nx] = 2;
                    q.push(pair<int, int>(ny, nx));
                }
            }
        }
    }

    // Caculate MAX safeArea HERE
    int safeArea = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (afterWall[i][j] == 0)
            {
                safeArea++;
            }
        }
    }

    ans = ans > safeArea ? ans : safeArea;
}

void recursiveWall(int cnt)
{
    // 3 walls constructed, time to spread the virus
    if (cnt >= 3)
    {
        BFS();
        return;
    }

    // Calculate all outcomes by building walls in every space possible
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (temp_board[i][j] == 0)
            {
                temp_board[i][j] = 1;
                recursiveWall(cnt + 1);
                temp_board[i][j] = 0;
            }
        }
    }

}

int main()
{
    // Take input HERE
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> board[i][j];

            if (board[i][j] == 2){
                // q.push(pair<int, int>(i, j));
                virus.push_back(make_pair(i, j));
            }
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (board[i][j] == 0)
            {
                copyBoard(temp_board, board);
                temp_board[i][j] = 1;
                recursiveWall(1);
                temp_board[i][j] = 0;
            }
        }
    }

    cout << ans << endl;

    return 0;
}
