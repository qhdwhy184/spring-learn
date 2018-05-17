package wyhlearn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpmAdapterAspect {
//    private Logger logger = Logger.getLogger(LogMessageId.MONITORING);

    @Around("@annotation(UpmExceptionAdapter)")
    public void logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            System.out.println("before call ------------");
            joinPoint.proceed();
            System.out.println("end call ------------");
        } catch (Exception e) {
                //todo logger.error(Logger.SYSLOG_MARKER, ErrorCode.IPFIX_CONFIG_APPLIEDTO_IN_USE.getId(),
                //todo "Input AppliedTos {} are used by other IpfixConfigs.", displayNames);
                //todo throw new IpfixException(ErrorCode.IPFIX_CONFIG_APPLIEDTO_IN_USE, displayNames);
//            return e;
        }
    }
}
