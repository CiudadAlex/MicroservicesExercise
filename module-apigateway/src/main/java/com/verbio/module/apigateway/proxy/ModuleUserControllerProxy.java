package com.verbio.module.apigateway.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.verbio.module.common.dto.LoginStatusDTO;

/**
 * ModuleUserControllerProxy.
 *
 * @author Alejandro
 *
 */
@FeignClient(name = "module-user")
@RibbonClient(name = "module-user")
public interface ModuleUserControllerProxy {

    @GetMapping("/login/{login}/{password}")
    public LoginStatusDTO login(@PathVariable("login") final String login, @PathVariable("password") final String password);
}
