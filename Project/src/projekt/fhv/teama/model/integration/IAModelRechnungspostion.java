package projekt.fhv.teama.model.integration;

import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.integrate.IAGast;

public interface IAModelRechnungspostion {

	boolean sindNochPostionenoffen(IAGast gast) throws DatabaseException ;

}
