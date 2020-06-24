package Alan;

import java.io.IOException;
import java.util.Base64;


public class Alan {

	protected static String inputString = "XC9cLzMnfF4zIC9cLzAgJCtJMkB8VjYzSTI1ICswIHxfKCl8LzMgJy8wfF98IHwoL1wvKClcL1wvICddWyd9e1stIEkyTHwxX1stNSAvXDFWfD4gJCgpIHw+KCkgMSAvLVwgLz0oXyl8X3wgKDB8XC98L1wvL1x8LXwtL1wvL1wzfFYnXVsnJzUgVlZdLVtAJ11bJyB8Jy9cLy9cICt9ezEvXC98KHx8VjkgMC89ICcvMHxffCBWVjB8X3x8X1spMVYnLXwtIDkzLXwtICddWycjISQgLz1JMjAvXC8vXCBAfFZgLyAwK317Wy18MiA5KF8pYC8gfCBffChfKSQrIFxeLy9cfFZ8Vi9cIC18LVstfDFfICcvKClMfCB8LXwoKVxeLyAxJy9cLy9cIHw9MzN8MTFWNiA5KCknXVsnLXwtL1wgfFwvfC8tXHwoWy0gJy8oKXxffCB8X3wvXC98PlstfDIkLXwtLy1cfFx8WykgL1wvWy18L1stfF4gOSgpfFYvXC8vLVwgOSF8LzMgJy8oKUx8IHxffHwnIHxcfFstXC9bLXxeIDYoKTFWMVYvLVwgfDMtfC0gYC8oKShfKSB8KTBWVnxcfCAxVlstXC9bLXxeIDkoKXxWL1wvL1wgfDJMfHxcfCAvXHwyMEx8fFZ8KSAvLVwxVjEpIHw+MzVbLXxeJ11bJyBgLygpfF98IHxWWy1cL1stfDIgOTAxVnxcfC9cIHxcL3xAfCgzICcvMHxffCA8fDInLyAxVjNcL1stfDIgOSgpfFZ8XHxeIDUvLVxgLyA2KCkwfCl8MycvMyAxVlstfC8zfDIgOSgpfFx8fFZAIC18LVstMV8xXyBeIHwhWy0gLy1cfFx8fCkgIyhfKXwyLXwtIGAvKClMfCBWVjMnfC9bLSB8PHxcfCgpVlYvXC8gWy0vXFt8LXwgKCknXVsnIzN8XiAvPTBJMiA1MCB8XzAvXC82ICcvKCkoXylJMiAjWy1AfDIrJzUgMTNbLTN8ViAvLVx7I3x8XHw2IHwzfF98KyAnLzBMfCdJMjMgLXwtKCkoKSAkfC18Jy8gKygpIDUvXCcvIHwnXVsnICEvXC81fDEpWy0gXC9cLzMgfDMwLXwtfC18IHw8fFYoKVxeLyBcXi8jLy1cLXwtJyQgLzMzMzFWIDYwfC9cLzYgKCl8XHwgXF4vMyB8KC9cLzBcL1wvIC18LX17Wy0gOV5eXlstIF4xVjEpIFZWWy0nfF5bLSA2KCl8XHwxVi9cIHwnfC8tXCcvIHwrIEAxVjEpIHwvPSAnLygpfF98IC9cJHwoIDFWMTMgXS1bKClcXi8gMSd8XC98IHw9Wy0zMV98fFx8NiBbKSgpMVYnKyAnXVsnWy18XzFfIC9cLy9cMyBgLzBMfCdJMlstICddWycwKCkgOHwhfFx8MSkgLXwtMCA1M1stIHxcfDNcLzN8XiA2MHxWfFZAIDl8fC9bLSAnLygpfF98IEx8fCcgfFYzXC9bLXxeIDkoKXxcfHxcfEAgMV9bLSddWycgYC8wTHwgfD4oKVZWfFx8IHxWM3wvM3wyIDYwfFZ8XHxAIHwyKF8pfFYgXkkyKClMfHxcfHw+IC9cMVZ8KSB8PlstNVstfF4rIGAvMChfKSAxVlstfC8zfDIgOTAvXC8xVi9cIHxcL3xefChbLSAnLzAoXykge0kyJy8gMVZbLVwvWy18MiA5MDFWfFx8QCAkQCcvIDkwMHw+MTMnLzMgMVZbLXwvM3wyIDYwMVYxVkAgKzMxX3wgXiB8MVstIC9cfFZ8PiBdLVsoXyl8Mi18LSBgLygpKF8pIC9cL1stXC9bLUkyIDYoKXxcfHxcfF4gNjFcLzMgJy8oKXxffCB8X3x8JyB8XHxbLVwvWy18XiA5KCl8VnxWL1wgMV9bLSddWycgJy8oKXxffCBbKSgpXF4vfFYgMVZbLXwvWy1JMiA2KCkxVjFWQCB8MnxffHxWIC8tXHxeKCkoXykxVnwpIC9cMVZ8PiBbKTM1M3xeKyBgLzAoXykgL1wvWy18L1stfDIgNigpMVZ8Vl4gL1wvL1xefCgzIGAvMChfKSBbfDInLyAvXC9bLVwvWy1JMiA5MHxcfDFWQCA1XmAvIDkwMHwpMTNgL1stIHxcfFstfC8zfDIgOSgpL1wvfFYvXCAnXVsnM3wxXyAvXCB8X3wzIEAvXC8xKSB8LXwoXyl8XiddWycgJy8wTHwgMVZbLVwvWy1JMiA2MHxWL1wvQCA5fHwvWy0gfFYzfC9bLUkyIDkwfFx8fFYvLVwgNiF8LzMgNiFcL1stICcvKClMfCAoXyl8JyAwMH17IHxWWy18L1stSTIgOSgpfFx8MVZAIDYxfC8zIHxcfDNcLzNJMiA5KCkxVnxcfF4gOTFcL1stIDl8fC8zICcvKCl8X3wgTHx8JyBWVlstJ3wvMyB8KHxcfDBcL1wvfFYgWy1AW317IDArfC18M3xeIC89KClJMiAkKCkgfDB8VjYgYC8wTHx8XiB8LXwzL1x8Mi18LSckIDgzWy18ViBePF0tW3x8XHw5IHwzfF98J11bJyAnLygpTHwnSTJbLSAnXVsnMDAgJCNgLyArKCkgNUAnLyAhLXwtICExViQxWylbLSBcXi8zIDgwK317IHw8L1wvMFxeLyBcXi98LXwvLVwnXVsnJyQgODMzL1wvIDkwITFWNiAoKXxWIFxeL1stIHwoL1wvMFxeLyAnXVsnXS1bMyA5L1xeXlstIC9cfFx8fD4gXC9cL1stJ0kyWy0gNjAvXC8vXC8vXCB8JzFfLy1cYC8gMS18LSAxIF0oXyk1J11bJyBcL1wvL1wxVjFWLy1cICddWydbLTFfMV8gJy8wTHwgfXswVlYgMSd8XC98IC89Wy1bLTFfITFWOSA5MC18LS18LS8tXCAvXC8vXF58KDMgYC8oKShfKSAoXykxVlspWy18MjUrQDFWWykgfFx8Wy18L1stfDIgOSgpfFx8fFx8L1wgNnx8L1stICcvMHxffCB8X3x8KiAxVlstfC9bLUkyIDYoKXxWL1wvQCB8XzMnXVsnIGAvKCkoXykgfCkwXF4vfFYgMVZbLXwvWy1JMiA5MHxcfHxcfF4gSTJMfHxWIC8tXHwyMHxffHxcfHwpIEB8VjEpIHwpMyQzfF4nXVsnICcvKCkoXykgfFZbLVwvWy18XiA2MHxWfFx8QCAvXC8vXC9cfDxbLSBgLzB8X3wgPHwyJy8gfFZbLVwvM3xeIDYwfFZ8Vi9cIDUvXCcvIDYoKSgpWykvM2AvMyB8VlstfC9bLXwyIDYoKTFWfFZeICtbLTFffCBeIHwhWy0gL1x8XHx8KSB9eyhfKXwyJ11bJyBgLygpfF98IHxcfFstfC8zSTIgOTB8Vi9cLy9cIDkxXC8zIGAvKClMfCAoXyl8KiAvXC8zfC8zfDIgOTB8VnxcfEAgfFstJ11bJyAnLzAoXykgWykoKVwvXC98XHwgfFZbLVwvM0kyIDYwL1wvfFx8Ly1cIEkyTHx8XHwgQEkyMEx8fFx8WykgQDFWfD4gWylbLTVbLXwyLXwtICcvKCkoXykgfFx8Wy18LzN8XiA5KCl8VnxWQCAxVjFefCgzIGAvMChfKSA8fDJgLyAvXC9bLXwvWy1JMiA5MDFWfFx8QCAkL1xgLyA2KCkoKVspMTMnLzMgL1wvM3wvM0kyIDYwMVYxVl4gLXwtWy18fF8gQCB8fFstIC9cMVYxKSB8LXxMfEkyLXwtICcvKClMfCAxVlstXC8zfDIgOTB8VnxcfF4gOTFcLzMgJy8wfF98IHxffHwnIDFWWy18L1stfDIgNjAxVjFWL1wgfF8zKyBgLygpKF8pIFspMFxeLy9cLyAxVlstfC8zSTIgNjAxVjFWLy1cIEkyKF8pL1wvIC8tXEkyKCl8X3x8XHx8KSAvLVwxVlspIFspMyQzfDItfC0gYC8wTHwgfFx8Wy18LzN8XiA5KCkvXC98XHwvXCAxVjEvXHwoWy0gJy8oKUx8IFt8Micv";
	
   public static String encode (byte[] text)
   {
	  return Base64.getEncoder().encodeToString(text);
   }

   public static byte[] decode (String text)
   {
	  return Base64.getDecoder().decode(text);
   }

   public static byte[] encrypt(byte[] cleartext, String key)
   {

	  byte[] toReturn = new byte[cleartext.length];
	  byte[] keyBytes = key.getBytes();
	  for (int i = 0; i < cleartext.length; i++)
	  {
		 toReturn[i] = (byte) (cleartext[i] ^ keyBytes[i % keyBytes.length]);
	  }
	  return toReturn;
   }
   
   public static void main(String[] args) throws IOException
   {

	   String str = "", line = "";

	   /*Decode the ciphertext*/
	   str = (new String ((decode(inputString))));
	   
	   
	   /*Split each character into array*/
	   String[] character = new String[str.length()];
	   for (int i = 0; i < str.length(); i++) {
		   character[i] = Character.toString(str.charAt(i));
	   }
	   
	  
	  /*Split 5th character into alphabet*/
	  for(int i =1; i <character.length; i += 6){
		  line += character[i] ;
	  }
	  
	  /*Loop from 20 to 7e*/
	  byte byteStr = 0x20;
	  byte byteEnd = 0x7e;
	  for(int i = byteStr  ; i<= byteEnd;i++) {
		 String key = Character.toString((char)i);
		  System.out.println((new String((encrypt(line.getBytes(), key)))));
		  System.out.println("This is key: " + key + "\n");
	  }
	  		
	    System.out.println(new String((encrypt(decode(inputString), "q"))));

   }
}
