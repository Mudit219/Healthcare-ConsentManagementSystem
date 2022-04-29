package com.springboot.ConsentManagement.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

@Configuration
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if(auth==null || targetDomainObject == null || !(permission instanceof String))
            return false;
        System.out.println(auth.getName());
        System.out.println(targetDomainObject.toString());
        System.out.println(permission.toString());
        return true;
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        if(auth==null || targetId == null || !(permission instanceof String))
            return false;
        System.out.println(auth.getName());
        System.out.println(targetId.toString());
        System.out.println(permission.toString());
        return true;
    }
}
