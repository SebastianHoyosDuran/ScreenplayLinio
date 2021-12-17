package tasks;

import cucumber.api.java.es.E;
import driver.GoogleChromeDriver;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uis.UiLinioBusquedaItems;
import uis.UiLinioInicio;
import uis.UiLinioMisDatosPersonales;

import java.util.List;

public class CambiarDatosPersonales implements Task{

    private final String nombre;
    private final String apellido;

    public CambiarDatosPersonales(String nombre,String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public <T extends Actor>void performAs(T actor){

        actor.attemptsTo(
                Click.on(UiLinioMisDatosPersonales.BTN_IR_DATOS_PERSONALES)
        );

        actor.attemptsTo(
                Enter.theValue(nombre).into(UiLinioMisDatosPersonales.TXT_NOMBRE),
                Enter.theValue(apellido).into(UiLinioMisDatosPersonales.TXT_APELLIDO)
        );

        actor.attemptsTo(
                Click.on(UiLinioMisDatosPersonales.BTN_GUARDAR_CAMBIOS)
        );

    }

    public static CambiarDatosPersonales enlinio(String nombre, String apellido){

        return Instrumented.instanceOf(CambiarDatosPersonales.class).withProperties(nombre,apellido);
    }
}
