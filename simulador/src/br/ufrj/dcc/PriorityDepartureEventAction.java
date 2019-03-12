package br.ufrj.dcc;

public class PriorityDepartureEventAction extends EventAction {

	public PriorityDepartureEventAction(State state, EventList eventList) {
		super(state, eventList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		//eventList.enqueue(new PriorityDepartureEvent(state.lambdaPriorityDeparture, state.time, EventType.SAIDA, new PriorityDepartureEventAction(state, eventList)));
		
		if(state.priorityClientList.size()>0){
			Client clienteAnt = state.priorityClientList.dequeue();
			clienteAnt.endJobTime=state.time;
			System.out.println(clienteAnt);
		//	state.n--;
			if(state.priorityClientList.size()>0){
				Client proxCliente= state.priorityClientList.dequeue();
				proxCliente.startJobTime = state.time;
				state.priorityClientList.enqueue(proxCliente);
				eventList.enqueue(new PriorityDepartureEvent(state.lambdaPriorityDeparture, state.time, EventType.SAIDA, new PriorityDepartureEventAction(state, eventList)));

			}
			else if(state.clientList.size()>0){
				Client cl = state.clientList.dequeue();
				cl.startJobTime = state.time;
				state.clientList.enqueue(cl);
				DepartureEvent deparEvent = new DepartureEvent(state.lambdaDeparture, state.time, EventType.SAIDA, new DepartureEventAction(state, eventList));
				
				if (cl.acumulatedJobTime>0.0){
				deparEvent.setTime(state.time + cl.remainingJobTime);
				}
				eventList.enqueue(deparEvent);
				//refazer a saida deleinacabado
				
			}
			else if(state.clientList.size()==0){
				DepartureEvent deparEvent = new DepartureEvent(state.lambdaDeparture, state.time, EventType.SAIDA, new DepartureEventAction(state, eventList));
				eventList.enqueue(deparEvent);

				
			}
		}
		
		
		
		//se tem outro prioritário na fila
		
			//se tem comum na fila
		
			//se não tem comum na fila
		//se não tem outro prioritário na fila
		
				//se tem comum na fila
				
				

		
		
		
		
		//lembrar que parei o comum
	}

}
