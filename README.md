# Proyecto Movie cards (Front)

Este proyecto usa:
- Java 11.
- h2.
- Spring boot 2.6.7.
- Integraciíón continua actions runners.
- Sonar

## 📋Requisitos Previos
Asegúrate de tener instalados los siguientes elementos en tu sistema:

- java --version.
- Tener instalado Docker ya que se usa una imagen de sonar.

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
3. **Iniciar contenedor docker:**

Si no tienes creado un action runner puedes crearlo repositorio>settings>Actions>Runners. Crear uno y seguir los comandos que te muestra con la creación del directorio y la configuración.
```
docker start ubuntu-sonar
docker exec -it -u root ubuntu-sonar /bin/bash
cd actions-runner/
```

Si ya lo tienes creado y el estado es “Offline” del action runner. Ejecutar el comando run en el contendor.
Para recibir trabajos que se le envíen desde GitHub.
  
```
export RUNNER_ALLOW_RUNASROOT="1"
./run.sh
```
Abre tu navegador web: 
- Para ver sonar: http://localhost:9000/projects
- Para ver la URL funcionando en local: http://localhost:8089/
