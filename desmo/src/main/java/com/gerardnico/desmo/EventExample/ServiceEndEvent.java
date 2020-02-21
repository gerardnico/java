package com.gerardnico.desmo.EventExample;

import desmoj.core.simulator.*;
import java.util.concurrent.TimeUnit;
/**
 * This class represents the service end event
 * in the EventsExample model.
 * It occurs when a van carrier finishes loading a truck.
 * @author Olaf Neidhardt, Ruth Meyer
 */
public class ServiceEndEvent extends EventOf2Entities<VanCarrier,Truck> {

	/**
	 * A reference to the model this event is a part of.
	 * Useful shortcut to access the model's static components
	 */
	private EventsExample myModel;

	/**
	 * Constructor of the service end event
	 *
	 * Used to create a new service end event
	 *
	 * @param owner the model this event belongs to
	 * @param name this event's name
	 * @param showInTrace flag to indicate if this event shall produce output for the trace
	 */
	public ServiceEndEvent(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		// store a reference to the model this event is associated with
		myModel = (EventsExample)owner;
	}

	/**
	 * This eventRoutine() describes what happens when a van carrier finishes
	 * loading a truck.
	 *
	 * The truck leaves the system.
	 * The van carrier will then check if there is another truck
	 * waiting for service.
	 * If there is another truck waiting it will service it.
	 * If not it will wait on its parking spot for the next
	 * customer to arrive.
	 */
	public void eventRoutine(VanCarrier vanCarrier, Truck truck) {

        // pass the departure of the truck to the trace
        sendTraceNote(truck + " leaves the terminal");

		// check if there are other trucks waiting
		if (!myModel.truckQueue.isEmpty())
		{
			// YES, there is at least one other truck waiting

			// remove the first waiting truck from the queue
			Truck nextTruck = myModel.truckQueue.first();
			myModel.truckQueue.remove(nextTruck);

			// create a new service end event
			ServiceEndEvent event = new ServiceEndEvent(myModel, "ServiceEndEvent", true);
 			// and schedule it for the van carrier at the appropriate time
			event.schedule(vanCarrier, nextTruck, new TimeSpan(myModel.getServiceTime(), TimeUnit.MINUTES));
		}
		else {
			// NO, there are no trucks waiting

			// --> the van carrier is placed on its parking spot
			myModel.idleVCQueue.insert(vanCarrier);

			// the VC is now waiting for a new customer to arrive
		}

	}
}