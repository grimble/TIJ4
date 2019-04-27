package ru.grimble.tij4.io;

public class CrossPrint {

    int rows;
    int cols;

    CrossPrint(int rows, int cols) {
        this.rows= rows;
        this.cols= cols;
    }

    class CrossLine {
        CrossLine() {
            for (int i=0; i < cols; i++) System.out.print("X");
            System.out.println();
        }
    }

    class FigureLine {
        FigureLine(int row) {

            if (row == 0 || row == cols - 1)
                throw new IndexOutOfBoundsException();

            int xcol= cols*row/rows;

            for (int col=0; col < cols; col++)
                if (col == 0 || col == cols - 1)
                    System.out.print("X");
                else if (col == xcol || col == cols - 1 - xcol)
                    System.out.print("X");
                else
                    System.out.print(" ");

            System.out.println();
        }
    }

    public void print() {

        for (int row=0; row < rows; row++)
            if (row == 0 || row == rows - 1)
                new CrossLine();
            else
                new FigureLine(row);

    }

    public static void main(String[] args) {

        new CrossPrint(15, 15).print();

    }

}

