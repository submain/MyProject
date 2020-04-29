package maindo;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
	
	public static void main(String[] args) {
        System.out.println(fun("anviaj"));
	}
	
	public static int fun(String str) {
		if("".equals(str)){
            return 0;
        }
		int max = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				boolean add = set.add(str.charAt(j));
				if (!add) {
					if (set.size() > max) {
						max = set.size();
					}
					set.clear();
					/*if (max > (str.length() - i / 2)) {
						return max;
					} else {
					}*/
					break;
				} else if (j == (str.length() - 1)) {
					if (set.size() > max) {
						max = set.size();
					}
					set.clear();
				}
			}
		}
		return max;
	}
}
