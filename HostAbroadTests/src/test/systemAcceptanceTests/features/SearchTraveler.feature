Feature: Buscar usuario (viajero).

  Descripción: Como usuario registrado, no registrado o administrador quiero
   poder buscar a viajeros para que se puedan alojar en mi casa.
  
  @First
  Scenario: Buscar usuario Happy Path
    Given el usuario navega hasta la pagina de search viajero
    When el usuario selecciona como tipo de usuario viajero
    And  pulsa el botón de buscar viajero
    Then el usuario podrá ver un listado con los viajeros
  
  @Second  
  Scenario: Buscar usuario Error
    Given el usuario navega hasta la pagina de search viajero
    When el usuario selecciona como tipo de usuario viajero
    And  pulsa el botón de buscar viajero
    Then mostrará mensaje indicando que no hay ningún viajero registrado.