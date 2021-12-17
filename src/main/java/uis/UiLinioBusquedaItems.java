package uis;

import net.serenitybdd.screenplay.targets.Target;

public class UiLinioBusquedaItems {


    // Titulo de cada item
    public static final Target TXT_NOMBRE_ITEM = Target.the("").locatedBy("//div[@class='detail-container']//span [@class='title-section' and contains(text(),'{0}')]");


}
