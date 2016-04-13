package com.uttec.icae.service.configicae;

import com.uttec.icae.model.ConfigIcae;


public interface ConfigIcaeService {

	ConfigIcae getNewOrExistingConfig();

	void save(ConfigIcae configPortal);

	ConfigIcae findOne(ConfigIcae configPortal);

}
