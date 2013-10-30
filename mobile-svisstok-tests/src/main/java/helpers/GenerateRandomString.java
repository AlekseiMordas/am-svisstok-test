package helpers;

import java.util.Random;

/**
 * @author Aleksei_Mordas
 *
 */
public class GenerateRandomString {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static Random rnd = new Random();
	
	public static String generateString()
	{
		StringBuilder sb = new StringBuilder( 10 );
		   for( int i = 0; i < 7; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString().toLowerCase();
	}

}