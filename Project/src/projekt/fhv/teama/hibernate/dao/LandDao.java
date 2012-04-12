package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.Land;
import projekt.fhv.teama.hibernate.HibernateHelper;

public class LandDao {
	
	
	public Land getLand(String bezeichnung) {
		try {
			Session session = HibernateHelper.getSession();
			Query q = session.createQuery("from Land where bezeichnung= :bezeichnung");
			q.setString("bezeichnung", bezeichnung);
			List result = q.list();
			Land p = null;
			if (result.size() == 1) {
				p = (Land) result.get(0);
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
