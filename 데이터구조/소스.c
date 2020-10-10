#include <stdio.h>
#include <stdlib.h> // malloc사용 
#define null NULL// NULL로 쓰기 귀찮아서 null이 NULL처럼 사용 할 수 있게 표현함. 
//노드 구조체 
typedef struct Node {
    int coef;
    int expen;
    Node* link;
}Node;

//헤드포인터 
typedef struct head {
    Node* link;
}head;

Node* creatNode(int a, int b) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->coef = a;
    newNode->expen = b;
    newNode->link = NULL;

    return newNode;
}

void insertNode(head* list, int a, int b) {
    Node* newNode = creatNode(a, b, cnt); // 노드 생성. 
    head* tmpNode = (head*)malloc(sizeof(head)); // 실제로 움직이는 노드생성. 
    tmpNode->link = list->link; // 실제로 움직이는 노드의 초기값을 헤드노드와 일치시킴. 

    if (list->link == null) { // 연결리스트가 비여있다면 헤드노드의 링크에 연결 
        list->link = newNode;
    }
    else {
        while (tmpNode->link->link != null) {
            // 다다음이 null값일 때 까지 움직여야 한다. 
            // 만약 tmpNode->link != null로 반복문을 돌린다면 
            // 노드 이동을 하기도 힘들고 후에 삽입하기도 힘들다.
            // 직접해보면 알 수 있을것이다.

            tmpNode->link = tmpNode->link->link;
            // 다음 노드로 이동 
        }

        tmpNode->link->link = newNode;
    }

    free(tmpNode);
    // 이용가치가 없는 메모리는 반환한다. 
}

void init(head* list) {
    list->link = NULL;
}

main() {
    int i, n, a, b;

    head list;
    // 연결리스트를 선언 (원래 이것도 포인터로 해야하는데) 
    // 포인터로 선언하면 다른 함수에서 이중포인터 쓰면서 하는거라서
    // 그건 나중에 당신의 힘으로 해보시기를... 

    init(&list);
    // 리스트의 포인터를 null값으로 초기화 함. 

    scanf("%d", &n);
    // 삽입할 노드의 갯수를 입력받음.

    for (i = 0; i < n; i++) {
        scanf("%d %d", &a, &b);
        // 노드에 들어갈 값을 입력 받음.

        insertNode(&list, a, b);
        // list에 a,b의 값을 노드로써 삽입한다. 
    }


    head* tmp = (head*)malloc(sizeof(head));
    // 그냥 list를 움직이게 된다면 메모리 누수, 메모리 유실이 일어나므로
    // 새로운 값을 선언한다. 
    tmp->link = list.link;

    for (i = 0; i < n; i++) {
        printf("%d %d\n", tmp->link->coef, tmp->link->expen);
        // 연결리스트 출력하는거. 

        tmp->link = tmp->link->link;
        // 다음 노드로 이동. 

    }

    free(tmp);
}