package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().createContact(new ContactData("Anna", "Kashenok", "Saint Petersburg", "9999999", "qa@test.com", "test1"), true);
        app.getContactHelper().returnToHomePage();
        app.logout();
    }
}
