/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.itrafa.ad.ud4.t1;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ejecuta ejercicio DAM-AD-UD4-T1
 *
 * @author rafa
 */
public class Init {
	private static final Logger log = LogManager.getLogger(Init.class);

	/**
	 * Pasos Ejercicio
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		System.console().format("%n");
		log.trace("Inicio de programa");

		/*
		 * 1. Crea la base de datos - Implementado con docker
		 */
		/*
		 * 2. Configura y crea la ORM Hibernate. - 2.1 Como usamos maven, añadimos
		 * dependencias a archivo POM - 2.2 Como Oracle precisa licencia y no lo
		 * descarga el IDE, añadimos manualmente a carpeta [prj]/lib/ y lo indicamos en
		 * maven. - 2.3 Configuramos hibernate - CONF: Podemos sacar archivo del archivo
		 * hibernate ? - CONF: Reverse no necesario, pues no hay schema ? - CONF:
		 * Modificamos datos conexión en hibernate.cfg.xml - PRE-MAPEO: Creamos clases
		 * equivalentes a las tablas EMP y DEPT - MAPEO: Creamos archivo mapeo para
		 * DEPT. - MAPEO: Añadimos anotaciones java para EMP - JAVA: CONEXIÓN: Creamos
		 * clase HibernateUtil para el acceso a la base de datos
		 * 
		 */
		/*
		 * 3. Realiza una inserción y un borrado sobre la tabla EMP. - 3.1 Creamos clase
		 * abstracta para las clases que representan tablas con métodos para guardar y
		 * borrar. Hacemos que las clases correspondientes hereden - 3.2 Creamos clase
		 * Empleado y llamamos al método de su clase abstracta para guardarlo en la base
		 * de datos
		 */
		Departamento d = new Departamento(50, "RRHH", "L.A.");
		d.save();
		d.delete();

		// Crea empleado
		Empleado e = new Empleado(8000, "Paco", "SALESMAN", 7698, LocalDate.of(2000, 10, 1), 2000.20, 200.20, 30);

		// Guarda empleado en base de datos
		e.save();

		// borra empleado recién creado
		e.delete();


		/*
		 * 4. Obtener un listado sobre las tablas EMP y DEPT que visualize 
		 * empno, ename, dname y loc. -
		 */

		Query consulta = sesion.createSQLQuery("SELECT * from Medallas where codDeportista =:codDeportista");
		consulta.setParameter("codDeportista", codDeportista);
		/*
		 * 5. Redactar un documento donde se explique el proceso seguido para la
		 * realización de la práctica. -
		 */
	}

}
