# Proyecto Movie cards (Front)

Este proyecto usa:
- Java 11.
- h2.
- Spring boot 2.6.7.
- Integraciíón continua actions runners.
- Sonar.
- OpenFeing (Client Rest Declarativo. Doc https://spring.io/projects/spring-cloud-openfeign).

## 📋Requisitos Previos
Asegúrate de tener instalados los siguientes elementos en tu sistema:

- java --version.
- Tener instalado Docker ya que se usa una imagen de sonar.
- Crear una cuenta en Azure. En nuestro caso es una cuenta de estudiante.

## 🔧Clonación del Repositorio
Ejecuta los siguientes pasos:

1. **Clona el repositorio:**
```
git clone https://github.com/CristianCubas/moviecards.git
```
2. **Accede al directorio del proyecto clonado:**
```
cd /workspace/moviecards
```

## 💻Ejecución de la aplicación
1. **Compila la aplicación:**
```
mvn clean install
```
2. **Inicia la aplicación:**
Click derecho en la clase MovieApplication run as>  Java Application/ Spring Boot App.
```
mvn spring-boot:run
```
## 🔩 Crear action runner
1. Crea un action runner repositorio>settings>Actions>Runners.
2. Selecciona "New self-hosted runner".
3. En la pantalla de creación seleccionamos Linux.
4. En la sección Download tenemos comando que se se tienen que ejecutar y seguir.
5. En la sección configure están los comandos para configurar y arrancar el runner en nuestro contenedor ubuntu-sonar.

⚠️ Si tenemos un error en la sección Configure "Must not run with sudo" ejecutamos primero este comando:
```
export RUNNER_ALLOW_RUNASROOT="1"
```
Volvemos a ejecutar los comandos de Configure y debería estar todo correcto.

6. Luego se mostrará una pantalla de registro en el cual podremos poner
  - Nombre del grupo: enter para asignar uno por defecto.
  - Nombre para el runner: mi-runner (es el que tengo en este repositorio).
  - Nos pide una etiqueta: pulsamos enter etiquetas por defecto.
  - Carpeta de trabajo: enter asigna una por defecto.

Sabremos que todo es correcto, ya que veremos:

✅ Connected to Github.

✅ Runner successfully added.

✅ Runner connection is good.

✅ Settings Saved.


## 🐋 levantar sonar con docker

1. Descargar la imagen
```
docker run -d --name ubuntu-sonar -p 9000:9000 josehilera/ubuntu-sonar
```
2. Comprobar que esta levantado: status up
```
docker ps -a
```
3. Si se hubiera detenido el contenedor lo volvemos a poner en marcha.
```
docker start ubuntu-sonar
```
4. Accedmos al contenedor
```
docker exec -it -u root ubuntu-sonar /bin/bash
```
5. Accemos al action runner.
```
cd actions-runner/
```
6. Si ya lo tienes creado y el estado es “Offline” del action runner. Ejecutar el comando run en el contendor.
Para recibir trabajos que se le envíen desde GitHub.
```
export RUNNER_ALLOW_RUNASROOT="1"
./run.sh
```
## ☁️ Crear aplicación web en Azure

1. Tener una cuenta en Azure.
```
https://portal.azure.com
```
2. Seleccionamos App Services>Crear>Aplicación web.
3. Tendremos la pantall de "Crear aplicación web"
   Elegimos los siguientes parámetros:
    - nombre = moviecards-user(en este caso el propietario de este repositorio).
    - Pruebe un nombre de host predeterminado único desabilitar.
    - Publicar = Código.
    - Pila del entorno en tiempo de ejecución = Java 11 (la aplicación utiliza esta version).
    - Pila de servidor web Java = Java SE (Embedded Web Server).
    - Sistema operative = Linux.
    - Region = East US.
    - Plan de precios = Gratis F1. (nuestra cuenta es de estudiante).
   
4. Seleccionamos "Revisar y crear".
5. Accedemos a sección de configuración de la aplicación "Credenciales de publicación de autenticación básica de SCM" y guardamos.
6. Abrimos centro de implmentación de la aplicación en Implementación>Centro de implementación y rellenamos:
   
    - Origen = GitHub.
    - Organización = nuestro usuario de GitHub.
    - Repositorio = moviecards.
    - Rama = main (master, depende de como lo tengas configurado).
    - Opción de flujo de trabajo = Agregar un flujo de trabajo.
    - Tipo de autentificación = Autentificación básica.
  7. Cuando terminemos todo esto veremos que en nuestra rama master/main tendremos un archivo main_moviescards-user.yml en nuestra carpeta .github/workflows. De este archivo nos interesa la sección deploy con lo cual tendremos que copiar para realizar el deploy de nuestra aplicación y copiarlo en nuestro main.yaml.

## 🚀 Abre tu navegador web
- Para ver sonar: usuario/contraseña (admin/admin)
```
http://localhost:9000
```
- Para ver la URL funcionando en local:
```
http://localhost:8089/
```
