# CS2901 - [Lab6] Programa de vacunación

## Instrucciones
- Grupal
- Tiempo 110 minutos

## Objetivos :dart:
- Construir el caso de uso para el programa.
- Implementar Requerimientos Funcionales descritos en su Caso de Uso.


## Introducción :ramen:
El Decreto de Urgencia N° 009-2021 dicta medidas extraordinarias y complementarias para crear y gestionar el Padrón Nacional de Vacunación contra la COVID 19. En este contexto, es necesario construir una plataforma de Consulta Única de Vacunación denominada www.pongoelhombro.gob.pe a fin de responder a la necesidad de la ciudadanía con respecto a la programación asignada.
Esto permitirá conocer dónde, cuándo y a qué hora le toca vacunarse a cada ciudadano. 


## Requerimientos :bookmark_tabs:
### Requerimientos Funcionales
- **RF1**: Los ciudadanos podrán consultar mediante su DNI cuándo le corresponde vacunarse. 
- **RF2**: Los ciudadanos que no se encuentren en el padrón podrán registrarse proporcionando sus datos personales: DNI, Nombres, Apellidos, Fecha Nacimiento, Teléfono, Correo Electrónico. 
- **RF3**: La fecha de vacunación está determinada por la fecha de nacimiento.
- **RF4**: Todo registro  nuevo será validado mediante una API de terceros (`Ejemplo:` https://ws-consultas.herokuapp.com/api/dni/{elNroDNI} ).
- **RF5**: El Ministerio de Salud (MINSA) podrá listar, consultar, reprogramar la fecha, los registros del padrón. [No es necesario implementar].
- **RF6**: El MINSA de manera aleatoria puede volver a verificar con RENIEC  los datos registrados.  [No es necesario implementar].

### Requerimientos No Funcionales
- **RNF1**: La base de datos a Usar es Postgres
- **RNF2**: La longitud máxima de caracteres del DNI será 8.
- **RNF3**: La cantidad máxima de usuarios concurrentes son 1000.
- **RNF4**: Crear Test de Stress que pruebe 1000 usuarios conectados al mismo tiempo.
- **RNF5**: El tiempo máximo para responder una consulta no será mayor a 400ms.
- **RNF6**: Medir el tiempo de respuesta de las consultas de los ciudadanos.

### Construya su Caso de Uso

## Ten en cuenta lo siguiente  :rocket:
### Build
Este comando te permite construir la aplicación compilando el codigo fuente del proyecto

```
mvn compile
```

### Run
Usando este comando podrás ejecutar la aplicación construída en el punto anterior.
```
mvn exec:java -Dexec.mainClass="<MainClassName>"
```

### Sonar Scan
Usando el siguiente comando podrás escanear tu proyecto con SonarCloud. Para más información sobre la configuración de Sonar puedes ingresar [al siguiente link](https://docs.google.com/document/d/1I6Ys17CyuuFFonIjWwUAK322beynL5wN2Gpi9XRpkDg/edit?usp=sharing).
```
mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar
```
