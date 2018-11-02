package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Anna", "Kashenok", "Saint Petersburg", "9999999", "qa@test.com", "test1"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Test", "Modification", "Saint Petersburg", "9999999", "qa@test.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
