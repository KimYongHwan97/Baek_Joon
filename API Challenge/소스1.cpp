#include <windows.h>

LRESULT CALLBACK WndProc(HWND hWnd, UINT iMessage, WPARAM wParamm, LPARAM lParam)
{
	HDC hdc, MemDC;
	PAINTSTRUCT ps;
	static HBITMAP MyBitmap;
	HBITMAP OldBitmap;
	int x, y;
	RECT rt;
	BITMAP bit;
	static int ex, ey;
}