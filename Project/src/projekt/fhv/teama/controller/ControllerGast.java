package projekt.fhv.teama.controller;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.interfaces.IControllerGast;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class ControllerGast implements IControllerGast {

	private IGast gastModel;
	private IGastDao gastDao;
	
	public ControllerGast() {
		gastDao=GastDao.getInstance();
	}

	@Override
	public void setAktuellGast(IGast gast) {
		gastModel=gast;
		
	}
	
	
	@Override
	public IGast getAktuellGast() {
		if(gastModel!=null)
			return gastModel;
		else
			return null;
		//TODO Fehlermeldung
	}
	
	public void setVorname(String vorname)
	{
		if(gastModel!=null)
		gastModel.setVorname(vorname);
	}

	

	@Override
	public void setNachname(String nachname) {
		if(gastModel!=null)
			gastModel.setNachname(nachname);
		
	}

	@Override
	public void setGeschlecht(char geschlecht) {
		if(gastModel!=null&&(geschlecht=='m'||geschlecht=='w'))
			gastModel.setGeschlecht(geschlecht);
		
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void setGeburtsdatum(Date geburtsdatum) {
		if(gastModel!=null&&(geburtsdatum.after(new Date(1900,01,01))))
			gastModel.setGeburtsdatum(geburtsdatum);
		
	}

	@Override
	public void setKontodaten(String kontonummer, String blz, String iban,
			String bic) {
		if(gastModel!=null)
		{
		if(kontonummer.length()<=50&&blz.length()<=50&&iban.length()<=50&&bic.length()<=50)
		{
			IKontodaten k=new Kontodaten(iban, bic, kontonummer, blz);
			gastModel.setKontodaten(k);
			
		}
		}
		
		
	}

	@Override
	public void setEmail(String email) {
		if(gastModel!=null)
		{
			gastModel.setEmail(email);
		}
		
	}

	@Override
	public void removeAdresse(IAdresse adresse) {
		if(gastModel!=null)
		{
			List<IAdresse> adressen=new Vector<IAdresse>(gastModel.getAdressen());
			if(adressen.contains(adresse))
				adressen.remove(adresse);
		}
		
		
	}

	@Override
	public void addAdresse(IAdresse adresse) {
		if(gastModel!=null)
		{
			List<IAdresse> adressen=new Vector<IAdresse>(gastModel.getAdressen());
			if(!adressen.contains(adresse))
				adressen.add(adresse);
		}
		
	}

	@Override
	public void setNummer(String nummer) {
		if(gastModel!=null)
		{
			gastModel.setNummer(nummer);
		}
		
	}

	@Override
	public void setZimmer(IZimmer zimmer) {
		if(gastModel!=null)
		{
			gastModel.setZimmer(zimmer);
		}
		
	}

	@Override
	public void setTelefonnummer(String telefonnummer) {
		if(gastModel!=null&&telefonnummer.length()<50)
		{
			gastModel.setTelefonnummer(telefonnummer);
		}
		
	}

	@Override
	public void save(IGast gast) {
		if(gast!=null)
			try {
				gastDao.create(gast);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
