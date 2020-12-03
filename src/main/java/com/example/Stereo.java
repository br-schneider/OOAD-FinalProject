
public class Stereo extends Extra {
	private Extra extra;

	public Stereo(Extra extra) {
		this.extra = extra;
		type = extra.getType();
	}

	public double getCost() {

		if (extra.getType().equalsIgnoreCase("Bose")) {
			return extra.getCost() + 450.00;
		} 
		else if (extra.getType().equalsIgnoreCase("Pioneer")) {
			return extra.getCost() + 285.00;
		} 
		else if (extra.getType().equalsIgnoreCase("Sony")) {
			return extra.getCost() + 300.00;
		}
		return extra.getCost();
	}
}
