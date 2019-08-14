import java.util.LinkedList;


public class User {
    private String name;
    private String id;
    private String pass;
    private LinkedList<Book> myList=new LinkedList<>();

    public User(String n,String i, String p){
        name=n;
        id=i;
        pass=p;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public void AddBook(Book book){
        myList.add(book);
        book.setBorrowed(true);
    }

    public void showMyBook(){
        System.out.println("\n"+this.name+"님의 대여 목록");
        MyLibrary.dash();
        Book s;

        for(int i=0;i<myList.size();i++){
            s=myList.get(i);
            System.out.print("["+i+1+"]. 책 제목: "+s.getBookName()+"\t대여일: "+s.getBorrowDate()+"\t반납 예정일: "+s.getReturnDate()+"\t("+s.getLastDay()+"일 후 반납)\n");
        }
    }

    public void RemoveBook(int index){
        index--;
        myList.get(index).setBorrowed(false);
        myList.remove(index);

    }


}
