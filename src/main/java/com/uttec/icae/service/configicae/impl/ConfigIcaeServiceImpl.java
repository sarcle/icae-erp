package com.uttec.icae.service.configicae.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uttec.icae.dao.configicae.ConfigIcaeRepository;
import com.uttec.icae.model.ConfigIcae;
import com.uttec.icae.service.configicae.ConfigIcaeService;

@Service("configIcaeService")
public class ConfigIcaeServiceImpl implements ConfigIcaeService {
	
//	private static final Logger logger = LoggerFactory.getLogger(ConfigIcaeServiceImpl.class);
	
	@Autowired
	private ConfigIcaeRepository configPortalRepository;
	
	@Value("${app.title}")
	private String appTitle;
	
	@Transactional(readOnly = true)
	@Override
	public ConfigIcae getNewOrExistingConfig() {
		ConfigIcae configPortal = configPortalRepository.findOne(1);
		if (configPortal == null) {
			configPortal = new ConfigIcae();
			configPortal.setAppTitle(appTitle);
		}
		return configPortal;
	}
	
	@Transactional
	@Override
	public void save(ConfigIcae configPortal) {
		if (configPortal.getId() != null) {
			configPortalRepository.saveAndFlush(configPortal);
		} else {
			configPortalRepository.save(configPortal);
		}
		if (configPortal.getAppTitle() == null || configPortal.getAppTitle().isEmpty()) {
			configPortal.setAppTitle(appTitle);
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public ConfigIcae findOne(ConfigIcae configPortal) {
		configPortal = configPortalRepository.findOne(configPortal.getId());
		if (configPortal != null && (configPortal.getAppTitle() == null || configPortal.getAppTitle().isEmpty())) {
			configPortal.setAppTitle(appTitle);
		}
		return configPortal;
	}
}
