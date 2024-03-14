package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driverref=new Driver();
		
		//Step 1 : Register the data base
//		DriverManager.registerDriver(driverref);
//		
//		//Step 2 : Establish the connection with db
//		Connection con = DriverManager.getConnection("jdbc:mysql://pensionbox-qa-database.clvkkb0owtsr.ap-south-1.rds.amazonaws.com/", "admin", "qa12345678");
//		
//		//Step 3 : Issue create statement
//		Statement state = con.createStatement();
//		
//		//Step 4 : Execute query 
//		ResultSet result = state.executeQuery("SELECT care_of FROM pensionbox_qa.kyc_verification_master where 'pan_number` = 'BZNPP9301C';");
//		
//		while(result.next())
//		{
//			System.out.println(result.getString(20));
//		}
//		
//		//step 5 :  close dB
//		con.close();
		
		DriverManager.registerDriver(driverref);

        // Step 2: Establish the connection with the database
        Connection con = DriverManager.getConnection("jdbc:mysql://pensionbox-qa-database.clvkkb0owtsr.ap-south-1.rds.amazonaws.com/pensionbox_qa", "admin", "qa12345678");

        // Step 3: Issue create statement
        Statement state = con.createStatement();

        // Step 4: Execute query
        ResultSet result = state.executeQuery("SELECT care_of FROM kyc_verification_master WHERE pan_number = 'BZNPP9301C';");

        while (result.next()) {
            System.out.println(result.getString("care_of")); // Assuming care_of is a column name
        }

        // Step 5: Close database resources
        result.close();
        state.close();
        con.close();
	}
}
