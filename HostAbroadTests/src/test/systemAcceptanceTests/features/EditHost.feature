Feature: Editar usuario con datos de anfitrión.

  Descripción: Como usuario registrado quiero poder editar mis intereses para 
  poder ofrecer información a los viajeros que quieran visitarme.
  
  @FirstEditHost
  Scenario: Editar usuario
    Given el usuario pulsa en editar en la sección de la información de su perfil como anfitrión
    When el usuario modifica sus datos
    And  pulsa el botón aceptar
    Then se mostrará que ha realizado los cambios
  