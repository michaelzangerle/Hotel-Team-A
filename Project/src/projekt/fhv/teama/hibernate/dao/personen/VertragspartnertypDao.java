package projekt.fhv.teama.hibernate.dao.personen;

import projekt.fhv.teama.classes.personen.IVertragspartnertyp;
import projekt.fhv.teama.hibernate.dao.GenericDao;

public class VertragspartnertypDao extends GenericDao<IVertragspartnertyp> implements IVertragspartnertypDao {
	private static IVertragspartnertypDao instance;

	public static IVertragspartnertypDao getInstance() {
		if (instance == null) {
			instance = new VertragspartnertypDao();
		}
		return instance;
	}
	
	
	public VertragspartnertypDao() {
		super("Vertragspartnertyp");
	}
}
