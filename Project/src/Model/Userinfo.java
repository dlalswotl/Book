package Model;

public class Userinfo {
    private String name;
    private String id;
    private String pass;
    private boolean admin_author;

    public Userinfo(){};
    public Userinfo(String n,String i,String p,boolean a){
        name=n;
        id=i;
        pass=p;
        admin_author=a;
    }
}

