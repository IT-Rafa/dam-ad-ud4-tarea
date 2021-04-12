/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.itrafa.ad.ud4.t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Console;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

/**
 * Representa tabla EMP
 *
 * @author rafa
 */
@Entity
@Table(name = "EMP")
public class Empleado extends DBEntity {

	// ATRIBUTOS
	private static final Logger log = LogManager.getLogger(Empleado.class);

	@Id
	@Column(name = "EMPNO")
	private int empno; // EMPNO: nº empleado

	@Column(name = "ENAME")
	private String ename; // ENAME: nombre empleado

	@Column(name = "JOB")
	private String job; // JOB: trabajo

	@Column(name = "MGR")
	private int mgr; // MGR: nº empleado responsable

	@Column(name = "HIREDATE")
	private Date hiredate; // HIREDATE:(DATE) fecha contrato
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
	@Column(name = "SAL", columnDefinition="Decimal(7,2)")
	private double sal; // SAL: salario

	@Column(name = "COMM", columnDefinition="Decimal(7,2)")
	private double comm; // COMM: comisión

	@Column(name = "DEPTNO")
	private int deptno; // DEPTNO: nº departamento

	// CONSTRUCTORES

	/**
	 * Contructor dato de prueba
	 */

	public Empleado() {
		log.trace("Creando objeto Empleado - Datos por consola");


		Console input = System.console();
		if (input != null) {

			setEmpno(Integer.parseInt(input.readLine("Número de empleado (8000): ")));
			setEname(input.readLine("Nombre de empleado (Paco Paco Paco): "));

			setJob(input.readLine("Tipo de trabajo ('SALESMAN'): "));

			setMgr(Integer.parseInt(input.readLine("Nº del responsable: (8000) ")));

			int year;
			int month;
			int day;
			setHiredate(new Date(year, month, day));

			setSal(Double.parseDouble(input.readLine("Salario: (3000.5)")));

			setComm(Double.parseDouble(input.readLine("Comisión:1000,7 ")));

			setDeptno(Integer.parseInt(input.readLine("Nº de departamento: (30)")));

		}
	}

	public Empleado(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm,
			int deptno) {
				log.trace("Creando objeto Empleado - Datos como parámetros");

		setEmpno(empno);
		setEname(ename);
		setJob(job);
		setMgr(mgr);
		setHiredate(hiredate);
		setSal(sal);
		setComm(comm);
		setDeptno(deptno);
	}

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

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate( Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	// OTROS MÉTODOS
	@Override
	public String toString() {
		return "Empleado{" + "empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + '}';
	}

}