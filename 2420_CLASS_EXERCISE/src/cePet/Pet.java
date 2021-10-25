package cePet;

/**
 * 
 * @author Qi Cao
 *
 */
public final class Pet {
	
	private final String name;
	private final int age;	
	private final String species;
	
	public Pet(String name, int age, String species) {
	
		this.name = name;
		this.age = age;
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return species +" "+ name + " "+"("+age+")";
	}
	
	
}
