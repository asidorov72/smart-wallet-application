package app.config;

import app.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(ApplicationException ex) {
        log.error("ApplicationException occurred: {}", ex.getMessage(), ex);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        modelAndView.addObject("errorTitle", ex.getErrorTitle());
        modelAndView.addObject("errorCode", ex.getErrorCode());

        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericException(Exception ex) {
        log.error("ApplicationException occurred: {}", ex.getMessage(), ex);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "Unexpected error occurred. Please try again later.");
        modelAndView.addObject("errorTitle", "Internal Server Error");
        modelAndView.addObject("errorCode", "500");

        return modelAndView;
    }
}
