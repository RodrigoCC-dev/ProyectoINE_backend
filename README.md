# Proyecto-INE

Proyecto desarrollado en Java para proveer la API con los servicios REST de la información del Censo 2017 de Chile.
## 1. Framework 
- Spring Boot
## 2. Requerimientos
### 2.1 Requerimientos míminos del Servidor
- Memoria RAM: 4 GB
- 10 GB HDD o SSD
- 1 vCPU
### 2.2 Requerimientos técnicos mínimos
- Tomcat v8 o superior
- Maven v3.3.9 o superior
- Java 1.8 o superior
- Unzip
## 3. Instalación
La descripción de instalación está desarrollada para un servidor con sistema Ubuntu 16.04 y con instalación Tomcat 8 a través de los repositorios oficiales. 
>Para instalaciones personalizadas de Tomcat, se debe adecuar las direcciones de instalación de las webapps en el script de instalación incluido en este repositorio.
### 3.1 Preparación
>Se considera que la instalación se realiza en el directorio **Home** del usuario administrador del servidor. Para otras ubicaciones, se debe modificar el script de instalación incluido en este repositorio.

En el directorio home del usuario administrador, clonar el repositorio del proyecto:

`git clone https://github.com/RodrigoCC-dev/ProyectoINE_backend.git`

Ingresar al directorio del proyecto con el siguiente comando:

`cd ProyectoINE_backend`

Copiar el script de instalación al directorio **Home**:

`cp Script.sh ..`

Agregar el usuario tomcat8 al grupo del usuario administrador:

`sudo adduser tomcat8 grupoUsuarioAdministrador`

### 3.2 Instalación
Volver al directorio **Home** y ejecutar el script de instalación:

`cd ..`

`sh Script.sh`

La ejecución de este script descargará los archivos de datos del Censo 2017 desde la página de Microdatos del Instituto Nacional de Estadísticas (INE), ejecutará los comandos maven necesarios para construir el archivo *.war*, compiará el archivo *.war* en la carpeta de las webapps de Tomcat, reiniciará el servicio Tomcat y borrará el directorio ProyectoINE_backend.
>Se considera que el directorio de las webapps de Tomcat se encuentra en la dirección /var/lib/tomcat8/webapps

## 4. Soporte
- rodrigo.castillo.c@usach.cl
