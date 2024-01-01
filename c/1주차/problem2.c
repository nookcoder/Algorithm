

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct Node {
    int number;
    struct Node* left;
    struct Node* right;
} Node;

Node* root = NULL;
Node* result = NULL;
Node* createTreeNode(int n);
void findTargetNode(Node* root, int targetNode);
Node* addChild(Node* root, int n,int left, int right);
void printTree(Node* root, char* _printString);

int main() {
    int nodeCount, printCount;
    int x,y,z;
    char printString[101];
    // 노드 갯수 입력 받기
    scanf("%d", &nodeCount);
    getchar();

    for(int i=0; i<nodeCount; i++) {
        // tree 값 입력받기
        scanf("%d %d %d", &x, &y, &z);
        getchar();

        if(i==0) {

            root = createTreeNode(x);
            Node* left = createTreeNode(y);
            Node* right = createTreeNode(z);

            root->left = left;
            root->right = right;
        } else {
            addChild(root, x, y, z);
        }
    }

    scanf("%d", &printCount);
    getchar();

    for(int i=0; i<printCount; i++){
        scanf("%s", printString);
        getchar();
        printTree(root, printString);
    }
    return 0;
}

// target 노드 위치 찾기
void findTargetNode(Node* root, int targetValue) {
    if(root->number == targetValue) {
        result = root;
    }
    if(root->left != NULL) {
        findTargetNode(root->left, targetValue);
    }

    if(root->right != NULL) {
        findTargetNode(root->right, targetValue);
    }
}


// 노드 생성하기
Node* createTreeNode(int n){
    Node* newNode = (Node*)malloc(sizeof(Node));
    // 0 이면 생성하지 않음
    if(n == 0) {
        return NULL;
    }
    newNode -> number= n;
    newNode -> left = NULL;
    newNode -> right = NULL;
    return newNode;
}

Node* addChild(Node* root, int n,int left, int right) {
    findTargetNode(root,n); // 추가할 노드 찾기
    // 자식 노드 추가하기
    if(left != 0){
        Node *leftChild = createTreeNode(left);
        result->left = leftChild;
    }

    if(right != 0) {
        Node *rightChild = createTreeNode(right);
        result->right = rightChild;
    }
    return result;
}

// tree 출력하기
void printTree(Node* root, char* _printString){
    int len = strlen(_printString);
    Node* currentNode = root;
    printf(" %d", currentNode->number); // root 출력

    for(int i=0; i<len; i++){
        if(*(_printString+i) == 'L') { // 왼쪽 노드 출력
            currentNode = currentNode->left;
            printf(" %d", currentNode->number);
        } else if(*(_printString+i) == 'R') { // 오른쪽 노드 출력
            currentNode = currentNode->right;
            printf(" %d", currentNode->number);
        } else {
            printf("\n");
            return;
        }
    }
    printf("\n");
}
