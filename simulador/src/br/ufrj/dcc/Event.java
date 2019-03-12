package br.ufrj.dcc;


public abstract class Event {
	double time=0.0;
	double lambda=0.0;
	EventType eventType;
	EventAction eventAction;

	
	
	public Event(double lambda,double time, EventType eventType, EventAction eventAction) {
		super();
		this.time = time ;
		this.lambda = lambda;
		this.eventType = eventType;
		this.eventAction = eventAction;
	}



	public Double getTime() {
		// TODO Auto-generated method stub
		return time;
	}
	public void act(){
		eventAction.act();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eventAction == null) ? 0 : eventAction.hashCode());
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(time);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eventAction == null) {
			if (other.eventAction != null)
				return false;
		} else if (!eventAction.equals(other.eventAction))
			return false;
		if (eventType != other.eventType)
			return false;
		if (Double.doubleToLongBits(time) != Double
				.doubleToLongBits(other.time))
			return false;
		return true;
	}
	
	//@Override
	abstract public String toString();
	
}
