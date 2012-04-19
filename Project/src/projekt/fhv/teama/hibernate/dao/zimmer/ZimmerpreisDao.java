package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.IZimmerpreis;
import projekt.fhv.teama.hibernate.dao.GenericDao;

public class ZimmerpreisDao extends GenericDao<IZimmerpreis> implements IZimmerpreisDao {

	private static ZimmerpreisDao instance;

	public static IZimmerpreisDao getInstance() {
		if (instance == null) {
			instance = new ZimmerpreisDao();
		}
		return instance;
	}

	private  ZimmerpreisDao() {
		super("Zimmerpreis");
	}
	
	

}
