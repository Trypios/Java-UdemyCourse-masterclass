import java.util.*;

public class MobilePhone {

    private ArrayList<Contact> allContacts = new ArrayList<Contact>();
    static boolean isActive = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        while (isActive) {
            options(phone);
        }
    }

    public static void options(MobilePhone phone) {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("\t1 quit ");
            System.out.println("\t2 print contact list ");
            System.out.println("\t3 add new contact ");
            System.out.println("\t4 update existing contact ");
            System.out.println("\t5 remove contact ");
            int input;
            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\nInvalid input");
                continue;
            }
            if (input >= 1 && input <= 5) {
                switch (input) {
                    case 1:
                        // exit
                        System.out.println("Quitting!");
                        isActive = false;
                        break;
                    case 2:
                        phone.printAllContacts();
                        break;
                    case 3:
                        phone.addNewContact();
                        System.out.println("Contact added");
                        break;
                    case 4:
                        phone.modifyContact();
                        System.out.println("Contact modified");
                        break;
                    case 5:
                        phone.removeContact();
                        System.out.println("Contact deleted");
                        break;
                    default:
                        System.out.println("\nError");
                }
            }
            System.out.println("\nInvalid input");
        }
    }

    public void printAllContacts() {
        if (allContacts.size() == 0) {
            System.out.println("Contact list is empty.");
        } else {
            int contactNo = 1;
            for (Contact contact : allContacts) {
                System.out.printf("%nContact #%d: %s", contactNo, contact.getInfo());
                contactNo++;
            }
        }
    }

    public void addNewContact() {
        System.out.println("Enter contact name: ");
        String inputName = scanner.nextLine();
        System.out.println("Enter contact phone number: ");
        String inputNumber = scanner.nextLine();
        Contact contact = new Contact(inputName, inputNumber);
        if (existingContact(contact.getName())) {
            System.out.println("Contact already exists");
        } else {
            this.allContacts.add(contact);
        }
    }

    public void modifyContact() {
        int position = searchContact();
        if (position != -1) {
            String currentName = this.allContacts.get(position).getName();
            System.out.printf("%nModifying %s: %n", currentName);
            allContacts.remove(this.allContacts.get(position));
            addNewContact();
        }
    }

    public void removeContact() {
        int position = searchContact();
        if (position != -1) {
            allContacts.remove(position);
        }
    }

    private int searchContact() {
        System.out.println("Enter contact name: ");
        String inputName = scanner.nextLine();
        for (int i = 0; i < this.allContacts.size(); i++) {
            if (this.allContacts.get(i).getName().equals(inputName)) {
                return i;
            }
        }
        System.out.println("Contact not found");
        return -1;
    }

    private boolean existingContact(String contactName) {
        for (Contact contact : this.allContacts) {
            if (contact.getName().equals(contactName)) {
                return true;
            }
        }
        return false;
    }

}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact (String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInfo() {
        return String.format("%nName: %s%nPhone Number: %s%n", this.name, this.phoneNumber);
    }
}
