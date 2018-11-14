package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;
import ru.stqa.ak.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Anna").withLastName("Kashenok").withAddress("Saint Petersburg").withMobilePhone("9999999").withEmail("qa@test.com").withGroup("test1");
        app.contact().create(contact, true);
        app.contact().returnToHomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
