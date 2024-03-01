
--- INSTRUCCIONES PARA BACKEND
1- Cargar la base de datos del script Prueba_restauranteBD.sql (el nombre de la base de datos es Prueba_Restaurante)
2- Modificar el archivo de propiedades en ruta \to-restaurant-app\backendRestaurant\src\main\resources\application.properties

--- Modificar usuario y password ---
spring.datasource.username=root
spring.datasource.password=admin

--- Modificar URL de conexion ---
cambiar "localhost" por la ruta del servidor donde está publicada la base de datos

spring.datasource.url=jdbc:mysql://localhost/Prueba_Restaurante?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true

--- Modificar el puerto de arranque si se desea ---

server.port = 8080

El proyecto se correrá en localhost:8080

//INSTRUCCIONES PARA FRONTEND
Si se desea cambiar la ruta del backend modificar el environtment.ts en la ruta to-restaurant-app\frontendRestaurant\src\app\environtment.ts

cambiar la url en l parametro: "urlBackend: 'http://localhost:8080/'"

El proyecto se corre en localhost:4200

