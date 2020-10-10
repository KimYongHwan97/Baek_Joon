#include <stdio.h>
#include <stdlib.h> // malloc��� 
#define null NULL// NULL�� ���� �����Ƽ� null�� NULLó�� ��� �� �� �ְ� ǥ����. 
//��� ����ü 
typedef struct Node {
    int coef;
    int expen;
    Node* link;
}Node;

//��������� 
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
    Node* newNode = creatNode(a, b, cnt); // ��� ����. 
    head* tmpNode = (head*)malloc(sizeof(head)); // ������ �����̴� ������. 
    tmpNode->link = list->link; // ������ �����̴� ����� �ʱⰪ�� ������ ��ġ��Ŵ. 

    if (list->link == null) { // ���Ḯ��Ʈ�� ���ִٸ� ������� ��ũ�� ���� 
        list->link = newNode;
    }
    else {
        while (tmpNode->link->link != null) {
            // �ٴ����� null���� �� ���� �������� �Ѵ�. 
            // ���� tmpNode->link != null�� �ݺ����� �����ٸ� 
            // ��� �̵��� �ϱ⵵ ����� �Ŀ� �����ϱ⵵ �����.
            // �����غ��� �� �� �������̴�.

            tmpNode->link = tmpNode->link->link;
            // ���� ���� �̵� 
        }

        tmpNode->link->link = newNode;
    }

    free(tmpNode);
    // �̿밡ġ�� ���� �޸𸮴� ��ȯ�Ѵ�. 
}

void init(head* list) {
    list->link = NULL;
}

main() {
    int i, n, a, b;

    head list;
    // ���Ḯ��Ʈ�� ���� (���� �̰͵� �����ͷ� �ؾ��ϴµ�) 
    // �����ͷ� �����ϸ� �ٸ� �Լ����� ���������� ���鼭 �ϴ°Ŷ�
    // �װ� ���߿� ����� ������ �غ��ñ⸦... 

    init(&list);
    // ����Ʈ�� �����͸� null������ �ʱ�ȭ ��. 

    scanf("%d", &n);
    // ������ ����� ������ �Է¹���.

    for (i = 0; i < n; i++) {
        scanf("%d %d", &a, &b);
        // ��忡 �� ���� �Է� ����.

        insertNode(&list, a, b);
        // list�� a,b�� ���� ���ν� �����Ѵ�. 
    }


    head* tmp = (head*)malloc(sizeof(head));
    // �׳� list�� �����̰� �ȴٸ� �޸� ����, �޸� ������ �Ͼ�Ƿ�
    // ���ο� ���� �����Ѵ�. 
    tmp->link = list.link;

    for (i = 0; i < n; i++) {
        printf("%d %d\n", tmp->link->coef, tmp->link->expen);
        // ���Ḯ��Ʈ ����ϴ°�. 

        tmp->link = tmp->link->link;
        // ���� ���� �̵�. 

    }

    free(tmp);
}