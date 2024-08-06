package Bestandsysteem;

import java.util.Arrays;
import java.util.List;

/**
 * @invar | getInhoud() != null
 */
public class Bestand extends Knoop {
	
	/**
	 * @representationObject
	 * @invar | inhoud != null
	 */
	byte[] inhoud; //reeks bytes
	
	/**
	 * @throws IllegalArgumentException | naam == null
	 * @post | getNaam() == naam
	 * @post | getInhoud().length == 0
	 * @post | getInhoud() != null
	 * @post | getOuder() == null
	 */
	public Bestand(String naam) {
		if (naam == null) 
			throw new IllegalArgumentException("Naam kan niet null zijn");
		this.naam = naam;
		this.inhoud = new byte[] {};
		this.ouder = null;
	}

	/**
	 * @creates | result
	 */
	public byte[] getInhoud() {
		return inhoud.clone();
	}
	
	public Knoop zoekOp(List<Knoop> pad) {
		if (pad.isEmpty())
			return this;
		return null;
	}


	
}
