package com.example.springbeanscopes;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopesController {

    public static final Logger LOG = LoggerFactory.getLogger(ScopesController.class);

    @Resource(name = "personSingleton")
    Person personSingleton;

    @Resource(name = "personPrototype")
    Person personPrototype;

    @Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    HelloMessageGenerator sessionScopedBean;

    @Resource(name = "applicationScopedBean")
    HelloMessageGenerator applicationScopedBean;

    @RequestMapping("/scopes/singleton")
    public String getSingletonScopeMessage() {
        LOG.info("Предыдущее имя: " + personSingleton.getName());
        personSingleton.setName("Имя для Singleton Person");
        LOG.info("Текущее имя: " + personSingleton.getName());
        return "Singleton";
    }

    @RequestMapping("/scopes/prototype")
    public String getPrototypeScopeMessage() {
        LOG.info("New prototype");
        Person prototypePerson = personPrototype;  // Получаем новый экземпляр прототипа
        prototypePerson.setName("Prototype Person Name");

        LOG.info("Current Name: " + prototypePerson.getName());
        return "Prototype";
    }

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage() {
        LOG.info("Previous Message: " + requestScopedBean.getMessage());
        requestScopedBean.setMessage("Request Scope Message");
        LOG.info("Current Message: " + requestScopedBean.getMessage());
        return "Request Scope";
    }

    @RequestMapping("/scopes/session")
    public String getSessionScopeMessage() {
        LOG.info("Previous Message: " + sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Session Scope Message");
        LOG.info("Current Message: " + sessionScopedBean.getMessage());
        return "Session Scope";
    }

    @RequestMapping("/scopes/application")
    public String getApplicationScopeMessage() {
        LOG.info("Previous Message: " + applicationScopedBean.getMessage());
        applicationScopedBean.setMessage("Application Scope Message");
        LOG.info("Current Message: " + applicationScopedBean.getMessage());
        return "Application Scope";
    }
}
