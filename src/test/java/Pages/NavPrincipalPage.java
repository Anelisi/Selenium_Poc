package Pages;

import Suporte.Generator;
import Suporte.ScreenShot;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class NavPrincipalPage extends BasePages {
    public NavPrincipalPage(WebDriver navegador) {
        super(navegador);
    }

    @Rule
    public TestName test = new TestName();

    public NavPrincipalPage confirmHeader() {
        //Confirmação de cadastro
        WebElement userInfo = navegador.findElement(By.className("header_user_info"));
        String textoNoElementoUserInfo = userInfo.getText();
        assertEquals("AniFe Devs", textoNoElementoUserInfo);

        return this;
    }

    String screenShotArquivo = "C:\\Users\\SouthSystem\\test-report\\" + Generator.dataHoraParaArquivo() +
            test.getMethodName() + ".png";

    public void printScreen() {
        //Screenshot página principal do usuário
        ScreenShot.tirar(navegador, screenShotArquivo);
    }
}
