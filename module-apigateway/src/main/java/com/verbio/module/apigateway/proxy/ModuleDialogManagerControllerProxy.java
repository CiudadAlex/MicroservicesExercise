package com.verbio.module.apigateway.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.verbio.module.common.dto.TextInputDTO;
import com.verbio.module.common.dto.TextOutputDTO;

/**
 * ModuleUserControllerProxy.
 *
 * @author Alejandro
 *
 */
@FeignClient(name = "module-dialog-manager")
@RibbonClient(name = "module-dialog-manager")
public interface ModuleDialogManagerControllerProxy {

    @PostMapping(path = "/answer", consumes = "application/json", produces = "application/json")
    public TextOutputDTO answer(@RequestBody final TextInputDTO textInputDTO);
}
