package v1;

/**
 * The class NotebookTest represents a sample notebook comprising of several notes of beverages.
 * 
 * @author	Sarah Pham
 * @version	February 3rd, 2021
 *
 */
public class NotebookTest {

	public static void main(String[] args)
	{
		Notebook myNotebook = new Notebook();
		myNotebook.addNote("Milk");
		myNotebook.addNote("Water");
		 
		myNotebook.addNote("Orange juice");
		myNotebook.addNote("Coconut water");
		myNotebook.addNote("Bubble tea");
		
		myNotebook.moveNoteToTop("Orange");
		for (int moves = 2; moves > 0; moves--)
		{
			myNotebook.moveNoteUp("Orange juice");
		}
		
		System.out.println(myNotebook.getNoteNumber("Orange juice"));
		
		for (int moves = 3; moves > 0; moves--)
		{
			myNotebook.moveNoteDown("Orange juice");
		}
		
		System.out.println(myNotebook.getNoteNumber("Orange juice"));
		
		System.out.println();
		myNotebook.moveNoteDown("Yes");
		myNotebook.moveNoteUp("Milk");
		myNotebook.moveNoteDown("Bubble tea");
		
		System.out.println();
		myNotebook.deleteNote(3);
		System.out.println(myNotebook.getNoteNumber("Orange juice"));
		myNotebook.moveNoteToTop("Coconut water");
		System.out.println(myNotebook.getNoteNumber("Coconut water"));
		System.out.println(myNotebook.numberOfNotes());
		myNotebook.moveNoteToBottom("Milk");
		System.out.println(myNotebook.getNoteNumber("Milk"));
		
		System.out.println(myNotebook.getNoteNumber(null));
		
		System.out.println(myNotebook.getNote(0));
		myNotebook.setNote(0, "Jasmine tea");
		System.out.println(myNotebook.getNote(0));
		System.out.println(myNotebook.numberOfNotes());
		System.out.println(myNotebook.getNote(1));
		
		System.out.println(myNotebook.getNote(3));
		myNotebook.moveNoteToBottom(myNotebook.getNote(3));
		System.out.println(myNotebook.getNote(3));
	}

}
