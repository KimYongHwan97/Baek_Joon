#include <stdio.h>

void main() {
    int i, j;
    int num;

    scanf("%d", &num);

    for (i = 2; i <= num/2; i++)
    {
        if (num % i == 0)
        {
            printf("�Ҽ��� �ƴմϴ�");
            break;
        }
        else
        {
            printf("�Ҽ� �Դϴ�");
            break;
        }
    }
}