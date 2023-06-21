import operation.*;

public class Login{
    private String username;
    private String password;
    private String userType;
    private String USER_ID;
    
    public Login(){
        
    }

    public Login(String username, String password, String userType){
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    public boolean checkUser(){
        boolean ch = false;
        String fileName = userType+".txt";
        FileOperation fo = new FileOperation(fileName);
        String[] userInfo = fo.getData();

        for(int i=0; userInfo[i] != null; i++){
            String[] userInfoFields = userInfo[i].split("\t");
            if(userInfoFields.length<3){
                continue;
            }else{
                if((username.equals(userInfoFields[1])) && (password.equals(userInfoFields[2]))){
                    USER_ID = userInfoFields[0];
                    ch = true;
                }
            }  
        }
        return ch;
    }
    public String getUserId(){
        return USER_ID;
    }
    /*public static void main(String[] args){
        Login l = new Login("John", "k2348397", "field maneger");
        System.out.println(Boolean.toString(l.checkUser()));
    }*/
}