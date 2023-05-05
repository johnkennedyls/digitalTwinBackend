package com.icesi.edu.co.pdg.dashboard.websocket.service;

import java.util.Random;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class WebSocketServerService {

    private final SimpMessagingTemplate template;
    private final Random random = new Random();

    public WebSocketServerService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 1000)
    public void enviarDatoAleatorio() {
        int datoAleatorio = random.nextInt(100);
        System.out.println("VALOR "+datoAleatorio);
        this.template.convertAndSend("/topic/random", datoAleatorio);
    }

}
