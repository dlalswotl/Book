package View;

import Control.Control;
import java.sql.Connection;

public class Menu {

    public static void main(String [] args){
        int userChoice;
        System.out.println("=======================================================================");
        System.out.println("도서 대출프로그램 v0.01 201433847이민재");
        System.out.println("=======================================================================");
        Connection con=Control.DBConnect(); //Mysql 연동

        System.out.println("1.일반 사용자 로그인\n2.관리자 로그인\n3.회원가입");
        System.out.println("선택:");
        userChoice=Control.scanner.nextInt();
        switch(userChoice){
            case 1:
                Control.LoginAsUser(con);
                break;
            case 2:
                Control.LoginAsAdmin(con);
                break;
            case 3:
                Control.SignUp(con);
        }
        Control.Login(con);



    }
}
