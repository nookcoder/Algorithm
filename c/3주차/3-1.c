#include <stdio.h>
#include <stdlib.h>

void insertItem(int key); // 힙에 삽입하기
int removeMax(); // 힙에서 제거하기
void printHeap(); // 힙 출력하기
void upHeap(int i);
void downHeap(int i);
void swapElement(int targetIndex1, int targetIndex2);
int heap[101]; // 힙 전역 변수 선언
int n = 0; // 힙 크기

int main() {
    char op = 'a'; // 반복문을 수행하기 위한 값 초기화
    int key, maxValue; // 입력받은 키 값
    // 대화형 프로그램 시작
    while(op != 'q') {
        scanf("%c", &op);
        getchar();

        switch (op) {
            case 'i':
                scanf("%d", &key);
                getchar();
                insertItem(key);
                break;

            case 'd':
                maxValue = removeMax();
                printf("%d\n", maxValue);
                break;
            case 'p':
                printHeap();
                break;
            case 'q':
                break;
        }
    }

    return 0;
}

void insertItem(int key) {
    n++;
//    if(n > 1) { // root 노드가 아닐 때
//        heap[n] = key; // last node 에 key 삽입
//        upHeap(n);
//    } else { // root 에 삽입할 때
//        heap[n] = key;
//    }
    heap[n] = key; // last node 에 key 삽입
    upHeap(n);
    printf("0\n");
    return;
}

void upHeap(int i) {
    int parentIndex = i / 2;
    if(i != 1 && heap[parentIndex] < heap[i]) { // ROOT 가 아니고, 자식 노드가 부모 노드보다 클 때 자리 바꿈
        swapElement(parentIndex, i);
        upHeap(parentIndex); // 부모 노드에 대해 동일한 과정 수행
        return;
    } else { // root 노드 이거나 부모가 더 클 때 종료
        return;
    }
}

int removeMax() {
    int root = heap[1]; // heap root node 저장
    swapElement(1, n); // root 노드와 lastNode 자리 변경
    n--; // heap 현재 사이즈 감소
    downHeap(1); // root 에 대하여 downHeap 적용
    return root;
}

void downHeap(int i) {
    int left = i * 2;
    int right = i * 2 + 1;
    int maxIndex = left;
    int max = heap[left]; // 왼쪽 값이 더 큰 값이라고 가정

    if(left > n) { // i 가 last node 이상이거나 자식 노드가 존재하지 않을 떄
        return;
    }

    if(heap[right] != 0 && right <= n && max < heap[right]) { // 오른쪽 child 가 internal node 일 때 둘 중 더 큰 값 찾기
        max = heap[right];
        maxIndex = right;
    }

    if(max > heap[i]) { // child 값이 부모 값보다 클 때
        swapElement(maxIndex, i);
        downHeap(maxIndex);
    } else {
        return;
    }
}

void printHeap() {
    int i;
    for(i=1; i<n + 1; i++) {
        printf(" %d", heap[i]);
    }
    printf("\n");
    return;
}

void swapElement(int targetIndex1, int targetIndex2) {
    int temp = heap[targetIndex1];
    heap[targetIndex1] = heap[targetIndex2];
    heap[targetIndex2] = temp;
    return;
}