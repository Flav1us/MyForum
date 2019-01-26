package storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.ForumThreadAsBytes;
//привет
public class ForumThreadDAO {
	private static SessionFactory factory = new Configuration().configure().
			addAnnotatedClass(ForumThreadAsBytes.class).
			setProperty("hibernate.id.new_generator_mappings", "false").
			buildSessionFactory();
	
	public static void save(ForumThreadAsBytes ft) {
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		System.out.println();s.save(ft);
		t.commit();
		s.close();
	}

	/*public static byte[] load() {
		Session s = factory.openSession();
		Transaction t = null;
		ForumThreadAsBytes bytes;
		try {
			t = s.beginTransaction();
			s.createSQLQuery("select * from forumthread");
			t.commit();
			bytes = s.get(ForumThreadAsBytes.class, 7849517898704798222L);
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw e;
		} finally {
			s.close();
		}
	}*/

}
