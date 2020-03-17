package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @Around on method: " + method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw e;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        logger.info("=====>>> Duration: " + duration / 1000D + " seconds");
        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        logger.info("Executing @AfterThrowing on method: " + method);
        logger.info("The exception is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @AfterReturning on method: " + method);
        logger.info("=====>>>Result is: " + result);
        convertAccountNamesToUpperCase(result);
        logger.info("=====>>>Uppercase result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account acc : result) {
            String upperName = acc.getName().toUpperCase();
            acc.setName(upperName);
        }
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        logger.info("Executing before addAccount");
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        logger.info("Method: " + methodSignature);
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            logger.info(tempArg.toString());
            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;
                logger.info("Account name: " + account.getName());
                logger.info("Account level: " + account.getLevel());
            }
        }
    }
}