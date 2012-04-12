package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;


/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 09.04.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Option {
    private int optionId;
    private Date erfuellung;
    private short prozentsatz;
    private boolean erfuellt;
    private Reservierung reservierung;
    
    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public Date getErfuellung() {
        return erfuellung;
    }

    public void setErfuellung(Date erfuellung) {
        this.erfuellung = erfuellung;
    }

    public short getProzentsatz() {
        return prozentsatz;
    }

    public void setProzentsatz(short prozentsatz) {
        this.prozentsatz = prozentsatz;
    }

    public boolean getErfuellt() {
        return erfuellt;
    }

    public void setErfuellt(boolean erfuellt) {
        this.erfuellt = erfuellt;
    }

    public Reservierung getReservierung() {
		return reservierung;
	}

	public void setReservierung(Reservierung reservierung) {
		this.reservierung = reservierung;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (erfuellt != option.erfuellt) return false;
        if (optionId != option.optionId) return false;
        if (prozentsatz != option.prozentsatz) return false;
        if (erfuellung != null ? !erfuellung.equals(option.erfuellung) : option.erfuellung != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = optionId;
        result = 31 * result + (erfuellung != null ? erfuellung.hashCode() : 0);
        result = 31 * result + (int) prozentsatz;
        result = 31 * result + (erfuellt ? 1 : 0);
        return result;
    }
}
