public class mainProgram {


   public static void main(String[] args) {

   	CharacterClass character1 = new CharacterClass();

	CharacterClass character2 = new CharacterClass("Harry Potter", "Mage");

	System.out.println("Character 1 Name is : " + character1.characterName);
	System.out.println("Character 2 Type is : " + character1.characterType);

	System.out.println("Character 1 Name is : " + character2.characterName);
	System.out.println("Character 2 Type is : " + character2.characterType);

	character2.levelUp();

   }



}