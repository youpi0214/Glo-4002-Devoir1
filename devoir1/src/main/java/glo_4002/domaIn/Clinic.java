package glo_4002.domaIn;

import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
	
	private Queue<String> medecinQueue;
	private Queue<String> radiologieQueue;
	
	public Clinic(/* ... */) {
		medecinQueue = new LinkedList<>();
		radiologieQueue = new LinkedList<>();
	}
	
	public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
		medecinQueue.add(name);
		if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
			radiologieQueue.add(name);
		}
	}
	
	public int getMedecinWaitingQueueSize() {
		return medecinQueue.size();
	}
	
	public int getRadiologieWaitingQueueSize() {
		return radiologieQueue.size();
	}
	
	public String getMedecinWaitingQueueNextPatient() {
		return medecinQueue.poll();
	}
}
