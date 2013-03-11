package ca.etsmtl.gti525.commun.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerInterceptor implements MethodInterceptor
{
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("*************************");
		System.out.println("Method name 1 : " + methodInvocation.getMethod().getName());
		System.out.println("Method arguments 2 : " + Arrays.toString(methodInvocation.getArguments()));

		//same with MethodBeforeAdvice
		System.out.println("HijackAroundMethod 3 : Before method hijacked!");
		
		try{
			//proceed to original method call
			Object result = methodInvocation.proceed();
                        
                        System.out.println("*************************");
			//same with AfterReturningAdvice
			System.out.println("HijackAroundMethod 4 : Before after hijacked!");
                        System.out.println("*************************");
			return result;
		
		}catch(IllegalArgumentException e){
			//same with ThrowsAdvice
			System.out.println("HijackAroundMethod : Throw exception hijacked!");
			throw e;
		}
		
	}
	
}
