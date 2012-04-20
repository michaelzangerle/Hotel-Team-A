package projekt.fhv.teama.controller;

import java.util.List;
import java.util.Vector;

import javassist.expr.NewArray;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.classes.zimmer.Zimmerstatus;
import projekt.fhv.teama.controller.interfaces.IControllerZimmer;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;



public class ControllerZimmer implements IControllerZimmer {
	

	IZimmer zimmertModel;
	IZimmerDao zimmerDao;
	
	public ControllerZimmer() {
		zimmerDao=ZimmerDao.getInstance();
	}

	@Override
	public List<IZimmer> getZimmerF�rGegebeneKategorie(
			IKategorie ausgew�hlteKategorie) throws NoDatabaseEntryFoundException {
		
		List<IZimmer> verf�gbare=new Vector<IZimmer>();
		List<IZimmer> alle=new Vector<IZimmer>(zimmerDao.getAll());
		
		for (IZimmer zi : alle) {
			if(zi.getKategorie().equals(ausgew�hlteKategorie)&&zi.getZimmerstatus().getKuerzel().equals("fuck"))
			{
				verf�gbare.add(zi);
			}
		}
		return verf�gbare;
		
	}
	

	
	
	
}
