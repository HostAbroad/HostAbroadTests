Feature: Editar usuario.

    Descripción: Como usuario registrado quiero poder editar mi información 
    básica para poder mantenerla actualizada.

    @FirstEditUser
    Scenario: Editar Usuario correctamente
        Given el usuario navega hasta la pagina editar
        When el usuario no registrado pulse en registrar
        And rellena los campos nombre completo, usuario, email, género, lenguaje y descripción correctamente
        And pulsa guardar
        Then se guardarán los cambios

    @SecondEditUser
    Scenario: Editar Usuario incorrectamente
        Given el usuario navega hasta la pagina editar
        When el usuario no registrado pulse en registrar
        And rellena los campos nombre completo, usuario, email, género, lenguaje y descripción incorrectamente
        And pulsa guardar
        Then se guardarán los cambios

    