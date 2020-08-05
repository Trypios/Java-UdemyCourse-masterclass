public class SwitchStatement {

    public static void main(String[] args) {

        char var = 'B';
        switch (var) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("Character " + var + " has been found");
                break;
            default:
                System.out.println("Character 'A', 'B', 'C', 'D' or 'E' has not been found");
        }

    }
}
