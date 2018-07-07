public class SuperReducedString {
	public SuperReducedString(String s) {
		int i = 0;
		while (i<s.length()-1) {
			if (s.charAt(i)==s.charAt(i+1))
				s = (i==0 ? s = s.substring(2) : s.substring(0, i).concat(s.substring((i--)+2)));
			else
				i++;
		}
		System.out.println(s);
	}
}
