#include<stdio.h>

void main()
{
	int a;
	scanf("%d", &a);
	
	if (a >= 90)
		printf("A");
	if (a >= 80 && a < 90)
		printf("B");
	if (a >= 70 && a < 80)
		printf("C");
	if (a >= 60 && a < 70)
		printf("D");
	if(a < 60)
		printf("F");
	exit(0);
}


//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.