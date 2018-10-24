package ru.stqa.ak.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    gotoAddNew();
    fillContactForm(new ContactData("Anna", "Kashenok", "Saint Petersburg", "9999999", "qa@test.com"));
    submitContactCreation();
    returnToHomePage();
    logout();
  }
}
