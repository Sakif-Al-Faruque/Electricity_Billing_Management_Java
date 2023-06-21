import operation.*;

public class Bill{
    //identify the customer
    private String customerID;

    //will be calculated 
    private double previousDues;
    private double totalDues;
    private boolean approval;

    //need to take user input
    private double recentDues;
    private String issueDate;
    private String dueDate;
    private String month;

    public Bill(){

    }
    public Bill(String customerID){
        this.customerID = customerID;
    }
    /*public void recordBill(String customerID){
        FileOperation fo = new FileOperation("customer");
        fo.getParticularData(customerID);
    }*/
    
    //issue bill (this one has been upgraded)
    public void issueBill(String[] info){
        String[] billInfo = new String[4];
        billInfo = info;
        this.recentDues = Double.parseDouble(billInfo[0]);
        this.issueDate = billInfo[1];
        this.dueDate = billInfo[2];
        this.month = billInfo[3];

        //for counting total bill
        FileOperation fo = new FileOperation("customer/"+customerID+".txt");
        String[] customerBillFields = new String[3];
        String[] customerBillRow = fo.getData();
        if(customerBillRow != null){
            for(int i=0; customerBillRow[i] != null; i++){
                customerBillFields = customerBillRow[i].split("\t");
                this.previousDues = Double.parseDouble(customerBillFields[1]);
            }
        }
        
        this.totalDues = previousDues + recentDues;

        //upgraded part started
        FileOperation fw = new FileOperation("unapproved-bill.txt");

        //Starting preparing bill
        String[] billRow = new String[8];
        billRow[0] = customerID;

        FileOperation fo1 = new FileOperation("customer.txt");
        if(fo1.getParticularData(customerID) != null){
            billRow[1] = fo1.getParticularData(customerID)[1];
            billRow[2] = fo1.getParticularData(customerID)[6];
        }

        billRow[3] = Double.toString(totalDues);
        billRow[4] = issueDate;
        billRow[5] = dueDate;
        billRow[6] = month;
        billRow[7] = Boolean.toString(approval);
        //ending preparing bill

        //Storing bill row in the unapproved-bill file.
        boolean chk = false;
        String[] totalBillInfo = fw.getData();
        String[] billInfoFields = new String[8];
        String[] billInfoFieldsForStoring = new String[8];
        String billInfoPartCularRecord = "";
        for(int m=0; totalBillInfo[m] != null; m++){
            billInfoFields = totalBillInfo[m].split("\t");
            if(billInfoFields[0].equals(customerID) && billInfoFields[1].equals("Empty")){

                billInfoFieldsForStoring[0] = billRow[0];
                billInfoFieldsForStoring[1] = billRow[1];
                billInfoFieldsForStoring[2] = billRow[2];
                billInfoFieldsForStoring[3] = billRow[3];
                billInfoFieldsForStoring[4] = billRow[4];
                billInfoFieldsForStoring[5] = billRow[5];
                billInfoFieldsForStoring[6] = billRow[6];
                billInfoFieldsForStoring[7] = billRow[7];
                

                for(int n=0; n<8; n++){
                    billInfoPartCularRecord += billInfoFieldsForStoring[n]+"\t";
                }
                chk = true;
                totalBillInfo[m] = billInfoPartCularRecord;
                break;
            }
        }
        if(chk){
            fw.setTotalData(totalBillInfo);
        }else{
            fw.setData(billRow, true);
        }
        //upgraded part ended


        //set each customer bill info (customer folder- id1.txt, id2.txt, ...)
        String[] particularCustomerBillRecord = new String[3];
        particularCustomerBillRecord[0] = billRow[2];
        particularCustomerBillRecord[1] = billRow[3];
        particularCustomerBillRecord[2] = billRow[6];
        fo.setData(particularCustomerBillRecord, true);//line 50 

        System.out.println("Bill has been issued Successfully!");
    }

    //show particular approved bill with user billing record and enable user to make recent totalDues 0
    public void payBill(){
        totalDues = 0;
        FileOperation fo = new FileOperation("approved-bill.txt");
        String[] dataRows = fo.getData();

        String[] particularDataRow;
        String duesInfo = "";

        for(int i=0; dataRows[i] != null; i++){
            particularDataRow = dataRows[i].split("\t");

            if(particularDataRow[0].equals(customerID)){
                particularDataRow[3] = Double.toString(totalDues);
                for(int j=0; j<8; j++){
                    duesInfo += particularDataRow[j]+"\t";
                }
                dataRows[i] = duesInfo;

                //update the last row of particular user bill with new totalDues 0
                FileOperation fw = new FileOperation("customer/"+customerID+".txt");
                String[] particularCustomerRows = fw.getData();

                String[] particularCustomerBillFields = new String[3];
                String particularCustomerInfo = "";

                for(int k=(particularCustomerRows.length-1); k>0; k--){
                    if(particularCustomerRows[k] != null){

                        particularCustomerBillFields = particularCustomerRows[k].split("\t");
                        particularCustomerBillFields[1] = Double.toString(totalDues);

                        //just assign the info to row
                        for(int j=0; j<3; j++){
                            particularCustomerInfo += particularCustomerBillFields[j]+"\t";
                        }

                        particularCustomerRows[k] = particularCustomerInfo;
                        break;
                    }
                }
                fw.setTotalData(particularCustomerRows);
            }
        }
        System.out.println("payment successful");
    }

    //show uapproved bills list(seen by executive engineer)
    public String[] showBill(){
        FileOperation fo = new FileOperation("unapproved-bill.txt");
        return fo.getData();
    }

    //show a particular user bill history(by field maneger and user)
    public String[] showParticularBill(){
        FileOperation fm = new FileOperation("customer/"+customerID+".txt");
        String[] customerRecord = fm.getData();
        return customerRecord;
    }

    //approve the bill by executive engineer... (this one has upgraded)
    public void billApproval(){
        approval = true;
        FileOperation fo = new FileOperation("unapproved-bill.txt");
        String[] dataRows = fo.getData();
        String[] particularDataRow = new String[8];
        for(int i=0; dataRows[i] != null; i++){
            particularDataRow = dataRows[i].split("\t");
            if(particularDataRow[0].equals(customerID)){
                particularDataRow[7] = Boolean.toString(approval);
                dataRows[i] = particularDataRow[0]+"\tEmpty"; //upgraded line
                break;
            }
        }
        fo.setTotalData(dataRows); //upgraded line


        FileOperation fw = new FileOperation("approved-bill.txt");
        
        //upgraded part started (in approve bill)
        Boolean k = false;
        String[] dataApp = fw.getData();
        String[] particularDataRowApp = new String[8];
        String upData = "";
        for(int i=0; dataApp[i] != null; i++){
            particularDataRowApp = dataApp[i].split("\t");
            if(particularDataRowApp[0].equals(customerID)){
                /*particularDataRowApp[7] = Boolean.toString(approval);
                dataApp[i] = particularDataRowApp[0]+"\tEmpty";*/
                particularDataRowApp[1] = particularDataRow[1];
                particularDataRowApp[2] = particularDataRow[2];
                particularDataRowApp[3] = particularDataRow[3];
                particularDataRowApp[4] = particularDataRow[4];
                particularDataRowApp[5] = particularDataRow[5];
                particularDataRowApp[6] = particularDataRow[6];
                particularDataRowApp[7] = particularDataRow[7];

                for(int j=0; j<8; j++){
                    upData += particularDataRowApp[j]+"\t"; 
                }
                dataApp[i] = upData;
                k = true;
                break;
            }
        }
        if(k){
            fw.setTotalData(dataApp);
        }else{
            fw.setData(particularDataRow, true);
        }
        //upgraded part ended
        System.out.println("approved successfully");
    }
   
    //for testing 
    /*public static void main(String[] args){
        Bill b = new Bill("1");
        //b.payBill();
        String[] str = new String[4];
        str[0] = "100";
        str[1] = "11-03-2020";
        str[2] = "16-03-2020";
        str[3] = "march";
        b.issueBill(str);
        /*b.showBill();
        //b.billRecord();
        //b.billApproval();
        //b.payBill("6489456");
        /*for(int i=0; b.showParticularBill()[i] != null; i++){
            System.out.println(b.showParticularBill()[i]);
        }/
        /*for(int i=0; b.showBill()[i] != null; i++){
            System.out.println(b.showBill()[i]);
        }/
    }/
        //b.billApproval();
    }*/
}