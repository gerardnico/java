package com.gerardnico.desmo.EventExample;

import desmoj.core.simulator.*;
import java.util.concurrent.TimeUnit;
/**
 * This class represents the truck arrival event
 * in the EventsExample model.
 * It occurs when a truck arrives at the terminal
 * to request loading of a container.
 * @author Olaf Neidhardt, Ruth Meyer
 */
public class TruckArrivalEvent extends Event<Truck> {

	/** a reference to the model this event is a part of.
	 * Useful shortcut to access the model's static components
	 */
	private EventsExample myModel;

	/**
	 * Constructor of the truck arrival event
	 *
	 * Used to create a new truck arrival event
	 *
	 * @param owner the model this event belongs to
	 * @param name this event's name
	 * @param showInTrace flag to indicate if this event shall produce output for the trace
	 */
	public TruckArrivalEvent(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		// store a reference to the model this event is associated with
		myModel = (EventsExample)owner;
	}

	/**
	 * This eventRoutine() describes what happens when a truck
	 * enters the terminal.
	 *
	 * On arrival, the truck will enter the queue (parking lot). It will then
	 * check if the van carrier is available.
	 * If this is the case, it will occupy the van carrier and schedule a
	 * service end event.
	 * Otherwise the truck just waits (does nothing).
	 */
	public void eventRoutine(Truck truck) {

		// truck enters parking-lot
		myModel.truckQueue.insert(truck);
		sendTraceNote("TruckQueueLength: "+ myModel.truckQueue.length());

		// check if a VC is available
		if (!myModel.idleVCQueue.isEmpty()) {
			// yes, it is

			// get a reference to the first VC from the idle VC queue
			VanCarrier vanCarrier = myModel.idleVCQueue.first();
			// remove it from the queue
			myModel.idleVCQueue.remove(vanCarrier);

			// remove the truck from the queue
			myModel.truckQueue.remove(truck);

			// create a service end event
			ServiceEndEvent serviceEnd = new ServiceEndEvent (myModel, "ServiceEndEvent", true);

			// and place it on the event list
			serviceEnd.schedule(vanCarrier, truck, new TimeSpan(myModel.getServiceTime(), TimeUnit.MINUTES));

		}

	}
}