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


//���� ������ �Է¹޾� 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.