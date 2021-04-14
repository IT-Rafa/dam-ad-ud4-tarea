/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.itrafa.ad.ud4.t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.Session;
import java.util.List;

/**
 * Representa tabla EMP
 *
 * @author rafa
 */
@Entity
@Table(name = "EMP")
public class Empleado extends DBEntity {

	// ATRIBUTOS
	private static final Logger LOG = LogManager.getLogger(Empleado.class);

	private int empno; // EMPNO: nº empleado
	private String ename; // ENAME: nombre empleado
	private String job; // JOB: trabajo
	private Integer mgr; // MGR: nº empleado responsable
	private LocalDate hiredate; // HIREDATE:(DATE) fecha contrato
	private Double sal; // SAL: salario
	private Double comm; // COMM: comisión
	private int deptno; // DEPTNO: nº departamento

	// GETTERS / SETTERS
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	// CONSTRUCTORES

	/**
	 * Contructor dato de prueba
	 */

	public Empleado() { }
	

	public Empleado(int empno, String ename, String job, int mgr, LocalDate hiredate, double sal, double comm,
			int deptno) {

		setEmpno(empno);
		setEname(ename);
		setJob(job);
		setMgr(mgr);
		setHiredate(hiredate);
		setSal(sal);
		setComm(comm);
		setDeptno(deptno);
	}

	// OTROS MÉTODOS
	@Override
	public String toString() {
		return "Empleado {\n  Número       : " + empno + "\n  Nombre       : " + ename + "\n  Trabajo      : " + job
				+ "\n  Gestor       : " + mgr + "\n  Fecha Inicio : " + hiredate + "\n  Salario      : " + sal + "\n  Comisión     : "
				+ comm + "\n  Departamento : " + deptno + "\n}\n";

	}

	public static List<Empleado> getAll() {

		List<Empleado> deptList = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			LOG.trace("Iniciando transacción con base datos");
			LOG.trace("Iniciando consulta");
			deptList = session.createNativeQuery("SELECT * FROM EMP", Empleado.class).list();

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
