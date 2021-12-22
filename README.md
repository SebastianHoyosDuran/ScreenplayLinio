# RetoSQAScreenplayLinio
Este proyecto es realizado con la intención de poner en práctica los conocimientos adquiridos en el semillero de automatización de pruebas impartido por la empresa SQA. En especifico el modelo de Screenplay

## Importante !
Linio es una página muy dinámica, con muchos cambios, lo que quiero decir con este es que al día que se desarrolló esta prueba no había ningún mensaje emergente acerca de una promoción o evento, si al momento de realizar esta prueba hay una ventana emergente, muy seguramente dará fallo. También sus productos tienen demasiado movimiento, puede que algún producto de la lista, deje de haber stock, cambie de nombre, cambie de precio. Cualquier cambio en algún producto puede generar falla en la prueba.

### Herramientas
_Las herramientas empleadas para este proyecto son:_
* Java
* Selenium Web Driver
* Screenplay
* Cucumber
* Gherkin


### Requisitos 🔧

_Para este reto, nuestra automatización debía cumplir con los siguientes requisitos:_

```
Buscar los 5 productos no desde el Excel sino desde el feature con examples
Utilizar un Background para realizar como mínimo 2 escenarios.
Realizar un escenario fallido y uno exitoso sin examples.
```

### Video Explicativo
_Antes de continuar, me gustaría añadir que grabé un video explicando las distintas pruebas paso a paso y también ejecutándolas en tiempo real_
* [Video](https://youtu.be/haowow6Au4U) - Presentación del proyecto
* [![Alt text](https://img.youtube.com/vi/haowow6Au4U/0.jpg)](https://www.youtube.com/watch?v=haowow6Au4U)

## Resultado del test
_Estos son los resultados del test, uno de las pruebas da fallido , dado el tercer punto , de los requerimientos se solcita un escenario fallido._
[![Test-Resultados.png](https://i.postimg.cc/HsshgqjS/Test-Resultados.png)](https://postimg.cc/jCmX6kHN)


## Modelo de Screenplay
_Es un patrón de diseño orientado al comportamiento BDD. Presenta un alto desacoplamiento de la interfaz de usuario. Propone trabajar en términos de tareas y no de interfaz de usuario_

_Screenplay presenta la siguiente ventaja frente al patrón Page Object no cumple con algunos de los principios SOLID recomendados para realizar código flexible y mantenible._

## Estructura del proyecto

_En este apartado vamos a definir cada apartado para que quede claro de forma general_

### Uis
_Las Uis son las Users Interfaces(Interfases de usuarios), es en donde guardamos los elementos que vamos a necesitar para nuestras pruebas, como lo son cajas de texto, botones, títulos etc._

### Tasks
_Las tareas o tasks son el paso a paso de lo que queremos que nuestra automatización haga, por ejemplo que le escriba en la caja de búsqueda de texto y que le de clic en buscar, es un ejemplo valido de una task. Como se puede intuir , acá hacemos uso de los componentes que se encuentren en los uis._

### Driver
_Este paquete hace que habrá el navegador con la configuración que nosotros deseemos. Si lo queremos que se maximice es por ejemplo una configuración_

### Features
_En este paquete encontramos los archivos feature, por cada archivo feature debe existir un archivo stepsDefinitions y un archivo Runner, en el archivo feature, escribimos en un lenguaje natural como lo es el español, el paso a paso del escenario que queremos probar._

### StepsDefinitions
_En el paquete stepsDefinitons o definición de pasos en español, es indicar cuales @Tasks se van a ejecutar en los pasos definidos anteriormente en el feature_

### Runner
_Estos archivos runner, son los que ejecutan la unión del el archivo feauture y el archivo stepsDefinitions._

## Paquetes, Clases y Métodos:
_A continuación mostraremos los códigos y de las clases a que paquete pertenecen y cuál es su función_

### Paquete Driver
#### Clase GoogleChromeDriver
##### Método ChromeDrive
_Este método tiene la intención de este método configurar el navegador con unas características pre determinadas para cuando se desee abrir, se abra con estas configuraciones_
```
  public static GoogleChromeDriver ChromeHisBrowserWeb(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        return new GoogleChromeDriver();
    }
```

##### Método WebDriver on
_La función de este método es abrir el navegador con el link que le pasemos como parámetro_
```
public WebDriver on(String url){
        driver.get(url);
        return driver;
    }
```

### Paquete Uis
#### Clase UiLinioInicio
_En esta clase encontramos los elementos que usamos en la pagina de inicio de linio_
```
   // Barra buscadora
    public static final Target TXT_BUSCADOR = Target.the("").locatedBy("//div[@class = 'input-group']//input[@type='search' and @placeholder='Busca productos']");

    // Botón búsqueda (Lupa)
    public static final Target BTN_BUSCADOR = Target.the("").locatedBy("//div[@class='input-group-btn']//button[@class='btn btn-primary btn-search']");

    // Botón para cerrar modal
    public static final Target BTN_CERRAR_MODAL = Target.the("").locatedBy("//div[@class='dy-modal-contents']//div[@class='dy-lb-close']");

    //Botón para cerrar anuncio
    public  static final Target BTN_CERRAR_ANUNCIO = Target.the("").located(By.id("dy-bottompromobar-close"));

    public  static final Target BTN_ABRIR_MENU_DESPEGABLE = Target.the("").locatedBy("//a[@href='/account']");

    public  static final Target BTN_ABRIR_MI_CUENTA = Target.the("").locatedBy("//a[@href='/account/profile-edit']");

    public  static final Target TXT_MENSAJE_SALUDO = Target.the("").locatedBy("//div[@class='subheader-notifications']//span[@class='user-welcome body-base-sm' and contains(text(),'¡Hola {0}!') ]");

```

#### Clase UiLinioLogin
_En esta clase encontramos los elementos que usamos en la pagina de login de linio_
```
    //Caja de texto Email
    public static final Target TXT_EMAIL = Target.the("").located(By.id("login_form_email"));

    //Caja de texto Contraseña
    public static final Target TXT_CONTRASENA = Target.the("").located(By.id("login_form_password"));

    //Boton iniciar sesion
    public static final Target BTN_INICIAR_SESION = Target.the("").located(By.xpath("//button[@type='submit' and @class='btn btn-security col-12']"));

```

#### Clase UiLinioVisalizarItem
_En esta clase encontramos los elementos que usamos en la pagina de linio cuando buscamos un ítem_
```
 // Titulo de cada item
    public static final Target TXT_NOMBRE_ITEM = Target.the("").locatedBy("//div[@class='detail-container']//span [@class='title-section' and contains(text(),'{0})]");
```


#### Clase UiLinioMisDatosPersonales
_En esta clase encontramos los elementos que usamos en la página de linio cuando queremos modificar información personal en el apartado de configuración_
```

    //Boton ir mis datos personales
    public static final Target BTN_IR_DATOS_PERSONALES = Target.the("").locatedBy("//div[@class='mobile-menu account-menu col-md-3 col-12 ']//li[@class='item-submenu active']//a[@class='item-link' and @href='/account/profile-edit']//span[contains(text(),'Mis datos personales')]");

    //Caja de texto nombre
    public static final Target TXT_NOMBRE = Target.the("").located(By.id("profile_update_firstName"));

    //Caja de texto apellido
    public static final Target TXT_APELLIDO = Target.the("").located(By.id("profile_update_lastName"));

    //Boton guardar cambios
    public static final Target BTN_GUARDAR_CAMBIOS = Target.the("").locatedBy("//button[@type='submit' and @class='btn btn-primary btn-sm col-12']");

    //Alerta cambios guardados
    public static final Target ALERT_CAMBIOS_GUARDADOS = Target.the("").locatedBy("//div[@class='alert-text' and contains(.,'¡Tus datos han sido guardados!')]");

    //Texto mis datos personales
    public static final Target TXT_MIS_DATOS_PERSONALES = Target.the("").locatedBy("//h1[@class='section-title']");

```

#### Clase UiLinioMisDirecciones
_En esta clase encontramos los elementos que usamos en la página de linio cuando queremos modificar información de direcciones para el envío de los productos en el apartado de configuración_
```
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

```

### Paquete Tasks
#### Clase HacerLogin
_En este clase contamos con el paso a paso para realizar el login desde la pagina de login de linio, esta clase cuenta con los parámetros de Correo y Contraseña porque los necesitamos para hacer el logeo._
```
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
                Enter.theValue(correo).into(UiLinioLogin.TXT_EMAIL),
                Enter.theValue(contrasena).into(UiLinioLogin.TXT_CONTRASENA),
                Click.on(UiLinioLogin.BTN_INICIAR_SESION)
        );

        actor.attemptsTo(
                Click.on(UiLinioInicio.BTN_CERRAR_MODAL)
        );

        actor.attemptsTo(
                Click.on(UiLinioInicio.BTN_ABRIR_MENU_DESPEGABLE),
                Click.on(UiLinioInicio.BTN_ABRIR_MI_CUENTA)

        );

```

#### Clase BuscarCategoria
_En esta clase la intención es que busque una categoría en el buscador y una vez la busque, seleccione un ítem de manera aleatoria, esta clase recibe un parámetro de producto, pero puede ser perfectamente el nombre de una categoría general y no de un producto en especifico_

```
   private String producto;

    public BuscarCategoria(String producto){
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    Click.on(UiLinioInicio.BTN_CERRAR_MODAL),
                    Click.on(UiLinioInicio.BTN_CERRAR_ANUNCIO)
            );

            actor.attemptsTo(
                    Enter.theValue(producto).into(UiLinioInicio.TXT_BUSCADOR),
                    Click.on(UiLinioInicio.BTN_BUSCADOR)
            );

            actor.attemptsTo(
                    Click.on(UiLinioBusquedaItems.TXT_NOMBRE_ITEM.of(elementoSeleccionadoAleatoriamente()))
            );
    }

    public static BuscarCategoria enlinio(String producto){

        return Instrumented.instanceOf(BuscarCategoria.class).withProperties(producto);
    }

    public List<WebElement> enlistarProductos(){
        List<WebElement> listaDeProductos;
        listaDeProductos = GoogleChromeDriver.driver.findElements(By.xpath("//div[@class='detail-container']//span [@class='title-section']"));
        return  listaDeProductos;
    }

    public String elementoSeleccionadoAleatoriamente(){
        int numeroAleatorio;
        numeroAleatorio = (int) (Math.random()*3);
        String elemento;
        elemento = enlistarProductos().get(numeroAleatorio).getText();
        return elemento;
    }
```

#### Clase EditarDireccion
_La función de esta clase es que paso a paso se dirigía al apartado de configuración de cuenta, luego a mis direcciones, luego a editar dirección, luego que agregue la información que recibe como parámetro que en este caso es: dirección, teléfono, barrio, departamento, municipio. Y por último le dé en guardar cambios_

```
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
```

#### Clase CambiarDatosPersonales
_La función de esta clase es que paso a paso se dirigía al apartado de configuración de cuenta, mis datos personales, luego ingrese los valores que está recibiendo por parámetro, en este caso el nombre y apellido y por ultimo le dé en guardar._

```
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
```

### Paquete Features
#### Archivo LinioLogin.feature
_En este archivo , definimos cuales van a hacer nuestros escenarios, en te caso contamos con dos escenarios, un exitoso y uno fallido._

##### Scenario Exitoso
_En este escenario es que logra hacer el login de manera exitosa dado que se ingresa de manera correcta tanto el correo como la contraseña._
```
 @ScenarioExitoso
  Scenario: hacer login de manera exitosa
    Given me encuentro en la pagina de login de linio
    When  ingrese los datos de manera correcta
    Then podre ver la opciones de mi cuenta
```


##### Scenario Fallido
_En este escenario intenta hacer el login, pero este termina de manera fallido dado que se intenta hacer el login con un correo y una contraseña incorrectos. Cuando intente continuar con los demás pasos, no podrá acceder a la configuración de cuenta porque no se encentra logueado_
```
 @ScenarioFallido
  Scenario: hacer login de manera fallida
    Given me encuentro en la pagina para hacer login de linio
    When  ingrese los datos de manera incorrecta
    Then no podre ver la opciones de mi cuenta
```

#### Archivo LinioComprador.feature
_En este escenario se plantea la búsqueda de un grupo de categorías, en este caso 5, mediante un Scenario Outline con sus respectivos Examples, lo que realiza este escenario es la serie de pasos con cada uno de los examples. Cuando encontremos la palabra <categoria> esta será reemplazada con el nombre de la categoría, estos escenarios se ejecutan según la cantidad de examples que coloquemos, porque el va a realizar toda la ejecución del escenario con un example y cuando termine volverá a ejecutar todo el escenario con el siguiente example._
```
  Scenario Outline: Buscar un producto
    Given que me encuentro en linio
    When busque <categoria> en el buscador y seleccione un item de manera aleatoria
    Then podre validar su <categoria> en pantalla
    Examples:
      | categoria |
      | Celular   |
      | Billetera |
      | Carro     |
      | Flor      |
      | Mouse     |
```
        
#### Archivo LinioConfiguracionDeCuenta.feature
_Este archivo contamos con dos escenarios y un background, dado que los escenarios son una serie de pasos para cumplir una tarea, un background lo podemos definir como unas precondiciones que siempre necesitamos cumplir para todos los distintos escenarios que tengamos en el archivo. En este caso, dado que queremos hacer cambios en nuestros datos personales y en la dirección de entrega, es necesario que primero que todo , entremos en la página de linio, y segundo debemos estar logeados._
```
      Background: Logearse en Linio
    Given dado que me logueo en la pagina de linio
    When vaya al apartado de configuracion de mi cuenta


  @Scenario1
  Scenario Outline: Actualizar mis datos personales
    When  cambie los datos de <nombre> <apellidos> en Mis datos personales
    Then podre ver el mensaje que los cambios se han guardado
    Examples:
      | nombre | apellidos        |
      | Juan   | Guillermos hoyos |

  @Scenario2
  Scenario Outline: Agregar una nueva direccion de entrega
    When Modifique los nuevos valores <telefono> <direccion> <barrio> <departamento> <municipio> en Mis direcciones
    Then podre ver la nueva <municipio> en la lista
    Examples:
      | telefono   | direccion           | barrio       | departamento | municipio |
      | 3123456789 | Calle 123 # 45 - 67 | Barrio Nuevo | Antioquia       | Medellin    |  
```  
  
### Paquete stepsDefinitions
_En estos archivos pasamos de lenguaje español a código de programación las instrucciones que encontrábamos en los archivos feature_
  
#### Archivo LinioLoginStepsDefinitions
  ```
  
    Actor actor = new Actor("Sebastian");


    @Given("^me encuentro en la pagina de login de linio$")
    public void meEncuentroEnLaPaginaDeLoginDeLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/account/login")));
    }

    @When("^ingrese los datos de manera correcta$")
    public void ingreseLosDatosDeManeraCorrecta() {
        actor.attemptsTo(HacerLogin.ConCredenciales("sebastiansqa@yopmail.com","AutomatizacionSQA2021"));
    }


    @Then("^podre ver la opciones de mi cuenta$")
    public void podreVerLaOpcionesDeMiCuenta() {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDatosPersonales.TXT_MIS_DATOS_PERSONALES), WebElementStateMatchers.containsText("MIS DATOS PERSONALES")));
    }

    @Given("^me encuentro en la pagina para hacer login de linio$")
    public void meEncuentroEnLaPaginaParaHacerLoginDeLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/account/login")));
    }

    @When("^ingrese los datos de manera incorrecta$")
    public void ingreseLosDatosDeManeraIncorrecta() {
        actor.attemptsTo(HacerLogin.ConCredenciales("correoincorrecto@yopmail.com","NoEsLaContraseña"));

    }

    @Then("^no podre ver la opciones de mi cuenta$")
    public void noPodreVerLaOpcionesDeMiCuenta() {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDatosPersonales.TXT_MIS_DATOS_PERSONALES), WebElementStateMatchers.containsText("MIS DATOS PERSONALES")));
    }
  ```
        
  #### Archivo LinioBusquedaDeProductosStepsDefinitons
  ```
   Actor actor = new Actor("Sebastian");

    @Given("^que me encuentro en linio$")
    public void queMeEncuentroEnLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/")));
    }

    @When("^busque (.*) en el buscador y seleccione un item de manera aleatoria$")
    public void busque_Celular_en_el_buscador_y_seleccione_un_item_de_manera_aleatoria(String producto) {
        actor.attemptsTo(BuscarCategoria.enlinio(producto));
    }

    @Then("^podre validar su (.*) en pantalla$")
    public void podreValidarSuCelularEnPantalla(String producto) {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioVisualizarItem.TXT_PRODUCTO.of(producto)) , WebElementStateMatchers.containsText(producto)));
    }
  ```
  
   #### Archivo LinioConfiguracionDeCuentaStepsDefinitions
  ```
   Actor actor = new Actor("Sebastian");


    //Background
    @Given("^dado que me logueo en la pagina de linio$")
    public void dadoQueMeLogueoEnLaPaginaDeLinio() {
        actor.can(BrowseTheWeb.with(GoogleChromeDriver.ChromeHisBrowserWeb().on("https://www.linio.com.co/account/login")));

    }

    @When("^vaya al apartado de configuracion de mi cuenta$")
    public void vayaAlApartadoDeConfiguracionDeMiCuenta() {
        actor.attemptsTo(HacerLogin.ConCredenciales("sebastiansqa@yopmail.com","AutomatizacionSQA2021"));

    }

    //Scanerio1
    @When("^cambie los datos de (.*) (.*) en Mis datos personales$")
    public void cambieLosDatosDeSebastianHoyosEnMisDatosPersonales(String nombre, String apellido) {
        actor.attemptsTo(CambiarDatosPersonales.enlinio(nombre,apellido));
    }


    @Then("^podre ver el mensaje que los cambios se han guardado$")
    public void podreVerElMensajeQueLosCambiosSeHanGuardado() {
        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDatosPersonales.ALERT_CAMBIOS_GUARDADOS)));
    }

    //Scenario2
    @When("^Modifique los nuevos valores (.*) (.*) (.*) (.*) (.*) en Mis direcciones$")
    public void modifiqueLosNuevosValoresCalleBarrioNuevoTolimaRoviraEnMisDirecciones(String telefono,String direccion, String barrio, String departamento, String munucipio) {
        actor.attemptsTo(EditarDireccion.enlinio(telefono,direccion,barrio,departamento,munucipio));
    }

    @Then("^podre ver la nueva (.*) en la lista$")
    public void podreVerLaNuevaCalleEnLaLista(String municipio) {

        actor.should(GivenWhenThen.seeThat(WebElementQuestion.the(UiLinioMisDirecciones.TXT_NUEVA_DIRECCION.of(municipio)) , WebElementStateMatchers.containsText(municipio)));
    }
  ```
        
  
### Paquete Runners
  _En este paquete de archivo, son los que ejecutan nuestras pruebas_
#### Archivo LinioLoginRunner
  ```
  @RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\LinioLogin.feature",
        glue = "stepsDefinitions",
        snippets = SnippetType.CAMELCASE
)

public class LinioLoginRunner {
} 
  ```
  
#### Archivo LinioConfiguracionDeCuentaRunner
  ```
  @RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\LinioConfiguracionDeCuenta.feature",
        glue = "stepsDefinitions",
        snippets = SnippetType.CAMELCASE
)


public class LinioConfiguracionDeCuentaRunner {

}
  ```
  
  #### Archivo LinioBusquedaDeProductosRunner
  ```
  @RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\LinioComprador.feature",
        glue = "stepsDefinitions",
        snippets = SnippetType.CAMELCASE
)

public class LinioBusquedaDeProductosRunner {
}
  ```
#### Esto sería todo por parte del proyecto de automatización a la página Linio, gracias por la atención prestada! 




