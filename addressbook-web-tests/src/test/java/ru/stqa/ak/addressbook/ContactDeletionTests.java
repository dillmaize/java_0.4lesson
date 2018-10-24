package ru.stqa.ak.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {

    selectContact();
    acceptNextAlert();
    deleteSelectedContacts();
    acceptDeletedContact();
  }
}
