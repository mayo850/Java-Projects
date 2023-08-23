/**
 * 
 * Code to test the Content class
 */
public class ContentTest {
	public static void main(String[] args) {

		Content library = new Content("Augustana Broadcasting");
		System.out.println(library);
		System.out.println("\nTop Ranked: ");
		System.out.println(library.topRanked());
		System.out.println("\nFound Item:");
		System.out.println(library.findVideoItem("stay"));
		System.out.println("\nFound Item:");
		System.out.println(library.findVideoItem("blue"));
	}
}
