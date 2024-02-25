package hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        System.out.println("START: " + proceedingJoinPoint.toString());
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            Long end = System.currentTimeMillis();
            Long timeMs = end - start;
            System.out.println("END: " + proceedingJoinPoint.toString() + " " + timeMs + "ms");

        }

    }
}
