/**
 * 
 */
package projekt.fhv.teama.view.support;

import java.math.BigDecimal;

import org.apache.pivot.wtk.validation.Validator;

/**
 *  
 *
 * @author Team A
 * @version 1.1
 */
public class CurrencyValidator implements Validator {
    public boolean isValid(String text) {
        boolean valid = true;

        if (text.length() > 0) {
            try {
                BigDecimal numericAmount = new BigDecimal(text);
                valid = (numericAmount.scale() <= 2
                    && numericAmount.signum() >= 0);
            } catch (NumberFormatException ex) {
                valid = false;
            }
        }

        return valid;
    }
}
