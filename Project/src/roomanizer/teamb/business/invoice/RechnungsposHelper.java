/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.business.invoice;

import java.math.BigDecimal;

/**
 *
 * @author Michael
 */
public class RechnungsposHelper {
    
    private int anzahl;
    private String bezeichnung;
    private BigDecimal einzelpreis;
    private String zimmer;
    private short ust_satz;

    public RechnungsposHelper(int anzahl, String bezeichnung, BigDecimal einzelpreis, String zimmer, short ust_satz) {
        this.anzahl = anzahl;
        this.bezeichnung = bezeichnung;
        this.einzelpreis = einzelpreis;
        this.zimmer = zimmer;
        this.ust_satz = ust_satz;
    }
    
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public BigDecimal getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(BigDecimal einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    public String getZimmer() {
        return zimmer;
    }

    public void setZimmer(String zimmer) {
        this.zimmer = zimmer;
    }
    
    public int getAnzahl() {
        return this.anzahl;
    }
    
    public void increaseAnzahl(int anzahl) {
        this.anzahl += anzahl;
    }
    
    public void decreaseAnzahl(int anzahl) {
        this.anzahl -= anzahl;
    }

    public short getUst_satz() {
        return ust_satz;
    }

    public void setUst_satz(short ust_satz) {
        this.ust_satz = ust_satz;
    }
    
    
    
}
