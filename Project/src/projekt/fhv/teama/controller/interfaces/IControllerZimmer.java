package projekt.fhv.teama.controller.interfaces;

import java.util.List;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IControllerZimmer {

	List<IZimmer> getZimmerF�rGegebeneKategorie(IKategorie ausgew�hlteKategorie)throws NoDatabaseEntryFoundException ;

	void save(IZimmer zimmer);

}
