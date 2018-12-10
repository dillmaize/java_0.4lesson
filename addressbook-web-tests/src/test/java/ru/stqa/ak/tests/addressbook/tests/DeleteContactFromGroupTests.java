package ru.stqa.ak.tests.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ak.tests.addressbook.model.ContactData;
import ru.stqa.ak.tests.addressbook.model.Contacts;
import ru.stqa.ak.tests.addressbook.model.GroupData;

import static org.testng.Assert.assertTrue;

public class DeleteContactFromGroupTests extends TestBase {

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
            app.group().create(new GroupData().withName("test1"));
        }
        if (app.db().contactsInGroup().size()== 0) {
            app.goTo().homePage();
            app.contact().addToGroup(app.db().contacts().iterator().next(), app.db().groups().iterator().next());
        }
    }
    @Test
    public void testDeleteContactFromGroup() {
        app.goTo().homePage();
        Contacts before = app.db().contactsInGroup();
        ContactData deletedContact = before.iterator().next();
        GroupData group = app.db().groups().iterator().next();
        app.contact().deleteFromGroup(deletedContact, group);
        Contacts after = app.db().contacts();
        assertTrue(after.iterator().next().getGroups().isEmpty());
    }
}
