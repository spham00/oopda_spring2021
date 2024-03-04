package v1;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	private static String MEDIA_DIRECTORY = "Media Files//";	// The folder the files are in.
	
	public static void main(String[] args) {
		
		DarkClip jonas = new DarkClip(MEDIA_DIRECTORY + "Dark-Jonas.gif", "Jonas Walking Into Cave");
		DarkClip theStranger = new DarkClip(MEDIA_DIRECTORY + "Dark-TheStranger.gif", "Stranger Leaving Cave");
		DarkShadowsClip angelique = new DarkShadowsClip(MEDIA_DIRECTORY + "DarkShadows-Angelique.wav", 606, "Angelique");
		DarkShadowsClip drHoffman = new DarkShadowsClip(MEDIA_DIRECTORY + "DarkShadows-DoctorHoffman.wav", 613, "Doctor Hoffman");
		DarkShadowsClip profStokes = new DarkShadowsClip(MEDIA_DIRECTORY + "DarkShadows-ProfessorStokes.wav", 506, "Professor Stokes");
		DarkShadowsClip zombie = new DarkShadowsClip(MEDIA_DIRECTORY + "DarkShadows-Zombie.wav", 942, "Zombie Sheriff Davenport");
		GameOfThronesClip joffery = new GameOfThronesClip(MEDIA_DIRECTORY + "GameOfThrones-Joffrey.gif", "Joffrey Baratheon");
		GameOfThronesClip jon = new GameOfThronesClip(MEDIA_DIRECTORY + "GameOfThrones-Jon.gif", "Jon Snow");
		RockyAndBullwinkleClip natasha = new RockyAndBullwinkleClip(MEDIA_DIRECTORY + "RockyAndBullwinkle-Natasha.wav", 1);
		RockyAndBullwinkleClip rockyBullwinkle = new RockyAndBullwinkleClip(MEDIA_DIRECTORY + "RockyAndBullwinkle-RockyAndBullwinkle.wav", 2);
		SeinfeldClip jerry = new SeinfeldClip(MEDIA_DIRECTORY + "Seinfeld-Jerry.wav", "Jerry", 1997);
		SeinfeldClip kramer = new SeinfeldClip(MEDIA_DIRECTORY + "Seinfeld-Kramer.wav", "Kramer", 1993);

		List<Playable> clips = new ArrayList<Playable>();
		clips.add(jonas);
		clips.add(theStranger);
		clips.add(angelique);
		clips.add(drHoffman);
		clips.add(profStokes);
		clips.add(zombie);
		clips.add(joffery);
		clips.add(jon);
		clips.add(natasha);
		clips.add(rockyBullwinkle);
		clips.add(jerry);
		clips.add(kramer);
		
		clips.forEach(c -> c.play());
	}

}
