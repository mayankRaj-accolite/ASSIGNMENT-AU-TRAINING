package com.thread;
import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class TaxiStand {
	private int size = 5;
	private CopyOnWriteArrayList<Taxi> taxiStand;
	private LinkedList<Taxi> taxiQueue;
	private LinkedList<Passenger> passengerQueue;

	public TaxiStand(int capacity, LinkedList<Taxi> q, LinkedList<Passenger> pq) {
		size = capacity;
		taxiQueue = q;
		passengerQueue = pq;
		taxiStand = new CopyOnWriteArrayList<>();
		for (int i = 0; i < size; i++) {
			taxiStand.add(new Taxi());
		}
		System.out.println("---Creating a TaxiStand with capacity---" + size);
	}

	public boolean addTaxi(Taxi c) {
		if (taxiStand.size() < 5) {
			taxiStand.add(c);
			return true;
		}
		taxiQueue.add(c);
		return false;
	}

	public CopyOnWriteArrayList<Taxi> getTaxistand() {
		return this.taxiStand;
	}

	public LinkedList<Taxi> getTaxiQueue() {
		return this.taxiQueue;
	}

	public boolean isFull() {
		return (taxiStand.size() < size) ? false : true;
	}

	public boolean isEmpty() {
		return (taxiStand.size() == 0) ? true : false;
	}

	public boolean allocatePassengerTaxi(Passenger p) {
		boolean flag = false;
		Passenger p1 = passengerQueue.poll();
		ListIterator<Taxi> itr = taxiStand.listIterator();
		while (itr.hasNext()) {
			Taxi t = itr.next();
			if (t.isFull()) {
				System.out.println("==>Taxi to : " + t.getDestination() + "is leaving<==");
				taxiStand.remove(t);
				if (taxiQueue.size() > 0) {
					taxiStand.add(taxiQueue.removeFirst());
					break;
				}
			} else if ((p1 != null) && p1.getDestination() == t.getDestination()) {
				if (passengerQueue.size() > 0)
					passengerQueue.removeFirst();
				t.allocatePassenger(p1);
				flag = true;

				break;
			} else if (t.allocatePassenger(p)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void printStatus() {
		ListIterator<Taxi> standIterator = taxiStand.listIterator();
		int position = 0;
		while (standIterator.hasNext()) {
			Taxi taxi = standIterator.next();
			position++;
			System.out.println(
					position + ". Taxi to " + taxi.getDestination() + " passengers=" + taxi.getpassengerCount());
		}
	}
	public boolean getPassengerQueueIsEmpty() {
		if (passengerQueue.size() == 0)
			return true;
		return false;
	}

	public Passenger removePassenger() {
		return passengerQueue.removeFirst();
	}
	
	public void setTaxistand(CopyOnWriteArrayList<Taxi> updatedtaxiStand) {
		this.taxiStand = updatedtaxiStand;
	}
	
	public void setTaxiQueue(LinkedList<Taxi> updatedtaxiQueue) {
		this.taxiQueue = updatedtaxiQueue;
	}

	public static void main(String[] args) {
		System.out.println("...Starting simulaion...");
		LinkedList<Taxi> taxiQueue = new LinkedList<Taxi>();
		LinkedList<Passenger> passengerQueue = new LinkedList<Passenger>();
		TaxiStand lot = new TaxiStand(5, taxiQueue, passengerQueue);

		TaxiQueueRunnable taxicreator = new TaxiQueueRunnable(taxiQueue, lot);
		PassengerQueueRunnable passengerCreator = new PassengerQueueRunnable(passengerQueue, lot);
		Thread taxi_thread = new Thread(taxicreator);
		Thread passenger_thread = new Thread(passengerCreator);
		taxi_thread.start();
		passenger_thread.start();
	}
}