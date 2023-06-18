package runners;

import configuration.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features",
        glue = "steps",
        tags = "@CertificateCheck",
        dryRun = false
)
public class CertificateSearchRunner {
    @BeforeClass
    public static void create(){
        BaseClass.create();
    }

    @AfterClass
    public static void end() throws InterruptedException{
        BaseClass.end();
    }

}
