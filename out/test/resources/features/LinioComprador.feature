Feature: HU-01 Busqueda de un grupo de productos de forma aleatoria
  Yo como usuario de Linio
  Quiero buscar un grupo de productos en la plataforma
  Para ver el nombre del producto en pantalla

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
