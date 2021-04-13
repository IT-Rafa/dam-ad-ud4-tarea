package es.itrafa.ad.ud4.t1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.*;


abstract class DBEntity {
	private static final Logger LOG = LogManager.getLogger(DBEntity.class);
	private  String className = this.getClass().getSimpleName();


	protected Session initSession() {
		LOG.trace("Iniciando sesión en base datos");
		return HibernateUtil.getSessionFactory().openSession();
	}


	public void save() {
		Session session = initSession();
		Transaction tx = null;

		try {
			LOG.trace("Iniciando transacción con base datos");
			tx = session.beginTransaction();
			LOG.trace("Guardando Objeto: {}", className );
			session.save(this);
			tx.commit();

		} catch (ConstraintViolationException constException) {
			LOG.error("No se respeta la restricción");
			LOG.error(constException.getLocalizedMessage());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			LOG.trace("Fin sesión en base datos");
			session.close();
		}
		LOG.trace("Guardado {} en base de datos", className);
	}



	public void delete() {
		Session session = initSession();
		Transaction tx = null;

		try {
			LOG.trace("Iniciando comunicación con base datos");
			tx = session.beginTransaction();
			LOG.trace("Eliminando {} de base datos", className);
			session.delete(this);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		LOG.trace("Eliminado {} de base de datos", className);

	}

}
