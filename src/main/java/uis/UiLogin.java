package uis;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiLogin {
    //Caja de texto Email
    public static final Target TXT_EMAIL = Target.the("").located(By.id("login_form_email"));

    //Caja de texto Contraseña
    public static final Target TXT_CONTRASENA = Target.the("").located(By.id("login_form_password"));

    //Boton iniciar sesion
    public static final Target BTN_INICIAR_SESION = Target.the("").located(By.xpath("//button[@type='submit' and @class='btn btn-security col-12']"));



}
