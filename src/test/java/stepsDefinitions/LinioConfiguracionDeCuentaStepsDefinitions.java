package stepsDefinitions;

import cucumber.api.java.en.*;
import driver.GoogleChromeDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.CambiarDatosPersonales;
import tasks.EditarDireccion;
import tasks.HacerLogin;
import uis.UiLinioMisDatosPersonales;
import uis.UiLinioMisDirecciones;

public class LinioConfiguracionDeCuentaStepsDefinitions {

    Actor actor = new Actor("Sebastian");


    //Background
    @Given("^dado que me logueo en la pagina de linio$")
    public void dadoQueMeLogueoEnLaPaginaDeLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/account/login")));

    }

    @When("^vaya al apartado de configuracion de mi cuenta$")
    public void vayaAlApartadoDeConfiguracionDeMiCuenta() {
        actor.attemptsTo(HacerLogin.ConCredenciales("sebastiansqa@yopmail.com","AutomatizacionSQA2021"));

    }

    //Scanerio1
    @When("^cambie los datos de (.*) (.*) en Mis datos personales$")
    public void cambieLosDatosDeSebastianHoyosEnMisDatosPersonales(String nombre, String apellido) {
        actor.attemptsTo(CambiarDatosPersonales.enlinio(nombre,apellido));
    }


    @Then("^podre ver el mensaje que los cambios se han guardado$")
    public void podreVerElMensajeQueLosCambiosSeHanGuardado() {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDatosPersonales.ALERT_CAMBIOS_GUARDADOS)));
    }

    //Scenario2
    @When("^Modifique los nuevos valores (.*) (.*) (.*) (.*) (.*) en Mis direcciones$")
    public void modifiqueLosNuevosValoresCalleBarrioNuevoTolimaRoviraEnMisDirecciones(String telefono,String direccion, String barrio, String departamento, String munucipio) {
        actor.attemptsTo(EditarDireccion.enlinio(telefono,direccion,barrio,departamento,munucipio));
    }

    @Then("^podre ver la nueva (.*) en la lista$")
    public void podreVerLaNuevaCalleEnLaLista(String municipio) {

        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDirecciones.TXT_NUEVA_DIRECCION.of(municipio)) , WebElementStateMatchers.containsText(municipio)));
    }


}
