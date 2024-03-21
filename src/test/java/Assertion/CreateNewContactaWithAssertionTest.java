package Assertion;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import genericUtility.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
@Listeners(genericUtility.ListenersImplementation.class)
public class CreateNewContactaWithAssertionTest extends BaseClass 
{
	@Test
	public  void CreateNewContactsWithMandatoryFieldTest() throws EncryptedDocumentException, IOException
	{
		//Read data -  Excel File
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		// Navigate to contact link
		HomePage hp=new HomePage(driver);
		hp.clicKOnAppMenu();
		hp.clickOncontactLink(driver);
		
		// click on create contact lookup image
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// create contact with mandatory field
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		// Verify Contact details
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		
	}
}
