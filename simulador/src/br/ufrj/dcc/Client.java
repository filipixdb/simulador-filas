package br.ufrj.dcc;

import javax.print.attribute.standard.Finishings;

public class Client {
	static private int nextId=0;
	double arrivalTime;
	int id;
	
	public double startJobTime=0.0;;
	public double endJobTime=0.0;;
	public double acumulatedJobTime=0.0;
	public double remainingJobTime=0.0;;

	public double getTime() {
		// TODO Auto-generated method stub
		return this.arrivalTime;
	}
	Client(double time){
		id = nextId ;
		nextId++;
		this.arrivalTime =time ;
		
	}
	public String toString(){
		return "O cliente de id "+id+" que chegou primeiramente em "+arrivalTime+" foi atendido por último em "+startJobTime+" e terminou em "+endJobTime+" tendo total de serviço igual a "+(endJobTime-startJobTime+acumulatedJobTime)+".";
		
	}

}
