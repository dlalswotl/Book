package Control;

import Model.Userinfo;

import java.util.Scanner;
import java.sql.*;

public class Control {
    public static Scanner scanner=new Scanner(System.in);

    public static void AddUserToDB(){

    }
    public static void GetUserInfoFromDB(Connection con,String inputID,String inputPass) {
        String query ="select id,pass,name,admin_auth from user_table where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,inputID);
            ResultSet rs = pstm.executeQuery();

           if(!(rs.next())) {
                System.out.println("정보없음");
            }

            else {
                String ID = rs.getString(1);
                String pass = rs.getString(2);
                String name = rs.getString(3);
                boolean auth = rs.getBoolean(4);
                System.out.println(ID);
            }

            pstm.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}

    }

    public static void Login(Connection con){
        String inputId; String inputPass;
        System.out.println("아이디를 입력해주세요");
        inputId=Control.scanner.next();
        System.out.println("비밀번호를 입력해주세요");
        inputPass=Control.scanner.next();
        Control.GetUserInfoFromDB(con,inputId,inputPass);


    }

    public static Connection DBConnect(){
        Connection con = null;
        String server = "localhost:3306"; // MySQL 서버 주소
        String database = "mydb"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "rkskek134!!"; // MySQL 서버 비밀번호

        // 1.드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 2.연결
        try {//
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false&serverTimezone=Asia/Seoul", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch(SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }

        /*String query = "select * from user_table";

        //쿼리문을 받는다.
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            //setString으로 ?에 들어갈 파라미터를 정해준다.
            //pstm.setString(1, "CS");
            //쿼리 후 결과값을 rs에 받는다.
            ResultSet rs = pstm.executeQuery();

            //행이 끝날때까지 데이터베이스를 읽어 들인다.
            while (rs.next()) {
                //열의 순서는 0번부터가 아니라 1번 부터이다.
                String ID = rs.getString(1);
                String pass = rs.getString(2);
                String name = rs.getString(3);
                boolean auth=rs.getBoolean(4);
                //결과 값을 출력한다.
                System.out.println(ID);

            }

            pstm.close();
        }catch(Exception e){
            e.printStackTrace();
        }


         3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}*/
        return con;

    }


}

