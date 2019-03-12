package br.ufrj.dcc;

import java.util.Random;


public class ExponentialSampleGenerator {
	static{
		random = new Random();
	}
	static Random random;
	static double getSample(Double lambda){
		if (lambda!=0){
		return Math.log(1-random.nextDouble())/-lambda;
		}
		else
			return 0.0;
	}
}
