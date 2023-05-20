package com.icesi.edu.co.pdg.dashboard.websocket.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import icesi.plantapiloto.common.dtos.output.AssetDTO;

@Service
class WebSocketServerService {

    private final SimpMessagingTemplate template;
    public WebSocketServerService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 3000)
    public void enviarDatoAleatorio() {
    	
        this.template.convertAndSend("/topic/random", "");
    }

}
