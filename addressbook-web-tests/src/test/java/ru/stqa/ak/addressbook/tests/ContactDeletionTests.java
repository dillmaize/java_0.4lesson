package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {

    app.getContactHelper().selectContact();
    app.getContactHelper().acceptNextAlert();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptDeletedContact();
  }
}
