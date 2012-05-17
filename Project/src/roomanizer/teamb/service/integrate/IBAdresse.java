/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roomanizer.teamb.service.integrate;

/**
 *
 * @author Michael
 */
public interface IBAdresse {

    String getStrasse();

    String getPlz();

    String getOrt();

    IBLand getBLand();
}
