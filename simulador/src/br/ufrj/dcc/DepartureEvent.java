package br.ufrj.dcc;

public class DepartureEvent extends Event{
	
	
	public DepartureEvent(double lambda,double time, EventType eventType,EventAction eventAction) {
		super(lambda,time, eventType, eventAction);
		double tmp=ExponentialSampleGenerator.getSample(lambda);
		this.time+=tmp;
		System.out.println(this);

		
		// TODO Auto-generated constructor stub
	}

	public void setTime(double proxOcorrencia) {
		this.time=proxOcorrencia;
	}
	
	public String toString() {
		String string;
		
		string = "Departure\n";
		string += "\tTime: " + time;
		
		return string;
	}

}
