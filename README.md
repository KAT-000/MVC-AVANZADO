# 💻 Portafolio de Prácticas y Proyectos Diarios (POO)

Repositorio centralizado dedicado al desarrollo diario de aplicaciones y ejercicios prácticos de **Programación Orientada a Objetos**. Cada carpeta o módulo representa un desafío independiente enfocado en consolidar la arquitectura de software, la lógica de negocio y la persistencia de datos.

## 🎯 ¿Qué se desarrolla en cada proyecto?
* **Modelado y Jerarquía de Clases:** Diseño de entidades aplicando encapsulamiento, herencia, polimorfismo y clases abstractas.
* **Arquitectura por Capas:** Separación de responsabilidades mediante el patrón **MVC** (Modelo - Vista - Controlador) apoyado por capas de gestión (`Manager`) y acceso a datos (`DAO`).
* **Persistencia Local:** Lectura, escritura y serialización de datos en archivos locales (formato **JSON** mediante **Gson**).
* **Validaciones y Control de Errores:** Implementación de reglas de negocio y manejo de **excepciones personalizadas** para garantizar la integridad de los datos.
* **Interfaces Gráficas (GUI):** Construcción de vistas interactivas de escritorio con **JavaFX**, utilizando tablas dinámicas (`TableView`) y controladores desacoplados.

## 🛠️ Stack Tecnológico Principal
* **Lenguaje:** Java
* **Interfaz Gráfica:** JavaFX
* **Serialización / Datos:** JSON (Librería Gson)
* **Control de Versiones:** Git & GitHub

## 📂 Estructura Estándar de los Proyectos
Aunque cada ejercicio tiene su propia temática, la mayoría sigue esta organización interna:

* `model/` — Entidades principales, clases padre e hijas.
* `dao/` — Clases encargadas de guardar y cargar la información en archivos JSON.
* `manager/` — Lógica de negocio, validaciones y administración de listas/colecciones.
* `controller/` — Intermediario entre la interfaz gráfica y la lógica del programa.
* `view/` — Componentes visuales de JavaFX con sus respectivos métodos de acceso (*getters* y *setters*).
* `exceptions/` — Excepciones propias para el control de fallos específicos del dominio.

---
*Repositorio en constante actualización con nuevos retos y mejoras de código.*
