package stepsDefinitions;

import cucumber.api.java.en.*;
import driver.GoogleChromeDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarCategoria;
import uis.UiVisualizarItem;

public class LinioBusquedaDeProductosStepsDefinitions {

    Actor actor = new Actor("Sebastian");

    @Given("^que me encuentro en linio$")
    public void queMeEncuentroEnLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/")));
    }

    @When("^busque (.*) en el buscador y seleccione un item de manera aleatoria$")
    public void busque_Celular_en_el_buscador_y_seleccione_un_item_de_manera_aleatoria(String producto) {
        actor.attemptsTo(BuscarCategoria.enlinio(producto));
    }

    @Then("^podre validar su (.*) en pantalla$")
    public void podreValidarSuCelularEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiVisualizarItem.TXT_PRODUCTO.of(producto)) , WebElementStateMatchers.containsText(producto)));
    }
}
