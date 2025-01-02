# Challenge-ONE-Back-End---Conversor-de-moneda
# Conversor de Monedas en Java

![GitHub Repo stars](https://img.shields.io/github/stars/iacastillo90/Challenge-ONE-Back-End---Conversor-de-moneda?style=social)
![Build Status](https://img.shields.io/github/workflow/status/iacastillo90/Challenge-ONE-Back-End---Conversor-de-moneda/Java%20CI)
![License](https://img.shields.io/github/license/iacastillo90/Challenge-ONE-Back-End---Conversor-de-moneda)
![Java](https://img.shields.io/badge/java-17-orange)

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Instalación](#instalación)
- [Uso](#uso)
- [Agradecimientos](#agradecimientos)

## Descripción

El **Conversor de Monedas en Java** es una aplicación de consola que permite a los usuarios convertir cantidades entre diferentes monedas. Utiliza una API externa para obtener las tasas de cambio actualizadas, asegurando conversiones precisas basadas en datos en tiempo real.

Este proyecto fue desarrollado como parte del desafío de programación de Alura Latam, con el objetivo de practicar la integración de APIs, manejo de excepciones y buenas prácticas de programación en Java.

## Características

- **Conversión entre múltiples monedas**: Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL), Peso Colombiano (COP).
- **Interfaz de consola amigable**: Menús claros y opciones fáciles de seleccionar.
- **Manejo de excepciones**: Validación de entradas del usuario y manejo de errores de conexión.
- **Actualización automática de tasas**: Obtiene las tasas de cambio más recientes cada vez que se inicia la aplicación.

## Tecnologías Utilizadas

- **Java 17**
- **Gson**: Biblioteca para el parseo de JSON.
- **API de ExchangeRate-API**: Proveedor de tasas de cambio de monedas.

## Instalación

### Prerrequisitos

- **Java Development Kit (JDK) 17** o superior instalado en tu máquina.
- **Git** para clonar el repositorio (opcional).

### Pasos

1. **Clonar el repositorio**

   ```bash
   https://github.com/iacastillo90/Challenge-ONE-Back-End---Conversor-de-moneda
   
2. **Navegar al directorio del proyecto**
   ```bash
   cd Challenge-ONE-Back-End---Conversor-de-moneda
   
4. **Agregar la biblioteca Gson**

- **Descarga** el archivo JAR de Gson (por ejemplo, gson-2.11.0.jar).
- **Coloca** el archivo JAR en el directorio del proyecto o en una carpeta específica de bibliotecas.
   
5. **Compilar el proyecto**
   ```bash
   javac -cp gson-2.11.0.jar *.java

6. **Ejecutar la aplicación**
   ```bash
   java -cp .;gson-2.11.0.jar Main

## Uso

1. **Ingresar el valor a convertir**
El programa solicitará un valor numérico para la conversión.

2. **Seleccionar la opción de conversión**
Se mostrará un menú con varias opciones de cambio de moneda (USD ↔ ARS, USD ↔ BRL, USD ↔ COP, etc.).

3. **Ver el resultado**
El programa mostrará el resultado de la conversión en la moneda deseada.

4. **Repetir o Salir**
Después de cada conversión, se podrá realizar otra operación o salir del programa.


![Descripción de la imagen](https://github.com/iacastillo90/Challenge-ONE-Back-End---Conversor-de-moneda/blob/main/img1)

## Agradecimientos

- **ExchangeRate-API por proporcionar una API gratuita de tasas de cambio.**
- **Gson por facilitar el parseo de JSON en Java.**
- **Inspirado en los cursos y materiales de Alura Latam.**

