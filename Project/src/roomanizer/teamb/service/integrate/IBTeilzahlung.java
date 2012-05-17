/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.service.integrate;

import java.math.BigDecimal;
import roomanizer.teamb.service.integrate.IBZahlungsmethode;

/**
 *
 * @author Johannes
 */
public interface IBTeilzahlung {

    IBZahlungsmethode getBZahlungsmethode();

    BigDecimal getBBetrag();
}
