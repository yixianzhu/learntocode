
//++from char to int++
String element = "el5";
int x = Character.getNumericValue(element.charAt(2));
System.out.println("x=" + x);

//++from char to string++
//You can use 
Character.toString(char)//Note that this method simply returns a call to 
String.valueOf(char) // which also works.
//As others have noted, string concatenation works as a shortcut as well:
String s = "" + 's';
