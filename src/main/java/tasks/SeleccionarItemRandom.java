package tasks;


import driver.GoogleChromeDriver;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uis.UiLinioBusquedaItems;
import uis.UiLinioInicio;
import java.util.List;

public class SeleccionarItemRandom implements Task  {


    private String producto;

    public SeleccionarItemRandom(String producto){
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Click.on(UiLinioBusquedaItems.TXT_NOMBRE_ITEM.of(elementoSeleccionadoAleatoriamente()))
        );

    }

    public static SeleccionarItemRandom enlinio(String producto){

        return Instrumented.instanceOf(SeleccionarItemRandom.class).withProperties(producto);
    }

    public List<WebElement> enlistarProductos(){

        String elementoEncontrado;
        List<WebElement> listaDeProductos;
        listaDeProductos = GoogleChromeDriver.driver.findElements(By.xpath("//div[@class='detail-container']//span [@class='title-section']"));
        //elementoEncontrado = listaDeProductos.get(0).getText();
        return  listaDeProductos;

    }

    public String elementoSeleccionadoAleatoriamente(){
        int numeroAleatorio;
        numeroAleatorio = (int) (Math.random()*3);
        String elemento;
        elemento = enlistarProductos().get(numeroAleatorio).getText();
        return elemento;
    }



}
