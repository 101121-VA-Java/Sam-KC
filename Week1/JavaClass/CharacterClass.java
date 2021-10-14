

public class CharacterClass {

	public String characterName;
	String characterType;
	double speed; 
	int strength;
	int level;
	int gold;
	boolean isRunning;


	public CharacterClass() {
		this.characterName = "Undefined";
		this.characterType = "Undefined";
		speed = 10;
		strength = 5;
		level = 1;
		gold = 0;
	}
	public CharacterClass( String characterName, String characterType  ) {

		this.characterName = characterName;
		this.characterType = characterType;

		speed = 10;
		strength = 5;
		level = 1;
		gold = 0;

	}

	public void levelUp(){
		level++;
		System.out.println("Leveled up to " + level);
	}





}