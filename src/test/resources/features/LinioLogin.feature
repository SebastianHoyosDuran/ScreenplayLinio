Feature: HU-01 Configuracion de cuenta
  Yo como usuario de Linio
  Quiero ingresar a mi cuenta
  Con mis credenciales

  @ScenarioExitoso
  Scenario: hacer login de manera exitosa
    Given me encuentro en la pagina de login de linio
    When  ingrese los datos de manera correcta
    Then podre ver la opciones de mi cuenta

  @ScenarioFallido
  Scenario: hacer login de manera fallida
    Given me encuentro en la pagina para hacer login de linio
    When  ingrese los datos de manera incorrecta
    Then no podre ver la opciones de mi cuenta