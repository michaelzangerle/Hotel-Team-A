package projekt.fhv.teama.controller.usecasecontroller;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import projekt.fhv.teama.classes.MyLittleDate;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerZusatzleistungBuchen;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAAufenthalt;
import projekt.fhv.teama.integrate.IAGast;
import projekt.fhv.teama.integrate.IALeistung;
import projekt.fhv.teama.integrate.IAZimmer;
import projekt.fhv.teama.model.ModelArtikel;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.ModelAufenthaltLeistung;
import projekt.fhv.teama.model.ModelGast;
import projekt.fhv.teama.model.ModelLeistung;
import projekt.fhv.teama.model.ModelZimmer;
import projekt.fhv.teama.model.ModelZusatzleistung;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;
import projekt.fhv.teama.model.exception.NotContainExeption;
import projekt.fhv.teama.model.exception.WrongParameterException;
import projekt.fhv.teama.model.interfaces.IModelArtikel;
import projekt.fhv.teama.model.interfaces.IModelAufenhaltLeistung;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;
import projekt.fhv.teama.model.interfaces.IModelLeistung;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
import projekt.fhv.teama.model.interfaces.IModelZusatzleistung;



import projekt.fhv.teama.model.integration.IAModelAufenthalt;
import projekt.fhv.teama.model.integration.IAModelGast;
import projekt.fhv.teama.model.integration.IAModelArtikel;
import projekt.fhv.teama.model.integration.IAModelZusatzleistung;
import projekt.fhv.teama.model.integration.IAModelZimmer;
import projekt.fhv.teama.model.integration.IAModelAufenthaltLeistung;

public class ControllerZusatzleistungBuchen
		implements
			IControllerZusatzleistungBuchen {

	// ModelRespositorys
	private IAModelAufenthalt modelAufenthalt;
	private IAModelGast modelGast;
	private IAModelArtikel modelArtikel;
	private IAModelZusatzleistung modelZusatzleistung;
	private IAModelZimmer modelZimmer;
	private IAModelAufenthaltLeistung modelAufenthaltLeistung;

	public ControllerZusatzleistungBuchen() {
		modelArtikel = new ModelArtikel();
		modelAufenthalt = new ModelAufenthalt();
		modelZusatzleistung = new ModelZusatzleistung();
		modelGast = new ModelGast();
		modelZimmer = new ModelZimmer();
		modelAufenthaltLeistung = new ModelAufenthaltLeistung();
	}

	private List<IAAufenthalt> aufenthalte = new Vector<IAAufenthalt>();

	private List<IALeistung> artikel = new Vector<IALeistung>();
	private List<IALeistung> zusatzleistungen = new Vector<IALeistung>();
	private List<IALeistung> leistungen = new Vector<IALeistung>();

	private HashMap<IAZimmer, List<LeistungAnzahl>> gebuchteLeistungen = new HashMap<IAZimmer, List<LeistungAnzahl>>();
	private HashMap<IAGast, List<LeistungAnzahl>> bereitsgebuchteLeistungen = new HashMap<IAGast, List<LeistungAnzahl>>();
	private boolean needReload = true;

	public List<IAAufenthalt> getAufenthalte() throws DatabaseException {
		if (aufenthalte.size() > 0)
			return aufenthalte;
		else {
			aufenthalte = modelAufenthalt.getAufenthalte(MyLittleDate.getDate(
					2012, 3, 25));
			return aufenthalte;
		}
	}

	public List<IAGast> getGaesteVonAuftenhalten() throws DatabaseException {
		if (aufenthalte.size() < 1) {
			aufenthalte.clear();
			getAufenthalte();
		}
		List<IAGast> gaeste = new Vector<IAGast>();
		for (IAAufenthalt aufenthalt : aufenthalte) {
			if (!gaeste.contains(aufenthalt.getAGast())
					&& aufenthalt.getAGast() != null)
				gaeste.add(aufenthalt.getAGast());
		}
		return gaeste;

	}

	public List<IAGast> getGaesteZumAufenhalt() throws FokusException {
		return modelAufenthalt.getGaesteZumAufenhalt();
	}

	public void setAufenthalt(IAAufenthalt aufenhalt)
			throws EmptyParameterException {
		modelAufenthalt.setAufenthalt(aufenhalt);
	}

	public IAAufenthalt getAufenthalt() throws FokusException {
		return (IAAufenthalt) modelAufenthalt.getAufenthalt();
	}

	public void setGast(IAGast gast) {
		modelGast.setAktuellGast(gast);
	}

	public IAGast getGast() throws FokusException {
		return (IAGast)modelGast.getAktuellGast();
	}

	public IAZimmer getZimmerByNummer(String nummer)
			throws EmptyParameterException, DatabaseException, FokusException {
		if (nummer == null)
			throw new EmptyParameterException();

		if (aufenthalte.size() <= 0)
			getAufenthalte();

		for (IAAufenthalt aufenthalt : aufenthalte) {
			if (aufenthalt.getAGast().equals(getGast())
					&& aufenthalt.getAZimmer() != null
					&& aufenthalt.getAZimmer().getNummer().equals(nummer)) {
				return aufenthalt.getAZimmer();
			}
		}
		return null;
	}

	public List<IAZimmer> getZimmerVonGast() throws FokusException,
			DatabaseException {
		List<IAZimmer> zimmers = new Vector<IAZimmer>();
		if (aufenthalte.size() <= 0)
			getAufenthalte();

		for (IAAufenthalt aufenthalt : aufenthalte) {
			if (aufenthalt.getAGast().equals(getGast())
					&& aufenthalt.getAZimmer() != null)
				zimmers.add(aufenthalt.getAZimmer());
		}

		return zimmers;
	}

	public IAGast getGastByNummer(String nummer) throws DatabaseException,
			EmptyParameterException, NotContainExeption {
		if (nummer == null)
			throw new EmptyParameterException();

		if (aufenthalte.size() <= 0)
			getAufenthalte();

		for (IAAufenthalt aufenthalt : aufenthalte) {
			if (aufenthalt.getAGast().getNummer().equals(nummer))
				return aufenthalt.getAGast();
		}

		throw new NotContainExeption();

	}

	public List<IALeistung> getArtikelundZusatzleistungen()
			throws DatabaseException {
		if (artikel.size() <= 0 || zusatzleistungen.size() <= 0) {
			artikel = modelArtikel.getAArtikel();
			zusatzleistungen = modelZusatzleistung.getAZusatzleistungen();
		}
		leistungen.clear();

		leistungen.addAll(artikel);
		leistungen.addAll(zusatzleistungen);

		return leistungen;

	}

	public void setAktuellesZimmer(IAZimmer zimmer)
			throws EmptyParameterException {
		modelZimmer.setAktullesZimmer(zimmer);

	}

	public IAZimmer getAktuellesZimmer() throws FokusException {
		return modelZimmer.getAAktullesZimmer();
	}

	public void addLeistung(IALeistung leistung, int anzahl)
			throws FokusException, EmptyParameterException {
		if (leistung != null && anzahl > 0) {
			if (gebuchteLeistungen.containsKey(getAktuellesZimmer())) {
				boolean istBereitsVorhanden = false;
				for (LeistungAnzahl help : gebuchteLeistungen
						.get(getAktuellesZimmer())) {
					if (help.getLeistung().equals(leistung)) {
						help.setAnzahl(anzahl);
						istBereitsVorhanden = true;
					}

				}
				if (!istBereitsVorhanden)
					gebuchteLeistungen.get(getAktuellesZimmer()).add(
							new LeistungAnzahl(leistung, anzahl));
			} else {
				List<LeistungAnzahl> l = new Vector<LeistungAnzahl>();
				l.add(new LeistungAnzahl(leistung, anzahl));
				gebuchteLeistungen.put(getAktuellesZimmer(), l);
			}
		} else {
			throw new EmptyParameterException();
		}

	}

	public void removeLeistung(IALeistung leistung) throws FokusException,
			EmptyParameterException {
		if (leistung != null) {
			if (gebuchteLeistungen.containsKey(getAktuellesZimmer())) {
				for (LeistungAnzahl help : gebuchteLeistungen
						.get(getAktuellesZimmer())) {
					if (help.getLeistung().equals(leistung)) {
						gebuchteLeistungen.get(getAktuellesZimmer()).remove(
								help);
						break;
					}

				}
			} else {
				throw new FokusException();
			}
		} else {
			throw new EmptyParameterException();
		}
	}

	public HashMap<IAZimmer, List<LeistungAnzahl>> getGebuchteLeistungen() {
		return gebuchteLeistungen;
	}

	public void saveLeistungen() throws FokusException,
			WrongParameterException, DatabaseException, NotContainExeption {
		for (IAZimmer z : gebuchteLeistungen.keySet()) {

			for (LeistungAnzahl l : gebuchteLeistungen.get(z)) {

				IALeistung leistung = l.getLeistung();
				int anzahl = l.getAnzahl();
				IAAufenthalt aufenthalt = getAufenhaltbyZimmer(z);
				java.util.Date date = new java.util.Date();
				Date datum = new Date(date.getTime());

				modelAufenthaltLeistung.save(leistung, aufenthalt, anzahl,
						datum);
			}
		}
		needReload = true;
	}

	public IALeistung getLeistungByBezeichnung(String bez)
			throws DatabaseException, NotContainExeption {
		if (leistungen.size() < 1) {
			getArtikelundZusatzleistungen();
		}

		for (IALeistung leistung : leistungen) {
			if (leistung.getBezeichnung().equals(bez))
				return leistung;
		}

		throw new NotContainExeption();
	}

	private IAAufenthalt getAufenhaltbyZimmer(IAZimmer zimmer)
			throws FokusException, NotContainExeption {
		for (IAAufenthalt auf : aufenthalte) {

			if (auf.getAGast().equals(getGast())
					&& auf.getAZimmer().equals(zimmer))
				return auf;
		}

		throw new NotContainExeption();

	}

	public List<LeistungAnzahl> bereitsgebuchtLeistungenFuerGast()
			throws DatabaseException, FokusException {

		if (aufenthalte.size() < 1)
			getAufenthalt();

		List<LeistungAnzahl> erg = new Vector<LeistungAnzahl>();

		if (!needReload && bereitsgebuchteLeistungen.containsKey(getGast())) {
			erg.addAll(bereitsgebuchteLeistungen.get(getGast()));
		} else {
			for (IAAufenthalt auf : aufenthalte) {
				if (auf.getAGast().getID() == getGast().getID())
					erg.addAll(modelAufenthaltLeistung
							.getLeistungenByAufenhalt(auf));
			}
			bereitsgebuchteLeistungen.put(getGast(), erg);
		}

		return erg;

	}

	public void clearLists() {
		this.gebuchteLeistungen = new HashMap<IAZimmer, List<LeistungAnzahl>>();
	}

}
