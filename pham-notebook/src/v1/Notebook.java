package v1;

import java.util.List;
import java.util.ArrayList;

/**
 * The class Notebook represents a notebook that is comprised of notes, where
 * the user can add, remove, and move notes.
 * 
 * @author 	Sarah Pham
 * @version	February 3rd, 2021
 */
public class Notebook
{
	/**
	 * A collection of notes, like a notebook.
	 */
	private List<String> notes;

	/**
	 * Creates a notebook.
	 */
	public Notebook()
	{
		notes = new ArrayList<String>();
	}

	/**
	 * Returns the ArrayList of notes.
	 * 
	 * @return	The ArrayList of notes.
	 */
	public List<String> getNotes()
	{
		return notes;
	}

	/**
	 * Sets the user-entered ArrayList as the notes in the notebook if it is not null.
	 * 
	 * @param notes	The ArrayList the user wants to put in the notebook.
	 */
	public void setNotes(ArrayList<String> notes)
	{
		if (notes != null) {
			this.notes = notes;
		}
		else {
			System.out.println("ERROR: Null is not valid");
		}
	}

	/**
	 * Returns the number of notes in the notebook.
	 * 
	 * @return	The number of notes.
	 */
	public int numberOfNotes()
	{
		return notes.size();
	}

	/**
	 * Adds the user-entered note to the notebook.
	 * 
	 * @param note	The note the user wants to add.
	 */
	public void addNote(String note)
	{
		if (note == null) {
			System.out.println("ERROR: The note cannot be null");
		}
		else {
			if (notes.contains(note)) {
				System.out.println("ERROR: The notebook cannot have duplicate notes.");
			}
			else {
				notes.add(note);
			}
		}
	}

	/**
	 * Deletes the note depending on the position the user enters.
	 * 
	 * @param index	The position of the note that the user wants to delete.
	 */
	public void deleteNote(int index)
	{
		if (index > 0 && index < notes.size()) {
			notes.remove(index);
		}
		else {
			System.out.println("ERROR: Index cannot be negative or more than " + (notes.size() - 1));
		}
	}

	/**
	 * Returns the position of the user-entered note.
	 * 
	 * @param note	The note the user wants to find the position of.
	 * @return		The position of the user-entered note.
	 */
	public int getNoteNumber(String note)
	{
		return notes.indexOf(note);
	}

	/**
	 * Returns the note for the user-entered position.
	 * 
	 * @param index	The position the user wants to get the note of.
	 * @return		The note at the user-entered position.
	 */
	public String getNote(int index)
	{
		if (index >= 0 && index < notes.size()) {
			return notes.get(index);
		}
		else {
			return "ERROR: Index cannot be negative or more than " + (notes.size() - 1);
		}
	}

	/**
	 * Updates an already-existing note with the user-entered text
	 * at a user-entered position.
	 * 
	 * @param index	The position of the note the user wants to replace.
	 * @param note	The note the user wants to replace the current one with.
	 */
	public void setNote(int index, String note)
	{
		if (index >= 0 && index < notes.size()) {
			if (note == null) {
				System.out.println("ERROR: The note cannot be null");
			}
			else {
				notes.set(index, note);
			}
		}
		else {
			System.out.println("ERROR: Index cannot be negative or more than " + (notes.size() - 1));
		}
	}

	/**
	 * Moves a user-entered note up one position.
	 * 
	 * @param note	The note the user wants to move up one position.
	 */
	public void moveNoteUp(String note)
	{
		if (notes.contains(note)) {
			int index = getNoteNumber(note);
			if (index > 0) {
				notes.remove(index);
				notes.add(index - 1, note);
			}
			else {
				System.out.println("ERROR: Cannot move note up any further");
			}
		}
		else {
			System.out.println("ERROR: " + note + " doesn't exist in the notebook");
		}
	}

	/**
	 * Moves a user-entered note down one position.
	 * 
	 * @param note	The note the user wants to move down one position.
	 */
	public void moveNoteDown(String note)
	{
		if (notes.contains(note)) {
			int index = getNoteNumber(note);
			if (index < notes.size() - 1) {
				notes.remove(index);
				notes.add(index + 1, note);
			}
			else {
				System.out.println("ERROR: Cannot move note down any further");
			}
		}
		else {
			System.out.println("ERROR: " + note + " doesn't exist in the notebook");
		}
	}

	/**
	 * Moves a user-entered note to the top position in the notebook.
	 * 
	 * @param note	The note the user wants to move to the first position.
	 */
	public void moveNoteToTop(String note)
	{
		if (notes.contains(note)) {
			if (notes.size() > 1) {
				notes.remove(note);
				notes.add(0, note);
			}
			else {
				System.out.println("Note is already on top");
			}
		}
		else {
			System.out.println("ERROR: " + note + " doesn't exist in the notebook");
		}
	}

	/**
	 * Moves a user-entered note to the bottom position in the notebook.
	 * 
	 * @param note	The note the user wants to move to the bottom position.
	 */
	public void moveNoteToBottom(String note)
	{
		if (notes.contains(note)) {
			if (notes.size() > 1 && notes.indexOf(note) != notes.size() - 1) {
				notes.remove(note);
				notes.add(note);
			}
			else {
				System.out.println("Note is already on the bottom");
			}
		}
		else {
			System.out.println("ERROR: " + note + " doesn't exist in the notebook");
		}
	}
}
