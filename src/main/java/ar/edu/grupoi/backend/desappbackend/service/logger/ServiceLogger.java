package ar.edu.grupoi.backend.desappbackend.service.logger;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(0)
public class ServiceLogger {
	
	private static Logger logger = Logger.getLogger(ServiceLogger.class);

	@Pointcut("within(ar.edu.grupoi.backend.desappbackend.webservice.*)")
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }



    /**
     * Advice que loguea cuando entra y sale .
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    	long start = System.currentTimeMillis();
	
		Object proceed = joinPoint.proceed();
		
		long executionTime = System.currentTimeMillis() - start;
	
        logger.info(
                "Class: "+ joinPoint.getThis() +
                ", Method: " + joinPoint.getSignature().getName() +
                ", Args: " + Arrays.toString(joinPoint.getArgs()) +
        		", Time: " + executionTime +"ms");
		
		return proceed;
    }

}
