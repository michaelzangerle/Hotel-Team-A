package projekt.fhv.teama.hibernate.dao.tests;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IVertragspartnertyp;
import projekt.fhv.teama.classes.personen.Vertragspartnertyp;
import projekt.fhv.teama.hibernate.dao.personen.IVertragspartnertypDao;
import projekt.fhv.teama.hibernate.dao.personen.VertragspartnertypDao;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public class VertragspartnertypTest {
	public static void main (String[] args) throws NoDatabaseEntryFoundException {
		IVertragspartnertypDao vtypdao = VertragspartnertypDao.getInstance();
		
		IVertragspartnertyp typA = new Vertragspartnertyp("A Kunde");
		IVertragspartnertyp typB = new Vertragspartnertyp("B Kunde");
		IVertragspartnertyp typC = new Vertragspartnertyp("C Kunde");
		
		// Einfügen
		vtypdao.create(typA);
		vtypdao.create(typB);
		vtypdao.create(typC);
		
		// Alle holen
		//Set<IVertragspartnertyp> typen = vtypdao.getAll();
		//System.out.println(typen.toString());
		
		// 1 holen
		//IVertragspartnertyp typ = vtypdao.getById(1);
		//System.out.println(typ.toString());
		
		// update 
		//typ.setBezeichnung("A- Kunde");
		//vtypdao.update(typ);
		
		//spezial
		//vtypdao.remove(typ);
		
	}
}
