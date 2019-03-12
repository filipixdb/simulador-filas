package br.ufrj.dcc;

public class ArrivalEvent extends Event {

	public ArrivalEvent(double lambda, double time, EventType eventType,
			EventAction eventAction) {
		super(lambda, time, eventType, eventAction);
		// TODO Auto-generated constructor stub
		double tmp=ExponentialSampleGenerator.getSample(lambda);
		this.time+=tmp;
		
		System.out.println(this);
	}

	public String toString() {
		String string;
		
		string = "Arrival\n";
		string += "\tTime: " + time;
		
		return string;
	}
}
