package stepsDefinitions;

import cucumber.api.java.en.*;
import driver.GoogleChromeDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.HacerLogin;
import uis.UiLinioInicio;
import uis.UiLinioMisDatosPersonales;

public class LinioLoginStepsDefinitons {

    Actor actor = new Actor("Sebastian");


    @Given("^me encuentro en la pagina de login de linio$")
    public void meEncuentroEnLaPaginaDeLoginDeLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/account/login")));
    }

    @When("^ingrese los datos de manera correcta$")
    public void ingreseLosDatosDeManeraCorrecta() {
        actor.attemptsTo(HacerLogin.ConCredenciales("sebastiansqa@yopmail.com","AutomatizacionSQA2021"));
    }


    @Then("^podre ver la opciones de mi cuenta$")
    public void podreVerLaOpcionesDeMiCuenta() {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDatosPersonales.TXT_MIS_DATOS_PERSONALES), WebElementStateMatchers.containsText("MIS DATOS PERSONALES")));
    }

    @Given("^me encuentro en la pagina para hacer login de linio$")
    public void meEncuentroEnLaPaginaParaHacerLoginDeLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/account/login")));
    }

    @When("^ingrese los datos de manera incorrecta$")
    public void ingreseLosDatosDeManeraIncorrecta() {
        actor.attemptsTo(HacerLogin.ConCredenciales("correoincorrecto@yopmail.com","NoEsLaContraseña"));

    }

    @Then("^no podre ver la opciones de mi cuenta$")
    public void noPodreVerLaOpcionesDeMiCuenta() {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDatosPersonales.TXT_MIS_DATOS_PERSONALES), WebElementStateMatchers.containsText("MIS DATOS PERSONALES")));
    }


}
