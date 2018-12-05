/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import java.util.Calendar;
import oracle.jdbc.pool.OracleDataSource;

public class EmployeeOperations {
    private Connection conn;
    private PreparedStatement pstmt;

    // This method opens a connection to the Oracle database
    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

            // Tallaght
//             ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
  //           ods.setUser("x00139120");
    //         ods.setPassword("db24Nov97");
            // Home Oracle XE
           ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
            ods.setUser("system");
            ods.setPassword("poppop00");

            conn = ods.getConnection();
            System.out.println("connected.");
        } catch (SQLException e) {
            System.out.print("Unable to load driver " + e.getMessage());
        }
        return conn;
    }
    
    public void closeDB() {
        try {
            pstmt.close();
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            System.out.println("Could not close connection "+ ex.getMessage());
        }
    }
    
    public void dropEmployeeSequence() {
        try {
            String s2 = "drop sequence empid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Employee Sequence dropped");
        } catch (SQLException ex) {
            
        }
    }

    public void createEmployeeSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence empid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Employee Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Employee Sequence " + ex.getMessage());
        }

    }

    public void dropEmployeeTable() {
        System.out.println("Checking for existence of Employee table");
        try {
            String s1 = "DROP TABLE Employee";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Employee table dropped");
        } catch (SQLException ex) {
            
        }
    }
    
    public void createEmployeetable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE Employee (empid NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "name VARCHAR2(40),"
                    + "type VARCHAR2(5),"
                    + "dateEmployed DATE,"
                    + "mid NUMBER,"
                    + "FOREIGN KEY(mid) references Manager(mid))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Employee Table Created");
             } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Employee table" + ex.getMessage());
        }
    }
    
    public void dropManagerSequence() {
        try {
            String s2 = "drop sequence mid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Manager Sequence dropped");
        } catch (SQLException ex) {
            
        }
    }

    public void createManagerSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence mid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Manager Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Manager Sequence " + ex.getMessage());
        }

    }
    
    public void dropCustomerSequence() {
        try {
            String s2 = "drop sequence custnum_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Customer Sequence dropped");
        } catch (SQLException ex) {
            
        }
    }

    public void createCustomerSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence custnum_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Customer Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Customer Sequence " + ex.getMessage());
        }

    }
    
    public void dropManagerTable() {
        System.out.println("Checking for existence of Manager table");
        try {
            String s1 = "DROP TABLE Manager";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Manager table dropped");
        } catch (SQLException ex) {
            
        }
    }
    
    public void createManagerTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE Manager (mid NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "name VARCHAR2(40),"
                    + "salary NUMBER)";
                    
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Manager Table Created");
             } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Manager table" + ex.getMessage());
        }
    }
    
    public void dropCustomerTable() {
        System.out.println("Checking for existence of Customer table");
        try {
            String s1 = "DROP TABLE Customer";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Customer table dropped");
        } catch (SQLException ex) {
            
        }
    }
    
    public void createCustomerTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE Customer (custnum NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "name VARCHAR2(40),"
                    + "address VARCHAR2(30),"
                    + "dateOfPurchase DATE,"
                    + "priceOfPurchase NUMBER,"
                    + "empId NUMBER,"
                    + "FOREIGN KEY(empId) references Employee(empId))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Customer Table Created");
             } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Customer table" + ex.getMessage());
        }
    }
    
    public void dropFTEmployeeTable() {
        System.out.println("Checking for existence of FullTimeEmployee table");
        try {
            String s1 = "DROP TABLE FullTimeEmployee";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("FullTimeEmployee table dropped");
        } catch (SQLException ex) {
            
        }
    }
    
    public void createFTtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE FULLTIMEEMPLOYEE (empId NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "salary decimal(10,2),"
                    + "FOREIGN KEY (empId) REFERENCES EMPLOYEE (empId))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
System.out.println("FT Table Created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "FULLTIMEEMPLOYEE table" + ex.getMessage());
        }
    }
    
    public void dropPTEmployeeTable() {
        System.out.println("Checking for existence of PartTimeEmployee table");
        try {
            String s1 = "DROP TABLE PartTimeEmployee";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("PartTimeEmployee table dropped");
        } catch (SQLException ex) {
            
        }
    }
    
    public void createPTtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE PARTTIMEEMPLOYEE   (empId NUMBER PRIMARY KEY "
                    + "NOT NULL,"
                    + "rate decimal(10,2),"
                    + "hours decimal(10,2),"
                    + "FOREIGN KEY (empId) REFERENCES EMPLOYEE (empId))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
System.out.println("PT Table Created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "PARTTIMEEMPLOYEE table" + ex.getMessage());
        }
    }
    
    public void fillTables() {
        Statement stmt;
        try {
            stmt = conn.createStatement();
            
            String sqlman1 = "INSERT INTO Manager VALUES "
                    + "(mid_seq.nextVal,'Alice',150000)";
            stmt.executeUpdate(sqlman1);
            String sqlemp1 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'John','FT',TO_DATE('2002/01/01','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp1);
            String sqlft1 = "INSERT INTO FULLTIMEEMPLOYEE VALUES (empid_seq.currVal,30000)";
            stmt.executeUpdate(sqlft1);
            String sqlcus1 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Jean','1 Whatever rd',TO_DATE('2018/02/01','yyyy/mm/dd'),100,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus1);
            
            
            String sqlemp2 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Robert','PT',TO_DATE('2004/02/02','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp2);
            String sqlpt1 = "INSERT INTO PARTTIMEEMPLOYEE VALUES (empid_seq.currVal,23,30)";
            stmt.executeUpdate(sqlpt1);
            String sqlcus2 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Graham','2 Lone Lane',TO_DATE('2018/05/04','yyyy/mm/dd'),200,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus2);
            
            String sqlman2 = "INSERT INTO Manager VALUES "
                    + "(mid_seq.nextVal,'Rose',130000)";
            stmt.executeUpdate(sqlman2);
            String sqlemp3 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Eric','FT',TO_DATE('2008-03-04','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp3);
            String sqlft2 = "INSERT INTO FULLTIMEEMPLOYEE VALUES (empid_seq.currVal,45000)";
            stmt.executeUpdate(sqlft2);
            String sqlcus3 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Ryan','3 Short Drive',TO_DATE('2018/08/07','yyyy/mm/dd'),250,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus3);
            
            
            String sqlemp4 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Emily','PT',TO_DATE('2016/04/08','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp4);
            String sqlpt2 = "INSERT INTO PARTTIMEEMPLOYEE VALUES (empid_seq.currVal,33,45)";
            stmt.executeUpdate(sqlpt2);
            String sqlcus4 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Liam','4 Boolean Walk',TO_DATE('2018/11/10','yyyy/mm/dd'),150,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus4);
            
            String sqlman3 = "INSERT INTO Manager VALUES "
                    + "(mid_seq.nextVal,'Alex',120000)";
            stmt.executeUpdate(sqlman3);
            String sqlemp5 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Jane','FT',TO_DATE('08/05/16','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp5);
            String sqlft3 = "INSERT INTO FULLTIMEEMPLOYEE VALUES (empid_seq.currVal,50000)";
            stmt.executeUpdate(sqlft3);
            String sqlcus5 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Danielle','5 Road rd',TO_DATE('2018/03/02','yyyy/mm/dd'),75,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus5);
            
            String sqlemp6 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Sarah','PT',TO_DATE('2008/06/04','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp6);            
            String sqlpt3 = "INSERT INTO PARTTIMEEMPLOYEE VALUES (empid_seq.currVal,44,45)";
            stmt.executeUpdate(sqlpt3);
            String sqlcus6 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Mary','6 Long Drive',TO_DATE('2018/06/05','yyyy/mm/dd'),175,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus6);
            
            String sqlman4 = "INSERT INTO Manager VALUES "
                    + "(mid_seq.nextVal,'Zack',140000)";
            stmt.executeUpdate(sqlman4);
            String sqlemp7 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Michael','FT',TO_DATE('2004/07/02','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp7);
            String sqlft4 = "INSERT INTO FULLTIMEEMPLOYEE VALUES (empid_seq.currVal,35000)";
            stmt.executeUpdate(sqlft4);
            String sqlcus7 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'April','7 Short Walk',TO_DATE('2018/08/07','yyyy/mm/dd'),0,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus7);
            
            String sqlemp8 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Paul','PT',TO_DATE('2001/08/02','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp8);
            String sqlpt4 = "INSERT INTO PARTTIMEEMPLOYEE VALUES (empid_seq.currVal,34,40)";
            stmt.executeUpdate(sqlpt4);
            String sqlcus8 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Reggie','8 Boolean Lane',TO_DATE('2018/03/09','yyyy/mm/dd'),225,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus8);
            
            String sqlman5 = "INSERT INTO Manager VALUES "
                    + "(mid_seq.nextVal,'Andrew',200000)";
            stmt.executeUpdate(sqlman5);
            String sqlemp9 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Ross','FT',TO_DATE('2001/09/01','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp9);
                String sqlft5 = "INSERT INTO FULLTIMEEMPLOYEE VALUES (empid_seq.currVal,40000)";
            stmt.executeUpdate(sqlft5);
            String sqlcus9 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'Colm','9 Cherry Grove',TO_DATE('2018/11/01','yyyy/mm/dd'),25,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus9);
            
            String sqlemp10 = "INSERT INTO Employee VALUES "
                    + "(empid_seq.nextVal,'Elaine','PT',TO_DATE('2012/11/12','yyyy/mm/dd'),mid_seq.currVal)";
            stmt.executeUpdate(sqlemp10);
            String sqlpt5 = "INSERT INTO PARTTIMEEMPLOYEE VALUES (empid_seq.currVal,50,50)";
            stmt.executeUpdate(sqlpt5);
            String sqlcus10 = "INSERT INTO Customer VALUES "
                    + "(custnum_seq.nextVal,'David','10 Muckross grove',TO_DATE('2018/07/02','yyyy/mm/dd'),300,empid_seq.currVal)";
            stmt.executeUpdate(sqlcus10);
            
            
        } catch (SQLException ex) {
            System.out.println("SQL Exception inserting values into "
                    + "Tables" + ex.getMessage());
        }
    }
}
