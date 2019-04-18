public class Main {

    public static void main(String[] args) {

        int[][] matrix = Spiral_Increment_Clockwise(15);
        printMatrix(matrix);

        System.out.println();

        matrix = Spiral_Increment_Counter_Clockwise(15);
        printMatrix(matrix);

    }

    public static int[][] Spiral_Increment_Clockwise(int Size) {
        int[][] matrix = new int[Size][Size];
        int x = 0;
        int y = 0;
        int value = 1;
        Direction dir = Direction.Right;
        matrix[x][y] = value;

        while (value < Size * Size) {
            if (dir == Direction.Right) {
                if ((x + 1) == matrix[0].length) {
                    dir = Direction.Down;
                } else if (matrix[x + 1][y] != 0) {
                    dir = Direction.Down;
                } else {
                    x++;
                    matrix[x][y] = ++value;
                }
            }
            if (dir == Direction.Down) {
                if ((y + 1) == matrix.length) {
                    dir = Direction.Left;
                } else if (matrix[x][y + 1] != 0) {
                    dir = Direction.Left;
                } else {
                    y++;
                    matrix[x][y] = ++value;
                }
            }
            if (dir == Direction.Left) {
                if ((x - 1) == -1) {
                    dir = Direction.Up;
                } else if (matrix[x - 1][y] != 0) {
                    dir = Direction.Up;
                } else {
                    x--;
                    matrix[x][y] = ++value;
                }
            }
            if (dir == Direction.Up) {
                if ((y - 1) == -1) {
                    dir = Direction.Right;
                } else if (matrix[x][y-1] != 0) {
                    dir = Direction.Right;
                } else {
                    y--;
                    matrix[x][y] = ++value;
                }
            }
        }
        return matrix;
    }


    public static int[][] Spiral_Increment_Counter_Clockwise(int Size) {
        int[][] matrix = new int[Size][Size];
        int x = 0;
        int y = 0;
        int value = 1;
        Direction dir = Direction.Down;
        matrix[x][y] = value;

        while (value < Size * Size) {
            if (dir == Direction.Right) {
                if ((x + 1) == matrix[0].length) {
                    dir = Direction.Up;
                } else if (matrix[x + 1][y] != 0) {
                    dir = Direction.Up;
                } else {
                    x++;
                    matrix[x][y] = ++value;
                }
            }
            if (dir == Direction.Down) {
                if ((y + 1) == matrix.length) {
                    dir = Direction.Right;
                } else if (matrix[x][y + 1] != 0) {
                    dir = Direction.Right;
                } else {
                    y++;
                    matrix[x][y] = ++value;
                }
            }
            if (dir == Direction.Left) {
                if ((x - 1) == -1) {
                    dir = Direction.Down;
                } else if (matrix[x - 1][y] != 0) {
                    dir = Direction.Down;
                } else {
                    x--;
                    matrix[x][y] = ++value;
                }
            }
            if (dir == Direction.Up) {
                if ((y - 1) == -1) {
                    dir = Direction.Left;
                } else if (matrix[x][y-1] != 0) {
                    dir = Direction.Left;
                } else {
                    y--;
                    matrix[x][y] = ++value;
                }
            }
        }
        return matrix;
    }


    public static void printMatrix(int[][] matrix) {
        for(int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++)
                if(matrix[i][j] < 10) System.out.print(matrix[i][j] + "   ");
                else if(matrix[i][j] < 100) System.out.print(matrix[i][j] + "  ");
                else System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}