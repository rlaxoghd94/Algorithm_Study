#include <iostream>
#include <queue>

using namespace std;

int N, M;
int map[101][101] = {{0}};
bool check[101][101] = {{false}};
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

void printMap()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            printf("%d ", map[i][j]);
        }
        printf("\n");
    }
}

int bfs()
{
    queue<pair<int, int>> Q;
    Q.push(pair<int, int>(0, 0));
    map[0][0] = 1;  // how long it takes during bfs() to arrive at (x,y)

    while (!Q.empty())
    {
        int cur_y = Q.front().first;
        int cur_x = Q.front().second;
        Q.pop();

        // end condition
        if ((cur_y == N - 1) && (cur_x == M - 1))
            break;

        for (int i = 0; i < 4; i++)
        {
            int next_y = cur_y + dy[i];
            int next_x = cur_x + dx[i];

            // is within the boundary
            if (next_y >= 0 && next_x >= 0 && next_y < N && next_x < M)
            {
                // if (x, y) hasn't been traversed and if (x, y) is a path
                if (map[next_y][next_x] == 1 && check[next_y][next_x])
                {
                    map[next_y][next_x] = map[cur_y][cur_x] + 1;
                    Q.push(pair<int, int>(next_y, next_x));
                }
            }
        }
    }

    return map[N - 1][M - 1];
}

int main()
{
    cin >> N >> M;

    string inputLine;
    for (int i = 0; i < N; i++)
    {
        inputLine = "";
        cin >> inputLine;

        for (int j = 0; j < M; j++)
        {
            map[i][j] = inputLine[j] - '0';
            if (map[i][j] == 1)
                check[i][j] = true;
        }
    }

    //printMap();
    cout << bfs() << endl;

    return 0;
}