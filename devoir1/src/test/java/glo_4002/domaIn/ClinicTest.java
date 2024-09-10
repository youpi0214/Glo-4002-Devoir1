package glo_4002.domaIn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClinicTest {
	
	@Test
	void givenPatient_whenArrivingToClinic_thenShouldBeAddedToMedecinWaitingQueue(){
	 String NomPatient = "John Doe";
	 VisibleSymptom visibleSymptom = VisibleSymptom.MIGRAINE;
	 Clinic clinic = new Clinic();
		
	 clinic.triagePatient(NomPatient, 1, visibleSymptom);
	 
	 Assertions.assertEquals(1, clinic.getMedecinWaitingQueueSize());
	}

	@Test
	void givenPatient_whenMedecinContainingPatients_thenShouldBeTheLastOneOnWaitingQueue(){
		String patientDejaPresent = "Alex";
		String nouveauPatient = "John Doe";
		VisibleSymptom visibleSymptom = VisibleSymptom.FLU;
		Clinic clinic = new Clinic();
		
		clinic.triagePatient(patientDejaPresent, 1, visibleSymptom);
		clinic.triagePatient(nouveauPatient, 1, visibleSymptom);
		String firstPatient = clinic.getMedecinWaitingQueueNextPatient();
		String secondPatient = clinic.getMedecinWaitingQueueNextPatient();
		
		
		Assertions.assertEquals(patientDejaPresent, firstPatient);
		Assertions.assertEquals(nouveauPatient, secondPatient);
	}
	
	@Test
	void givenPatientThatDoesntRequireRadiologie_whenArrivingToClinic_thenShouldNotBeAddedRadiologieWaitingQueue(){
		String nomPatient1 = "John Doe";
		String nomPatient2 = "Alex";
		VisibleSymptom visibleSymptom1 = VisibleSymptom.FLU;
		VisibleSymptom visibleSymptom2 = VisibleSymptom.MIGRAINE;
		Clinic clinic = new Clinic();
		
		clinic.triagePatient(nomPatient1, 1, visibleSymptom1);
		clinic.triagePatient(nomPatient2, 1, visibleSymptom2);
		
		Assertions.assertEquals(0, clinic.getRadiologieWaitingQueueSize());
	}
	
	@Test
	void givenPatientThatRequiredRadiologie_whenArrivingToClinic_thenShouldBeAddedRadiologieWaitingQueue(){
		String nomPatient1 = "John Doe";
		String nomPatient2 = "Alex";
		VisibleSymptom visibleSymptom1 = VisibleSymptom.BROKEN_BONE;
		VisibleSymptom visibleSymptom2 = VisibleSymptom.SPRAIN;
		Clinic clinic = new Clinic();
		
		clinic.triagePatient(nomPatient1, 1, visibleSymptom1);
		clinic.triagePatient(nomPatient2, 1, visibleSymptom2);
		
		Assertions.assertEquals(2, clinic.getRadiologieWaitingQueueSize());
	}

}