/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.fhv.teama.classes.interfaces.teamb;

import java.math.BigDecimal;

/**
 *
 * @author Johannes
 */
public interface IBTeilzahlung {

    IBZahlungsmethode getBZahlungsmethode();

    BigDecimal getBBetrag();
}
