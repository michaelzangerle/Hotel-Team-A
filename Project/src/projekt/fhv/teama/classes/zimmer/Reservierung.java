package projekt.fhv.teama.classes.zimmer;

import java.sql.Timestamp;
import java.util.List;

import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.Person;
import projekt.fhv.teama.classes.personen.Vertragspartner;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Reservierung {
    private int ID;
    private Timestamp von;
    private Timestamp bis;
    private Person person;
    private Vertragspartner vertragspartner;
    
    private List<Option> optionen;
    private List<Zimmer> zimmer;
    private List<Kategorie> kategorie;
    private List<Gast> gast;
    
    

}
