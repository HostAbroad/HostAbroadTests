Feature: Crear usuario.

    Descripción: Como usuario no registrado quiero poder registrarme para
    poder comunicarme con otros usuarios.

    @FirstCreateUser
    Scenario: Crear Usuario correctamente
        Given el usuario navega hasta la pagina principal
        When el usuario no registrado pulse en registrar
        And rellena los campos nombre, apodo, email y contraseña correctamente
        And pulsa aceptar
        Then se registrará el nuevo usuario

    @SecondCreateUser
    Scenario: Crear Usuario
        Given el usuario navega hasta la pagina principal
        When el usuario no registrado pulse en registrar
        And rellena los campos nombre, apodo, email y contraseña correctamente
        And pulsa rechazar
        Then se anularán los cambios

    @ThirdCreateUser
    Scenario: Crear Usuario
        Given el usuario navega hasta la pagina principal
        When el usuario no registrado pulse en registrar
        And rellena los campos nombre, apodo, email y contraseña erroneamente
        And pulsa aceptar
        Then se mostrará un mensaje de error indicando que debe rellenar todos los campos

    