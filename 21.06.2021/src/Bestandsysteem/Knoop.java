package Bestandsysteem;

import java.util.List;

/**
 * @invar | getNaam() != null
 * @invar | getOuder() == null || getOuder().getIngangen().containsValue(this)
 */
public abstract class Knoop {
	
	/**
	 * @invar | naam != null
	 */
	String naam;
	
	/**
	 * @peerObject
	 * @invar | ouder == null || ouder.getIngangen().containsValue(this)
	 */
	Directory ouder;
	
	/**
	 * @peerObject
	 */
	public Directory getOuder() {
		return ouder;
	}
	
	public String getNaam() {
		return naam;
	}
	
	//geen doc nodig
	public abstract Knoop zoekOp(List<Knoop> pad);
	

}
