Feature: Buscar usuario (anfitrión).

  Descripción: Como usuario registrado quiero poder 
  buscar a anfitriones para poder alojarme en sus casas.
  
  @SearchHostFirst
  Scenario: Buscar usuario Happy Path
    Given el usuario navega hasta la pagina de search
    When el usuario selecciona como tipo de usuario anfitrión
    And  pulsa el botón de buscar
    Then el usuario podrá ver un listado con los anfitriones
  
  @SearchHostSecond  
  Scenario: Buscar usuario Error
    Given el usuario navega hasta la pagina de search
    When el usuario selecciona como tipo de usuario anfitrión
    And  pulsa el botón de buscar
    Then mostrará mensaje indicando que no hay ningún anfitrión registrado.