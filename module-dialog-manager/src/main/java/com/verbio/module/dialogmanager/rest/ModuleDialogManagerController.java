package com.verbio.module.dialogmanager.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verbio.module.common.constants.IntentCode;
import com.verbio.module.common.dto.IntentDTO;
import com.verbio.module.common.dto.TextInputDTO;
import com.verbio.module.common.dto.TextOutputDTO;
import com.verbio.module.dialogmanager.proxy.ModuleDirectRequestControllerProxy;
import com.verbio.module.dialogmanager.proxy.ModuleNLUControllerProxy;

/**
 * ModuleProductController.
 *
 * @author Alejandro
 *
 */
@RestController
public class ModuleDialogManagerController {

    private static final Logger LOG = Logger.getLogger(ModuleDialogManagerController.class.getName());

    @Autowired
    private ModuleNLUControllerProxy moduleNLUControllerProxy;

    @Autowired
    private ModuleDirectRequestControllerProxy moduleDirectRequestControllerProxy;

    @PostMapping(path = "/answer", consumes = "application/json", produces = "application/json")
    public TextOutputDTO answer(@RequestBody final TextInputDTO textInputDTO) {

        final IntentDTO intent = moduleNLUControllerProxy.intentRecognizer(textInputDTO);

        LOG.info(intent.getIntentCode());

        if (IntentCode.NAME.name().equals(intent.getIntentCode())) {
            return moduleDirectRequestControllerProxy.findAnswer(intent);
        }

        // If the intent is IntentCode.UNKNOWN direct request will answer also
        return moduleDirectRequestControllerProxy.findAnswer(intent);
    }

}
