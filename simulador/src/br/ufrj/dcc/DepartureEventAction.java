package br.ufrj.dcc;

public class DepartureEventAction extends EventAction {

	public DepartureEventAction(State state, EventList eventList) {
		super(state, eventList);
		
		// TODO Auto-generated constructor stub
	}
	public void act(){
		if(state.clientList.size()>0){

			//state.n--;
			Client cl = state.clientList.dequeue();
			cl.endJobTime = state.time;
			
			if( state.clientList.size()>0){
				eventList.enqueue(new DepartureEvent(state.lambdaDeparture,state.time,EventType.SAIDA,new DepartureEventAction(state,eventList)));

				Client client = state.clientList.dequeue();
				client.startJobTime = state.time;
				state.clientList.enqueue(client);
				
			}
			 System.out.println(cl);
			
		}
		
		
	}

}
