package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import uis.UiLinioInicio;
import uis.UiLinioMisDatosPersonales;
import uis.UiLinioMisDirecciones;

public class EditarDireccion implements Task {

    private final String telefono;
    private final String direccion;
    private final String barrio;
    private final String departamento;
    private final String municipio;

    public EditarDireccion(String telefono,String direccion,String barrio,String departamento,String municipio){
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    @Override
    public <T extends Actor>void performAs(T actor){

        actor.attemptsTo(
                Click.on(UiLinioMisDirecciones.BTN_IR_MIS_DIRECCIONES),
                Click.on(UiLinioMisDirecciones.BTN_IR_EDITAR_DIRECCION)
        );

        actor.attemptsTo(
                Enter.theValue(telefono).into(UiLinioMisDirecciones.TXT_CELULAR),
                Enter.theValue(direccion).into(UiLinioMisDirecciones.TXT_DIRECCION),
                Enter.theValue(barrio).into(UiLinioMisDirecciones.TXT_BARRIO)
        );

        actor.attemptsTo(
                Click.on(UiLinioInicio.BTN_CERRAR_ANUNCIO)
        );

        actor.attemptsTo(
                Click.on(UiLinioMisDirecciones.MENU_DEPARTAMENTO),
                Click.on(UiLinioMisDirecciones.OPCIONES_DEPARTAMENTO.of(departamento)),
                Click.on(UiLinioMisDirecciones.MENU_CIUDAD),
                Click.on(UiLinioMisDirecciones.OPCIONES_CIUDAD.of(municipio))
        );

        actor.attemptsTo(
                Click.on(UiLinioMisDirecciones.BTN_GUARDAR_CAMBIOS)
        );


    }

    public static EditarDireccion enlinio(String telefono, String direccion,String barrio, String departamento, String municipio){

        return Instrumented.instanceOf(EditarDireccion.class).withProperties(telefono,direccion,barrio,departamento,municipio);
    }

}
