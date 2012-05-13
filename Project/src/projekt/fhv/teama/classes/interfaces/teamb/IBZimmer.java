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
public interface IBZimmer {
    
    List<IBRechnungsPosition> getBRechnungsPositionen();

    String getNumber();
}
