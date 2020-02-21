package com.gerardnico.desmo.EventExample;

import desmoj.core.simulator.*;
import java.util.concurrent.TimeUnit;
/**
 * This class represents an entity (and event) source, which continually generates
 * trucks (and their arrival events) in order to keep the simulation running.
 *
 * It will create a new truck, schedule its arrival at the terminal (i.e. create
 * and schedule an arrival event) and then schedule itself for the point in
 * time when the next truck arrival is due.
 * @author Olaf Neidhardt, Ruth Meyer
 */
public class TruckGeneratorEvent extends ExternalEvent {

	/**
	 * Constructs a new TruckGeneratorEvent.
	 *
	 * @param owner the model this event belongs to
	 * @param name this event's name
	 * @param showInTrace flag to indicate if this event shall produce output for the trace
	 */
	public TruckGeneratorEvent(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
	}
	/**
	 * The eventRoutine() describes the generating of a new truck.
	 *
	 * It creates a new truck, a new TruckArrivalEvent
	 * and schedules itself again for the next new truck generation.
	 */
	public void eventRoutine() {

		// get a reference to the model
		EventsExample model = (EventsExample)getModel();

		// create a new truck
		Truck truck = new Truck(model, "Truck", true);
		// create a new truck arrival event
		TruckArrivalEvent truckArrival = new TruckArrivalEvent(model, "TruckArrivalEvent", true);
		// and schedule it for the current point in time
		truckArrival.schedule(truck, new TimeSpan(0.0));

		// schedule this truck generator again for the next truck arrival time
		schedule(new TimeSpan(model.getTruckArrivalTime(), TimeUnit.MINUTES));
		// from inside to outside...
		// draw a new inter-arrival time value
		// wrap it in a TimeSpan object
		// and schedule this event for the current point in time + the inter-arrival time

	}
}
