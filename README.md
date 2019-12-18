# Project-Dynamic-Web
JSF JPA PrimeFaces


CONFIGURACIÓN:
#1 Dynamic Web Project
#2 Properties -> Project Faces -> JavaServer Faces
	#Add jar Mojarra 2.2
#3 Properties -> Project Faces -> JPA
	#Add Eclipse Link 2.5

#4 Agregar conexión DB
	#Add connection -> Generic JDBC -> Driver
	#Add JAR -> ojdbc
	#Add JAR -> ojdbc to WebContent -> WEB-INF -> lib -> 

#5 CAPA DAO Data Acces Object
	#JPA content -> persistence.xml -> properties -> NAME
	#JPA content -> persistence.xml -> properties -> javax.persistence.jdbc.user
	#JPA content -> persistence.xml -> properties -> javax.persistence.jdbc.password
	#JPA content -> persistence.xml -> properties -> javax.persistence.jdbc.driver: oracle.jdbc.driver.OracleDriver
	#JPA content -> persistence.xml -> properties -> javax.persistence.jdbc.url: jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1
---------------------------------------------------------------------------------------------------------------------------
	#Java Resource -> src -> new Package Entidades -> New -> JPA Entities from Tables -> select tablas
	# -> Key Generator: sequence -> Sequence Name
	# in Class -> @SequenceGenerator add -> ", allocationSize=1"

---------------------------------------------------------------------------------------------------------------------------
	#Java Resource -> src -> new Package DAO -> 
	#New Class -> DaoManager -> Persistence.createEntityManagerFactory("NAME PERSISTENCE XML')
	#New Class -> ProductoDao -> em.createNamedQuery(JPQL) Java Persistence Query Language

-------------------------------------------------------------------------------------------------------------------------	
	# add controllers
-------------------------------------------------------------------------------------------------------------------------	
	# add html file xhtml
	# add jar primefaces
	# xmlns:p="http://primefaces.org/ui"
	
	
	

	
	

