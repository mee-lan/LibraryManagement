import java.util.Scanner;

/**
 * This is my Java DOC
 * @author Milan_Gyawali
 * @version 0.0.1
* @since 2000
 * @see <a href="https://docs.oracle.com/en/java/javase/19/docs/api/index.html">JavaDocs</a>
 *
 */
class Library{
        int num = 0;
        int noOfAdded=0;
        boolean exit = false;
        String books;
    Scanner sc= new Scanner(System.in);
    String[] available = new String[15];
//    String[] added= new String[10];
    String[] issued= new String[10];
   void numSetter(){
       num+=1;
    }
    void available(){
        for (String e:
             available) {
            System.out.println(e);

        }
    }
    void issueBook(){
       boolean found = false;
        System.out.println("Which book do you want to issue?");
        String issue= sc.next();
        for (int i=0;i<available.length;i++) {
            if(issue.equals(available[i])){
                found= true;
                issued[num]=issue;
                numSetter();
                System.out.println("Book has been issued ");
            }
        }
        if (found!=true){
            System.out.println("We don't have this book 😔 ".toUpperCase());
            System.out.println("Check available books pressing 4 👉👈 .\n *YOU CAN ALSO ADD SOME BOOKS BY PRESSING 3 👀 * " );
        }


    }
    void issuedBook(){
        System.out.println("Issued Books are: ");
        for (int i=0;i<issued.length;i++) {
            if (this.issued[i]==null){
                continue;
            }
            System.out.println("*"+issued[i]);
        }
    }
    void returnBook(){
        System.out.println("Which book do you want to return");
        Scanner sc= new Scanner(System.in);
        String check= sc.next();
        boolean loop=true;
        for (int i=0;i<issued.length;i++) {
            if (check.equals(issued[i])){
                loop=false;
                System.out.println("Thank you for returning the book. Have a great day!");
                issued[i]=null;
            }
        }
        if (loop) {
            System.out.println("This book is not issued from here!!");
        }

    }
    void addBook(){
        System.out.println("Please enter the name of Book");
        String add= sc.next();
        available[noOfAdded]=add;
        noOfAdded+=1;
        System.out.println("Book has been added to the library");
    }
    void addBook(String books){
        available[noOfAdded]=books;
        noOfAdded+=1;
    }
    void addedBooks(){
        System.out.println("Available books are:");
        for(String book:available)
            { if(book==null){
                break;
            }
                System.out.println(book);
            }
    }
}
public class OnlineLibrary{
    public static void main(String[] args) {
        boolean loop= true;
        Library p1 = new Library();
//        p1.addBook("Ramayan");
//        p1.addBook("Geeta");
//        p1.addBook("Physics");
        System.out.println("Welcome to library!".toUpperCase());
        do {

            System.out.println("Press \n 1. for issuing book \n 2. For returning book \n 3. For adding books \n 4. Show available books \n 5. Show your issued books \n 6. Exit");
            Scanner scanner = new Scanner(System.in);
            int userIn = scanner.nextInt();
            switch (userIn) {
                case 1:
                    p1.issueBook();
                    break;
                case 2:
                    p1.returnBook();
                    break;
                case 3:
                    p1.addBook();
                    break;
                case 4:
                    p1.addedBooks();
                    break;
                case 5:
                    p1.issuedBook();
                    break;
                case 6:
                    loop= false;
                    break;

            }
            System.out.println("\n");
        }
        while(loop);
    }

}


