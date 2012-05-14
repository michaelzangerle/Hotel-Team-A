/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.fhv.teama.classes.interfaces.teamb;

import java.util.List;

/**
 *
 * @author Johannes
 */
public interface IBReservierung {

    List<IBGast> getBGaeste();

    List<IBZimmer> getBZimmer();

    //Set<IBRechnungsPosition> getBRechnungsPositionen();
}
