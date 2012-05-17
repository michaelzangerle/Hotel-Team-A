/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.service.integrate;

import java.util.List;

/**
 *
 * @author Johannes
 */
public interface IBGast {

    List<IBRechnungsPosition> getBRechnungsPositionen();

    String getFirstname();

    String getSurname();

    List<IBAdresse> getBAdressen();
    
}
