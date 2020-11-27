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
    ArrayList<contact> contactDetails = new ArrayList<>();
    public void addcontact(contact obj) {
        contactDetails.add(obj);
    }
    public ArrayList<contact> viewcontact(){
        return contactDetails;
    }
}
public class AddressBookMain {
    static ArrayList<String> check=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("..........Address Book Problem................");
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList> addbook = new HashMap<>();
        int var = 1;
        int p = 0;
        while (var == 1) {
            System.out.println("1.new addressbook 2.Exit");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Enter addressbook name");
                    String addbookname = sc.next();
                    for (int i = 0; i < check.size(); i++) {
                        if (addbookname.equals(check.get(i))) {
                            System.out.println("Sorry, Addressbook already exists");
                            p = 1;
                        }
                    }
                    if (p == 1) {
                        break;
                    }
                    System.out.println("Enter Number of person");
                    int personno = sc.nextInt();
                    bookdetails book1 = new bookdetails();
                    ArrayList<String> check1=new ArrayList<>();
                    contact c1 = new contact();
                    System.out.println("Enter First Name:");
                    c1.firstname = sc.next();
                    System.out.println("Enter last name: ");
                    c1.lastname = sc.next();
                    System.out.println("Enter address");
                    c1.address = sc.next();
                    System.out.println("Enter City: ");
                    c1.city = sc.next();
                    System.out.println("Enter State: ");
                    c1.state = sc.next();
                    System.out.println("Enter zip: ");
                    c1.zip = sc.nextInt();
                    System.out.println("Enter phone number: ");
                    c1.phoneno = sc.nextInt();
                    System.out.println("Enter email id: ");
                    c1.email = sc.next();
                    System.out.println("End of contact");
                    book1.addcontact(c1);
                    check1.add(c1.firstname);
                    if(personno>=2) {
                        for (int i = 0; i < personno-1; i++) {
                            contact c2 = new contact();
                            System.out.println("Enter First Name:");
                            c2.firstname = sc.next();
                            while (c2.firstname != check1.get(i)) {
                                System.out.println("Person already exists");
                                System.out.println("Enter First Name:");
                                c2.firstname = sc.next();
                                break;
                            }
                            System.out.println("Enter last name: ");
                            c2.lastname = sc.next();
                            System.out.println("Enter address");
                            c2.address = sc.next();
                            System.out.println("Enter City: ");
                            c2.city = sc.next();
                            System.out.println("Enter State: ");
                            c2.state = sc.next();
                            System.out.println("Enter zip: ");
                            c2.zip = sc.nextInt();
                            System.out.println("Enter phone number: ");
                            c2.phoneno = sc.nextInt();
                            System.out.println("Enter email id: ");
                            c2.email = sc.next();
                            System.out.println("End of contact");
                            book1.addcontact(c2);
                            check1.add(c2.firstname);
                        }
                    }
                    addbook.put(addbookname, book1.viewcontact());

                    System.out.println("Edit or delete person details 1.Edit 2.delete");
                    int option = sc.nextInt();

                    String nameofperson;
                    switch (option) {
                        case 1:
                            System.out.println("Enter fname");
                            nameofperson = sc.next();
                            for (int i = 0; i < book1.viewcontact().size(); i++) {
                                if (nameofperson.equalsIgnoreCase(book1.viewcontact().get(i).firstname)) {
                                    System.out.println("1.FirstName" + " " + "2.Lastname" + "  " + "3.Address" + " " + "4.city" + " " + "5.state" + " " + "6.zip" + " " + "7.phone" + " " + "8.email");
                                    int choose = sc.nextInt();
                                    switch (choose) {
                                        case 1:
                                            System.out.println("New First Name:");
                                            book1.viewcontact().get(i).firstname = sc.next();
                                            break;
                                        case 2:
                                            System.out.println("New Last Name:");
                                            book1.viewcontact().get(i).lastname = sc.next();
                                            break;
                                        case 3:
                                            System.out.println("New Address:");
                                            book1.viewcontact().get(i).address = sc.next();
                                            break;
                                        case 4:
                                            System.out.println("New City:");
                                            book1.viewcontact().get(i).city = sc.next();
                                            break;
                                        case 5:
                                            System.out.println("New State:");
                                            book1.viewcontact().get(i).state = sc.next();
                                            break;
                                        case 6:
                                            System.out.println("New zip:");
                                            book1.viewcontact().get(i).zip = sc.nextInt();
                                            break;
                                        case 7:
                                            System.out.println("New phone no:");
                                            book1.viewcontact().get(i).phoneno = sc.nextInt();
                                            break;
                                        case 8:
                                            System.out.println("New email:");
                                            book1.viewcontact().get(i).email = sc.next();
                                            break;
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter firstname");
                            nameofperson = sc.next();
                            for (int i = 0; i < book1.viewcontact().size(); i++) {
                                if (nameofperson.equalsIgnoreCase(book1.viewcontact().get(i).firstname)) {
                                    book1.viewcontact().remove(i);
                                }
                            }
                            break;
                        case 3:
                            break;
                    }
                    check.add(addbookname);

                    for (int i = 0; i < book1.viewcontact().size(); i++) {
                        System.out.println("Details of person " + (i + 1));
                        System.out.println(book1.viewcontact().get(i).firstname);
                        System.out.println(book1.viewcontact().get(i).lastname);
                        System.out.println(book1.viewcontact().get(i).address);
                        System.out.println(book1.viewcontact().get(i).city);
                        System.out.println(book1.viewcontact().get(i).state);
                        System.out.println(book1.viewcontact().get(i).zip);
                        System.out.println(book1.viewcontact().get(i).phoneno);
                        System.out.println(book1.viewcontact().get(i).email);
                    }
                    var = 1;
                    break;
                case 2:
                    System.out.println("Thank You");
                    var = 0;
                    break;


            }
        }
    }
}
