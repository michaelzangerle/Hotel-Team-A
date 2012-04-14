package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface ISaison {
	public void setBezeichnung(String Bezeichnung);
	public String getBezeichnung();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	public IZimmerpreis getZimmerpreis();
}
