/**
 * 
 */
package projekt.fhv.teama.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Liefert eine Session für den Datenbankzugriff (Singleton)
 * 
 * @author Team A
 * @version 2.1
 */
public class HibernateHelper {

	@SuppressWarnings("rawtypes")
	private static final ThreadLocal session = new ThreadLocal();
	@SuppressWarnings({ "unused", "rawtypes" })
	private static final ThreadLocal transaction = new ThreadLocal();
	@SuppressWarnings("deprecation")
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private HibernateHelper() {
	}

	/**
	 * Besteht eine Session so wird diese zurückgegeben - ansonsten wird eine neue Session erstellt und diese retourniert.
	 * 
	 * @return Eine Session wird zurückgegeben
	 */
	@SuppressWarnings("unchecked")
	public static Session getSession() {
		Session session = (Session) HibernateHelper.session.get();
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
			HibernateHelper.session.set(session);
		}
		return session;

	}

}
