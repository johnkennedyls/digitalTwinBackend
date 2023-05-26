package com.icesi.edu.co.pdg.dashboard.services.connection;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import icesi.plantapiloto.common.dtos.MeasurementDTO;

@Service
class WebSocketServerService {

    private final SimpMessagingTemplate template;
    public WebSocketServerService(SimpMessagingTemplate template) {
        this.template = template;
    }
    
    public void sendMeasure(MeasurementDTO measure) {
    	this.template.convertAndSend("/topic/realtime",measure);
    }

}
