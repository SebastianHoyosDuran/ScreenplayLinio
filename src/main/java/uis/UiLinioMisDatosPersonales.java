package uis;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiLinioMisDatosPersonales {

    //Boton ir mis datos personales
    public static final Target BTN_IR_DATOS_PERSONALES = Target.the("").locatedBy("//div[@class='mobile-menu account-menu col-md-3 col-12 ']//li[@class='item-submenu active']//a[@class='item-link' and @href='/account/profile-edit']//span[contains(text(),'Mis datos personales')]");

    //Caja de texto nombre
    public static final Target TXT_NOMBRE = Target.the("").located(By.id("profile_update_firstName"));

    //Caja de texto apellido
    public static final Target TXT_APELLIDO = Target.the("").located(By.id("profile_update_lastName"));

    //Boton guardar cambios
    public static final Target BTN_GUARDAR_CAMBIOS = Target.the("").locatedBy("//button[@type='submit' and @class='btn btn-primary btn-sm col-12']");

    //Aletar cambias guardados
    public static final Target ALERT_CAMBIOS_GUARDADOS = Target.the("").locatedBy("//div[@class='alert-text' and contains(.,'¡Tus datos han sido guardados!')]");

    //Texto mis datos personales
    public static final Target TXT_MIS_DATOS_PERSONALES = Target.the("").locatedBy("//h1[@class='section-title']");

}
