package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Anna", "Kashenok", "Saint Petersburg", "9999999", "qa@test.com", "test1"), true);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().acceptNextAlert();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptDeletedContact();
  }
}
