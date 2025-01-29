package api.utilities;

import java.util.ResourceBundle;

public class ReadFromProperties {

    public static ResourceBundle getURL() {
        //load properties bundle
        return ResourceBundle.getBundle("routes");


    }


}
