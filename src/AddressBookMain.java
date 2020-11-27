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
    public static void main(String args[]){
        System.out.println(".......Welcome to Address Book.......");
        Scanner sc = new Scanner(System.in);
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
}
