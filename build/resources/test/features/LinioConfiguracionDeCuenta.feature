Feature: HU-01 Configuracion de cuenta
  Yo como usuario de Linio
  Quiero modificar informacion de mi cuenta
  Para mantenerla actualizada

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