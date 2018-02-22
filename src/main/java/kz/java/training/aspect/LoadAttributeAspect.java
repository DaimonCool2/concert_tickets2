package kz.java.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@Aspect
public class LoadAttributeAspect {

	@Around("@annotation(kz.java.training.aspect.annotation.LoadAttribute) && args(modelMap)")
	public Object returnDefaultPage(ProceedingJoinPoint joinPoint, ModelMap modelMap) {
		Object output = null;
		if (modelMap.get("id") != null) {
			try {
				output = joinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return output;
	}

}
