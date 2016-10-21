package Files;

public class Outcome implements Comparable {
	private String name;
	private int odds;
	
	public Outcome(String n, int o) {
		name = n;
		odds = o;
	}

	public int winAmount(int amount){
		int winnings = amount * odds;
		
		return winnings;
	}
	
	public boolean equals(Outcome other){
		if (other.name == this.name){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return (name + " (" + odds + ":1)" );
	}

	public int compareTo(Object other){
		return this.toString().compareTo(other.toString());
	}
}
