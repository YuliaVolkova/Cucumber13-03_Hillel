package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificatePage {
    @FindBy(name = "certificate")
    WebElement searchField;
    @FindBy(id = "certificateCheckForm")
    WebElement checkFormMessage;


    WebDriver driver;

    public CertificatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void sendNumber(String number){
        searchField.sendKeys(number);
        searchField.sendKeys(Keys.ENTER);
//        | CertNumber | Result |
//        | 45924126   | true   |positive check
//        | 8523699    | true   |negative check
//        | 254551     | true   |negative check
//        | 78008248   | true   |positive check
//        | 74185296   | false  |positive check



    }

    public boolean checkLinkCertificate() {
        return driver.getCurrentUrl().contains("view");
    }

    public boolean checkCertificateForm() throws Exception{
        System.out.println(checkFormMessage.getAttribute("class"));

        int i = 0;
        boolean result=false;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMessage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Out of time wait certificate checker");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }



}
