package br.ufrj.dcc;

public class ArrivalEventAction extends EventAction{

	public ArrivalEventAction(State state, EventList eventList) {
		super(state, eventList);
		// TODO Auto-generated constructor stub
	}
	public void act(){
		//state.n++;

		eventList.enqueue(new ArrivalEvent(state.lambdaArrival,state.time,EventType.CHEGADA,new ArrivalEventAction(state,eventList)));
		//System.out.println("enqueue no cliente com tempo "+state.time);
		Client cl=new Client(state.time);
		state.clientList.enqueue(cl);
		
		if(state.clientList.size()==1 && state.priorityClientList.size()==0){
			cl.startJobTime = state.time;
			eventList.enqueue(new DepartureEvent(state.lambdaDeparture, state.time, EventType.SAIDA, new DepartureEventAction(state, eventList)));

		}

		
	}

}
