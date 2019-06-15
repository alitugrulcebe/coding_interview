package codewar;

import java.util.Objects;

public class Maze {

    public static class Coordinate {

        public int row, col;

        public Coordinate (int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            if (row != that.row || col != that.col) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row , col);
        }

    }

    public static boolean hasExit(String[] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length()];
        Coordinate exit = null;
        int ki = -1;
        int kj = -1;
        int count = 0;
        for(int i = 0; i< maze.length; i++) {
            for(int j=0; j< maze[i].length(); j++) {
                if(maze[i].charAt(j) == 'k') {
                    ki = i;
                    kj = j;
                    count++;
                }
            }
        }
        for(int i = 0; i< maze.length; i++) {
            if (maze[i].charAt(0) == ' ') {
                String s1 = maze[i];
                StringBuilder sb = new StringBuilder(s1);
                sb.setCharAt(0, 'E');
                maze[i] = sb.toString();
                exit = new Coordinate(i,0);
            }
            if (maze[i].charAt(maze[i].length() - 1) == ' ') {
                String s1 = maze[i];
                StringBuilder sb = new StringBuilder(s1);
                sb.setCharAt(maze[i].length() - 1, 'E');
                maze[i] = sb.toString();
                exit = new Coordinate(i,maze[i].length() - 1);
            }
        }
        for(int j = 0; j< maze[0].length(); j++) {

            if (maze[0].charAt(j) == ' ') {
                String s1 = maze[0];
                StringBuilder sb = new StringBuilder(s1);
                sb.setCharAt(j, 'E');
                maze[0] = sb.toString();
                exit = new Coordinate(0,j);
            }

            if (maze[maze.length -1].charAt(j) == ' ') {
                String s1 = maze[maze.length -1];
                StringBuilder sb = new StringBuilder(s1);
                sb.setCharAt(j, 'E');
                maze[maze.length - 1] = sb.toString();
                exit = new Coordinate(maze.length -1,j);
            }
        }


        if(count > 1 || count < 1)
            throw new RuntimeException();
        else if(maze.length == 1 && maze[0].length() == 1) {
            return true;
        } else {
//            String s1 = maze[ki];
//            StringBuilder sb = new StringBuilder(s1);
//            sb.setCharAt(kj,'#');
//            maze[ki] = sb.toString();
            return hasExitHelper(maze, new Coordinate(ki,kj), exit);
        }
    }

    private static boolean isWalkable(String[] maze,Coordinate current) {
        return current.row >= 0 && current.row < maze.length &&
                current.col >= 0 && current.col < maze[current.row].length() &&
                (maze[current.row].charAt(current.col) == ' ' || maze[current.row].charAt(current.col) == 'k');
    }


    public static boolean hasExitHelper(String[] maze, Coordinate c,Coordinate exit) {
        if( c.equals(exit)) {
            return true;
        }

        final int[][]SHIFT={{0, 1},{1,0},{0,-1},{-1,0}};
//        Coordinate next = new Coordinate(c.row + s[0], c.col + s[1]);

        // Check if maze[x][y] is valid
        if (isWalkable(maze,c)) {
            // mark x, y as part of solution path
            String s1 = maze[c.row];
            StringBuilder sb = new StringBuilder(s1);
            sb.setCharAt(c.col, '#');
            maze[c.row] = sb.toString();

            /* Move forward in x direction */
            if (hasExitHelper(maze, new Coordinate(c.row + 1, c.col), exit))
                return true;

            if (hasExitHelper(maze, new Coordinate(c.row, c.col + 1), exit))
                return true;

            /* If moving in x direction doesn't give
            solution then Move down in y direction */
            if (hasExitHelper(maze, new Coordinate(c.row - 1, c.col), exit))
                return true;

            if (hasExitHelper(maze, new Coordinate(c.row, c.col - 1), exit))
                return true;

            /* If none of the above movements works then
            BACKTRACK: unmark x, y as part of solution
            path */
            s1 = maze[c.row];
            sb = new StringBuilder(s1);
            sb.setCharAt(c.col, ' ');
            maze[c.row] = sb.toString();
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] maze = {   "########",
                            "# # ## #",
                            "# #k#  #",
                            "# # # ##",
                            "# # #  #",
                            "#     ##",
                            "########"
        };
//        String[] maze = {"########",
//                "# # ####",
//                "# #k#   ",
//                "# # # ##",
//                "# # # ##",
//                "#      #",
//                "########"};

//        String[] maze = { "####",
//                "##k#",
//                "## #",
//                "## #"};

        System.out.println(hasExit(maze));
    }
}