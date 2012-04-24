package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.NotContainExeption;

public interface IModelLand {

	ILand getLandByKuerzel(String kuerzel) throws DatabaseException, EmptyParameterException, NotContainExeption ;

}
