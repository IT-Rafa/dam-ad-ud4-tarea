package es.itrafa.ad.ud4.t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final Logger LOG = LogManager.getLogger(HibernateUtil.class);
	private static final SessionFactory SF = buildSessionFactory();

	private HibernateUtil() {

	}

	private static SessionFactory buildSessionFactory() {
		try {
			LOG.trace("Accediendo a base de datos");
			return new Configuration().configure().buildSessionFactory();

		} catch (HibernateException ex) {

			LOG.error("Fallo en Aacceso a base de datos");
			LOG.error(ex.getLocalizedMessage());
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return SF;
	}

	public static void closeSessionFactory() {
		LOG.trace("Cerrando acceso a base de datos");
		SF.close();
	}

}
