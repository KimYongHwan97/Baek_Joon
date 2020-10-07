#include<stdio.h>

void main()
{
	int a, b;

	scanf("%d %d", &a, &b);
	if (a > b)
		printf(">");
	if (a < b)
		printf("<");
	if (a == b)
		printf("==");
	exit(0);
}
