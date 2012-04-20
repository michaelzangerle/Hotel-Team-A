/**
 * 
 */
package projekt.fhv.teama.hibernate.dao.tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.pivot.collections.LinkedList;

import projekt.fhv.teama.classes.leistungen.IZusatzleistung;
import projekt.fhv.teama.hibernate.dao.leistungen.ArtikelDao;
import projekt.fhv.teama.hibernate.dao.leistungen.IArtikelDao;
import projekt.fhv.teama.hibernate.dao.leistungen.IWarengruppeDao;
import projekt.fhv.teama.hibernate.dao.leistungen.IZusatzleistungDao;
import projekt.fhv.teama.hibernate.dao.leistungen.WarengruppeDao;
import projekt.fhv.teama.hibernate.dao.leistungen.ZusatzleistungDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

/**
 * @author mike
 *
 */
public class LeistungTest {

	/**
	 * @param args
	 * @throws DatabaseException 
	 */
	public static void main(String[] args) throws DatabaseException {
		
		IArtikelDao adao = ArtikelDao.getInstance();
		IZusatzleistungDao zDao = ZusatzleistungDao.getInstance();
		IWarengruppeDao wdao = WarengruppeDao.getInstance();
		short i1 = 20;
		short i2 = 10;
		
//		IWarengruppe w1 = new Warengruppe("Bier", i1, "Verschiedene Biersorten aus der Region", null, null);
//		IWarengruppe w2 = new Warengruppe("Wein", i1, "Verschiedene Weinsorten aus der Region", null, null);
//		IWarengruppe w3 = new Warengruppe("Magazine", i1, "Verschiedene Magazine für Klein und Groß", null, null);
//		IWarengruppe w4 = new Warengruppe("Snacks", i1, "Verschiedene Snacks", null, null);
//		IWarengruppe w5 = new Warengruppe("Handtücher", i1, "Handbestickte Handtücher", null, null);
//		
//		
//		wdao.create(w1);
//		wdao.create(w2);
//		wdao.create(w3);
//		wdao.create(w4);
//		wdao.create(w5);
		
//		Set<IWarengruppe> waren = new HashSet<IWarengruppe>(wdao.getAll());
//		for (IWarengruppe w : waren) {
//			System.out.println(w);
//		}
		
//		System.out.println(wdao.getById(1));
		
//		wdao.remove(wdao.getById(1));
//		wdao.remove(wdao.getById(2));
//		IWarengruppe w1 = wdao.getById(9);
//		w1.setBeschreibung("Beschreibung der handgefertigten Waren");
//		w1.setBezeichnung("Handgefertigte Waren");
//		wdao.create(w1);
		
//		IArtikel a2 = new Artikel(75.5F, "Handtuch", "Handgefertigtes Handtuch", wdao.getById(9));
//		IArtikel a1 = new Artikel(75.5F, "Badetuch", "Handgefertigtes Badetuch", wdao.getById(9));
//		adao.create(a2);
//		adao.create(a1);
		
//		adao.remove(adao.getById(24));
		wdao.remove(wdao.getById(2));
		
//		System.out.println(adao.getArtikel("Kellerbier"));
		
//		wdao.create(new Warengruppe("Wellness", i2, "Wellness-Angebote", null, null));
		
//		IZusatzleistung z1 = new Zusatzleistung(86F, "Massage", "Massageangebote von IWellness", true, wdao.getById(10), null);
//		IZusatzleistung z2 = new Zusatzleistung(26F, "Gesichtsmaske", "Massageangebote von IWellness", true, wdao.getById(10), null);
//		IZusatzleistung z3 = new Zusatzleistung(36F, "Schlammbad", "Massageangebote von IWellness", true, wdao.getById(10), null);
		
		
//		IZusatzleistung z2 = zDao.getById(27);
//		IZusatzleistung z3 = zDao.getById(28);
//		
//		z2.setBeschreibung("Gesichtsmaske von IWellness");
//		z3.setBeschreibung("Schlammbad von IWellness");
		
//		zDao.create(z1);
//		zDao.create(z2);
//		zDao.create(z3);
		
//		Set<IZusatzleistung> zusatzleistungen = zDao.getAll();
//		
//		for (IZusatzleistung z : zusatzleistungen) {
//			System.out.println(z);
//		}
		
//		System.out.println(zDao.getById(28));
//		System.out.println(zDao.getZusatzleistung("Schlammbad"));
		
	}

}
