Proyecto SOAP

Este proyecto contiene el código fuente y las pruebas para el servicio SOAP PokeApiSOAP.
Instalación

Para ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

    Java Development Kit (JDK) 8 o superior
    Apache Maven
    SOAP UI (para ejecutar las pruebas de integración)

Pasos de instalación:

    Clona el repositorio:

    bash

git clone https://github.com/tu-usuario/proyecto-soap.git

Compila el proyecto:

En la raíz del proyecto, ejecuta el siguiente comando:

bash

    mvn clean install

Ejecución de las pruebas

Este proyecto incluye pruebas de integración escritas con SOAP UI. Sigue los siguientes pasos para ejecutar las pruebas:

    Descarga e instala SOAP UI:

    Visita el sitio web de SOAP UI y descarga la versión adecuada para tu sistema operativo. Sigue las instrucciones de instalación.

    Abre SOAP UI:

    Una vez instalado, abre SOAP UI desde tu sistema operativo.

    Importa el proyecto:

    En SOAP UI, selecciona "File" > "Import Project" y selecciona el archivo del proyecto SOAP (proyecto-soap-soapui-project.xml) ubicado en la carpeta src/test/resources.

    Ejecuta las pruebas:

    Una vez importado el proyecto, podrás ver las pruebas en la pestaña "TestCases". Haz clic derecho en la prueba que deseas ejecutar y selecciona "Run TestCase".

Contribución

Si encuentras algún error o tienes alguna mejora para sugerir, no dudes en abrir un issue o enviar un pull request.
