package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class NavPrincipalPage extends BasePages {
    public NavPrincipalPage(WebDriver navegador) {
        super(navegador);
    }

    public NavPrincipalPage confirmHeader() {
        //Confirmação de cadastro
        WebElement userInfo = navegador.findElement(By.className("header_user_info"));
        String textoNoElementoUserInfo = userInfo.getText();
        assertEquals("AniFe Devs", textoNoElementoUserInfo);

        return this;
    }
}
