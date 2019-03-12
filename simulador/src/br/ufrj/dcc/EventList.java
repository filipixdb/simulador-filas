package br.ufrj.dcc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class EventList {

	TreeSet<Event> lista;

	public EventList(){
		lista = new TreeSet<Event>(new EventTimeComparator());
	}

	public void enqueue(Event e){
		lista.add(e);
	}

	public Event dequeue(){
		return lista.pollFirst();

	}
	class EventTimeComparator implements Comparator<Event>{

		@Override
		public int compare(Event o1, Event o2) {
			if (o1.getTime() < o2.getTime()){
				return -1;
			}else
				if (o2.getTime() < o1.getTime()){
					return 1;
				}
				else return 0;

		}

	}
	public Event popNextDeparture() {
		ArrayList<Event> listaTemp = new ArrayList<Event>();
		Event temp=lista.pollFirst();
		while(temp!=null){
			if (temp instanceof DepartureEvent){
				break;
			}
			listaTemp.add(temp);
			temp=lista.pollFirst();
		}
		lista.addAll(listaTemp);
		return temp;
	}
	// TODO Auto-generated method stub
}
