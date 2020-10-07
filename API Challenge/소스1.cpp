#include <windows.h>

struct {
	int x, y;
	BOOL Move;

} Line[10000];
int index = 0;


LRESULT CALLBACK WndProc(HWND hWnd, UINT iMessage, WPARAM wParam, LPARAM lParam)
{
	HDC hdc;
	PAINTSTRUCT ps;
	int i;
	static BOOL bNowDraw = FALSE;
	switch (iMessage)
	{//시작점의 위치를 배열에 기록해둔다.
	case WM_LBUTTONDOWN:
		bNowDraw = TRUE;
		Line[index].x = LOWORD(lParam);
		Line[index].y = HIWORD(lParam);
		Line[index].Move = TRUE;
		index++;
		return 0;
		//다음 마우스 이동점까지 선을 그리고 배열상에 기록한다.
	case WM_MOUSEMOVE:
		if (bNowDraw == TRUE)
		{
			hdc = GetDC(hWnd);
			MoveToEx(hdc, Line[index - 1].x, Line[index - 1].y, NULL);
			Line[index].x = LOWORD(lParam);
			Line[index].y = HIWORD(lParam);
			Line[index].Move = TRUE;
			index++;
			ReleaseDC(hWnd, hdc);
		}
		return 0;
		//그리기 종료
	case WM_LBUTTONUP:
		bNowDraw = FALSE;
		return 0;
		//화면을 지우고 다시 그리며 배열의 인덱스를 리셋하여 다시 기록하도록 한다.
	case WM_RBUTTONDOWN:
		index = 0;
		InvalidateRect(hWnd, NULL, TRUE);
		return 0;
		//배열의 정보를 읽어 화면을 복구한다

	case WM_PAINT:
		hdc = BeginPaint(hWnd, &ps);
		for (i = 0; i < index; i++)
		{
			if (Line[i].Move == TRUE)
				MoveToEx(hdc, Line[i].x, Line[i].y, NULL);
			else
				LineTo(hdc, Line[i].x, Line[i].y);
		}
		EndPaint(hWnd, &ps);
		return 0;
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	}
	return(DefWindowProc(hWnd, iMessage, wParam, lParam));
}