# Proyecto SOAP

Este proyecto contiene el código fuente y las pruebas para el servicio SOAP pokeapi-soap y una base de datos H2.
Instalación

## Instalación
Para ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- Java Development Kit (JDK) 8 o superior
- Apache Maven
- SOAP UI (para ejecutar las pruebas de integración)

Pasos de instalación:

1. Clona el repositorio:
    `git clone https://github.com/orlandoag89/pokeapi-soap.git`

2. Compila el proyecto:
    En la raíz del proyecto, ejecuta el siguiente comando:
    `mvn clean install`
3. Ejecuta el proyect
    Para levantar el servicio ejecuta el siguiente comando:
   `mvn spring-boot:run`

## Configuración de la Base de Datos H2
El proyecto está configurado para utilizar la base de datos H2 en modo de memoria. No es necesario realizar ninguna configuración adicional.

1. Abre la consola de h2 `http://localhost:8080/h2-console`
2. Escribe las credenciales `username: sa` y `password: password`

## Ejecución de las pruebas
Este proyecto incluye pruebas de integración escritas con SOAP UI. Sigue los siguientes pasos para ejecutar las pruebas:

1. Descarga e instala SOAP UI:
Visita el sitio web de SOAP UI y descarga la versión adecuada para tu sistema operativo. Sigue las instrucciones de instalación.

2. Abre SOAP UI:
Una vez instalado, abre SOAP UI desde tu sistema operativo.

3. Descarga el WSDL del proyecto:
Vista el siguiente link: `http://localhost:8080/ws/pokemons.wsdl` así se validará que el servicio está ejecutándose.

4. Importa el proyecto:
En SOAP UI, selecciona "SOAP" y pega el link del WSDL.

5. Ejecuta las pruebas:
Llena los datos requeridos del xml que se muestra en request y ejecuta la prueba

## Validar que se han guardado los datos en H2
Una vez que se ha ejecutado y respondido correctamente el serivicio abre la consola de h2 y verifica que la ip, requestDate y method se han guardado.

## Contribución

Si encuentras algún error o tienes alguna mejora para sugerir, no dudes en abrir un issue o enviar un pull request.
