package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCDelete 
{
	public static void main(String[] args) 
	{
		try {
            // Step 1: Register the database driver
            Driver driverref = new Driver();
            DriverManager.registerDriver(driverref);

            // Step 2: Establish the connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://pensionbox-qa-database.clvkkb0owtsr.ap-south-1.rds.amazonaws.com/", "admin", "qa12345678");

            // Step 3: Issue create statement
            Statement state = con.createStatement();

            //DELETE FROM `pensionbox_qa`.`users` WHERE (`userid` = '71a237a9-cfb6-4462-8780-ee9267eab747');SET `pan_number` = 'BZNPP9301D'
            // Step 4: Execute query
            int result = state.executeUpdate("DELETE FROM `pensionbox_qa`.`kyc_verification_master` WHERE `pan_number` ='BZNPP9301D';");
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
