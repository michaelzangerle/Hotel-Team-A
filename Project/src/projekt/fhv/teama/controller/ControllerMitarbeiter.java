package projekt.fhv.teama.controller;

import java.util.Vector;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.controller.exeption.LoginInExeption;
import projekt.fhv.teama.controller.interfaces.IControllerMitarbeiter;
import projekt.fhv.teama.hibernate.dao.personen.IMitarbeiterDao;
import projekt.fhv.teama.hibernate.dao.personen.MitarbeiterDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ControllerMitarbeiter implements IControllerMitarbeiter {
	
	IMitarbeiter mitarbeiterModel;
	IMitarbeiterDao mitarbeiterDao;
	
	public ControllerMitarbeiter() {
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
