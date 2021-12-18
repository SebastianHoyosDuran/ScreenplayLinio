# RetoSQALinio
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
Buscar los 5 productos no desde el excel sino desde el feature con examples
Utilizar un Background para realizar como mínimo 2 escenarios.
Realizar un escenario fallido y uno exitoso sin examples.
```

### Video Explicativo
_Antes de continuar, me gustaría añadir que grabé un video explicando las distintas pruebas paso a paso y también ejecutándolas en tiempo real_
* [Video](https://youtu.be/haowow6Au4U) - Presentación del proyecto
* [![Alt text](https://img.youtube.com/vi/haowow6Au4U/0.jpg)](https://www.youtube.com/watch?v=haowow6Au4U)

## Estructura del proyecto_

_En este apartado vamos a definir cada apartado para que quede claro de forma general_

### Uis
_Las Uis son las Users Interfaces(Interfases de usuarios), es en donde guardamos los elementos que vamos a necesitar para nuestras pruebas, como lo son cajas de texto, botones, títulos etc._

### Tasks
_Las tareas o tasks son el paso a paso de lo que queremos que nuestra automatizacion haga, por ejemplo que le escriba en la caja de busqueda de texto y que le de click en buscar, esun ejemplo valido de una task._

### Driver
_Este paquete hace que habra el navegador con la configuracion que nosotros deseemos. Si lo quieremos que se maxime es por ejemplo una configuracion_


## Paquetes, Clases y Metodos:
_A continuación mostraremos los códigos y de las clases a que paquete pertenecen y cuál es su función_

### Paquete Driver
#### Clase GoogleChromeDriver
##### Metodo ChromeDrive
_Este método tiene el parámetro String de Url o también conocido como link, la intención de este método es abrir el navegador web con unas configuraciones definidas e iniciar el navegador en el link que le pasamos como parámetro_
```
public static void ChromeDriver(String url){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.get(url);

    }
```



#### Esto sería todo por parte del proyecto de automatización a la página Linio, gracias por la atención prestada! 




