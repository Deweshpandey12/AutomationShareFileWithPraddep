package contactTestWithBaseClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
public class CreateContactaWithLeadsourceTest extends BaseClass
{
	@Test
	public void createContactWithLeadSource() throws EncryptedDocumentException, IOException 
	{
		//Read data -  Excel File
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 5, 3);

		// Navigate to contact link

		HomePage hp=new HomePage(driver);
		hp.clicKOnAppMenu();
		hp.clickOncontactLink(driver);

		// click on create contact lookup image
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// create contact with mandatory field

		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);


		// Verify Contact details
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}


	}
}
