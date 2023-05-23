package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.icesi.edu.co.pdg.dashboard.model.entity.Alarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.EmailService;



@Service
public class EmailServiceImp implements EmailService{
	
	@Autowired
	private final JavaMailSender mailSender;

	public EmailServiceImp(JavaMailSender mailSender) {
        this.mailSender = mailSender;
}
	
	@Override
	public void sendEmail(List<String> emails, TypeAlarm typeAlarm,List<Alarm> alarms) throws IOException, MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
		
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("classpath:/EmailTemplate.html");
		String htmlContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
		StringBuilder htmlBuilder = new StringBuilder(htmlContent);
		
		int index = htmlBuilder.indexOf("%PLANT_NAME%");
		if (index != -1) {
		  htmlBuilder.replace(index, index + "%PLANT_NAME%".length(), typeAlarm.getPlant().getPlantName());
		}
		index = htmlBuilder.indexOf("%NUM%");
		if (index != -1) {
		  htmlBuilder.replace(index, index + "%NUM%".length(), Integer.toString(typeAlarm.getNumberAlarmsMax()));
		}
		index = htmlBuilder.indexOf("%TYPE_ALARM_NAME%");
		if (index != -1) {
		  htmlBuilder.replace(index, index + "%TYPE_ALARM_NAME%".length(), typeAlarm.getTypeAlarmName());
		}
		index = htmlBuilder.indexOf("%CONDITION%");
		if (index != -1) {
		  htmlBuilder.replace(index, index + "%CONDITION%".length(), typeAlarm.getCondition());
		}
		index = htmlBuilder.indexOf("%ALARMS_TABLE%");
		if (index != -1) {
		  String alarmsTable = "";
		  for (Alarm alarm : alarms) {
		    alarmsTable += String.format("<tr><td>%.1f</td><td>%s</td></tr>", alarm.getTagValue(), alarm.getActivationDate().toString());
		  }
		  htmlBuilder.replace(index, index + "%ALARMS_TABLE%".length(), alarmsTable);
		}
		for(String email:emails) {
			mimeHelper.setText(htmlBuilder.toString(), true);
			mimeHelper.setTo(email);
			mimeHelper.setSubject("Notificación en Planta "+typeAlarm.getPlant().getPlantName() );

			mailSender.send(mimeMessage);
		}
		
	}


}
