/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.itrafa.ad.ud4.t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Representa tabla EMP
 *
 * @author rafa
 */

public class Departamento extends DBEntity  {

	// ATRIBUTOS
	private static final Logger log = LogManager.getLogger(Departamento.class);


	private int deptno; // DEPTNO: nº departamento
	private String dname; // DNAME: nombre departamento
	private String loc; // LOC: localización

	// CONSTRUCTORES
	/**
	 * Contructor con todos los campos.
	 */
	public Departamento(int deptno, String dname, String loc) {
		log.trace("Creando objeto Departamento");
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	// GETTER / SETTER

	// OTROS MÉTODOS

	@Override
	public String toString() {
		return "Departamento{" + "deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + '}';
	}

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

}