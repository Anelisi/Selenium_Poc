package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PincipalPage extends BasePages {
    public PincipalPage(WebDriver navegador) {
        super(navegador);
    }

    public CreateAnAccount clicarSignIn() {
        // Clicar em "Sign in" na pagina inicial
        navegador.findElement(By.linkText("Sign in")).click();

        return new CreateAnAccount(navegador);
    }
}
