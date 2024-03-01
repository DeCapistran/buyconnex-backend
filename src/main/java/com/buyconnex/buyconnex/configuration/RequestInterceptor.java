package com.buyconnex.buyconnex.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private LocaleResolver localeResolver;

    /*Logique à exécuter avant le traitement de la requête par les controleurs*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        localeResolver.setLocale(request, response, request.getLocale());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        //Logique à exécuter après le traitement de la requête par les controleurs avant la génération de la vue
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Logique à exécuter après la génération de la vue.
    }
}
