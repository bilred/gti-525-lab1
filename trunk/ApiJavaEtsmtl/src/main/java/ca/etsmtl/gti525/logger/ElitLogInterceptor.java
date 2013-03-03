/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.gti525.logger;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Hadjout Dalil
 */
public class ElitLogInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ElitLogInterceptor.class.toString());

    @AroundInvoke
    public Object log(InvocationContext ic) {
        try {
            LOGGER.log(Level.INFO, "Before: {0}", ic.getMethod().getName());
            Object[] params = ic.getParameters();
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    LOGGER.log(Level.INFO, "\n\tparamètre numéro " + i + " = " + params[i], ic.getMethod().getName());
                }

            }
            return ic.proceed();


        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Execption s'est produit Encours d'execution", ic.getMethod().getName() + "----" + ex.getMessage());
            return null;

        } finally {
            LOGGER.log(Level.INFO, "After:  {0}", ic.getMethod().getName());
        }
    }
}
