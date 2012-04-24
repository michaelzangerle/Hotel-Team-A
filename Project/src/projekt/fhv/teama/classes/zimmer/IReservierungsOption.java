package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IReservierungsOption extends IModel {
	
	public void setProzentsatz(short prozentsatz);

	public short getProzentsatz();

	public void setErfuellung(Date erfuellung);

	public Date getErfuellung();

	public void setReservierung(IReservierung reservierung);

	public IReservierung getReservierung();

	public void setErfuellt(boolean erfuellt);

	public boolean getErfuellt();
	
}
