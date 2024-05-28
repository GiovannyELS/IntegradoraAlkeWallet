# Proyecto AlkeWallet

Este proyecto se lleva a cabo como un ejercicio dentro del curso “Desarrollo de Aplicaciones Móviles Android Trainee” del Bootcamp Talento Digital para Chile. El ejercicio consiste en el desarrollo de una billetera virtual llamada Alke Wallet. El diseño del proyecto se centra en proporcionar una interfaz intuitiva y fácil de usar que permite a los usuarios realizar operaciones financieras básicas, tales como depósitos, retiros y consultas de saldo.

## Objetivo

Durante el módulo 5 Se nos encargó implementar la arquitectura MVVM y la lógica de comunicación entre View y View Model, para las pantallas necesarias que se realizaron en el módulo anterior.  Esto conlleva que se asegure una interacción fluida y eficaz entre estas capas esenciales en el proceso de desarrollo de la app.

## Requerimientos

La Alke Wallet debe cumplir con una serie de características y requerimientos técnicos para garantizar su calidad y funcionalidad. Estos incluyen:

1. **Definición de Interfaces:**

   - Interfaz para la capa View que describa los métodos y propiedades utilizados por el View Model para comunicarse con la Vista.
   - Interfaz para el View Model que declare los métodos y propiedades disponibles para la Vista.

2. **Implementación de Data Binding:**
   - Mecanismo de data binding para permitir la actualización automática de la Vista cuando los datos en el View Model cambien y viceversa.

3. **Uso de Eventos:**
   - Implementación de eventos o mecanismos de notificación para informar a la Vista sobre eventos importantes o cambios en el View Model.

4. **Manejo de Comandos:**
   - Estructura para el manejo de comandos desde la Vista al View Model.

5. **Validación de Datos:**
   - Implementación de mecanismos de validación de datos en el View Model.

6. **Documentación:**
   - Proporcionar una documentación detallada de la arquitectura

  
## Características Principales

➡️ _Creación de Usuarios:_ Se registra y verifica usuarios de manera segura. 

➡️ _Loggin de Usuario:_ Permite loggear al usuario creado en el Signup page.

➡️ _Validación:_ Se validan datos de registro con el Shared Preferences y la respectiva lógica. 

➡️ _Saldo Inicial:_ Se puede visualiza tu saldo actual (seteado en duro).

➡️ _Nombre de Usuario creado:_ Se puede apreciar la tarjeta inicial del home el nombre de la persona loggeada, la imagen no cambia ya que deberia
  existir una pantalla en el signup para tomar o subir la foto desde la creacion de usuario. se tomará en cuenta para proximas entregas. 
 
➡️ _Transacciones realizadas:_ Se mantiene una lista de transacciones de muestra creada. En las cuales se ingresa por lista los datos requeridos en el recycler.

➡️ _Navegación fluida:_ Se realiza navegación por los comados asignados a los botones.

➡️ _Uso del ViewBinding:_ Se utiliza el Binding para las actualizaciones automáticas de las vistas. 

### Screenshots

A continuación, se muestran algunos pantallazos de la aplicación:
