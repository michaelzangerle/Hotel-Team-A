package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import projekt.fhv.teama.classes.personen.Berechtigung;
import projekt.fhv.teama.classes.personen.Land;
import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.HibernateHelper;
import projekt.fhv.teama.hibernate.dao.GenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseNotFoundException;

public class MitarbeiterDao extends GenericDao<Mitarbeiter> {

	
	public MitarbeiterDao() {
		super("Mitarbeiter");
	}
}
