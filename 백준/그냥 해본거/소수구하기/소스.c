#include <stdio.h>


void main()
{
	int a,b,c=0;
	int arr[1000];
	scanf("%d", &a);

	for (int i = 2; i <= a;i++)
	{
		if ((i % 1) == 0 && (i % i) == 0 && (i%2) != 0 && (i%3) != 0 && (i%5) != 0 || i==2 || i==3 || i==5)
		{
			printf("%d ,",i);
			arr[c] = i;
			c++;
					
		}
		
	}
	printf("\n몇번째 값을 출력하시겠습니까?");
	scanf("%d", &b);
	printf("%d",arr[b]);
}