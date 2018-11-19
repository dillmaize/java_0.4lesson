package ru.stqa.ak.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.ak.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGeneration {

    @Parameter(names = "-c", description = "Contact count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    public static void main(String[] args) throws IOException {
        ContactDataGeneration generator = new ContactDataGeneration();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }
    private void run() throws IOException {
        List<ContactData> contacts = genetateContacts(count);
        save(contacts, new File(file));
    }
    private void save(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }
    private List<ContactData> genetateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstName("test" + i).withLastName("lastname" + i). withAddress("address" + i)
                    .withHomePhone("homephone" + i).withMobilePhone("mobilephone" + i).withWorkPhone("workphone" + i)
                    .withEmail("email" + i).withEmail2("email2" + i).withEmail3("email3" + i));
        }
        return contacts;
    }
}
