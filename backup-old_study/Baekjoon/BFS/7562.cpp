#include <iostream>
#include <queue>

using namespace std;

int T, I;
int map[301][301] = {{0}};
int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
int dy[] = {2, 1, -1, -2, -2, -1, 1, 2};

int bfs(int start_x, int start_y, int end_x, int end_y)
{
    // reset all map values to 0 for different testcases
    for (int i = 0; i < 301; i++)
    {
        for (int j = 0; j < 301; j++)
        {
            map[i][j] = 0;
        }
    }

    /*
     * Since I've used map[y][x] as both my visit checker and a counter checker,
     * I had to start with map[start_y][start_x] with 1.
     * But when I print the final answer, I have to subtract 1 from map[end_y][end_x], because
     * technically speaking, I haven't made the first move at map[start_y][start_x], but at map[next_y][next_x];
     */

    map[start_y][start_x] = 1;
    queue<pair<int, int>> q;
    q.push(pair<int, int>(start_x, start_y));

    while (!q.empty())
    {
        int cur_x = q.front().first;
        int cur_y = q.front().second;
        q.pop();

        // End condition
        if (cur_x == end_x && cur_y == end_y)
        {
            break;
        }

        for (int i = 0; i < 8; i++)
        {
            int next_x = cur_x + dx[i];
            int next_y = cur_y + dy[i];

            // Boundary check
            if ((next_x >= 0 && next_x < I) && (next_y >= 0 && next_y < I))
            {
                // hasn't been traversed already
                if (map[next_y][next_x] == 0)
                {
                    map[next_y][next_x] = map[cur_y][cur_x] + 1;
                    q.push(pair<int, int>(next_x, next_y));
                }
            }
        }
    }

    return map[end_y][end_x] - 1;
}

int main()
{
    scanf("%d", &T);

    while (T--)
    {
        scanf("%d", &I);
        int start_y, start_x, end_y, end_x;
        scanf("%d %d", &start_x, &start_y);
        scanf("%d %d", &end_x, &end_y);

        cout << bfs(start_x, start_y, end_x, end_y) << endl;
    }

    return 0;
}