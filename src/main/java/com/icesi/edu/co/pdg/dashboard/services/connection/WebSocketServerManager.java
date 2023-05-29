package com.icesi.edu.co.pdg.dashboard.services.connection;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

@Service
class WebSocketServerManager {

    private final SimpMessagingTemplate template;
    public WebSocketServerManager(SimpMessagingTemplate template) {
        this.template = template;
    }
    
    public void sendMeasure(MeasurementDTO[] measures) {
    	this.template.convertAndSend("/topic/realtime",measures);
    }

}
