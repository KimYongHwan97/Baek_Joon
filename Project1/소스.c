#include<stdio.h>

void main()
{
	int a, b;
	int c;

	printf("�� �ްڽ��ϴ�");
	scanf("%d", &a);

	for (b = 2; b <= a; b++)
	{
		for (c = 2; c < b; c++)
		{
			//if (b % c == 0)
				//break;
			printf("�����߽��ϴ�");
		}
	}/*
	while (a <= 1);
	if (b == c)
	{
		printf("%d\n", b);
	}*/
}