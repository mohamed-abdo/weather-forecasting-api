package com.softideas.common.aspects.validation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Predicate;

@Aspect
@Component
public class ValidateAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAspect.class);

    @Pointcut(value = "execution(* *(..))")
    public void beforePoint() {
    }

    @Before(value = "beforePoint() && @annotation(validate)", argNames = "point,validate")
    public void execution(JoinPoint point, Validate validate) throws ValidatorException, IllegalAccessException, InstantiationException {
        LOGGER.info("Before executing annotation {}.", point.getStaticPart().toShortString());
        String[] paramNames = ((MethodSignature) point.getSignature()).getParameterNames();
        HashMap<String, Object> params = new HashMap<String, Object>();
        for (int i = 0; i < paramNames.length; i++) {
            params.put(paramNames[i], point.getArgs()[i]);
        }
        Object propertyValue = params.get(validate.parameterName());
        Predicate predicate = validate.test().newInstance();
        if (!predicate.test(propertyValue)) {
            LOGGER.error("Validate aspect catch invalid object.");
            throw new ValidatorException("INVALID_INPUT");
        }
    }

}
