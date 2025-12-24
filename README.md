# 📚 LiterAlura – Catálogo de Libros en Java

LiterAlura es una aplicación de consola desarrollada en **Java** que permite crear un **catálogo de libros** a partir de datos obtenidos desde una **API externa**.  
El proyecto consume la **API de Google Books**, procesa respuestas en formato **JSON**, guarda la información en una **base de datos SQLite** y permite al usuario interactuar mediante un menú en consola.

Este proyecto fue desarrollado como parte de un desafío de programación enfocado en consumo de APIs, persistencia de datos y buenas prácticas en Java.

---

## 🎯 Objetivos del Proyecto

- Consumir datos desde una API REST (Google Books)
- Analizar y mapear respuestas JSON
- Persistir datos en una base de datos
- Realizar consultas desde la base de datos
- Ofrecer interacción textual al usuario (consola)
- Utilizar Maven para la gestión de dependencias

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Maven**
- **Google Books API**
- **Gson** (manejo de JSON)
- **SQLite** (base de datos)
- **JDBC**

---

## 📂 Estructura del Proyecto

# 📚 LiterAlura – Catálogo de Libros en Java

LiterAlura es una aplicación de consola desarrollada en **Java** que permite crear un **catálogo de libros** a partir de datos obtenidos desde una **API externa**.  
El proyecto consume la **API de Google Books**, procesa respuestas en formato **JSON**, guarda la información en una **base de datos SQLite** y permite al usuario interactuar mediante un menú en consola.

Este proyecto fue desarrollado como parte de un desafío de programación enfocado en consumo de APIs, persistencia de datos y buenas prácticas en Java.

---

## 🎯 Objetivos del Proyecto

- Consumir datos desde una API REST (Google Books)
- Analizar y mapear respuestas JSON
- Persistir datos en una base de datos
- Realizar consultas desde la base de datos
- Ofrecer interacción textual al usuario (consola)
- Utilizar Maven para la gestión de dependencias

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Maven**
- **Google Books API**
- **Gson** (manejo de JSON)
- **SQLite** (base de datos)
- **JDBC**

---

## 📂 Estructura del Proyecto

literAlura/
├── pom.xml
└── src/
└── main/
└── java/
└── com/
└── literalura/
├── BookAPI.java
├── BookParser.java
├── Database.java
└── LiterAlura.java


---

## 📌 Funcionalidades

La aplicación ofrece las siguientes opciones al usuario:

1. 🔍 **Buscar libros por título o palabra clave**  
   (consulta a la API de Google Books y guarda los resultados)

2. 📖 **Ver todos los libros guardados**  
   (consulta desde la base de datos SQLite)

3. ✍️ **Buscar libros por autor**

4. 📊 **Contar cuántos libros están almacenados**

5. 🚪 **Salir de la aplicación**

---

## ▶️ Cómo Ejecutar el Proyecto

### Requisitos previos
- Java 17 o superior
- Maven instalado

### Pasos

1. Clona el repositorio:
```bash
git clone https://github.com/tu_usuario/literAlura.git
