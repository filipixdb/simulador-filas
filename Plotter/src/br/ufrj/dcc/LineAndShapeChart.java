package br.ufrj.dcc;

import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;


public class LineAndShapeChart extends JFrame {

	private static final long serialVersionUID = 1L;

	public LineAndShapeChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);

		
		// This will create the dataset 
        XYDataset dataset = createDataset();

        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart, false);
        
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        
        // mouse zoomable
        chartPanel.setMouseZoomable(true, false);
        
        // add it to our application
        setContentPane(chartPanel);
        
    }
    
    

    private  XYDataset createDataset() {
    	XYSeries s1 = new XYSeries("Simulacao 1");
        s1.add(1, 10);
        s1.add(200000000, 20);
        s1.add(300000000, 30);
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
    }
    
    
    private JFreeChart createChart(XYDataset dataset, String title) {
        

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            title,  // title
            "Time",             // x-axis label
            "P(X < x)",   // y-axis label
            dataset,            // data
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        
        return chart;
    }
    
    
}