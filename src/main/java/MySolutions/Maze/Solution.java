package MySolutions.Maze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution
{
    class Node {
        int x,y,dist;
        Node(int x,int y,int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    private static final int[] row = {-1,0,0,1};
    private static final int[] col = { 0,-1,1,0};

    boolean isValid(List<List<Integer>> lot, boolean[][] visited, int row, int column, int numRows, int numColumns) {
        return (row >= 0) &&
                (row < numRows) &&
                (column >= 0) &&
                (column < numColumns) &&
                (lot.get(row).get(column) == 1) &&
                visited[row][column] == false;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        int min_dist = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[numRows][numColumns];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            int i = n.x;
            int j = n.y;
            int dist = n.dist;
            if(lot.get(i).get(j) == 9) {
                min_dist = n.dist;
                break;
            }

            for(int k=0;k<4;k++) {
                if(isValid(lot,visited,i+row[k],j+col[k],numRows,numColumns)) {
                    visited[i+row[k]][j+col[k]] = true;
                    queue.add(new Node(i+row[k],j+col[k],dist+1));
                }
            }
        }
        return min_dist;
    }

    public static void main(String[] args) {
        List<List<Integer>> path = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(0);
        a.add(0);
        path.add(a);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(0);
        b.add(0);
        path.add(b);
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(9);
        c.add(1);
        path.add(c);

        Solution x = new Solution();
        x.removeObstacle(3,3,path);
    }

}