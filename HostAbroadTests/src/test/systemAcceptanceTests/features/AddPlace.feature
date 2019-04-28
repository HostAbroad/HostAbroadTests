Feature: Añadir alojamiento.

    Descripción: Como usuario registrado quiero poder añadir un alojamiento que pueda 
    ser elegido por otros usuarios registrados para que puedan alojarse en el mismo.

    @FirstAddPlace
    Scenario: Crear alojamiento correctamente
        Given el usuario navega hasta la pagina crear alojamiento
        When rellena los campos descripción, dirección y familia correctamente
        And pulsa aceptar
        Then se registrará el nuevo alojamiento
        
    @SecondAddPlace
    Scenario: Crear alojamiento incorrectamente
        Given el usuario navega hasta la pagina crear alojamiento
        When rellena los campos descripción, dirección y familia incorrectamente
        And pulsa aceptar
        Then se mostrará error

    

    