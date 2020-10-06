#include <stdio.h>

void main()
{
	double a, b;
	scanf("%lf %lf", &a, &b);
	printf("%.9lf", a/b);

	exit(0);
}