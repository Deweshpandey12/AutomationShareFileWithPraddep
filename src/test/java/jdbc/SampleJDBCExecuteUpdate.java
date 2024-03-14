package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate 
{
	public static void main(String[] args) throws SQLException 
	{
		 try {
	            // Step 1: Register the database driver
	            Driver driverref = new Driver();
	            DriverManager.registerDriver(driverref);

	            // Step 2: Establish the connection with the database
	            Connection con = DriverManager.getConnection("jdbc:mysql://pensionbox-qa-database.clvkkb0owtsr.ap-south-1.rds.amazonaws.com/", "admin", "qa12345678");

	            // Step 3: Issue create statement
	            Statement state = con.createStatement();

	            // Step 4: Execute query
	            int result = state.executeUpdate("UPDATE `pensionbox_qa`.`kyc_verification_master` SET `pan_number` = 'AGOPJ7236K' WHERE `pan_number` ='BZNPP9301C'");
	            if (result == 1) {
	                System.out.println("Data is modified");
	            } else {
	                System.out.println("No data modified");
	            }

	            // Step 5: Close the connection
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	}
}
