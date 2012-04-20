package projekt.fhv.teama.controller;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerZimmer;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;



public class ControllerZimmer implements IControllerZimmer {
	

	IZimmer zimmertModel;
	IZimmerDao zimmerDao;
	
	public ControllerZimmer() {
		zimmerDao=ZimmerDao.getInstance();
	}

	@Override
	public List<IZimmer> getZimmerFürGegebeneKategorie(
			IKategorie ausgewählteKategorie) throws DatabaseEntryNotFoundException {
		
		List<IZimmer> verfügbare=new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (IZimmer zi : alle) {
			if(zi.getKategorie().equals(ausgewählteKategorie)&&zi.getZimmerstatus().getKuerzel().equals("fuck"))
			{
				verfügbare.add(zi);
			}
		}
		return verfügbare;
		
	}

	@Override
	public void save(IZimmer zimmer) {
		if(zimmer!=null)
			try {
				zimmerDao.create(zimmer);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

	
	
	
}
