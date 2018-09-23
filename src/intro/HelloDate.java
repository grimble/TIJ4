package intro;

import java.util.Date;

/** The first Thinking in Java example program.
 * Displays a string and today's date.
 * <p>
 * You can <em>even</em> insert a list:
 * <ol>
 * <li> Item one
 * <li> Item two
 * <li> Item three
 * </ol>
 * </p>
 * @author Bruce Eckel
 * @author www.MindViewLLC.com
 * @version 4.0
 *
 */
public class HelloDate {
    /** Entry point to class & application.
     * @param args array of string arguments
     */
    static void main(String[] args) {
            System.out.println("Hello, it's: ");
            System.out.println(new Date());
    }
}

