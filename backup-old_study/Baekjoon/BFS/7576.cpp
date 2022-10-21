#include <iostream>
#include <queue>

using namespace std;

int M, N;
int board[1001][1001];
bool visit[1001][1001];
int DATE = 0;
int cnt = 0;

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
queue<pair<int, int>> q;

/*
 * [Board value legend]
 *  1 = ripe
 *  0 = unripe
 * -1 = overripe
 */
int BFS()
{
    DATE = 1;
    while (!q.empty())
    {
        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            int cury = q.front().first;
            int curx = q.front().second;
            visit[cury][curx] = true;

            q.pop();

            // EXIT CONDITION: where there are no tomatoes to maturate
            if (cnt == 0)
                return 0;

            for (int j = 0; j < 4; j++)
            {
                int newy = cury + dy[j];
                int newx = curx + dx[j];

                if (newx >= 0 && newx < M && newy >= 0 && newy < N)
                {
                    if (board[newy][newx] == 0 && !visit[newy][newx])
                    {
                        q.push(pair<int, int>(newy, newx));
                        board[newy][newx] = 1;
                        visit[newy][newx] = true;
                        cnt--;  //deduct (int: cnt) once it has maturated
                    }
                }

                if (cnt == 0)
                {
                    return DATE;
                }
            }
        }
        DATE++;
    }
    return -1;
}


int main()
{
    cin >> M >> N;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> board[i][j];
            if (board[i][j] == 1)
            {
                // we need to find the number of days it takes for all tomatoes to maturate
                // therefore, we need to, from the start, do BFS with all the ripe ones(board[i][j] == 1).
                q.push(pair<int, int>(i, j));
            }
            else if (board[i][j] == 0)
            {
                // (int: cnt) to keep track of how many more tomatos need to maturate
                cnt++;
            }
        }
    }

    cout << BFS() << endl;

    return 0;
}
