package es.itrafa.ad.ud4.t1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.*;

abstract class DBEntity {
	private static final Logger log = LogManager.getLogger(DBEntity.class);
	private  String className = this.getClass().getSimpleName();

	public void save() {
		log.trace("Iniciando sesión en base datos");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			log.trace("Iniciando transacción con base datos");
			tx = session.beginTransaction();
			log.trace("Guardando Objeto: {}", className );
			session.save(this);
			tx.commit();

		} catch (ConstraintViolationException constException) {
			log.error("No se respeta la restricción");
			log.error(constException.getLocalizedMessage());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			log.trace("Fin sesión en base datos");
			session.close();
		}
		log.trace("Guardado {} en base de datos", className);
	}

	public void delete() {
		log.trace("Iniciando sesión en base datos");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			log.trace("Iniciando comunicación con base datos");
			tx = session.beginTransaction();
			log.trace("Eliminando {} de base datos", className);
			session.delete(this);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		log.trace("Eliminado {} de base de datos", className);

	}
}
