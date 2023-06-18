package steps;

import configuration.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.CertificatePage;

public class CertificateSteps extends BaseClass {
    static {
        if (driver == null){
            BaseClass.create();
        }
    }
    CertificatePage certificatePage=new CertificatePage(driver);
    @Before
    public void openCertificatePage(){
        driver.navigate().to("https://certificate.ithillel.ua/");
    }

    @When("I enter certificate number {string}")
    public void iEnterCertNumber(String certNumber){
        certificatePage.sendNumber(certNumber);
    }


    @Then("Check certificate verification {string}")
    public void certifVerification(String expected) throws Exception {
        certificatePage.checkCertificateForm();
        Assert.assertEquals(Boolean.valueOf(expected), certificatePage.checkLinkCertificate());

    }
}
