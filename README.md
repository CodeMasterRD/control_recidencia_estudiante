Estructura Básica de una Documentación Técnica
Introducción

Nombre del proyecto: Control recidencia
Descripción breve:
Este sistema de Control de Entrada, Salida, Uso de Cocina y solicitud de botellones. 
Automatizará los procesos de registro de entrada y salida de los estudiantes en el recinto. Además, integrará funcionalidades específicas para el control del uso de la cocina y los botellones.

Autor(es) o equipo.
Erick Tejada
Israel Vargas
Juaquin
Cristopher Agramonte

Fecha de creación:
5/12/2024


Resumen del Proyecto

Propósito del proyecto.
Problemática que resuelve.
Público objetivo.
Tecnologías utilizadas (React.js en tu caso).
Requisitos Previos

Software y herramientas necesarias para trabajar en el proyecto.
netbeans, Java JDK 21, JDBC DRIVER CONECTOR, My sql, Java swing, 

Instalación y Configuración

Pasos para clonar el repositorio:
bash
Copiar código
git clone <repositorio>
cd <directorio-del-proyecto>
Instrucciones para instalar dependencias:
bash
Copiar código
npm install
Configuración de variables de entorno (si aplica).
Estructura del Proyecto

Arquitectura de proyecto"
bash
Copiar código
/src
├── Controler     # Carpeta de los controladores
├── Model         # Carpeta que que de los DOU 
├── View          # Carpeta que de la vista



Guía de Uso

Cómo correr la aplicación en un entorno local:
1.ejecutar en netbeans


Funcionalidades Principales
1.3	Funcionalidad del sistema para el estudiante
•	Registro de Entrada y Salida.
•	Registro de Uso de Cocina y finalizar uso de cocina.
•	Solicitud de botellones para subministro del agua.
1.4	Funcionalidad del sistema para el administrativo
•	Gestión de Usuarios: Los administradores tienen acceso a la creación y actualización de registros de estudiantes, incluyendo la activación o desactivación de usuarios en el sistema.
•	Registro de Estudiantes por Administrador: El administrador debe tener la capacidad de registrar nuevos estudiantes en el sistema. Esto incluye asignar una matrícula única, nombre completo y otros detalles relevantes.
•	Monitoreo en Tiempo Real: El administrador consta con la funcionalidad de pode ver cuales estudiante están dentro de residencia,  fuera o en uso de la cocina.
•	Monitoreo de los botellones: El administrador podrá visualizar cuanto estudiante tienen botellones, cuales no tienen y quienes han solicitado botellones.
•	Inventario de botellones: El administrador tiene acceso a ver cuántos botellones quedan en los anaqueles.
•	Historial de uso: Para cada estudiante, mantenga un historial de entradas, salidas y uso de la cocina, de manera que pueda generar informes y analizar patrones de uso. Esto puede ser útil para realizar análisis de seguridad o mejorar la gestión de espacios.
•	Panel de Administrador con Reportes en Tiempo Real: También podrían ver las solicitudes pendientes y los estados no confirmados, de modo que puedan gestionar cualquier incidencia de inmediata.
•	Gráfica: Para analizar y ver de manera detallada el control de flujo




Tecnologías y Librerías

Explica las herramientas usadas, por ejemplo:
Java Swing: Desarrollo de la interfaz de usuario.
MySQL: Desarrollo de la base de datos.

Mantenimiento y Contribución

Instrucciones para contribuir (si es un proyecto colaborativo).
Estándares de código, convenciones de nombres, etc.
Posibles Mejoras y Futuras Funcionalidades

Forma de contactar al creador(es) del proyecto para dudas o soporte.
829-661-9526
