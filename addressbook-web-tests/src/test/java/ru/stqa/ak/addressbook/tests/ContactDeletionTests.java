package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;
import ru.stqa.ak.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Anna").withLastName("Kashenok").withAddress("Saint Petersburg").withMobilePhone("9999999").withEmail("qa@test.com").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));

    }


}
