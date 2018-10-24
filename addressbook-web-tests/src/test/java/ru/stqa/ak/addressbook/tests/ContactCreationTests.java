package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.gotoAddNew();
    app.fillContactForm(new ContactData("Anna", "Kashenok", "Saint Petersburg", "9999999", "qa@test.com"));
    app.submitContactCreation();
    app.returnToHomePage();
    app.logout();
  }
}
