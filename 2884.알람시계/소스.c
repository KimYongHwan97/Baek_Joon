#include <stdio.h>

void main()
{
	int H, M;

	scanf("%d %d", &H, &M);
	if (0 <= H && H <= 23 && 0 <= M && M <= 59)
	{
			if (H >= 24)
			{
				H = H - 24;
			}
			M = 60 - (M - 45);
			if (M >= 60)
			{
				H++;
				M = M - 60;
			}
			printf("%d %d", H, M);
		if (M - 45 < 45)
		{
			H--;
			if (H < 0)
			{
				H = H + 24;
			}
			M = 60 + (M - 45);
			if (M >= 60)
			{
				H++;
				M = M - 60;
			}
			printf("%d %d", H, M);

		}
	}
	exit(0);
}