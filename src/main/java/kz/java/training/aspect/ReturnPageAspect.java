package kz.java.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@Aspect
public class ReturnPageAspect {

	@Around("@annotation(kz.java.training.aspect.annotation.ReturnDefaultPageIfIdNull) && args(modelMap,..)")
	public ModelAndView returnDefaultPage(ProceedingJoinPoint joinPoint, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("error");
		if (modelMap.get("id") == null) {
			modelAndView.setViewName("redirect:/");
		} else {
			try {
				modelAndView = (ModelAndView) joinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return modelAndView;
	}

}
