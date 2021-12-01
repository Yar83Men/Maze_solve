package Algorithm_and_Structure;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        // 1 приход
        // 0 не проходной
        // Вход  [0, 0], выход [4, 4]


        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int[][] maze1 = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        int[][] grid = {
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

        System.out.println(checkMaze(maze1, 0, 0, 4, 3));
        Arrays.stream(maze1).forEach(arrayElement -> System.out.println(Arrays.toString(arrayElement)));

        System.out.println(checkMaze(maze, 0, 0, 3, 3));
        Arrays.stream(maze).forEach(arrayElement -> System.out.println(Arrays.toString(arrayElement)));

        System.out.println(checkMaze(grid, 0, 0, 12, 7));
        Arrays.stream(grid).forEach(arrayElement -> System.out.println(Arrays.toString(arrayElement)));
    }

    private static boolean checkMaze(int[][] maze, int col, int row, int endCol, int endRow) {
        maze[col][row] = 5;
        if (col == endCol && row == endRow) {
            return true;
        }
        boolean result = false;
        // up
        if (isValid(col, row - 1, maze) && maze[col][row - 1] != 5
                || (isValid(col, row - 2, maze) && maze[col][row - 1] == 5)
        ) {
            row--;
            result = checkMaze(maze, col, row, endCol, endRow);
        }
        // down
        if (isValid(col, row + 1, maze) && !result && maze[col][row + 1] != 5
                || (isValid(col, row + 2, maze) && maze[col][row + 1] == 5)
        ) {
            row++;
            result = checkMaze(maze, col, row, endCol, endRow);
        }
        // left
        if (isValid(col - 1, row, maze) && !result && maze[col - 1][row] != 5
                || (isValid(col, row, maze) && maze[col - 1][row] == 5)) {
            col--;
            result = checkMaze(maze, col, row, endCol, endRow);
        }
        // right
        if (isValid(col + 1, row, maze) && !result && maze[col + 1][row] != 5
                || (isValid(col, row, maze) && maze[col + 1][row] == 5)) {
            col++;
            result = checkMaze(maze, col, row, endCol, endRow);
        }
        //System.out.println("col = " + col + " " + "row = " + row);
        return result;
    }

    private static boolean isValid(int col, int row, int[][] maze) {
        return col >= 0 && col < maze.length && row >= 0 && row < maze[0].length && maze[col][row] == 1;
    }
}
