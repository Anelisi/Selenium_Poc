package tests;

import Pages.BasePages;
import Pages.PincipalPage;
import Suporte.Generator;
import Suporte.ScreenShot;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith (DataDrivenTestRunner.class)
@DataLoader(filePaths = "datausers.csv")
public class CadastroTest extends BasePages {

    public CadastroTest(WebDriver navegador, TestName test) {
        super(navegador);
        this.test = test;
    }

    @Rule
    public TestName test;


    @Before
    public void setUp() {
        navegador = Web.createBrowser();
    }

    @Test
    public void cadastroClientePoc(
            @Param(name = "email") String email,
            @Param(name = "title") String title,
            @Param(name = "firstName") String firstName,
            @Param(name = "lastName") String lastName,
            @Param(name = "senha") String senha,
            @Param(name = "dia") Integer dia,
            @Param(name = "mes") Integer mes,
            @Param(name = "ano") Integer ano,
            @Param(name = "address") String address,
            @Param(name = "city") String city,
            @Param(name = "states") String states,
            @Param(name = "zipCode") String zipCode,
            @Param(name = "countries") String countries,
            @Param(name = "mobile") String mobile,
            @Param(name = "alias") String alias
    ) {

       new PincipalPage(navegador)
                .clicarSignIn()
                .inserirEmail(email)
                .title(title)
                .completeName(firstName,lastName)
                .inserirSenha(senha)
                .aniversario(dia,mes,ano)
                .address(address)
                .city(city)
                .inserirState(states)
                .inserirZipCode(zipCode)
                .inserirContry(countries)
                .inserirMobile(mobile)
                .inserirAlias(alias)
                .registrar();

        //Screenshot página principal do usuário
        String screenShotArquivo = "C:\\Users\\SouthSystem\\test-report\\" + Generator.dataHoraParaArquivo() +
                test.getMethodName() + ".png";
        ScreenShot.tirar(navegador, screenShotArquivo);
    }

    @After
    public void tearDown() {
        //navegador.close();
    }
}
