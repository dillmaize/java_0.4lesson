package ru.stqa.ak.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ak.addressbook.model.ContactData;
import ru.stqa.ak.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/friends.png");
        ContactData contact = new ContactData()
                .withFirstName("Anna").withLastName("Kashenok").withAddress("Saint Petersburg")
                .withMobilePhone("9999999").withEmail("qa@test.com").withPhoto(photo).withGroup("test1");
        app.contact().create(contact, true);
        app.contact().returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurrentDir(){
        File currentDir = new File(".");
        currentDir.getAbsoluteFile();
        System.out.println(currentDir.getAbsoluteFile());
        File photo = new File("src/test/resources/friends.png");
        System.out.println(photo.getAbsoluteFile());
        System.out.println(photo.exists());
    }

    @Test (enabled = false)
    public void testBadContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Anna").withLastName("Kashenok'").withAddress("Saint Petersburg").withMobilePhone("9999999").withEmail("qa@test.com").withGroup("test1");
        app.contact().create(contact, true);
        app.contact().returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
