#include<stdio.h>

void main()
{
	int a, b;
	int c;

	printf("값 받겠습니다");
	scanf("%d", &a);

	for (b = 2; b <= a; b++)
	{
		for (c = 2; c < b; c++)
		{
			//if (b % c == 0)
				//break;
			printf("실행했습니다");
		}
	}/*
	while (a <= 1);
	if (b == c)
	{
		printf("%d\n", b);
	}*/
}