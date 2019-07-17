package wyhlearn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import wyhlearn.annotation.TestAnnotation;

@Aspect
@Component
public class TestAspect {
    //    private Logger logger = Logger.getLogger(LogMessageId.MONITORING);
    @Pointcut(value = "execution(@wyhlearn.annotation.TestAnnotation "
            + "!static * *(..)) && "
            + "@annotation(annotation)",
            argNames = "annotation")
    private void instanceMethodWithAnnotation(TestAnnotation annotation) {
    }

    @Around(value = "instanceMethodWithAnnotation(annotation)", argNames = "joinPoint, annotation")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, TestAnnotation annotation) throws Throwable {
        try {
            System.out.println("before call ------------");
            System.out.println(joinPoint.getSourceLocation().getWithinType().getSimpleName());
            Signature signature = (CodeSignature) joinPoint.getSignature();
            Class[] types = ((CodeSignature) signature).getParameterTypes();
            String[] names = ((CodeSignature) signature).getParameterNames();
            Object[] values = joinPoint.getArgs();

            System.out.println("name: " + signature.getName());

            for (int i = 0; i < types.length; i++) {
                System.out.println(i + "type:" + types[i] + ", name:" + names[i] + ", value:" + values[i]);
            }

            joinPoint.proceed();
            System.out.println("end call ------------");
        } catch (Exception e) {
            //todo logger.error(Logger.SYSLOG_MARKER, ErrorCode.IPFIX_CONFIG_APPLIEDTO_IN_USE.getId(),
            //todo "Input AppliedTos {} are used by other IpfixConfigs.", displayNames);
            //todo throw new IpfixException(ErrorCode.IPFIX_CONFIG_APPLIEDTO_IN_USE, displayNames);
//            return e;
        }
        return null;
    }
}
