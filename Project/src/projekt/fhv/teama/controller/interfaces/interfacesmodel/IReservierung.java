package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface IReservierung {
	public void addKategorie(IKategorie kat);
	public void removeKategorie(IKategorie kat);
	public IKategorie getKategorie();
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	public void setPerson(IPerson person);
	public IPerson getPerson();
	public void addGast(IGast gast);
	public void removeGast(IGast gast);
	public IGast getGast();
	public void addOption(IOption option);
	public void removeOption(IOption option);
	public IOption getOption();
	public void setVertragspartner(IVertragspartner partner);
	public IVertragspartner getVertragspartner();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
}
