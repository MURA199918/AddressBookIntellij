import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

class contact{
    String firstname;
    String lastname;
    String address;
    String city;
    String state;
    int zip;
    int phoneno;
    String email;
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(){
        this.lastname=lastname;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(){
        this.address=address;
    }
    public String getCity(){
        return city;
    }
    public void setCity(){
        this.city=city;
    }
    public String getState(){
        return state;
    }
    public void setState(){
        this.state=state;
    }
    public int getZip(){
        return zip;
    }
    public void setZip(){
        this.zip=zip;
    }
    public int getPhoneno(){
        return phoneno;
    }
    public void setPhoneno(){
        this.phoneno=phoneno;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email=email;
    }
    public String toString(){
        return String.format("FirstName: "+firstname+" "+"LastName: "+lastname+" "+"Address: "+address+" "+"City: "+city+" "+"State: "+state+" "+"Zip: "+zip+" "+"PhoneNumber: "+phoneno+" "+"EmailID: "+email);
    }
}
class bookdetails{
    ArrayList<contact> contactDetails = new ArrayList<>();
    public void addcontact(contact obj) {
        contactDetails.add(obj);
    }
    public ArrayList<contact> viewcontact(){
        return contactDetails;
    }

    public static String ADDRESS_FILE = "Adress-file.txt";
    public static void writeData(List<contact> contactList){
        StringBuffer empBuffer = new StringBuffer();
        contactList.forEach(employee ->{
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });

        try {
            Files.write(Paths.get(ADDRESS_FILE), empBuffer.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void printData() {
        try{
            Files.lines(new File(ADDRESS_FILE).toPath()).forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<contact> readData(){
        List<contact> contactList = new ArrayList<>();
        try{
            Files.lines(new File(ADDRESS_FILE).toPath())
                    .map(line->line.trim())
                    .forEach(line->System.out.println(line));
        }catch (IOException e){
            e.printStackTrace();
        }
        return contactList;
    }
}
public class AddressBookMain {
    static ArrayList<String> check=new ArrayList<>();
    public static void main(String[] args) {
        bookdetails book1=new bookdetails();
        System.out.println("..........Address Book Problem................");
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList> addbook = new HashMap<>();
        HashMap<String, String> checkcity=new HashMap<>();
        HashMap<String, String> checkstate=new HashMap<>();
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
                    //bookdetails book1 = new bookdetails();
                    ArrayList<String> check1=new ArrayList<>();
                    contact c1 = new contact();
                    System.out.println("Enter First Name:");
                    c1.firstname=sc.next();
                    System.out.println("Enter last name: ");
                    c1.lastname=sc.next();
                    System.out.println("Enter address");
                    c1.address=sc.next();
                    System.out.println("Enter City: ");
                    c1.city=sc.next();
                    System.out.println("Enter State: ");
                    c1.state=sc.next();
                    System.out.println("Enter zip: ");
                    c1.zip=sc.nextInt();
                    System.out.println("Enter phone number: ");
                    c1.phoneno=sc.nextInt();
                    System.out.println("Enter email id: ");
                    c1.email=sc.next();
                    System.out.println("End of contact");
                    book1.addcontact(c1);
                    checkcity.put(c1.firstname, c1.city);
                    checkstate.put(c1.firstname,c1.state);
                    check1.add(c1.firstname);
                    List<String> listwithoutduplicates = check1.stream().distinct().collect(Collectors.toList());
                    if(personno>=2) {
                        for (int i = 0; i < personno-1; i++) {
                            contact c2 = new contact();
                            while (c2.firstname != listwithoutduplicates.get(i)) {
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
                            checkcity.put(c2.firstname, c2.city);
                            checkstate.put(c2.firstname,c2.state);
                            check1.add(c2.firstname);
                            listwithoutduplicates = check1.stream().distinct().collect(Collectors.toList());
                        }
                    }
                    //addbook.put(addbookname, book1.viewcontact());

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
                                            int x=1;
                                            while(x==1) {
                                                System.out.println("New First Name:");
                                                book1.viewcontact().get(i).firstname = sc.next();
                                                if (book1.viewcontact().get(i).firstname.equals(listwithoutduplicates.get(i))) {
                                                    x = 1;
                                                }
                                                else
                                                    x=0;
                                                    break;
                                            }
                                            checkcity.put(book1.viewcontact().get(i).firstname,book1.viewcontact().get(i).getCity());
                                            checkstate.put(book1.viewcontact().get(i).firstname,book1.viewcontact().get(i).getState());
                                            checkcity.remove(nameofperson,book1.viewcontact().get(i).getCity());
                                            checkstate.remove(nameofperson,book1.viewcontact().get(i).getState());
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
                                            checkcity.put(nameofperson,book1.viewcontact().get(i).city);
                                            break;
                                        case 5:
                                            System.out.println("New State:");
                                            book1.viewcontact().get(i).state = sc.next();
                                            checkstate.put(nameofperson,book1.viewcontact().get(i).state);
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
                    addbook.put(addbookname,book1.viewcontact());

                    System.out.println("Writing details into file");
                    bookdetails.writeData(book1.viewcontact());
                    bookdetails.printData();
                    System.out.println("Reading details from file");
                    bookdetails.readData();

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
        System.out.println("Enter city to search");
        String citysearch=sc.next();
        System.out.println("People in city "+citysearch);
        checkcity.entrySet().stream().forEach(e->{
            if(e.getValue().equals(citysearch)){
                System.out.println(e.getKey());
            }
        });
        long citycount= checkcity.entrySet().stream().filter(x->x.getValue().equals(citysearch)).count();
        System.out.println("Number of people in city "+citysearch+" is "+citycount);

        System.out.println("Enter state to search");
        String statesearch=sc.next();
        System.out.println("People in state "+statesearch);
        checkstate.entrySet().stream().forEach(e->{
            if(e.getValue().equals(statesearch)){
                System.out.println(e.getKey());
            }
        });
        long statecount = checkstate.entrySet().stream().filter(x->x.getValue().equals(statesearch)).count();
        System.out.println("Number of people in state "+statesearch+" is "+statecount);

        System.out.println("Sorting addressbook by FirstName");
        for(Map.Entry entry : addbook.entrySet()){
            List<contact> list = ((bookdetails)entry.getValue()).viewcontact().stream().sorted(Comparator.comparing(contact::getFirstname)).collect(Collectors.toList());
            System.out.println(entry.getKey()+" "+list.toString());
        }

        System.out.println("Sorting addressbook by City");
        for(Map.Entry entry : addbook.entrySet()){
            List<contact> list = ((bookdetails)entry.getValue()).viewcontact().stream().sorted(Comparator.comparing(contact::getCity)).collect(Collectors.toList());
            System.out.println(entry.getKey()+" "+list.toString());
        }

        System.out.println("Sorting addressbook by State");
        for(Map.Entry entry : addbook.entrySet()){
            List<contact> list = ((bookdetails)entry.getValue()).viewcontact().stream().sorted(Comparator.comparing(contact::getState)).collect(Collectors.toList());
            System.out.println(entry.getKey()+" "+list.toString());
        }

        System.out.println("Sorting addressbook by Zip");
        for(Map.Entry entry : addbook.entrySet()){
            List<contact> list = ((bookdetails)entry.getValue()).viewcontact().stream().sorted(Comparator.comparing(contact::getZip)).collect(Collectors.toList());
            System.out.println(entry.getKey()+" "+list.toString());
        }
    }
}
