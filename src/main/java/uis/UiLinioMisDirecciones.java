package uis;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiLinioMisDirecciones {

    //Boton ir a mis direcciones
    public static final Target BTN_IR_MIS_DIRECCIONES = Target.the("").locatedBy("//div[@class='item-section']//span[contains(.,'Mis direcciones')]");

    //Boton editar direccion
    public static final Target BTN_IR_EDITAR_DIRECCION = Target.the("").locatedBy("//div[@class='col-xs-12 col-12 col-lg-2']//a[@class='link-low-sm' and @ng-show='addressBook.editable || !address.isComplete']");

    //Caja Texto celular
    public static final Target TXT_CELULAR = Target.the("").located(By.id("address_mobilePhone"));

    //Caja Texto direccion
    public static final Target TXT_DIRECCION = Target.the("").located(By.id("address_line1"));

    //Caja Texto barrio
    public static final Target TXT_BARRIO = Target.the("").located(By.id("address_neighborhood"));

    //Menu deplegable departamento
    public static final Target MENU_DEPARTAMENTO = Target.the("").located(By.id("address_region"));

    //Opcion a elegir departamento
    public static final Target OPCIONES_DEPARTAMENTO = Target.the("").locatedBy("//select[@id='address_region']//option[@value='{0}']");

    //Menu deplegable ciudad
    public static final Target MENU_CIUDAD = Target.the("").located(By.id("address_municipality"));

    //Opcion a elegir ciudad
    public static final Target OPCIONES_CIUDAD = Target.the("").locatedBy("//select[@id='address_municipality']//option[@label='{0}']");

    //Boton guardar cambios
    public static final Target BTN_GUARDAR_CAMBIOS = Target.the("").locatedBy("//button[@class='btn btn-sm col-12 offset-md-6 col-md-6 btn-primary']");

    //Texto de la nueva direccion
    public static final Target TXT_NUEVA_DIRECCION = Target.the("").locatedBy("//address[contains(.,'{0}')]");

}
