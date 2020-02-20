package com.gerardnico.desmo.ProcessExample;

import desmoj.core.simulator.*;
import co.paralleluniverse.fibers.SuspendExecution;

import java.util.concurrent.TimeUnit;

/**
 * This class represents a process source, which continually generates
 * trucks in order to keep the simulation running.
 * <p>
 * It will create a new truck, activate it (so that it arrives at
 * the terminal) and then wait until the next truck arrival is
 * due.
 *
 * SimProcess is a subclasses of ModelComponent
 */
public class TruckGenerator extends SimProcess {

    /**
     * TruckGenerator constructor comment.
     *
     * @param owner       the model this truck generator belongs to
     * @param name        this truck generator's name
     * @param showInTrace flag to indicate if this process shall produce output
     *                    for the trace
     */
    public TruckGenerator(Model owner, String name, boolean showInTrace) {
        super(owner, name, showInTrace);
    }


    /**
     * describes this process's life cycle: continually generate new trucks.
     *  SuspendExecution put a "mark" where process execution can be interrupted for the internal process scheduling logic
     */
    @Override
    public void lifeCycle() throws SuspendExecution {

        // get a reference to the model
        ProcessesExample model = (ProcessesExample) getModel();

        // endless loop:
        while (true) {

            // create a new truck
            // Parameters:
            // model       = it's part of this model
            // "Truck"     = name of the object
            // true        = yes please, show the truck in trace file
            Truck truck = new Truck(model, "Truck", true);

            // now let the newly created truck roll on the parking-lot
            // which means we will activate it after this truck generator
            truck.activateAfter(this);

            // wait until next truck arrival is due
            hold(new TimeSpan(model.getTruckArrivalTime()));
            // from inside to outside...
            // we draw a new inter-arrival time
            // we make a TimeSpan object out of it and
            // we wait for exactly this period of time
        }
    }
}

