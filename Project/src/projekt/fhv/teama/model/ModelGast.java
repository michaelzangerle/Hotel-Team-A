package projekt.fhv.teama.model;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.personen.IAdresse;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.personen.GastDao;
import projekt.fhv.teama.hibernate.dao.personen.IGastDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.interfaces.IModelGast;

public class ModelGast implements IModelGast {

	private IGast gastModel;
	private IGastDao gastDao;

	public ModelGast() {
		gastDao = GastDao.getInstance();
	}

	@Override
	public void setAktuellGast(IGast gast) {
		gastModel = gast;

	}

	@Override
	public IGast getAktuellGast() throws FokusException {
		if (gastModel != null)
			return gastModel;
		else
			throw new FokusException();
	}

	public void setVorname(String vorname) throws EmptyParameterException,
			FokusException {
		if (vorname != null) {
			if (gastModel != null)
				gastModel.setVorname(vorname);
			else {
				throw new FokusException();
			}
		} else
			throw new EmptyParameterException();
	}

	@Override
	public void setNachname(String nachname) throws FokusException, EmptyParameterException{
		if (nachname != null) {
			if (gastModel != null)
				gastModel.setNachname(nachname);
			else {
				throw new FokusException();
			}
		} else {
			throw new EmptyParameterException();
		}

	}

	@Override
	public void setGeschlecht(char geschlecht) {
		if (gastModel != null && (geschlecht == 'm' || geschlecht == 'w'))
			gastModel.setGeschlecht(geschlecht);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setGeburtsdatum(Date geburtsdatum) {
		if (gastModel != null && (geburtsdatum.after(new Date(1900, 01, 01))))
			gastModel.setGeburtsdatum(geburtsdatum);

	}

	@Override
	public void setKontodaten(String kontonummer, String blz, String iban,
			String bic) throws WrongParameterException, FokusException  {
		if (gastModel != null) {
			if (kontonummer.length() <= 50 && blz.length() <= 50
					&& iban.length() <= 50 && bic.length() <= 50) {
				IKontodaten k = new Kontodaten(iban, bic, kontonummer, blz);
				gastModel.setKontodaten(k);

			}
			else {
				throw new WrongParameterException();
			}
		}
		else
			throw new FokusException();
	}

	@Override
	public void setEmail(String email) throws FokusException, EmptyParameterException {
		if(email!=null)
		{
		if (gastModel != null) {
			gastModel.setEmail(email);
		}
		else {
			throw new FokusException();
		}
		}
		else {
			throw new EmptyParameterException();
		}

	}

	@Override
	public void removeAdresse(IAdresse adresse) throws NotContainExeption, FokusException {
		if (gastModel != null) {
			List<IAdresse> adressen = new Vector<IAdresse>(
					gastModel.getAdressen());
			if (adressen.contains(adresse))
				adressen.remove(adresse);
			else {
				throw new NotContainExeption();
			}
		}
		else
		{
			throw new FokusException();
		}

	}

	@Override
	public void addAdresse(IAdresse adresse) throws FokusException, EmptyParameterException{
		if(adresse!=null)
		{
		if (gastModel != null) {
			gastModel.addAdresse(adresse);
		}
		else
			throw new FokusException();
		}
		else {
			throw new EmptyParameterException();
		}
		

	}

	@Override
	public void setNummer(String nummer) throws FokusException, EmptyParameterException {
		if(nummer!=null)
		{
		
		if (gastModel != null) {
			gastModel.setNummer(nummer);
		}
		else
			throw new FokusException();
		}
		else {
			throw new EmptyParameterException();
		}
		
	}

	@Override
	public void setZimmer(IZimmer zimmer) throws FokusException, EmptyParameterException {
		if(zimmer!=null){
		if (gastModel != null) {
			gastModel.setZimmer(zimmer);
		}
		else
			throw new FokusException();
		}
		else {
			throw new EmptyParameterException();
		}
		

	}

	@Override
	public void setTelefonnummer(String telefonnummer) throws FokusException {
		if (gastModel != null && telefonnummer.length() < 50) {
			gastModel.setTelefonnummer(telefonnummer);
		}
		else {
			throw new FokusException();
		}

	}

	@Override
	public void save(IGast gast) throws DatabaseException, EmptyParameterException {
		if (gast != null)
				gastDao.create(gast);
		else {
			throw new EmptyParameterException();
		}
			

	}

}
