package br.ufrj.dcc;


public  abstract class EventAction {
	State state;
	EventList eventList;

	public EventAction(State state, EventList eventList) {
		// TODO Auto-generated constructor stub
		this.state=state;
		this.eventList=eventList;
	}
	public abstract void act();

}
