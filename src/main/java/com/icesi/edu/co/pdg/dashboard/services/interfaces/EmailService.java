package com.icesi.edu.co.pdg.dashboard.services.interfaces;



import java.io.IOException;
import java.util.List;

import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;

import jakarta.mail.MessagingException;

public interface EmailService {

	void sendEmail(List<String> email, TypeAlarm typeAlarm, List<Alarm> alarms) throws IOException, MessagingException;


}
