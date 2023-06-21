package user;

import operation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class User{
    private String id;
    private String username;
    private String password;
    private String nid;
    private String address;
    private String registerDate;
    private String meterNo;

    public User(){

    }
    public User(String[] userInfo){
        if(userInfo.length == 7){
            String[] str = new String[7];
            str = userInfo;
            this.id = str[0];
            this.username = str[1];
            this.password = str[2];
            this.nid = str[3];
            this.address = str[4];
            this.registerDate = str[5];
            this.meterNo = str[6];
        }else if(userInfo.length == 6){
            String[] str = new String[6];
            str = userInfo;
            this.id = str[0];
            this.username = str[1];
            this.password = str[2];
            this.nid = str[3];
            this.address = str[4];
            this.registerDate = str[5];
        }
    }
    public void addInfo(){
        String[] userInfoRow;
        if(meterNo == null){
            userInfoRow = new String[6];
            userInfoRow[0] = id;
            userInfoRow[1] = username;
            userInfoRow[2] = password;
            userInfoRow[3] = nid;
            userInfoRow[4] = address;
            userInfoRow[5] = registerDate;
            FileOperation fo = new FileOperation("field-maneger.txt");
            fo.setData(userInfoRow, true);
        }else{
            userInfoRow = new String[7];
            userInfoRow[0] = id;
            userInfoRow[1] = username;
            userInfoRow[2] = password;
            userInfoRow[3] = nid;
            userInfoRow[4] = address;
            userInfoRow[5] = registerDate;  
            userInfoRow[6] = meterNo;
            FileOperation fo = new FileOperation("customer.txt");
            fo.setData(userInfoRow, true);  
        }
        System.out.println("Inserted successfully!");
    }
    //delete particular row
    public void deleteInfo(String user, String particularId){
        String filename = user+".txt";
        FileOperation fo = new FileOperation(filename);
        String[] dataRow = fo.getData();
        String[] particularDataRow;
        if(user.equals("customer")){
            particularDataRow = new String[7];
        }else{
             particularDataRow = new String[6];
        }
        for(int i=0; dataRow[i] != null; i++){
            particularDataRow = dataRow[i].split("\t");
            if(particularDataRow[0].equals(particularId)){
                dataRow[i] = particularDataRow[0]+"\tEmpty";
                break;
            }
        }
        fo.setTotalData(dataRow);
    }
    //update particular row
    public void updateInfo(String user, String particularId, String[] updateData){
        String filename = user+".txt";
        FileOperation fo = new FileOperation(filename);
        String[] dataRow = fo.getData();
        String[] particularDataRow;
        String updatedDataRow = "";
        if(user.equals("customer")){
            particularDataRow = new String[7];
        }else{
             particularDataRow = new String[6];
        }
        for(int i=0; dataRow[i] != null; i++){
            particularDataRow = dataRow[i].split("\t");
            if(particularDataRow[0].equals(particularId)){
                for(int j=0; j<updateData.length; j++){
                    updatedDataRow += (updateData[j]+"\t");
                }
                dataRow[i] = particularDataRow[0]+"\t"+updatedDataRow;
                System.out.println("Updated Successfully");
                break;
            }
        }
        fo.setTotalData(dataRow);
    }
    //show particular info
    public String[] showParticularInfo(String user, String particularId){
        String filename = user+".txt";
        FileOperation fo = new FileOperation(filename);
        String[] dataRow = fo.getData();
        String[] particularDataRow;
        if(user.equals("customer")){
            particularDataRow = new String[7];
        }else{
             particularDataRow = new String[6];
        }
        for(int i=0; dataRow[i] != null; i++){
            particularDataRow = dataRow[i].split("\t");
            if(particularDataRow[0].equals(particularId)){
                break;
            }
        }
        return particularDataRow;
    }
    //show list of info
    public void showRowInfo(String user){
        String filename = user+".txt";
        FileOperation fo = new FileOperation(filename);
        String[] dataRow = fo.getData();

        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
        List<List<String>> rowsList = new ArrayList<>(); 

        if(filename.equals("field-maneger.txt")){
            headersList.add("Id");
            headersList.add("Username");
            headersList.add("Password");
            headersList.add("NId");
            headersList.add("Address");
            headersList.add("Register Date");
        }else{
            headersList.add("Id");
            headersList.add("Username");
            headersList.add("Password");
            headersList.add("NId");
            headersList.add("Address");
            headersList.add("Register Date");
            headersList.add("Meter No.");
        }
        
        for(int i=0; dataRow[i] != null; i++){

            String[] particularInfo = dataRow[i].split("\t");
            List<String> row = new ArrayList<>();

            for(int j=0; j<particularInfo.length; j++){
                row.add(particularInfo[j]);
            }
            rowsList.add(row);
        }
        System.out.println(tableGenerator.generateTable(headersList, rowsList));
        
    }
    
    /*public static void main(String[] args){
        
        
        String[] str = new String[6];
        str[0] = "bob";
        str[1] = "k4534hgfj";
        str[2] = "85965858";
        str[3] = "house#43,ck";
        str[4] = "20-02-2020";
        str[5] = "88888";
        User u = new User(str);
        u.addInfo();
        /str = u.showParticularInfo("customer", 1);
        for(int i=0; i<u.showParticularInfo("customer", 1).length; i++){
            System.out.println(u.showParticularInfo("customer", 1)[i]);
        }
        //u.deleteInfo("customer", 1);
        u.updateInfo("customer", 1, str);
    /}*/

}