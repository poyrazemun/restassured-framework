package base;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static api.utilities.ReadFromProperties.getURL;

public class BaseRoutes {

    public Logger logger;

//eger sadece USER modulu olsaydi user bilgilerini olusturmayi burda yapardim ama farkli modullerde olacagi
    //icin her modulun dataProvide'ni kendi test sinifinin altinda yapmak daha mantikli.

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = getURL().getString("base_URI");
        RestAssured.basePath = getURL().getString("base_path");

        //logs
        logger = LogManager.getLogger(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        RestAssured.reset();

    }


}
