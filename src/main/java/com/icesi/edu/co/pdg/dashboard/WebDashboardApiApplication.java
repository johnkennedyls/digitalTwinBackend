package com.icesi.edu.co.pdg.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagValueDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.StateAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.TypeAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.springexpression.Context;


@SpringBootApplication
public class WebDashboardApiApplication  {

	
	 @Autowired
	    private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(WebDashboardApiApplication.class, args);
		System.out.println("Inicia pdg");
	}

	@Bean
	public CommandLineRunner runner(TypeAlarmRepository re,StateAlarmRepository st,PlantRepository pa) {
		return (args) -> {

		
			 Context context = applicationContext.getBean(Context.class);
			 
			 StateAlarm activa = new StateAlarm();
			 activa.setStateAlarmName("Activa");

			 StateAlarm enRevision = new StateAlarm();
			 enRevision.setStateAlarmName("En Revision");
			 enRevision.setStateAlarm(activa);

			 StateAlarm cerrado = new StateAlarm();
			 cerrado.setStateAlarmName("Cerrado");
			 cerrado.setStateAlarm(enRevision);
			 
			 st.save(activa);
			 st.save(enRevision);
			 st.save(cerrado);
			 
			 Plant plant = new Plant();
			 plant.setPlantName("PB12");
			 Plant pa1=pa.save(plant);

		        // Crear una lista de TagValueDTO de ejemplo
		        List<TagValueDTO> tagValues = new ArrayList<>();
		        
		        // Crear un objeto TypeAlarm
		        TypeAlarm typeAlarm = new TypeAlarm();
		        typeAlarm.setCondition("h2o > 1.0");
		        typeAlarm.setTypeAlarmDescription("Alarma para valores mayores a 1.0");
		        typeAlarm.setTypeAlarmName("Alarma de valores altos");
		        typeAlarm.setNumberAlarmsMax(1);
		        typeAlarm.setPlant(pa1);
		        re.save(typeAlarm);

		        TagValueDTO tagValue1 = new TagValueDTO();
		        tagValue1.setAssetName("h2o");
		        tagValue1.setValue(2.0);
		        tagValues.add(tagValue1);

		        TagValueDTO tagValue2 = new TagValueDTO();
		        tagValue2.setAssetName("h2o");
		        tagValue2.setValue(1.5);
		        tagValues.add(tagValue2);
		        
		        // Llamar al método updateTagValues del bean Context con la lista de TagValueDTO
		        context.updateTagValues(tagValues);

		        // Obtener las alarmas disparadas
		        List<AlarmDTO> triggeredAlarms = context.checkAlarms();

		        // Imprimir las alarmas disparadas
		        System.out.println("Alarmas disparadas:");
		        for (AlarmDTO alarm : triggeredAlarms) {
		            System.out.println(alarm.getTypeAlarm().getCondition());
		        }
			
			
	
			
			
		};

	}

}
