package ru.stqa.ak.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ak.addressbook.model.ContactData;
import ru.stqa.ak.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {
    public boolean acceptNextAlert = true;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void gotoAddNew() {
        click(By.linkText("add new"));
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void acceptDeletedContact() {
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptNextAlert() {
        acceptNextAlert = true;
    }


    public void selectContactById(int id) {

        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    // public void selectContact() {
    //     click(By.name("selected[]"));
    // }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("img[title='Edit']")).get(index).click();
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.xpath("//tr[.//*[@id='" + id + "']]//*[@title='Edit']")).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact, boolean b) {
        gotoAddNew();
        fillContactForm(contact, true);
        submitContactCreation();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        acceptNextAlert();
        deleteSelectedContacts();
        acceptDeletedContact();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }


}
