package 二刷;

public class TwoTwentythree_RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
		int overlap = 0;
		int a = Math.max(A, E);
		int b = Math.min(C, G);
		int c = Math.max(B, F);
		int d = Math.min(D, H);
		if(a < b && c < d){
			overlap = (b-a)*(d-c);
		}
		return (C-A) * (D-B) + (G-E) * (H-F) - overlap;
	}
}
