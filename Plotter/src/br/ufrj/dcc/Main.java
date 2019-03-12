package br.ufrj.dcc;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LineAndShapeChart queueChart = new LineAndShapeChart("Queue Simulation Plot", "CDF");
		queueChart.pack();
		queueChart.setVisible(true);
	}

}
