package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IOption extends IDao {
	public void setProzentsatz(short prozentsatz);
	public short getProzentsatz();
	public void setErfuellung(boolean optionErf);
	public boolean getErfuellung();
	public void setReservierung(IReservierung res);
	public IReservierung getReservierung();
	public void setErfuelltAm(Date erfuellung);
	public Date getErfuelltAm();
}
