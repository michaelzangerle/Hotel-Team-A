package projekt.fhv.teama.model.interfaces;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.model.exception.FokusException;

public interface IModelKategorie {

	IKategorie getKategorie() throws FokusException;

	void setKategorie(IKategorie kategorie);

}
