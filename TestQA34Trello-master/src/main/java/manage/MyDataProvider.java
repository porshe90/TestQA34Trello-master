package manage;

import models.Board;
import models.Card;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public static Iterator<Object[]> boardData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"test qa1"});
        list.add(new Object[]{"test qa2"});
        list.add(new Object[]{"test qa3"});

        return list.iterator();

    }

    @DataProvider
    public static Object[][] boardDatamodel() {
       // List<Object[]> list = new ArrayList<>();
       // list.add(new Object[]{Board.builder().title("test_qa34_model1")});
        //list.add(new Object[]{Board.builder().title("test_qa34_model2")});
        return new Object[][]{};

        // //{{Board.builder().title("test_qa34_model1")}};
    }

    @DataProvider
    public  Iterator<Object[]> dataCardCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        reader.readLine();
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Card.builder().cardName(split[0]).color(split[1]).build()});
            line=reader.readLine();
        }
        return list.iterator();
    }

}
