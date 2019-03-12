package br.ufrj.dcc;

public class PriorityArrivalEventAction extends EventAction {

	public PriorityArrivalEventAction(State state, EventList eventList) {
		super(state, eventList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		//state.n++;

		eventList.enqueue(new PriorityArrivalEvent(state.lambdaPriorityArrival,state.time,EventType.CHEGADA,new PriorityArrivalEventAction(state,eventList)));
		
		Client cl = new Client(state.time);
		state.priorityClientList.enqueue(cl);
		if(state.priorityClientList.size()==1){
			cl.startJobTime = state.time;
			eventList.enqueue(new PriorityDepartureEvent(state.lambdaPriorityDeparture, state.time, EventType.CHEGADA, new PriorityDepartureEventAction(state, eventList)));
		}
		
		Event saidaDoComunQueSeraRefeita = eventList.popNextDeparture();
		//implementar pausa no que está em serviço
		//tinha um outro em serviço
		
		//verificar que tem um comum, e que não existe um prioritário em atendimento que já fez isso
		if(state.clientList.size()>0 && state.priorityClientList.size()==1){
			Client clientComun = state.clientList.dequeue();
			clientComun.acumulatedJobTime+= (state.time-clientComun.startJobTime);
			
			clientComun.remainingJobTime = saidaDoComunQueSeraRefeita.time -state.time;
			state.clientList.enqueue(clientComun);
			//eventList.enqueue(saidaDoComunQueSeraRefeita.time)
			
			//sortearemos um novo sample de exp para o trabalho resultante
			//lembrar de setar o startjobtime pro tempo atual quando for resumido
					
			
		}
		//se existe um prioritário sendo atendido que já fez isso
		
		//se existe um prioritário e não tem nenhum comum
		//não faz nada
		
		//se não existe prioriário e não existe comum
	}

}
