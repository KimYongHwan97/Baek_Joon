#include <stdio.h>

void main()
{
	int A, B, C;

	scanf("%d %d %d", &A, &B, &C);

	printf("%d\n", (A + B) % C);
	printf("%d\n", (((A % C) + (B % C)) % C));
	printf("%d\n", (A * B) % C);
	printf("%d", ((A % C) * (B % C)) % C);

	exit(0);
}



/*(A+B)%C�� ((A%C) + (B%C))%C �� ������?

(A��B)%C�� ((A%C) �� (B%C))%C �� ������?*/