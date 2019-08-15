import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class MyLibrary {
    //회원 정보 배열
    ArrayList<User> users=new ArrayList<>();

     //도서관에 있는 책 리스트
    List<Book> bookList=new LinkedList<>();


    Scanner scan=new Scanner(System.in);

    User curUser;

    public void start(){
        int i=0;
        System.out.println("로그인화면 - 계정 선택");
        dash();
        for(User u : users) {
            System.out.printf("[%d]%s(%s)\n",i++,u.getName(),u.getId());
        }
        System.out.println("[-1]종 료");
        dash();
        System.out.print("선택 : ");
        int sel = scan.nextInt();
        System.out.println("## "+sel+"선택 ##");
        // 선택된 메뉴에 따라 처리
        switch(sel) {
            case -1: System.exit(0);break;
            default:
                curUser = users.get(sel);
                System.out.println("환영합니다 "+curUser.getName()+"님!");
                showMenu();
        }
    }

    public void showMenu(){
        cls(); int choice;
        System.out.println("메인화면 - 작업 선택"+"("+curUser.getId()+")");
        dash();
        System.out.println("1.도서 대출\n2.도서 반납\n3.나의 도서 대여 현황\n-1.종료");
        dash();
        System.out.print("선택: ");
        choice=scan.nextInt();

        switch(choice) {
            case -1: cls();start();break;
            case 1: BorrowBook();showMenu();break;
            case 2:returnBook();showMenu();break;
            case 3:curUser.showMyBook();showMenu();break;
        }
    }

    public void returnBook(){
        if(curUser.getMyList().size()==0) {
            System.out.println("현재 대여중인 도서가 없습니다.");
            return;
        }

        int choice;
        System.out.println("\n도서 반납 - 도서 선택"+"("+curUser.getId()+")");

        curUser.showMyBook();
        System.out.print("반납하실 도서의 번호를 입력해주세요(뒤로가기:-1)0:");
        choice=scan.nextInt();
        if(choice==-1)
            return;
        curUser.RemoveBook(choice);
        System.out.println("도서의 반납이 완료되었습니다");
    }

    public void BorrowBook(){
        System.out.println("\n도서 대출 - 도서 선택"+"("+curUser.getId()+")");
        dash();
        showBookList(); int bookNum;
        dash();
        System.out.print("대출을 원하시는 책의 번호를 입력해주세요(뒤로가기:-1):");
        bookNum=scan.nextInt()-1;
        if(bookNum==-2)
            return;

        Book b=bookList.get(bookNum);

        if (b.getBorrowed())
            System.out.println("##해당 도서는 현재 대출이 불가능합니다##.");

        else {
            curUser.AddBook(b);
            b.setBorrowDate(LocalDate.now());
            b.setReturnDate(b.getBorrowDate().plusWeeks(2));
            b.setLastDay(Period.between(b.getBorrowDate(), b.getReturnDate()).getDays());
            System.out.println("##대출이 완료되었습니다##");
        }

    }


    public void showBookList(){
        for(int i=0;i<bookList.size();i++){
            System.out.printf("[%d].%s\t,%s\t,%s\t,%s\n",i+1,bookList.get(i).getBookName(),bookList.get(i).getAuthor(),bookList.get(i).getIsbn(),bookList.get(i).isBorrowed());
        }
    }

    public void genUser() {
        users.add(new User("이민재","dlalswotl","rkskek134!!"));
        users.add(new User("김민재","kyo97kr","sksms134!!"));
    }

    public void genBook(){
        bookList.add(new Book("반일 종족주의","9788970873268","이영훈"));
        bookList.add(new Book("유럽 도시 기행 1","9788965135586","유시민"));
        bookList.add(new Book("설민석의 한국사 대모험 11","9791188874385","설민석"));
        bookList.add(new Book("유아 식판식","9788952790385","김주연"));
        bookList.add(new Book("90년생이 온다","9791188248674","임홍택"));
        bookList.add(new Book("여행의 이유","9788954655972","김영하"));
        bookList.add(new Book("설민석의 삼국지","9788933870792","설민석"));
        bookList.add(new Book("천년의 질문 1","9788965746829","조정래"));
        bookList.add(new Book("아주 작은 습관의 힘","9791162540640","제임스 클리어"));
        bookList.add(new Book("왜 아이에게 그런 말을 했을까","9791188248919","정재영"));
    }

    public void cls(){
        for(int i=0;i<5;i++)
            System.out.println();
    }

    public static void dash(){
        System.out.println("========================================================================================");
    }
}
