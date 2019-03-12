package br.ufrj.dcc;

import java.util.Comparator;
import java.util.TreeSet;

public class ClientList {
	TreeSet<Client> clientList;
	
	ClientList(){
		clientList = new TreeSet<Client>(new ClientTimeComparator());
		
	}
	public int size(){
		return clientList.size();
	}

	public void enqueue(Client e){
		clientList.add(e);
	}

	public Client dequeue(){
		return clientList.pollFirst();

	}
	public Client dequeueLast(){
		return clientList.pollLast();
	}
	

	class ClientTimeComparator implements Comparator<Client>{

		@Override
		public int compare(Client o1, Client o2) {
			if (o1.getTime() < o2.getTime()){
				return -1;
			}else
				if (o2.getTime() < o1.getTime()){
					return 1;
				}
				else return 0;

		}

	}
}
