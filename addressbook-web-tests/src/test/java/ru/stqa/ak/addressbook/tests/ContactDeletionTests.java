package ru.stqa.ak.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Anna", "Kashenok", "Saint Petersburg", "9999999", "qa@test.com", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomePage();

    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().acceptNextAlert();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptDeletedContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
