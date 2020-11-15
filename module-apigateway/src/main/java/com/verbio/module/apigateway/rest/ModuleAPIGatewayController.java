package com.verbio.module.apigateway.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verbio.module.apigateway.proxy.ModuleDialogManagerControllerProxy;
import com.verbio.module.apigateway.proxy.ModuleUserControllerProxy;
import com.verbio.module.common.dto.LoginStatusDTO;
import com.verbio.module.common.dto.TextInputDTO;
import com.verbio.module.common.dto.TextOutputDTO;

/**
 * ModuleProductController.
 *
 * @author Alejandro
 *
 */
@RestController
public class ModuleAPIGatewayController {

    private static final Logger LOG = Logger.getLogger(ModuleAPIGatewayController.class.getName());

    @Autowired
    private ModuleUserControllerProxy moduleUserControllerProxy;

    @Autowired
    private ModuleDialogManagerControllerProxy moduleDialogManagerControllerProxy;

    @CrossOrigin
    @PostMapping(path = "/answerWithAuth", consumes = "application/json", produces = "application/json")
    public TextOutputDTO answerWithAuth(@RequestBody final TextInputDTO textInputDTO) {

        final String userName = textInputDTO.getUserName();
        final String password = textInputDTO.getPassword();

        final LoginStatusDTO loginStatusDTO = moduleUserControllerProxy.login(userName, password);

        if (!loginStatusDTO.getSucess()) {
            return new TextOutputDTO("Authentication failed");
        }

        final TextOutputDTO textOutputDTO = moduleDialogManagerControllerProxy.answer(textInputDTO);

        LOG.info(textOutputDTO.getTextOutput());

        return textOutputDTO;
    }

}
