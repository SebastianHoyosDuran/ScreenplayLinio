package tasks;

import cucumber.api.java.hu.Ha;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import uis.UiLinioInicio;
import uis.UiLogin;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HacerLogin implements Task{

    private final String correo;
    private final String contrasena;

    public HacerLogin(String correo,String contrasena){
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public static Performable ConCredenciales(String correo, String contrasena){
        return instrumented(HacerLogin.class, correo , contrasena);
    }

    @Override
    public <T extends Actor>void performAs(T actor){

        actor.attemptsTo(
                Enter.theValue(correo).into(UiLogin.TXT_EMAIL),
                Enter.theValue(contrasena).into(UiLogin.TXT_CONTRASENA),
                Click.on(UiLogin.BTN_INICIAR_SESION)
        );

        actor.attemptsTo(
                Click.on(UiLinioInicio.BTN_CERRAR_MODAL)
        );

        actor.attemptsTo(
                Click.on(UiLinioInicio.BTN_ABRIR_MENU_DESPEGABLE),
                Click.on(UiLinioInicio.BTN_ABRIR_MI_CUENTA)

        );

    }

}
