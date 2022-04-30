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
        System.out.println(auth.getAuthorities().contains(permission.toString()));
        if(permission.equals("profile_doctor:read")) {
            if (auth.getAuthorities().contains(permission.toString()) && (auth.getName() == targetDomainObject.toString()))
                return true;
        }
        if(permission.equals("authorities:read"))
            return true;
        return false;
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
