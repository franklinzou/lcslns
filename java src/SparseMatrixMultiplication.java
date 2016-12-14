/*
 * Sparse Matrix Multiplication
 * Tag: Hash Table
 */
import java.util.*;

public class SparseMatrixMultiplication {
    public class Node {
        public int x;
        public int y;
        public int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, k = A[0].length, n = B[0].length;
        // store non-zero nodes in A, B matrix and only work on these nodes subsequently
        List<Node> ANodes = new ArrayList<Node>(), BNodes = new ArrayList<Node>();
        int [][] res = new int[m][n];
        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= k - 1; j ++)
                if(A[i][j] != 0) ANodes.add(new Node(i, j, A[i][j]));
        
        for(int i = 0; i <= k - 1; i ++)
            for(int j = 0; j <= n - 1; j ++)
                if(B[i][j] != 0) BNodes.add(new Node(i, j, B[i][j]));
                
        for(Node ANode : ANodes)
            for(Node BNode : BNodes)
                if(ANode.y == BNode.x) res[ANode.x][BNode.y] += ANode.val * BNode.val;
        return res;        
    }
}
