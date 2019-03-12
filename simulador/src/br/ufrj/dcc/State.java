package br.ufrj.dcc;

public class State {

	//int n=0;
	double time;
	double lambdaArrival;
	double lambdaDeparture;
	
	ClientList clientList;
	PriorityClientList priorityClientList;
	public double lambdaPriorityArrival;
	public double lambdaPriorityDeparture;
	
	State(){
	//	this.n=0;
		time=0.0;
		clientList = new ClientList();
		priorityClientList = new PriorityClientList();
	}
	
}
