package operation;

import java.io.*;
import java.util.*;

public class FileOperation{
    private File f;
    private String fileName;
    public FileOperation(){

    }
    //set the file name with constructor
    public FileOperation(String fileName){
        this.fileName = fileName;
        try{
            f = new File("datafile/"+fileName);
            f.createNewFile();
        }catch(IOException e){
            System.out.println("File error occurs");
        }  
    }
    //get all rows
    public String[] getData(){
        String[] rows = new String[1000];
        try{
            Scanner getRow = new Scanner(f);
            int i = 0;
            while(getRow.hasNextLine()){
                rows[i] = getRow.nextLine();
                i++;
            }
            
        }catch(IOException e){
            System.out.println("File error occurs");
        }
        return rows;
    }
    //get a specific row with indivisual fields
    public String[] getParticularData(String id){
        String row = " ";
        String[] fields = new String[10];
        try{
            Scanner getRow = new Scanner(f);
            int i = 0;
            while(getRow.hasNextLine()){
                row = getRow.nextLine();
                fields = row.split("\t");
                if(fields[0].equals(id)){
                    break;
                }
                i++;
            }
            
        }catch(IOException e){
            System.out.println("File error occurs");
        }
        return fields;
    }
    //set one row(used for insertaion)
    public void setData(String[] columns, boolean append){
        try{
            FileWriter fw = new FileWriter("datafile/"+this.fileName, append);
            String infoRow = "";
            for(int i=0; i<columns.length; i++){
                infoRow += (columns[i]+"\t");
            }
            fw.write(infoRow+"\n");
            fw.close();
        }catch(IOException e){
            System.out.println("File error occurs");
        }
    }
    //set total rows(used for update and delete mainly)
    public void setTotalData(String[] rows){
        try{
            FileWriter fw = new FileWriter("datafile/"+this.fileName);
            String infoRow = "";
            for(int i=0; i<rows.length; i++){
                if(rows[i] == null){
                    break;
                }else{
                    fw.write(rows[i]+"\n");
                }
            }
            fw.close();
        }catch(IOException e){
            System.out.println("File error occurs");
        }
    }

    /*public static void main(String[] args){
        String[] str = new String[2];
        str[0] = "hello";
        str[1] = "world";
        FileOperation fw = new FileOperation("new.txt");
        //fw.setData(str, true);
        //String[] k = fw.getParticularData("hello");
        //System.out.println(k.length);
        //fw.setTotalData(str);
        //String[] k = fw.getData();
        //System.out.println(k.length);
        
    }*/
}