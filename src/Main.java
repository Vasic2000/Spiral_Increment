public class Main {

    public static void main(String[] args) {

        int[][] matrix = Spiral_Increment(9, Rotation.ClockWize);
        printMatrix(matrix);

        System.out.println();

        matrix = Spiral_Increment(13, Rotation.CounterClockWize);
        printMatrix(matrix);
    }

    public static int[][] Spiral_Increment(int Size, Rotation rot) {
        Direction dir;
        if (rot == Rotation.ClockWize)
            dir = Direction.Right;
        else
            dir = Direction.Down;

        int[][] matrix = new int[Size][Size];
        int x = 0, y = 0, value = 1;
        matrix[x][y] = value;

        while (value < Size * Size) {

            if (dir == Direction.Right) {
                if ((x + 1) == matrix[0].length) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Down;
                    else
                        dir = Direction.Up;

                } else if (matrix[x + 1][y] != 0) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Down;
                    else
                        dir = Direction.Up;

                } else {
                    x++;
                    matrix[x][y] = ++value;
                }
            }

            if (dir == Direction.Down) {
                if ((y + 1) == matrix.length) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Left;
                    else
                        dir = Direction.Right;

                } else if (matrix[x][y + 1] != 0) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Left;
                    else
                        dir = Direction.Right;

                } else {
                    y++;
                    matrix[x][y] = ++value;
                }
            }

            if (dir == Direction.Left) {
                if ((x - 1) == -1) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Up;
                    else
                        dir = Direction.Down;

                } else if (matrix[x - 1][y] != 0) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Up;
                    else
                        dir = Direction.Down;

                } else {
                    x--;
                    matrix[x][y] = ++value;
                }
            }

            if (dir == Direction.Up) {
                if ((y - 1) == -1) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Right;
                    else
                        dir = Direction.Left;

                } else if (matrix[x][y - 1] != 0) {
                    if (rot == Rotation.ClockWize)
                        dir = Direction.Right;
                    else
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
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++)
                if (matrix[i][j] < 10) System.out.print(matrix[i][j] + "   ");
                else if (matrix[i][j] < 100) System.out.print(matrix[i][j] + "  ");
                else System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}