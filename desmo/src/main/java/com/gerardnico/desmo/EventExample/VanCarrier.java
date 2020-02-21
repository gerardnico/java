package com.gerardnico.desmo.EventExample;

import desmoj.core.simulator.*;
/**
 * The VanCarrier entity encapsulates all data relevant for a van carrier.
 * In our model, it only stores a reference to the truck it is currently
 * (un)loading.
 * @author Olaf Neidhardt, Ruth Meyer
 */
public class VanCarrier extends Entity {

	/**
	 * Constructor of the van carrier entity.
	 *
	 * @param owner the model this entity belongs to
	 * @param name this VC's name
	 * @param showInTrace flag to indicate if this entity shall produce output for the trace
	 */
	public VanCarrier(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
	}
}