package com.thread;

import java.util.*;
public class TaxiQueueRunnable implements Runnable {

	private LinkedList<Taxi> taxiQueue;
	private TaxiStand taxiStand;

	public TaxiQueueRunnable(LinkedList<Taxi> q, TaxiStand l) {
		taxiQueue = q;
		taxiStand = l;
	}

	@Override
	public void run() {
		System.out.println("Starting taxiQueue Thread...");
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException ie) {
				System.out.println("Unable to create");
			}
			Taxi t = new Taxi();
			if (taxiStand.addTaxi(t)) {
				System.out.println("Taxi added");
			} else {
				System.out.println("Adding Taxi to the queue");
			}

		}
	}
}
