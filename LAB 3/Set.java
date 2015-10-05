import java.util.LinkedHashSet;


public class Set extends LinkedHashSet<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Set  vhozhdenia(Set a,Set b) {
		Set c = new Set();
		for (Integer i : b) {
			
			if (a.contains(i)==true) {
				c.add(i);
			}
			}
		return c;
	}
	public  static Set  nevhozhdenia(Set a,Set b) {
		Set c = new Set();
		for (Integer i : b) {
			
				if (!a.contains(i)) {
					c.add(i);
				}
			}
		for (Integer i : a) {
			
			if (!b.contains(i)) {
				c.add(i);
			}
		}
	
		return c;
	}
	public Set sliyanie(Set a,Set b )
	{
		
		a.addAll(b);
		return a;
	}
	

	

	
	

}
