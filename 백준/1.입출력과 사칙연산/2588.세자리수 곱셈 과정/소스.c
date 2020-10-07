#include <stdio.h>

void main()
{
	int a, b; // a = 472 , b = 385 박을예정
	int tmp;

	scanf("%d %d", &a, &b);
	tmp = b % 10;							// b를 10으로 나눈 나머지값 (5)
	printf("%d\n", a * tmp);				// 472와 일의자리 숫자 5 곱한 값
	tmp = ((b % 100) - (b % 10))/10 ;		// 472와 십의자리 숫자 8 곱한 값 /10을 안하면 8이 아니라 80을 곱하게됨.
	printf("%d\n", a * tmp);				
	tmp = (b - (b % 100))/100;				// 472와 백의자리 숫자 3 곱한 값 마찬가지로 /100을 안하면 300을 곱하게 됨.
	//printf("%d", tmp);
	printf("%d\n", a * tmp);
	printf("%d", a*b);

	exit(0);
	

}