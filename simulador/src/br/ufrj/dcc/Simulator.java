/**
 *
 */
package br.ufrj.dcc;

import java.io.IOException;


public class Simulator {

	State state;
	EventList eventList;
//	EventList prioritaria;
//    Double lambda=1.2;
	//Double tempoEventoInicial;
	public Simulator(){
		eventList = new EventList();
		state= new State();
		state.lambdaArrival=3;
		state.lambdaDeparture=5;
		state.lambdaPriorityArrival=2;
		state.lambdaPriorityDeparture=5;

	}

	public void go() {


		eventList.enqueue(new ArrivalEvent(state.lambdaArrival,state.time,EventType.CHEGADA,new ArrivalEventAction(state,eventList)));

		//eventList.enqueue(new DepartureEvent(state.lambdaDeparture,state.time, EventType.SAIDA, new DepartureEventAction(state,eventList)));

		eventList.enqueue(new PriorityArrivalEvent(state.lambdaPriorityArrival,state.time,EventType.CHEGADA,new PriorityArrivalEventAction(state,eventList)));

		//eventList.enqueue(new PriorityDepartureEvent(state.lambdaPriorityDeparture,state.time,EventType.SAIDA,new PriorityDepartureEventAction(state,eventList)));

		while(true){
			Event event=eventList.dequeue();
			state.time=event.getTime();
			event.act();
			//System.out.println(state.n +" ");
			System.out.println("Evento saiu\n" + "\tTime: " + event.time + "\n\n");
			System.out.println("\tLength:" + (state.priorityClientList.size() + state.clientList.size()) + "\n");
//		proxOcorrencia
//			try {
//				System.in.read();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//


		}

	}





}
