package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {

    app.selectContact();
    app.acceptNextAlert();
    app.deleteSelectedContacts();
    app.acceptDeletedContact();
  }
}
