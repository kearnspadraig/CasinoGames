package Files;

public class Outcome implements Comparable {
	private String name;
	private int odds;
	
	public Outcome(String n, int o) {
		name = n;
		odds = o;
	}

	public int winAmount(int amount){
		return amount * odds;
	}
	
	public boolean equals(Outcome other){
		System.out.println(String.format("This: %s\nOther: %s", this.name, other.name));
		return (other.name.equals(this.name));
	}

	public String getName(){
        return name;
    }
	
	public String toString(){
		return (name + " (" + odds + ":1)" );
	}

	public int compareTo(Object other){
		return this.toString().compareTo(other.toString());
	}
}
