package com.verbio.module.dialogmanager.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.verbio.module.common.dto.IntentDTO;
import com.verbio.module.common.dto.TextOutputDTO;

/**
 * ModuleDirectRequestControllerProxy.
 *
 * @author Alejandro
 *
 */
@FeignClient(name = "module-direct-request")
@RibbonClient(name = "module-direct-request")
public interface ModuleDirectRequestControllerProxy {

    @PostMapping(path = "/intentRecognizer", consumes = "application/json", produces = "application/json")
    public TextOutputDTO findAnswer(@RequestBody final IntentDTO intent);
}
