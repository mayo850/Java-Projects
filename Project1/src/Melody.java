
/**
 * Name: Izan Khan
 * Date: 12 September 2020
 * CSC 371
 * Program Project 1--Melody.java
 * 
 * Description:
 *  A Melody Player which plays a notes of a particular song, with option to Append two or more songs, 
 *  reverse notes of a song, change the Tempo and Stop. Focusing on Queues, the program uses Notes of a song/track.
 * 
 * Cite Assistance (who and what): Was having problems with repeating notes, took help from Anas. Repeat1 was stopping at 6 sec.
 */

import melody.audio.*;

public class Melody {

	private String title;
	private String artist;
	private QueueADT<Note> song;
	private double duration;

	/**
	 * Initializes melody to store the passed in parameters.
	 * 
	 * @param title  indicates song title in string
	 * @param artist indicates artist name
	 * @param song   indicates a queue of notes for song
	 */

	public Melody(String title, String artist, QueueADT<Note> song) {

		/* Initialize data */
		this.title = title;
		this.artist = artist;
		this.song = song;

		duration = 0; // set Duration to 0

		Note note = null; // Note of song

		int size = song.size(); // get the size of the queue

		int repeat = 0;

		/* Iterate over the queue to find duration of song */
		for (int i = 0; i < size; i++) {
			if (repeat % 2 == 1) {
				duration += note.getDuration();
			}

			note = song.remove(); // get note from queue
			duration += note.getDuration();
			song.add(note);
			if (note.isRepeat() && repeat % 2 == 1) {
				duration += note.getDuration(); // add repeat duration to total duration
				repeat++;

				// increment
			} else if (note.isRepeat()) {
				repeat++;
			}
		}

	}

	/**
	 * 
	 * @return title of the song
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 
	 * @return name of the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * 
	 * @return duration of the song in seconds
	 */
	public double getTotalDuration() {
		return duration;
	}

	/**
	 * returns the information of the song, including song title, artist name,
	 * duration of each note, etc.
	 */
	@Override
	public String toString() {
		String str = ""; // string containing info of song

		// Add title line to the string
		str += this.title + '\n';

		// Add artist line to the string
		str += this.artist + '\n';

		int size = song.size(); // get size of the queue

		// Iterate over the queue to add notes info to the string
		for (int i = 0; i < size; i++) {
			// Get note from queue
			Note note = song.remove();

			// Add note info to the string
			str += note.toString() + '\n';

			// add the removed note back to queue
			song.add(note);
		}

		// return the string
		return str;
	}

	/**
	 * 
	 * Changes the tempo of each note to be tempo percent of what it originally was.
	 * 
	 * @param tempo indicates the value of tempo to be changed
	 */
	public void changeTempo(double tempo) {

		// Get size of the queue
		int size = song.size();

		// Iterate over the queue to change the tempo of each note
		for (int i = 0; i < size; i++) {
			// Get note from queue
			Note note = song.remove();

			// get duration of the note
			double duration = note.getDuration();

			// divide the duration by tempo.
			duration = (duration) / tempo;

			// set the new duration of the note
			note.setDuration(duration);

			// add the note back to the queue
			song.add(note);
		}

		// Update duration after change takes effect
		duration = duration / tempo;

	}

	/**
	 * Method that will reverse the notes of the song the note will be reverse and
	 * the song will be played in reverse order
	 */
	public void reverse() {
		// create a stack to store notes
		StackADT<Note> stack = new ArrayStack<>();

		while (!song.isEmpty()) {
			// Get each note from the queue
			Note note = song.remove();

			// add the note to the stack
			stack.push(note);
		}

		while (!stack.isEmpty()) {
			// Get each note from stack
			Note note = stack.pop();

			// add each note back to queue, stack will return last note first, hence
			// queue will have reverse notes
			song.add(note);
		}
	}

	/**
	 * Adds notes from the given other song to the end of existing song/ already
	 * added song.
	 * 
	 * @param other indicates another melody to be added
	 */
	public void append(Melody other) {
		// Append title of other melody
		this.title += ", " + other.title;

		// Append the artist of other melody
		this.artist += ", " + other.artist;

		// get size of the other melody queue
		int size = other.song.size();

		// iterate over the other melody to add its note to current melody
		for (int i = 0; i < size; i++) {
			// get note from other melody
			Note note = other.song.remove();

			// add note to the current melody
			this.song.add(note);

			// add note back to current melody
			other.song.add(note);
		}

		// Update the duration of original melody
		duration = duration + other.duration;
	}

	/**
	 * Method that will play the melody. Notes are played from beginning till the
	 * end including repeated notes.
	 * 
	 */
	public void play() {

		Note note = null;

		// get size of the current melody queue size
		int size = this.song.size();
		int repeat = 0;

		// create a temporary queue to store repeated notes
		QueueADT<Note> tempQueue = new ArrayQueue<>();
		for (int i = 0; i < size; i++) {
			if (repeat % 2 == 1) {
				tempQueue.add(note); // add note to temporary queue
			}

			note = song.remove();// get new note from queue
			note.play(); // play the note
			song.add(note); // add note back to main queue

			if (note.isRepeat() && repeat % 2 == 1) {
				tempQueue.add(note);

				// play the notes that were added to temp queue for repetition
				while (!tempQueue.isEmpty()) {
					Note tempNote = tempQueue.remove();
					tempNote.play();
				}
				repeat++;

			} else if (note.isRepeat()) {
				repeat++;
			}

		}

	}

}