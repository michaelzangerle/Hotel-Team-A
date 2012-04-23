package projekt.fhv.teama.model.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IModelZimmer {

	List<IZimmer> getVerfuegbareZimmerF�rGegebeneKategorie(IKategorie ausgew�hlteKategorie)throws DatabaseEntryNotFoundException ;

	void save(IZimmer zimmer);

	List<IZimmer> getVerf�gbareZimmer();

}
