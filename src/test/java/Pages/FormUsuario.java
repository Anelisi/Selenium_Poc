package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormUsuario extends BasePages{

    public FormUsuario(WebDriver navegador) {
        super(navegador);
    }
    WebElement formularioUsuario = navegador.findElement(By.id("authentication"));

    public FormUsuario titleMr() {
        // Selecionar "Mr."
        formularioUsuario.findElement(By.id("id_gender1")).click();
        return this;
    }
    public FormUsuario titleMrs() {
        // Selecionar "Mr."
        formularioUsuario.findElement(By.id("id_gender2")).click();
        return this;
    }

    public FormUsuario title(String title) {

        if(title.equalsIgnoreCase("1")) {
            this.titleMr();
        } else {
            this.titleMrs();
        }
        return this;
    }

    public FormUsuario completeName(String firstName, String lastName) {

        // Digitar no campo "First name" e no campo "Last name"
        formularioUsuario.findElement(By.id("customer_firstname")).sendKeys(firstName);
        formularioUsuario.findElement(By.id("customer_lastname")).sendKeys(lastName);

        return this;
    }

    public FormUsuario inserirSenha(String senha) {
        // Digitar no campo "Password"
        formularioUsuario.findElement(By.id("passwd")).sendKeys(senha);

        return this;
    }

    public FormUsuario diaAniver(Integer dia) {
        // Selecionar a dia de aniversario na Box
        navegador.findElement(By.id("days")).click();
        WebElement dataDia = navegador.findElement(By.name("days"));
        new Select(dataDia).selectByIndex(dia);

        return this;
    }

    public FormUsuario mesAniver(Integer mes) {
        // Selecionar a mês de aniversario na Box
        navegador.findElement(By.id("months")).click();
        WebElement dataMes = navegador.findElement(By.name("months"));
        new Select(dataMes).selectByIndex(mes);

        return this;
    }

    public  FormUsuario anoAniver (Integer ano) {
        // Selecionar a ano de aniversario na Box
        navegador.findElement(By.id("years")).click();
        WebElement dataAno = navegador.findElement(By.name("years"));
        new Select(dataAno).selectByIndex(ano);

        return this;
    }

    public FormUsuario aniversario(Integer dia, Integer mes, Integer ano) {
        this.diaAniver(dia);
        this.mesAniver(mes);
        this.anoAniver(ano);
        return this;
    }

    public FormUsuario address(String address) {
        // Digitat no campo "Address"
        formularioUsuario.findElement(By.id("address1")).sendKeys(address);

        return this;
    }

    public FormUsuario city(String city) {
        // Digitar no campo "City"
        formularioUsuario.findElement(By.id("city")).sendKeys(city);

        return this;
    }

    public FormUsuario inserirState(String states) {
        // Selecionar na box "State"
        navegador.findElement(By.id("id_state")).click();
        WebElement state = navegador.findElement(By.name("id_state"));
        new Select(state).selectByVisibleText(states);

        return this;
    }

    public FormUsuario inserirZipCode(String zipCode) {
        // Digitar no campo "Zip/Postal Code"
        formularioUsuario.findElement(By.id("postcode")).sendKeys(zipCode);

        return this;
    }

    public FormUsuario inserirContry(String countries) {
        // Selecionar na box "Country"
        navegador.findElement(By.id("id_country")).click();
        WebElement country = navegador.findElement(By.name("id_country"));
        new Select(country).selectByVisibleText(countries);

        return this;
    }

    public FormUsuario inserirMobile(String mobile) {
        // Digitar no campo "Mobile phone"
        formularioUsuario.findElement(By.id("phone_mobile")).sendKeys(mobile);

        return this;
    }

    public FormUsuario inserirAlias(String alias) {
        // Digitar no campo "Assign an address alias for future reference."
        formularioUsuario.findElement(By.id("alias")).sendKeys(alias);

        return this;
    }

    public NavPrincipalPage registrar() {
        // Clicar no botão Register
        formularioUsuario.findElement(By.id("submitAccount")).click();

        return new NavPrincipalPage(navegador);
    }
}
