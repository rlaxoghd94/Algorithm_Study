//
//  main.cpp
//  Baekjoon_playground
//
//  Created by Nic Taehong Kim on 02/01/2019.
//  Copyright © 2019 Nic Taehong Kim. All rights reserved.
//

#include <iostream>
using namespace std;

int N;
int input[101][101];
bool visited[101][101];

void printMatrix(){
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            cout << input[i][j] << " ";
        }
        cout << "\n";
    }
}

void DFS(int top, int x, int y){
    visited[top][y] = true;
    input[top][y] = 1;

    for (int i = 0; i < N; i++){
        if (!visited[top][i] && input[y][i]){
           DFS(top, y, i);
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    scanf("%d", &N);

    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            scanf("%d", &input[i][j]);
            visited[i][j] = false;
        }
    }
    cout << "\n";
    // printMatrix();

    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            if (!visited[i][j] && input[i][j] == 1){
                DFS(i, i, j);
            }
        }
    }

    printMatrix();


    return 0;
}
