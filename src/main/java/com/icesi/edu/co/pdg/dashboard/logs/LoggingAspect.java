package com.icesi.edu.co.pdg.dashboard.logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.LogDashboardService;

@Aspect
@Component
public class LoggingAspect {
	
	@Autowired
	LogDashboardService logDashboardService;
	
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.TypeAlarmServiceImp.addTypeAlarm(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.TypeAlarmServiceImp.editTypeAlarm(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.TypeAlarmServiceImp.deleteTypeAlarm(..))")
	public void typeAlarmOperations() {}
	
	@AfterReturning("typeAlarmOperations()")
	public void afterSuccessfulTypeAlarmOperations(JoinPoint joinPoint) throws Exception {
		String description="";
	    String methodName = joinPoint.getSignature().getName();
	    if(methodName.equals("editTypeAlarm")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se editó la el tipo de alarma con id: " + args[0] + "\n"
	        + "Cuerpo: " + args[1];
	    }else if(methodName.equals("addTypeAlarm")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se creó el tipo de alarma con cuerpo: " + args[0] ;
	    }else {
	    	Object[] args = joinPoint.getArgs();
		    description = "Se eliminó el tipo de alarma con id: " + args[0] ;
	    }
	    logDashboardService.save("INFO", description);
	    
	}
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.PlantServiceImp.addPlant(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.PlantServiceImp.editPlant(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.PlantServiceImp.deletePlant(..))")
	public void plantOperations() {}
	
	@AfterReturning("plantOperations()")
	public void afterSuccessfulPlantOperations(JoinPoint joinPoint) throws Exception {
		String description="";
	    String methodName = joinPoint.getSignature().getName();
	    if(methodName.equals("editPlant")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se editó la planta con id: " + args[0] + "\n"
	        + "Cuerpo: " + args[1];
	    }else if(methodName.equals("addPlant")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se creó la planta con cuerpo: " + args[0] ;
	    }else {
	    	Object[] args = joinPoint.getArgs();
		    description = "Se eliminó la planta con id: " + args[0] ;
	    }
	    logDashboardService.save("INFO", description);
	    
	}
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.ProcessServiceImp.addProcess(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.ProcessServiceImp.startExecution(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.ProcessServiceImp.pauseExecution(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.ProcessServiceImp.continueExecution(..)) || "
			+ "execution(* com.icesi.edu.co.pdg.dashboard.services.imp.ProcessServiceImp.stopExecution(..))")
	public void processOperations() {}
	
	@AfterReturning("processOperations()")
	public void afterSuccessfulProccessOperations(JoinPoint joinPoint) throws Exception {
		String description="";
	    String methodName = joinPoint.getSignature().getName();
	    if(methodName.equals("addProcess")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se creo el proceso con id: " + args[0];
	    }else if(methodName.equals("startExecution")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se inició el proceso con id: " + args[0] ;
	    }else if(methodName.equals("pauseExecution")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se pauso el proceso con id: " + args[0] ;
	    }else if(methodName.equals("continueExecution")) {
	    	Object[] args = joinPoint.getArgs();
	    	description = "Se reanudo el proceso con id: " + args[0] ;
	    }else {
	    	Object[] args = joinPoint.getArgs();
		    description = "Se detuvo el proceso con id: " + args[0] ;
	    }
	    logDashboardService.save("INFO", description);
	    
	}
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.PlantServiceImp.addPlant(..))")
	public void alarmOperation() {}
	
	@AfterReturning("alarmOperation()")
	public void afterSuccessfulAlarmOperation(JoinPoint joinPoint) throws Exception {
		String description="";
	    Object[] args = joinPoint.getArgs();
	    description = "Se activarón las siguientes alarmas: " + args[0] ;
	    logDashboardService.save("WARN", description);
	    
	}
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.ActionHistoryServiceImp.addActionHistory(..))")
	public void actionHistoryOperation() {}
	
	@AfterReturning("actionHistoryOperation()")
	public void afterSuccessfulactionHistoryOperation(JoinPoint joinPoint) throws Exception {
		String description="";
	    Object[] args = joinPoint.getArgs();
	    description = "Se agregó el siguiente comentario: " + args[0] +" a la alarma con id: " + args[1];
	    logDashboardService.save("INFO", description);
	    
	}
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.EmailServiceImp.sendEmail(..))")
	public void sendEmailOperation() {}
	
	@AfterReturning("sendEmailOperation()")
	public void afterSuccessfulsendEmailOperation(JoinPoint joinPoint) throws Exception {
		String description="";
	    Object[] args = joinPoint.getArgs();
	    description = "Se envió un correo a : " + args[0] ;
	    logDashboardService.save("INFO", description);
	    
	}
	
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.EmailServiceImp.sendEmail(..))")
	public void stateAlarmOperation() {}
	
	@AfterReturning("stateAlarmOperation()")
	public void afterSuccessfulstateAlarmOperation(JoinPoint joinPoint) throws Exception {
		String description="";
	    Object[] args = joinPoint.getArgs();
	    description = "Se cambió el estado de la alarma con id  " + args[1]+ "a : " + args[0] ;
	    logDashboardService.save("INFO", description);
	    
	}
	
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard.services.imp.AssignedUserServiceImp.addAssignedUser(..))")
	public void userAsignedOperation() {}
	
	@AfterReturning("userAsignedOperation()")
	public void afterSuccessfuluserAsignedOperation(JoinPoint joinPoint) throws Exception {
		String description="";
	    Object[] args = joinPoint.getArgs();
	    description = "Se agregarón los usuarios : " + args[0]+ "al tipo de alarma con id " + args[1] ;
	    logDashboardService.save("INFO", description);
	    
	}
	
	@Pointcut("execution(* com.icesi.edu.co.pdg.dashboard..*.*(..)) && !execution(* com.icesi.edu.co.pdg.dashboard.logs.LoggingAspect.*(..)) && !execution(* com.icesi.edu.co.pdg.dashboard.services.imp.LogDashboardServiceImp.*(..))")
	public void allDashboardOperations() {}

	@AfterThrowing(pointcut = "allDashboardOperations()", throwing = "ex")
	public void afterExceptionInDashboardOperations(JoinPoint joinPoint, Exception ex) throws Exception {
		  logDashboardService.save("ERROR", ex.toString());
	}
}
