package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ScrapyardProperties {
    public static final Properties PROPS;

    static {
        PROPS = new Properties();
        try{
            PROPS.load(new FileInputStream("files/scrapyard.properties"));
        } catch (IOException e) {
            System.out.println("Cant load scrapyard properties:" +e.getMessage());
            }
        }
    }

