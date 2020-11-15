package com.verbio.module.dialogmanager.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.verbio.module.common.dto.IntentDTO;
import com.verbio.module.common.dto.TextInputDTO;

/**
 * ModuleUserControllerProxy.
 *
 * @author Alejandro
 *
 */
@FeignClient(name = "module-nlu")
@RibbonClient(name = "module-nlu")
public interface ModuleNLUControllerProxy {

    @PostMapping(path = "/intentRecognizer", consumes = "application/json", produces = "application/json")
    public IntentDTO intentRecognizer(@RequestBody final TextInputDTO textInputDTO);
}
