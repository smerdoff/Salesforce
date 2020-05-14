package tests;

import models.Account;
import models.Contact;
import org.testng.annotations.Test;

public class FunctionalTests extends BaseTest {

    @Test
    public void login() {
        Account account = new Account("Eugene", "312321321", "Description");
        loginPage
                .openPage()
                .provideCredsAndLogin("eugenesmerdov17-enes@force.com", "QaEugene17")
                .verifyLogin()
                .clickNew()
                .createAccount(account)
                ;
    }

    @Test(description = "Тест автозаполнения формы создания контакта")
    public void createContact() {
        Contact contact = new Contact("Eug","Andr","Smrdff","Mac","title","esm@gmail.com","80177223123","+3339312123","MD","EugFAX32131231","Nyamiha Street","Eug");
        loginPage
                .openPage()
                .provideCredsAndLogin("eugenesmerdov17-enes@force.com", "QaEugene17")
                .goToContacts()
                .clickNew()
                .selectSalutation("Mr.")
                .fillInInputs(contact)
                .fillInAccountName(contact)
                .clickSave()
                ;
    }
}