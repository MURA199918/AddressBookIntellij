import java.util.*;
class contact{
    String firstname;
    String lastname;
    String address;
    String city;
    String state;
    int zip;
    int phoneno;
    String email;
}
class bookdetails{
    ArrayList<contact> contactDetails = new ArrayList<contact>();
    public void addcontact(contact obj) {
        contactDetails.add(obj);
    }
    public ArrayList<contact> viewAllPerson(){
        return contactDetails;
    }
}
public class AddressBookMain {
    public static void main(String args[]) {
        System.out.println(".......Welcome to Address Book.......");
        Scanner sc = new Scanner(System.in);
        bookdetails book1 = new bookdetails();
        for (int i = 0; i < 2; i++) {
            contact c1 = new contact();
            System.out.println("Enter First Name:");
            c1.firstname = sc.nextLine();
            System.out.println("Enter the last name: ");
            c1.lastname = sc.nextLine();
            System.out.println("Enter the address");
            c1.address = sc.nextLine();
            System.out.println("Enter the City: ");
            c1.city = sc.nextLine();
            System.out.println("Enter the State: ");
            c1.state = sc.nextLine();
            System.out.println("Enter the zip: ");
            c1.zip = sc.nextInt();
            System.out.println("Enter the mob.no: ");
            c1.phoneno = sc.nextInt();
            System.out.println("Enter the email: ");
            c1.email = sc.next();
            System.out.println("Thank You");
            bookdetails book1 = new bookdetails();
            book1.addcontact(c1);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(book1.viewAllPerson().get(i).firstname);
        }

        System.out.println("Want to edit person details 1.Yes 2.No");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter fname");
                String nameofperson = sc.next();
                for (int i = 0; i < book1.viewAllPerson().size(); i++) {
                    if (nameofperson.equalsIgnoreCase(book1.viewAllPerson().get(i).firstname)) {
                        System.out.println("1.FirstName" + " " + "2.Lastname" + "  " + "3.Address" + " " + "4.city" + " " + "5.state" + " " + "6.zip" + " " + "7.phone" + " " + "8.email")
                        int choose = sc.nextInt();
                        switch (choose) {
                            case 1:
                                System.out.println("New First Name:");
                                book1.viewAllPerson().get(i).firstname = sc.next();
                                break;
                            case 2:
                                System.out.println("New Last Name:");
                                book1.viewAllPerson().get(i).lastname = sc.next();
                                break;
                            case 3:
                                System.out.println("New Address:");
                                book1.viewAllPerson().get(i).address = sc.next();
                                break;
                            case 4:
                                System.out.println("New City:");
                                book1.viewAllPerson().get(i).city = sc.next();
                                break;
                            case 5:
                                System.out.println("New State:");
                                book1.viewAllPerson().get(i).state = sc.next();
                                break;
                            case 6:
                                System.out.println("New zip:");
                                book1.viewAllPerson().get(i).zip = sc.nextInt();
                                break;
                            case 7:
                                System.out.println("New phone no:");
                                book1.viewAllPerson().get(i).phoneno = sc.nextInt();
                                break;
                            case 8:
                                System.out.println("New email:");
                                book1.viewAllPerson().get(i).email = sc.next();
                                break;
                        }
                    }
                }
                break;
            case 2:
                break;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(book1.viewAllPerson().get(i).lastname);
        }
    }

}
