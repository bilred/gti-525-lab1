/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.gti525.profiling;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Hadjout Dalil
 */
public class ElitProfilingInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ElitProfilingInterceptor.class.toString());

    @AroundInvoke
    public Object profil(InvocationContext invocation) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long endTime = System.currentTimeMillis() - startTime;
            LOGGER.log(Level.INFO, "\n=================== Profiling Begin===========================\n");
            LOGGER.log(Level.INFO, "La Methode " + invocation.getMethod().getName()
                    + " a pris " + endTime + " (ms)");

            System.out.println("\n=================== Profinling End ===========================\n");
        }
    }
}
