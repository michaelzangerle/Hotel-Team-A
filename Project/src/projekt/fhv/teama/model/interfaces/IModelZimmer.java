package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;
import projekt.fhv.teama.model.exception.EmptyParameterException;
import projekt.fhv.teama.model.exception.FokusException;

public interface IModelZimmer {

	List<IZimmer> getVerfuegbareZimmerFürGegebeneKategorie(IKategorie ausgewählteKategorie, IReservierung iReservierung)throws DatabaseEntryNotFoundException, DatabaseException ;

	void save(IZimmer zimmer) throws DatabaseException, EmptyParameterException;

	List<IZimmer> getVerfügbareZimmer() throws DatabaseException;

	void setStatus(IZimmerstatus status) throws EmptyParameterException;

	void setAktullesZimmer(IZimmer zimmer) throws EmptyParameterException;

	IZimmer getAktullesZimmer() throws FokusException;
}
