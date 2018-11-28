package ru.stqa.ak.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;
import ru.stqa.ak.addressbook.model.Contacts;
import ru.stqa.ak.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static ru.stqa.ak.addressbook.tests.TestBase.app;

public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withFirstName("Anna").withLastName("Kashenok").withAddress("Saint Petersburg")
                    .withMobilePhone("9999999").withEmail("qa@test.com"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("test2'"));
        }
    }
    @Test
    public void testAddContactToGroup() {
        app.goTo().homePage();
        ContactData addedContact = app.db().contacts().iterator().next();
        GroupData group = app.db().groups().iterator().next();
        Contacts before = group.getContacts();
        app.contact().addToGroup(addedContact, group);
        GroupData group1 = app.db().groups().iterator().next();
        Contacts after = group1.getContacts();
        assertThat(after, equalTo(before.withAdded(addedContact)));
    }

}
