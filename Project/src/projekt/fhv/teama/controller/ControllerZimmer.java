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
	public List<IZimmer> getZimmerFürGegebeneKategorie(
			IKategorie ausgewählteKategorie) throws NoDatabaseEntryFoundException {
		
		List<IZimmer> verfügbare=new Vector<IZimmer>();
		List<IZimmer> alle=new Vector<IZimmer>(zimmerDao.getAll());
		
		for (IZimmer zi : alle) {
			if(zi.getKategorie().equals(ausgewählteKategorie)&&zi.getZimmerstatus().getKuerzel().equals("fuck"))
			{
				verfügbare.add(zi);
			}
		}
		return verfügbare;
		
	}
	

	
	
	
}
