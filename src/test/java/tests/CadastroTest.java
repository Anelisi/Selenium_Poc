package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import Pages.PincipalPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Suporte.Web;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "test01.csv")
public class CadastroTest {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createBrowser();
    }

    @Test
    public void cadastroClientePoc(
            @Param(name = "email") String email,
            @Param(name = "title") String title,
            @Param(name = "firstname") String firstname,
            @Param(name = "lastname") String lastname,
            @Param(name = "senha") String senha,
            @Param(name = "dia") Integer dia,
            @Param(name = "mes") Integer mes,
            @Param(name = "ano") Integer ano,
            @Param(name = "address") String address,
            @Param(name = "city") String city,
            @Param(name = "states") String states,
            @Param(name = "zipcode") String zipcode,
            @Param(name = "countries") String countries,
            @Param(name = "mobile") String mobile,
            @Param(name = "alias") String alias
    ) {

        new PincipalPage(navegador)
                .clicarSignIn()
                .inserirEmail(email)
                .title(title)
                .completeName(firstname,lastname)
                .inserirSenha(senha)
                .aniversario(dia,mes,ano)
                .address(address)
                .city(city)
                .inserirState(states)
                .inserirZipCode(zipcode)
                .inserirContry(countries)
                .inserirMobile(mobile)
                .inserirAlias(alias)
                .registrar()
                .printScreen();

    }

    @After
    public void tearDown() {
        //navegador.close();
    }
}
