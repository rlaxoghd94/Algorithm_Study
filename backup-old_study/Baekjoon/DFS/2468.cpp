#include <iostream>
#include <queue>
#include <vector>

using namespace std;

#define MAX_N 101

int N;
int board[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];
int ans, cnt = 0;

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

void copyBoard(int (*a)[MAX_N], int (*b)[MAX_N])
{
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            a[i][j] = b[i][j];
}

void initVisited()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            visited[i][j] = false;
        }
    }
}

void DFS(int floodHeight, int x, int y)
{
    visited[y][x] = true;

    for (int i = 0; i < 4; i++)
    {
        int xx = x + dx[i];
        int yy = y + dy[i];

        if (xx >= 0 && yy >= 0 && xx < N && yy < N)
        {
            if (!visited[yy][xx] && board[yy][xx] > floodHeight)
            {
                DFS(floodHeight, xx, yy);
            }
        }
    }
}

/*
 * The goal of this problem is to find the maximum amount of areas you can get per any (int: floodHeight) possible
 * Therefore, you need to do Depth-First-Search(DFS) for every possible height within the given variables
 */
int main()
{
    cin >> N;

    int maxHeight = -1;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> board[i][j];

            // search for maximum height in the given inputs
            maxHeight = maxHeight < board[i][j] ? board[i][j] : maxHeight;
        }
    }

    /*
     * DFS for i in range (0 .. maxHeight),
     * IF (int[][]: board[j][k]) has higher value than the (int: i), the flood height
     */
    for (int i = 0; i < maxHeight; i++)
    {
        for (int j = 0; j < N; j++)
        {
            for (int k = 0; k < N; k++)
            {
                if (!visited[j][k] && board[j][k] > i)
                {
                    cnt++;    
                    DFS(i, k, j);
                }
            }
        }

        ans = ans > cnt ? ans : cnt;
        initVisited();
        cnt = 0;
    }

    cout << ans << endl;
    return 0;
}