import operation.*;
import java.util.Scanner;
public class Company{
    public static void main(String[] args){
        System.out.println("-----------Add Executive Engineer--------------");
        FileOperation fo = new FileOperation("executive engineer.txt");
        String[] str = new String[3];

        Scanner adminInput = new Scanner(System.in);
        System.out.print("ID: ");
        str[0] = adminInput.nextLine();
        System.out.print("Username: ");
        str[1] = adminInput.nextLine();
        System.out.print("Password: ");
        str[2] = adminInput.nextLine();

        fo.setData(str, true);
        System.out.println("Inserted Succesfully");
    }
}