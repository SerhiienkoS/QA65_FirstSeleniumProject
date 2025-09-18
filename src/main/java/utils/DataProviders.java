package utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Petya","Pupkin","01234567890","Petya@gm.com","Hutoryankova","QA"});
        list.add(new Object[]{"Vasya","Papkin","01234567891","Vasya1@gm.com","Hutoryankova","QA"});
        list.add(new Object[]{"Yuri","Popkin","0123456789012","Yuri2@gm.com","Hutoryankova","QA"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>addNewContactWithCSV() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resourses/Contact.csv")));

        String line =  reader.readLine();
        while (line!=null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
