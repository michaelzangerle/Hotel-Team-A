package projekt.fhv.teama.controller.interfaces;

import projekt.fhv.teama.classes.personen.IGast;

public interface IControllerGast {

	void setAktuellGast(IGast gast);

	IGast getAktuellGast();

	void setVorname(String vorname);

	void setNachname(String nachname);

}
