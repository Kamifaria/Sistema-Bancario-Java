package hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static Session session;
	public static String msg = null;

	public static Session abrirSession() {
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			return session;
		} catch (Throwable e) {
			msg = e.toString();
			return null;
		}
	}

	public static void fecharSession() {
		try {
			if (session != null) {
				session.close();
			}
		} catch (Exception e) {
			msg = e.toString();
		}
	}
}
