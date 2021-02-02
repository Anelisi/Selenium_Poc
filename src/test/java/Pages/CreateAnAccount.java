package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAnAccount extends BasePages{
    public CreateAnAccount(WebDriver navegador) {
        super(navegador);
    }

    public FormUsuario inserirEmail(String email) {

        // Digitar no campo "Email address" e clicar em "Create an account"
        navegador.findElement(By.id("authentication")).findElement(By.id("email_create")).sendKeys(email);
        navegador.findElement(By.id("authentication")).findElement(By.id("SubmitCreate")).click();

        return new FormUsuario(navegador);
    }
}
