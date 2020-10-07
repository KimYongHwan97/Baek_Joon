#include <stdio.h>


void main()
{
	int a=1000, b;
	int count = 0;

	printf("\n몇번째 값을 출력하시겠습니까?");
	scanf("%d", &b);

	for (int i = 2; i <= a; i++)
	{
		if ((i % 1) == 0 && (i % i) == 0 && (i % 2) != 0 && (i % 3) != 0 && (i % 5) != 0 || i == 2 || i == 3 || i == 5)
		{
			count++;
			if (count == b)
			{
				printf("%d", i);
			}
		}

	}

}