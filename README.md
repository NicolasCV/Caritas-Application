# MiCaritas-Application
Bienvenidos, este repositorio contiene el codigo fuente para la aplicacion Android que se desarrollo durante este semestre en colaboracion con la institucion Caritas de Monterrey. Este `ReadMe.md` busca ser una guia de instalacion para cualquier desarrollador que busque utilizar o seguir con el desarrollo de esta.



Esta sera una Aplicación de Android que ayudará a los donantes a ver su cantidad total donada a Caritas cuando lo desee. También tendrá la opción de ver eventos futuros de la organización, así como el feed de noticias que Cáritas publique. También podrá ver datos generales de su perfil y tendrá una liga que lleve a la página de caritas desde la aplicación.

Para ver la cantidad donada se hará uso de una base de datos, debido a que no se pudo establecer un ambiente similar al de ejecucion, se realizo la base de datos dentro de la aplicacion Android. Sin embargo, en un ambiente donde se busque publicar la aplicacion, se requiere un servidor cifrado para almacenar la información que contendrá la base de datos. [Por restriccion de tiempo, la conexion con la base de datos local tampoco fue exitosa]




## Instrucciones de Instalacion

Dentro del repositorio, en la carpeta de documentos dentro de la `main` branch, existe una carpeta con el nombre `Documentos` donde se puede encotnrar informacion mas detallada a la siguiente.

Nuestra aplicación fue desarrollada con Android Studio utilizando Android 6.0 (Marshmallow). Para instalar la aplicación en un dispositivo móvil es tan simple como descargar el archivo .apk en la carpeta de documentos e instalarla en tu dispositivo móvil. Probablemente tendrás que darle permisos a la aplicación que la este intentando instalar, el dispositivo proveerá instrucciones de cómo hacer esto.
Para hacer modificaciones a la aplicación es necesario descargar el código fuente en un zip y extraer todo en una carpeta. Esta, al momento de intentar abrirla con Android Studio, será detectada automáticamente como un proyecto y se empezará a construir todo el ambiente. De aquí en adelante se le puede hacer todas las modificaciones necesarias.

Aun es necesario que se implementen las funciones de la base de datos, esto se podrá implementar de la siguiente manera:
La aplicación está pensada para que cuando se tenga una API de Cáritas, sea muy simple pedir los datos del usuario y desplegarlos. La parte que sí se pudo implementar en el back-end fue el parseo de la información otorgada del feed.

Dentro de Android Studio, en el fragmento “Login.kt” se puede hacer la conexión con el API para enviar los datos introducidos en los campos de correo y contraseña para hacer la autenticación de usuario. En los fragmentos “PerfilFragment.kt” y “DonacionesCaritas.kt” se puede usar el API para, con los datos de usuario introducidos al inicio, extraer los datos necesarios como String y desplegarlos en los campos correspondientes. Por último, para editar información personal desde la aplicación, si así lo desea caritas, se puede implementar esta función dentro del fragmento “EditarPerfil.kt”





# Contribudores
## Equipo 2

Nicolás Cárdenas Valdez A01114959@itesm.mx - Android Developer


Carlos Sevilla Silva A00826925@itesm.mx - Android Developer


Andrés Limón Calleja A01552116@itesm.mx - Scrum Master


Iván David Manzano A01029111@itesm.mx - DB master
