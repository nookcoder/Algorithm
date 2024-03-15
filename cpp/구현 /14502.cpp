#include <iostream>
#include <string>
#include <iomanip>

using namespace std;
int main() {
    int row, col;

    // 입력 받기
    cin >> col >> row;
    int **arr = new int *[col];
    for(int i=0; i<col; i++) {
        arr[i] = new int [row];
        for(int j=0; j<row; j++) {
            cin >> arr[i][j];
        }
    }

    return 0;
}

void dfs(int **arr, int startCol, int startRow) { // i 는 세로, j 는 가로
    int i,j;
    int x[4] = {1, 0, 1, 0};
    int y[4] = {0, 1, 0, 1};
    for(i=0; i<4; i++) {
        int target = arr[startCol + y[i]][startRow + x[i]];
        
    }
}