package uis;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiLinioInicio {

    // Barra buscadora
    public static final Target TXT_BUSCADOR = Target.the("").locatedBy("//div[@class = 'input-group']//input[@type='search' and @placeholder='Busca productos']");

    // Boton busqueda (Lupa)
    public static final Target BTN_BUSCADOR = Target.the("").locatedBy("//div[@class='input-group-btn']//button[@class='btn btn-primary btn-search']");

    // Boton para cerrar modal
    public static final Target BTN_CERRAR_MODAL = Target.the("").locatedBy("//div[@class='dy-modal-contents']//div[@class='dy-lb-close']");

    //Boton para cerrar anuncio
    public  static final Target BTN_CERRAR_ANUNCIO = Target.the("").located(By.id("dy-bottompromobar-close"));

    public  static final Target BTN_ABRIR_MENU_DESPEGABLE = Target.the("").locatedBy("//a[@href='/account']");

    public  static final Target BTN_ABRIR_MI_CUENTA = Target.the("").locatedBy("//a[@href='/account/profile-edit']");

    public  static final Target TXT_MENSAJE_SALUDO = Target.the("").locatedBy("//div[@class='subheader-notifications']//span[@class='user-welcome body-base-sm' and contains(text(),'¡Hola {0}!') ]");




}
