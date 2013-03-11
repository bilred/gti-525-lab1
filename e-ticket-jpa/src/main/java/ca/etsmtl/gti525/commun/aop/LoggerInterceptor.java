package ca.etsmtl.gti525.commun.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = Logger.getLogger(LoggerInterceptor.class.toString());

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        System.out.println("************Debut du Log*************");
        LOGGER.log(Level.INFO, "Before: {0}", methodInvocation.getMethod().getName());
        
        Object[] params = methodInvocation.getArguments();
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                LOGGER.log(Level.INFO, "\n\tparamètre numéro " + i + " = " + params[i], methodInvocation.getMethod().getName());
            }
        }

        try { //proceed to original method call
            Object result = methodInvocation.proceed();  
            return result; //same with AfterReturningAdvice

        } catch (IllegalArgumentException ex) { //same with ThrowsAdvice
            LOGGER.log(Level.SEVERE, "Execption s'est produit Encours d'execution", methodInvocation.getMethod().getName() + "----" + ex.getMessage());
            throw ex;
        } finally {
            LOGGER.log(Level.INFO, "After:  {0}", methodInvocation.getMethod().getName());
//            System.out.println("**********Fin du Log***************");
        }
    }
}
