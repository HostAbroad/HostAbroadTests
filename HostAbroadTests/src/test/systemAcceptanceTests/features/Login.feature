Feature: Loguear usuario

	Descripción: Como usuario registrado quiero poder loguearme 
	en la aplicación para poder utilizar todas las funcionalidades 
	propias de los usuarios registrados.

@LogInFirst
  Scenario: Logear usuario Happy Path
    Given el usuario navega hasta la pagina de login
    When el usuario rellena los campos de email con "test@test.com" y contraseña con "test123"
    And  pulsa el botón de logear
    Then el usuario accederá a su página de zona de usuario

  Scenario Outline: Logear usuario Error
    Given el usuario navega hasta la pagina de login
    When el usuario rellena los campos de email con <email> y contraseña con <password>
    And  pulsa el botón de logear
    Then el usuario recibe un mensaje de error
    
    Examples:
    | email			  |   	password 		|
    | @ehoo		      |		testD2345	 	|
    |test@test1.com   |		1				|