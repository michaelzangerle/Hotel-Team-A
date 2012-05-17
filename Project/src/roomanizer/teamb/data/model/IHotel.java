/**
 * 
 */
package roomanizer.teamb.data.model;

import roomanizer.teamb.service.integrate.IBHotel;

/**
 * Beschreibt 
 * @author Team A
 * @version 1.2
 */
public interface IHotel extends IBHotel {

	public abstract String getBic();

	public abstract void setBic(String bic);

	public abstract String getBlz();

	public abstract void setBlz(String blz);

	public abstract String getChef();

	public abstract void setChef(String chef);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract String getFbn();

	public abstract void setFbn(String fbn);

	public abstract String getFaxnummer();

	public abstract void setFaxnummer(String fnr);

	public abstract String getIban();

	public abstract void setIban(String iban);

	public abstract Integer getId();

	public abstract void setId(Integer id);

	public abstract String getKontonummer();

	public abstract void setKontonummer(String knr);

	public abstract String getLand();

	public abstract void setLand(String land);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getOrt();

	public abstract void setOrt(String ort);

	public abstract String getPlz();

	public abstract void setPlz(String plz);

	public abstract String getStrasse();

	public abstract void setStrasse(String strasse);

	public abstract String getTelefonummer();

	public abstract void setTelefonnummer(String tnr);

	public abstract String getUid();

	public abstract void setUid(String uid);

	public abstract String getKnr();

	public abstract void setKnr(String knr);

	public abstract String getRechnungen();

	public abstract void setRechnungen(String rechnungen);

}