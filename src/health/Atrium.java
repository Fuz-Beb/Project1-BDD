package health;

import org.xml.sax.Attributes;

//Travail fait par :
//Bobet Pierrick - 17 131 792
//Bouteloup Remy - 17 132 265

public class Atrium {
	
	// Attributes
	private String name;
	private int id;
	private double volume;
	
	// Comfort constructor
	public Atrium(Attributes attrs) {
		
	}
	
	// Getters / Setters
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}
	/**
	 * @param volume
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}	
}