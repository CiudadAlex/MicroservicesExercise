package com.verbio.module.directrequest.engine;

import org.springframework.web.bind.annotation.RequestBody;

import com.verbio.module.common.dto.IntentDTO;

/**
 * DirectRequestAnswerer.
 *
 * @author Alejandro
 *
 */
public interface DirectRequestAnswerer {

    public String findAnswer(@RequestBody final IntentDTO intent);
}
