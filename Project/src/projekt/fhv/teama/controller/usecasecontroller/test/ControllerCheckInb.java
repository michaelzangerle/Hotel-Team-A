package projekt.fhv.teama.controller.usecasecontroller.test;

import projekt.fhv.teama.controller.usecasecontroller.ControllerCheckIn;
import projekt.fhv.teama.controller.usecasecontroller.interfaces.IControllerCheckIn;
import projekt.fhv.teama.model.ModelAdresse;
import projekt.fhv.teama.model.ModelAufenthalt;
import projekt.fhv.teama.model.ModelGast;
import projekt.fhv.teama.model.ModelKategorie;
import projekt.fhv.teama.model.ModelKontodaten;
import projekt.fhv.teama.model.ModelLand;
import projekt.fhv.teama.model.ModelPfandTyp;
import projekt.fhv.teama.model.ModelReservierung;
import projekt.fhv.teama.model.ModelStatusentwicklung;
import projekt.fhv.teama.model.ModelTeilreservierung;
import projekt.fhv.teama.model.ModelZimmer;
import projekt.fhv.teama.model.ModelZimmerstatus;
import projekt.fhv.teama.model.interfaces.IModelAdresse;
import projekt.fhv.teama.model.interfaces.IModelAufenthalt;
import projekt.fhv.teama.model.interfaces.IModelGast;
import projekt.fhv.teama.model.interfaces.IModelKategorie;
import projekt.fhv.teama.model.interfaces.IModelKontodaten;
import projekt.fhv.teama.model.interfaces.IModelLand;
import projekt.fhv.teama.model.interfaces.IModelPfandTyp;
import projekt.fhv.teama.model.interfaces.IModelReservierung;
import projekt.fhv.teama.model.interfaces.IModelStatusentwicklung;
import projekt.fhv.teama.model.interfaces.IModelTeilreservierung;
import projekt.fhv.teama.model.interfaces.IModelZimmer;
import projekt.fhv.teama.model.interfaces.IModelZimmerstatus;

public class ControllerCheckInb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IModelReservierung cres = new ModelReservierung();
		IModelAufenthalt cauf = new ModelAufenthalt();
		IModelGast cgast = new ModelGast();
		IModelTeilreservierung ctres = new ModelTeilreservierung();
		IModelKategorie ckat = new ModelKategorie();
		IModelKontodaten ckonto = new ModelKontodaten();
		IModelPfandTyp cpfandTyp = new ModelPfandTyp();
		IModelZimmer czimmer = new ModelZimmer();
		IModelZimmerstatus czimmerStatus = new ModelZimmerstatus();
		IModelAdresse cadr = new ModelAdresse();
		IModelLand cland =new ModelLand();
		IModelStatusentwicklung sentw=new ModelStatusentwicklung();

		IControllerCheckIn controllerCheckIn = new ControllerCheckIn(cres, cauf, cgast, ctres, ckat, ckonto, cpfandTyp,
				czimmer, czimmerStatus, cadr,cland,sentw);
//		
//		try {
//		List<IReservierung> reservierungscheckIn = controllerCheckIn.getCheckInReservierungen();
//		for (IReservierung iReservierung : reservierungscheckIn) {
//			System.out.println(iReservierung);
//		}
//		
//	} catch (Exception e) {
//		
//	}
		

	}

}
