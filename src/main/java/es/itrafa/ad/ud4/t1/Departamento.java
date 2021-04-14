/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.itrafa.ad.ud4.t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import java.util.List;

/**
 * Representa tabla EMP
 *
 * @author rafa
 */

public class Departamento extends DBEntity {

	// ATRIBUTOS
	private static final Logger LOG = LogManager.getLogger(Departamento.class);

	private int deptno; // DEPTNO: nº departamento
	private String dname; // DNAME: nombre departamento
	private String loc; // LOC: localización

	// GETTER & SETTER
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	// CONSTRUCTORES
	/**
	 * Contructor con todos los campos.
	 */
	public Departamento() {
	}

	public Departamento(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	// GETTER / SETTER

	// OTROS MÉTODOS

	@Override
	public String toString() {
		return "Departamento {\n  Número       : " + deptno + "\n  Nombre       : " + dname + "\n  Localización : "
				+ loc + "\n}\n";
	}

	public static List<Departamento> getAll() {

		List<Departamento> deptList = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			LOG.trace("Iniciando transacción con base datos");
			LOG.trace("Iniciando consulta");
			deptList = session.createNativeQuery("SELECT * FROM DEPT", Departamento.class).list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			LOG.trace("Fin sesión en base datos");
			session.close();
		}
		LOG.trace("Fin consulta");
		return deptList;
	}

}
