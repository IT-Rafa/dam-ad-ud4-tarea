package es.itrafa.ad.ud4.t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final Logger Log = LogManager.getLogger(HibernateUtil.class);
	private static final SessionFactory SF = buildSessionFactory();

	private HibernateUtil() {

	}

	private static SessionFactory buildSessionFactory() {
		try {
			Log.trace("Accediendo a base de datos");
			return new Configuration().configure().buildSessionFactory();

		} catch (HibernateException ex) {

			Log.error("Fallo en Aacceso a base de datos");
			Log.error(ex.getLocalizedMessage());
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return SF;
	}

	public static void closeSessionFactory() {
		Log.trace("Cerrando acceso a base de datos");
		SF.close();
	}

}
