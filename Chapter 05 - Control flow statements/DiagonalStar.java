public class DiagonalStar {

    public static void main(String[] args) {

        printSquareStar(5);
        printSquareStar(8);
        printSquareStar(17);

    }

    public static void printSquareStar(int number) {

        if (number<5) {
            System.out.println("Invalid Value");
        } else {
            for (int row = 1; row <= number; row++) {
                for (int column = 1; column <= number; column++) {
                    if ((row==1) || (column==1) || (row==number) || (column==number) || (row==column) || (number+1==row+column)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
            System.out.println("\n");
        }
    }

}