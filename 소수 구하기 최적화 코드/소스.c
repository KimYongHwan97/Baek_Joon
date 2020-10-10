#include <stdio.h>

void main() {
    int i, j;
    int num;

    scanf("%d", &num);

    for (i = 2; i <= num/2; i++)
    {
        if (num % i == 0)
        {
            printf("소수가 아닙니다");
            break;
        }
        else
        {
            printf("소수 입니다");
            break;
        }
    }
}