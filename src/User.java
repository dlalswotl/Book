import java.util.LinkedList;


public class User {
    private String name;
    private String id;
    private String pass;
    private LinkedList<BorrowedBook> myList=new LinkedList<>();

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
        myList.add(new BorrowedBook(book));
    }

    public void showMyBook(){
        System.out.println("\n"+this.name+"님의 대여 목록");
        MyLibrary.dash();
        BorrowedBook s;

        for(int i=0;i<myList.size();i++){
            s=myList.get(i);
            System.out.print("책 제목: "+s.getBookName()+"\t대여일: "+s.getBorrowDate()+"\t반납 예정일: "+s.getReturnDate()+"\t("+s.getLastDay()+"일 후 반납)\n");
        }
    }


}
