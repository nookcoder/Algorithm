#pragma warning(disable:4996)
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    char data;
    struct Node *prev;
    struct Node *next;
} Node;

typedef struct list {
    struct Node* head;
    struct Node* tail;
} list;

Node *head = NULL;
Node* createNode();
Node* getByPosition(list*list, int r);
int getNodeListSize(list* list);
void add(list *list, int r, char e);
void delete(list *list, int r);
void get(list *list, int r);
void print(list *list);

int main() {
    int count, r;
    char op, e;

    list* nodeList = (list*) malloc(sizeof(list));

    nodeList->head = createNode();
    nodeList->tail = createNode();
    nodeList->head->next = nodeList->tail;
    nodeList->tail->prev = nodeList->head;

    scanf("%d", &count);
    getchar();
    while(count-- > 0) {
        scanf("%c", &op);
        getchar();

        switch (op) {
            case 'A':
                scanf("%d %c", &r, &e);
                getchar();
                add(nodeList, r, e);
                break;
            case 'D':
                scanf("%d", &r);
                getchar();
                delete(nodeList, r);
                break;
            case 'P':
                print(nodeList);
                break;
            case 'G':
                scanf("%d", &r);
                getchar();
                get(nodeList, r);
                break;
        }
    }

    return 0;
}

Node* createNode() {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

// 현재 list 의 노드 갯수 구하기
int getNodeListSize(list* list) {
    int size = 0;
    Node* currentNode = list->head->next;
    while(currentNode != list->tail) {
        size++;
        currentNode = currentNode->next;
    }
    return size;
}

void add(list *list, int r, char e) {
    int size = getNodeListSize(list);
    // 추가할 새로운 노드 생성
    Node* newNode = createNode();
    newNode->data = e;
    // 위치에 넣을 수 있을 때
    if(size >= r - 1 && r >= 1) {
        Node *targetNode = getByPosition(list, r - 1);
        newNode->prev = targetNode;
        newNode->next = targetNode->next;
        targetNode->next->prev = newNode;
        targetNode->next = newNode;
        return;
    }

    // 위치가 유효하지 않을 때
    printf("invalid position\n");
    return;
}

void delete(list *list, int r) {
    int size = getNodeListSize(list);
    if(size >= r && r >= 1) {
        Node *targetNode = getByPosition(list, r);
        Node *prevNode = targetNode->prev;
        Node *nextNode = targetNode->next;
        prevNode->next = nextNode;
        nextNode->prev = prevNode;
        if(targetNode != NULL) {
            free(targetNode);
        }
        return;
    }

    printf("invalid position\n");
    return;
}

// 위치를 통해 node 가져오기
Node* getByPosition(list *list, int r) {
    int position = 0;
    Node *currentNode = list->head;
    while(position != r) {
        position++;
        currentNode = currentNode->next;
    }
    return currentNode;
}

// list의 순위 r 에 위치한 원소를 반환
void get(list* list, int r) {
    int size = getNodeListSize(list);
    if(size >= r && r >= 1) {
        Node* targetNode = getByPosition(list, r);
        printf("%c\n", targetNode->data);
        return;
    }

    // 유효하지 않은 위치가 입력됐을 때
    printf("invalid position\n");
    return;
}

// list 에 있는 모든 원소 출력하기
void print(list *list) {
    Node *currentNode = list->head->next;
    while(currentNode != list->tail) {
        printf("%c", currentNode->data);
        currentNode = currentNode->next;
    }

    printf("\n");
}
