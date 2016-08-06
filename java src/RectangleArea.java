/*
 * Rectangle Area
 * Tag: Math
 */
import java.util.*;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // General: type: use A > B judegement to avoid A - B > 0 judgement with possible overflow
        // Calculate merge area!!
        int mergeX = Math.min(C, G) > Math.max(A, E) ? Math.min(C, G) - Math.max(A, E) : 0;
        int mergeY = Math.min(D, H) > Math.max(B, F) ? Math.min(D, H) - Math.max(B, F) : 0;
        return (C - A) * (D - B) + (G - E) * (H - F) - mergeX * mergeY;
    }
}