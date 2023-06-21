import java.util.Scanner;
import operation.*;
import user.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Start{
    private static String EXECUTIVE_ENGINEER_ID = "";
    private static String FIELD_MANEGER_ID = "";
    private static String CUSTOMER_ID = "";

    public static void main(String[] args){
        Clear c = new Clear();//clear the screen

        System.out.println("**************[Electric Billing Management Console Application]**********");
        while(true){
            c.cls();
            Scanner option = new Scanner(System.in);
            System.out.println("-------------Main Dashboard--------------");
            System.out.println("Option-1 : Executive Engineer");
            System.out.println("Option-2 : Field Maneger");
            System.out.println("Option-3 : Customer");
            System.out.println("Option-4 : Exit");
            System.out.print("Enter your option: ");
            int opt = option.nextInt();

            if(opt == 1){
                c.cls();
                System.out.println("-------------Executive Engineer Login Panel--------------");
                //Executive engineer log in page(Authentication)
                Scanner userLoginInput = new Scanner(System.in);
                System.out.print("Username: "); 
                String username = userLoginInput.nextLine();
                System.out.print("Password: "); 
                String password = userLoginInput.nextLine();
                Login ex = new Login(username, password, "executive engineer");

                if(ex.checkUser()){
                    c.cls();

                    EXECUTIVE_ENGINEER_ID = ex.getUserId();
                    while(true){
                    Scanner eOption = new Scanner(System.in);
                    System.out.println("-------------Executive Engineer Dashboard--------------");
                    System.out.println("Option-1 : Approve Bill");
                    System.out.println("Option-2 : Add Field Maneger");
                    System.out.println("Option-3 : Field Maneger Info");
                    System.out.println("Option-4 : Exit");
                    System.out.print("Enter your option: ");
                    int eOpt = eOption.nextInt();

                    if(eOpt == 1){
                        c.cls();
                        System.out.println("Approve Bill----------------");

                        //showing unapproved bill biginning
                        Bill b = new Bill();
                        /*for(int i=0; b.showBill()[i] != null; i++){
                            System.out.println(b.showBill()[i]);
                        }*/

                        String[] dataRow = b.showBill();

                        TableGenerator tableGenerator = new TableGenerator();
                        List<String> headersList = new ArrayList<>();
                        List<List<String>> rowsList = new ArrayList<>(); 

                        
                        headersList.add("Id");
                        headersList.add("Username");
                        headersList.add("Password");
                        headersList.add("Bill Amount");
                        headersList.add("Issue Date");
                        headersList.add("Due Date");
                        headersList.add("Month");
                        headersList.add("Approval");
                        
                        
                        for(int i=0; dataRow[i] != null; i++){

                            String[] particularInfo = dataRow[i].split("\t");
                            List<String> row = new ArrayList<>();

                            for(int j=0; j<particularInfo.length; j++){
                                row.add(particularInfo[j]);
                            }
                            rowsList.add(row);
                        }
                        System.out.println(tableGenerator.generateTable(headersList, rowsList));
                        //showing unapproved bill ending
                        
                        //select id for approval
                        Scanner billInput = new Scanner(System.in);
                        System.out.print("Enter Customer ID: ");
                        String cusId = billInput.nextLine();
                        Bill ab = new Bill(cusId);
                        ab.billApproval();
                        
                    }else if(eOpt == 2){
                        c.cls();
                        //add field maneger
                        System.out.println("Add Field Maneger--------------");
                        Scanner fmInfoInput = new Scanner(System.in);
                        String[] fmInfo = new String[6];
                        System.out.print("Id: ");
                        fmInfo[0] = fmInfoInput.nextLine();
                        System.out.print("Username: ");
                        fmInfo[1] = fmInfoInput.nextLine();
                        System.out.print("Password: ");
                        fmInfo[2] = fmInfoInput.nextLine();
                        System.out.print("NID: ");
                        fmInfo[3] = fmInfoInput.nextLine();
                        System.out.print("Address: ");
                        fmInfo[4] = fmInfoInput.nextLine();
                        System.out.print("Registration date: ");
                        fmInfo[5] = fmInfoInput.nextLine();
                        User fm = new User(fmInfo);
                        fm.addInfo();

                    }else if(eOpt == 3){
                        c.cls();
                        //show field maneger in a table
                        System.out.println("Field Maneger-----------------");
                        User fm = new User();
                        fm.showRowInfo("field-maneger");

                        //For update and delete info
                        System.out.println("Option-1: Update Field Maneger Info");
                        System.out.println("Option-2: delete Field Maneger Info");
                        System.out.println("Option-3: Cancel Operation");
                        System.out.print("Enter your option: ");

                        Scanner mod = new Scanner(System.in);
                        int modOption = mod.nextInt();

                        if(modOption == 1){
                            //for update
                            System.out.println("Field Maneger Upadate------------");
                            System.out.print("Enter ID: ");
                            Scanner updateID = new Scanner(System.in);
                            String fieldManegerId = updateID.nextLine();

                            //Collect info in a string array to pass it in the update method
                            String[] userInfoRow = new String[5];
                            System.out.print("Enter Username: ");
                            userInfoRow[0] = updateID.nextLine();
                            System.out.print("Enter Password: ");
                            userInfoRow[1] = updateID.nextLine();
                            System.out.print("Enter NID: ");
                            userInfoRow[2] = updateID.nextLine();
                            System.out.print("Enter Address: ");
                            userInfoRow[3] = updateID.nextLine();
                            System.out.print("Enter Registration Date: ");
                            userInfoRow[4] = updateID.nextLine();
                            
                            User fieldManeger = new User();
                            fieldManeger.updateInfo("field-maneger", fieldManegerId, userInfoRow);

                        }else if(modOption == 2){
                            //Delete
                            System.out.println("Field Maneger Delete------------");
                            System.out.print("Enter ID: ");
                            Scanner updateID = new Scanner(System.in);
                            String fieldManegerId = updateID.nextLine();

                            User fieldManeger = new User();
                            fieldManeger.deleteInfo("field-maneger", fieldManegerId);
                        }else if(modOption == 3){
                            System.out.println("Operation Cancel");
                        }else{
                            System.out.println("Choosen wrong option");
                        }

                    }else if(eOpt == 4){
                        break;
                    }else{
                        System.out.print("You have entered wrong option");
                        Scanner wait = new Scanner(System.in);
                        String enter = wait.nextLine();
                    }
                    }
                }else{
                    System.out.print("Authentication failed...Try again!");
                    Scanner wait = new Scanner(System.in);
                    String enter = wait.nextLine();
                }
                
            }else if(opt == 2){
                c.cls();
                System.out.println("-------------Field Maneger Login Panel--------------");

                //field maneger log in page(Authentication)
                Scanner userLoginInput = new Scanner(System.in);
                System.out.print("Username: "); 
                String username = userLoginInput.nextLine();
                System.out.print("Password: "); 
                String password = userLoginInput.nextLine();
                Login fml = new Login(username, password, "field-maneger");

                if(fml.checkUser()){
                    c.cls();

                    FIELD_MANEGER_ID = fml.getUserId();
                    while(true){
                        Scanner fOption = new Scanner(System.in);
                        System.out.println("-------------Field Maneger Dashboard--------------");
                        System.out.println("Option-1 : Issue Bill");
                        System.out.println("Option-2 : Add Customer");
                        System.out.println("Option-3 : Customer Info");
                        System.out.println("Option-4 : Exit");
                        System.out.print("Enter your option: ");
                        int fOpt = fOption.nextInt();

                        if(fOpt == 1){
                            c.cls();
                            System.out.println("Bill Issue-------------------");
                            Scanner billInput = new Scanner(System.in);
                            String[] billInfo = new String[4];

                            System.out.print("Customer ID: ");
                            String cusId = billInput.nextLine();
                            System.out.print("Recent Dues: ");
                            billInfo[0] = billInput.nextLine();
                            System.out.print("Issue Date: ");
                            billInfo[1] = billInput.nextLine();
                            System.out.print("Due Date: ");
                            billInfo[2] = billInput.nextLine();
                            System.out.print("Month: ");
                            billInfo[3] = billInput.nextLine();

                            Bill b = new Bill(cusId);
                            b.issueBill(billInfo);
                        }else if(fOpt == 2){
                            c.cls();
                            System.out.println("Add Customer--------------");
                            Scanner cusInput = new Scanner(System.in);
                            String[] customerInfo = new String[7];

                            System.out.print("ID: ");
                            customerInfo[0] = cusInput.nextLine();
                            System.out.print("Username: ");
                            customerInfo[1] = cusInput.nextLine();
                            System.out.print("Passoword: ");
                            customerInfo[2] = cusInput.nextLine();
                            System.out.print("NID: ");
                            customerInfo[3] = cusInput.nextLine();
                            System.out.print("Address: ");
                            customerInfo[4] = cusInput.nextLine();
                            System.out.print("Register Date: ");
                            customerInfo[5] = cusInput.nextLine();
                            System.out.print("Meter No.: ");
                            customerInfo[6] = cusInput.nextLine();

                            User cus = new User(customerInfo);
                            cus.addInfo();
                        }else if(fOpt == 3){
                            c.cls();
                            //show customer in a table
                            System.out.println("Customer-----------------");
                            User cus = new User();
                            cus.showRowInfo("customer");
                            
                            //For update and delete info
                            System.out.println("Option-1: Update Customer Info");
                            System.out.println("Option-2: delete Customer Info");
                            System.out.println("Option-3: Cancel Operation");
                            System.out.print("Enter your option: ");

                            Scanner mod = new Scanner(System.in);
                            int modOption = mod.nextInt();
                            if(modOption == 1){
                                //for update
                                System.out.println("Customer Upadate------------");
                                System.out.print("Enter ID: ");
                                Scanner updateID = new Scanner(System.in);
                                String customerId = updateID.nextLine();

                                //Collect info in a string array to pass it in the update method
                                String[] userInfoRow = new String[6];
                                System.out.print("Enter Username: ");
                                userInfoRow[0] = updateID.nextLine();
                                System.out.print("Enter Password: ");
                                userInfoRow[1] = updateID.nextLine();
                                System.out.print("Enter NID: ");
                                userInfoRow[2] = updateID.nextLine();
                                System.out.print("Enter Address: ");
                                userInfoRow[3] = updateID.nextLine();
                                System.out.print("Enter Registration Date: ");
                                userInfoRow[4] = updateID.nextLine();
                                System.out.print("Enter Meter No.: ");
                                userInfoRow[5] = updateID.nextLine();
                                
                                User customerU = new User();
                                customerU.updateInfo("customer", customerId, userInfoRow);
                            }else if(modOption == 2){
                                //Delete
                                System.out.println("Customer Delete------------");
                                System.out.print("Enter ID: ");
                                Scanner updateID = new Scanner(System.in);
                                String fieldManegerId = updateID.nextLine();

                                User customerU = new User();
                                customerU.deleteInfo("customer", fieldManegerId);
                            }else if(modOption == 3){
                                System.out.println("Operation Cancel");
                            }else{
                                System.out.println("Choosen wrong option");
                            }

                        }else if(fOpt == 4){
                            break;
                        }else{
                            System.out.print("You have entered wrong option");
                            Scanner wait = new Scanner(System.in);
                            String enter = wait.nextLine();
                        }
                    }
                }else{
                    System.out.print("Authentication failed...Try again!");
                    Scanner wait = new Scanner(System.in);
                    String enter = wait.nextLine();
                }
            }else if(opt == 3){
                c.cls();
                System.out.println("-------------Customer Login Panel--------------");
                
                //customer log in page(Authentication)
                Scanner userLoginInput = new Scanner(System.in);
                System.out.print("Username: "); 
                String username = userLoginInput.nextLine();
                System.out.print("Password: "); 
                String password = userLoginInput.nextLine();
                Login csl = new Login(username, password, "customer");

                if(csl.checkUser()){
                    while(true){
                        c.cls();

                        CUSTOMER_ID = csl.getUserId();
                        //System.out.println(CUSTOMER_ID);
                        Scanner cOption = new Scanner(System.in);
                        System.out.println("-------------Customer Dashboard--------------");
                        System.out.println("Option-1 : Pay Bill");
                        System.out.println("Option-2 : Show Profile");
                        System.out.println("Option-3 : Exit");
                        System.out.print("Enter your option: ");
                        int cOpt = cOption.nextInt();
                        if(cOpt == 1){
                            c.cls();
                            Bill b = new Bill(CUSTOMER_ID);
                            b.payBill();
                            Scanner exitInput = new Scanner(System.in);
                            System.out.print("Press e to Exit...");
                            String k = exitInput.nextLine();
                            /*if(k.equals("e")){
                                break;
                            }*/
                        }else if(cOpt == 2){
                            c.cls();
                            System.out.println("Profile-------------");
                            User cus = new User();
                            String[] customerInfo = cus.showParticularInfo("customer", CUSTOMER_ID);
                            String[] cusFields = new String[7];

                            cusFields[0] = "ID            : ";
                            cusFields[1] = "Name          : ";
                            cusFields[2] = "Password      : ";
                            cusFields[3] = "Address       : ";
                            cusFields[4] = "NID           : ";
                            cusFields[5] = "Register Date : ";
                            cusFields[6] = "Meter No      : ";

                            for(int i=0; i<customerInfo.length; i++){
                                System.out.println(cusFields[i]+customerInfo[i]);
                            }
                            Scanner exitInput = new Scanner(System.in);
                            System.out.print("Press e to Exit...");
                            String k = exitInput.nextLine();
                            /*if(k.equals("e")){
                                break;
                            }*/
                        }else if(cOpt == 3){
                            break;
                        }else{
                            System.out.print("You have entered wrong option");
                            Scanner wait = new Scanner(System.in);
                            String enter = wait.nextLine();
                        }
                    }
                }else{
                    System.out.print("Authentication failed...Try again!");
                    Scanner wait = new Scanner(System.in);
                    String enter = wait.nextLine();
                }
            }else if(opt == 4){
                break;
            }else{
                System.out.print("You have entered wrong option");
                Scanner wait = new Scanner(System.in);
                String enter = wait.nextLine();
            }
        }
    }
}