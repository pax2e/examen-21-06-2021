package Bestandsysteem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import logicalcollections.LogicalMap;
/**
* @invar | getIngangen() != null
* @invar | getIngangen().isEmpty() || getIngangen().values().stream().allMatch(k -> k.getOuder() == this)
*/
public class Directory extends Knoop  {
	
	/**
	 * @representationObject
	 * @peerObjects
	 * @invar | ingangen != null
	 * @invar | ingangen.isEmpty() || ingangen.values().stream().allMatch(k -> k.getOuder() == this)
	 */
	HashMap<String, Knoop> ingangen = new HashMap<String, Knoop>();
	
	/**
	 * @throws IllegalArgumentException | naam == null
	 * @post | getOuder() == null
	 * @post | getNaam() == naam
	 * @post | getIngangen().isEmpty()
	 */
	public Directory(String naam) {
		if (naam == null) 
			throw new IllegalArgumentException("Naam kan niet null zijn");
		this.naam = naam;
		this.ouder = null;
	}
	
	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Map<String, Knoop> getIngangen() {
		return Map.copyOf(ingangen);
	}
	
	/**
	 * @pre | knoop != null
	 * @pre | !getIngangen().containsKey(knoop.getNaam())
	 * @pre | !getIngangen().containsValue(knoop)
	 * @mutates_properties | this.getIngangen(), knoop.getOuder()
	 * @post | getIngangen().containsKey(knoop.getNaam()) && getIngangen().containsValue(knoop)
	 * @post | knoop.getOuder() == this
	 */
	public void addIngang(Knoop knoop) {
		getIngangen().put(knoop.naam, knoop);
		knoop.ouder = this;
	}	
	
	/**
	 * @pre | knoop != null
	 * @pre | knoop.getOuder() == this
	 * @pre | getIngangen().containsKey(knoop.getNaam()) &&  getIngangen().containsValue(knoop)
	 * @mutates_properties | this.getIngangen(), knoop.getOuder()
	 * @post | !getIngangen().containsKey(knoop.getNaam()) && !getIngangen().containsValue(knoop)
	 * @post | knoop.getOuder() == null
	 */
	public void removeIngang(Knoop knoop) {
		knoop.ouder = null;
		getIngangen().remove(knoop.naam, knoop);
	}

	
	public Knoop zoekOp(List<Knoop> pad) {
		if (pad.isEmpty())
			return this;
		Knoop kind = pad.get(0);
		if (kind == null)
			return null;
		return kind.zoekOp(pad.subList(1, pad.size()));
		
	}
}
