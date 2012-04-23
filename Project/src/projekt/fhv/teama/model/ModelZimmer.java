package projekt.fhv.teama.model;

import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.zimmer.IZimmerDao;
import projekt.fhv.teama.hibernate.dao.zimmer.ZimmerDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.interfaces.IModelZimmer;



public class ModelZimmer implements IModelZimmer {
	

	IZimmer zimmertModel;
	IZimmerDao zimmerDao;
	
	public ModelZimmer() {
		zimmerDao=ZimmerDao.getInstance();
	}

	@Override
	public List<IZimmer> getVerfuegbareZimmerF�rGegebeneKategorie(
			IKategorie ausgew�hlteKategorie) throws DatabaseEntryNotFoundException {
		
		List<IZimmer> verf�gbare=new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (IZimmer zi : alle) {
			if(zi.getKategorie().equals(ausgew�hlteKategorie)&&zi.getZimmerstatus().getKuerzel().equals("FG"))
			{
				verf�gbare.add(zi);
			}
		}
		return verf�gbare;
		
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

	@Override
	public List<IZimmer> getVerf�gbareZimmer() {
		
		List<IZimmer> verf�gbare=new Vector<IZimmer>();
		List<IZimmer> alle = null;
		try {
			alle = new Vector<IZimmer>(zimmerDao.getAll());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (IZimmer zi : alle) {
			if(zi.getZimmerstatus().getKuerzel().equals("fuck"))
			{
				verf�gbare.add(zi);
			}
		}
		return verf�gbare;
	}
	

	
	
	
}
