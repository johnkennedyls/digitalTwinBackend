package com.icesi.edu.co.pdg.dashboard.config;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;

import icesi.plantapiloto.common.controllers.AssetManagerControllerPrx;
import icesi.plantapiloto.common.controllers.ProcessManagerControllerPrx;
import icesi.plantapiloto.common.controllers.WorkSpaceManagerControllerPrx;

@Configuration
public class IceConfig {
	@Value("${ice.proxy}")
    private String proxy;
	private Communicator communicator;
	
	@Bean
    Communicator iceCommunicator() {
        this.communicator = Util.initialize();
        return this.communicator;
    }
	
	@Bean
	WorkSpaceManagerControllerPrx workSpaceManagerProxy(Communicator com) {
		return WorkSpaceManagerControllerPrx.checkedCast(com.stringToProxy("WorkSpaceManager:"+proxy));
	}
	
	@Bean
	AssetManagerControllerPrx assetManagerProxy(Communicator com) {
		return AssetManagerControllerPrx.checkedCast(com.stringToProxy("AssetManager:"+proxy));
	}
	
	@Bean
	ProcessManagerControllerPrx processManagerProxy(Communicator com) {
		return ProcessManagerControllerPrx.checkedCast(com.stringToProxy("ProcessManager:"+proxy));
	}
	
	@PreDestroy
    public void preDestroy() {
        if (this.communicator != null) {
            this.communicator.destroy();
        }
    }
}
