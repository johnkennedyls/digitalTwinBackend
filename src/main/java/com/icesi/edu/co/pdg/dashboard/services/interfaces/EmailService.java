package com.icesi.edu.co.pdg.dashboard.services.interfaces;



import java.io.IOException;

import java.util.List;

import javax.mail.MessagingException;

import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;


public interface EmailService {

	void sendEmail(List<String> emails, TypeAlarm typeAlarm, List<Alarm> alarms) throws IOException, MessagingException;


}
