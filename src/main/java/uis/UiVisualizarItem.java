package uis;

import net.serenitybdd.screenplay.targets.Target;

public class UiVisualizarItem {

    //Titulo del producto
    public static final Target TXT_PRODUCTO = Target.the("").locatedBy("//h1[contains(.,'{0}')]");

}
