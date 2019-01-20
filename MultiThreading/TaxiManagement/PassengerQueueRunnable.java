package com.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PassengerQueueRunnable implements Runnable {
	TaxiStand lot;
	LinkedList<Passenger> passengerQueue;
	int queueNumber = 0;

	public PassengerQueueRunnable(LinkedList<Passenger> queue, TaxiStand l) {
		passengerQueue = queue;
		lot = l;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {

			}
			CopyOnWriteArrayList<Taxi> taxiStand = lot.getTaxistand();
			LinkedList<Taxi> taxiQueue = lot.getTaxiQueue();

			ListIterator<Taxi> itr = taxiStand.listIterator();
			while (itr.hasNext()) {
				Taxi t = itr.next();
				if (t.getTaxiSize() > 0) {
					t.updateTime();
					if (t.getTime() >= 45) {
						System.out.println("Taxi to:" + t.getDestination() + "is leaving due to timeout");
						taxiStand.remove(t);
						if (taxiQueue.size() > 0)
							taxiStand.add(taxiQueue.removeFirst());
					}
				}
			}
			lot.setTaxiQueue(taxiQueue);
			lot.setTaxistand(taxiStand);
			int pick = new Random().nextInt(Passenger.DESTINATION.values().length);
			Passenger p = new Passenger(Passenger.DESTINATION_VALUES[pick]);
			System.out.println("New passenger with destination " + p.getDestination() + " arrives at stand.");

			if (!lot.allocatePassengerTaxi(p)) {
				System.out.println("Presently No cab found for current passenger. Adding Passenger to Queue..");
				passengerQueue.add(p);
				System.out.println("Passeneger successfully added to queue...");
			}
		}
	}
}

