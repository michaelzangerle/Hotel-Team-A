package projekt.fhv.teama.model;

import java.util.Vector;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.hibernate.dao.personen.IMitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.personen.MitarbeiterDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelMitarbeiter;


/**
 * Model für den Umgang mit einem Mitarbeiter
 * @author Team-A
 * @version 1.5
 */
public class ModelMitarbeiter implements IModelMitarbeiter {
	
	IMitarbeiter mitarbeiterModel;
	IMitarbeiterDao mitarbeiterDao;
	
	public ModelMitarbeiter() {
		mitarbeiterDao=MitarbeiterDao.getInstance();
	}

	
	@Override
	public IMitarbeiter getMitarbeiterByUid(String uid,String pw) throws DatabaseException, LoginInExeption {
		
		for (IMitarbeiter m : new Vector<IMitarbeiter>(mitarbeiterDao.getMitarbeiterByNummer(uid))) {
			if(m.getNummer().equals(uid)&&m.getPasswort().equals(pw))
				return m;
		}
		throw new LoginInExeption(uid,pw);

	}

}
