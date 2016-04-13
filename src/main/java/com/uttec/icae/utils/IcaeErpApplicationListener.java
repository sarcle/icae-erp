package com.uttec.icae.utils;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.uttec.icae.model.ConfigIcae;
import com.uttec.icae.service.configicae.ConfigIcaeService;

@Component
public class IcaeErpApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

//	private static final Logger logger = Logger.getLogger(IcaeErpApplicationListener.class);
	
	@Autowired
	private ConfigIcaeService configPortalService;
	
	@Autowired
	private ServletContext context;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		logger.debug("onApplicationEvent..");
		ConfigIcae configPortal = new ConfigIcae(1);
		configPortal = configPortalService.findOne(configPortal);
		if (configPortal != null) {
//			logger.debug("La configuracion existe");
			context.setAttribute("logoUrl", configPortal.getLogoUrl());
			context.setAttribute("appTitle", configPortal.getAppTitle());
		}
	}
}
