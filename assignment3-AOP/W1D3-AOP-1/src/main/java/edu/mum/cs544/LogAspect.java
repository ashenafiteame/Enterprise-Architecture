package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {
//    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
//    public void logAfter(JoinPoint joinpoint) {
//        System.out.println((new SimpleDateFormat("EEE, d MMM HH:mm:ss yyyy z").format(new Date())) + " method= " + joinpoint.getTarget());
//
//    }

    @Around("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("exception happend" + e);
        }
        System.out.println((new SimpleDateFormat("EEE, d MMM HH:mm:ss yyyy z").format(new Date())) + " method= " + proceedingJoinPoint.getTarget() + " address= " + args[0] + " message= " + args[1]);
        return args;
    }


    @AfterReturning(pointcut = "execution(* edu.mum.cs544.EmailSender.getOutgoingMailServer(..))", returning = "ret")
    public void logAfter(String ret) {
        System.out.println("outgoing mail server  = " + ret);
    }

    @Around("execution(* edu.mum.cs544.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("Time to Execute save = " + totalTime +"ms");
        return retVal;
    }
}
