package rabinkarp;

import java.util.LinkedList;

public class RK {
	
	LinkedList<Character> chars = new LinkedList<Character> ();
	int hash = 0;
	int exp =1;
	int charS = 0;
	
	public RK(int m) {
		charS = m;
		for(int i =0; i < m; ++i){
			exp = Math.floorMod(exp*31,511);
		}
	}
	
	
	public int nextCh(char d) {
		
		chars.add(d);

		if(chars.size() <= charS){
			hash = Math.floorMod(hash*31 - exp * 0 + d, 511);
		}else{
			char c = chars.removeFirst();
			hash = Math.floorMod(hash*31 - exp * c + d, 511);
		}
		return hash;
	}
}
