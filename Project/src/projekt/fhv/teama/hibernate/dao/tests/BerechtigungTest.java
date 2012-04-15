package projekt.fhv.teama.hibernate.dao.tests;



import java.util.Set;

import projekt.fhv.teama.classes.personen.Berechtigung;
import projekt.fhv.teama.classes.personen.Mitarbeiter;
import projekt.fhv.teama.hibernate.dao.personen.BerechtigungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public class BerechtigungTest {
	
	public static void main(String[] args) throws DatabaseException{
		Berechtigung b = new Berechtigung("Checkin","ci", "Berechtigung um einen check-in vorgang abzuschliessen. wer haette dass gedacht");
		BerechtigungDao bd = new BerechtigungDao();
		//bd.create(b);
		b = bd.getById(4);
		System.out.print(b.toString());
		b=bd.getBerechtigungByBezeichnung("checkin");
		System.out.print(b.toString());
		
		Set<Mitarbeiter> berechtigteMitarbeiter = b.getBerechtigte();
		for (Mitarbeiter ma : berechtigteMitarbeiter) {
			System.out.println(ma.toString());
		}
	}
}
