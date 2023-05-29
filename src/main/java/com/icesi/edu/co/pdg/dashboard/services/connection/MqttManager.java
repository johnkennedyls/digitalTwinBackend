package com.icesi.edu.co.pdg.dashboard.services.connection;

import org.eclipse.paho.client.mqttv3.IMqttClient;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icesi.edu.co.pdg.dashboard.services.springexpression.Context;

import icesi.plantapiloto.common.controllers.ProcessManagerControllerPrx;
import icesi.plantapiloto.common.dtos.ExecutionDTO;
import icesi.plantapiloto.common.dtos.MeasurementDTO;
import icesi.plantapiloto.common.dtos.ProcessDTO;

@Service
public class MqttManager implements CommandLineRunner  {
	
	@Autowired
	ProcessManagerControllerPrx processManager;
	@Autowired
	WebSocketServerManager webSocket;
	@Value("${mqtt.server.uri}")
    private String mqttServerUri;
	@Value("${webdasboard.workspace.id}")
    private Integer workspaceId;
	@Autowired
	 private ApplicationContext applicationContext;
	
	private IMqttClient client;
	private final ObjectMapper objectMapper;
	
	public MqttManager() {
		this.objectMapper = new ObjectMapper();
	}
	
	@Override
	public void run(String... args) throws Exception {
		ProcessDTO[] processes = processManager.findProcessByWorkSpace(workspaceId);
		System.out.println("Starting");
		for(ProcessDTO currentProcess : processes) {
			System.out.println("1");
			ExecutionDTO[] executions = processManager.findExecutions(currentProcess.id, 0, 123123, true);
			for(ExecutionDTO execution: executions) {
				System.out.println("2");
				subscribeToMqtt(execution.id+"");
			}
		}
	}
	
	public void connectToMqtt() throws Exception {
		if(client.isConnected()) {
			return;
		}
		MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);

        client = new MqttClient(mqttServerUri, MqttClient.generateClientId());
        client.connect(options);
    }
	
	public void subscribeToMqtt(String mqttTopic) throws Exception {
		if(!client.isConnected()) {
			connectToMqtt();
		}
		client.subscribe(mqttTopic, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            MeasurementDTO measure = objectMapper.readValue(payload, MeasurementDTO.class);
            Context context = applicationContext.getBean(Context.class);
            context.checkAlarms(measure);
            
            System.out.println("MQTT: "+measure.value);
            webSocket.sendMeasure(measure);
        });
	}
	
	public void unsubscribeOfMqtt(String mqttTopic) throws MqttException {
		if(!client.isConnected()) {
			return;
		}
		client.unsubscribe(mqttTopic);
	}
	
	public void closeConnection() throws MqttException {
		if(!client.isConnected()) {
			return;
		}
		client.close();
	}
}
