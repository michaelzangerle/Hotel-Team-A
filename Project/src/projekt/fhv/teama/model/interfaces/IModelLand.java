package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IModelLand {

	ILand getLandByKuerzel(String kuerzel) throws DatabaseException ;

}
