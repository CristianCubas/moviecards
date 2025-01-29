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

Abre tu navegador web: 
- Para ver sonar: http://localhost:9000/projects
- Para ver la URL funcionando en local: http://localhost:8089/
