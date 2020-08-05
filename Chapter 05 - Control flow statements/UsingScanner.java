import java.util.Scanner;

public class UsingScanner {

    public static void main(String[] args) {
        //scanner
        Scanner scanner = new Scanner(System.in);

//        System.out.println("How old are you?");
//        int age = scanner.nextInt();
//        scanner.nextLine(); //this takes care of the integer input issue
//        System.out.println("You are "+age+" years old\n");
//
//        System.out.println("What is your name?");
//        String name = scanner.nextLine();
//        System.out.println("Your name is " + name);
//
//        System.out.println("What is your surname?");
//        String surname = scanner.nextLine();
//        System.out.println("Your surname is " + surname);

        for (boolean i=true; i;) {
            System.out.println("Enter 'Mikis' ");
            String myVar = scanner.nextLine();
            if (myVar.equals("Mikis")) {
                System.out.println("Correct!");
                i = false;
            }
        }

        scanner.close();
//        System.out.println("Again, you are "+name+" "+surname+", "+age+" years old");
    }

}
