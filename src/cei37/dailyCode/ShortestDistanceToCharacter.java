package cei37.dailyCode;

public class ShortestDistanceToCharacter {

	public static void main(String[] args) {
		ShortestDistanceToCharacter s = new ShortestDistanceToCharacter();
		for (int c : s.shortestToChar("instagram", 'a')) {
			System.out.print(c + ", ");
		}

	}

    public int[] shortestToChar(String S, char c) {
    	int [] res = new int[S.length()];
    	char [] ch = S.toCharArray();
    	
    	int found = -1;
    	for (int i=0; i<ch.length; i++) {
    		res[i] = Integer.MAX_VALUE;
    		if (ch[i] == c) {
    			found = i;
    			res[i] = 0;
    		} else if (found != -1){
    			res[i] = i - found;
    		}
    	}
    	
    	found = -1;
    	for (int i=ch.length -1; i>=0; i--) {
    		if (ch[i] == c) {
    			found = i;
    			res[i] = 0;
    		} else if (found != -1){
    			res[i] = Integer.min(res[i], found - i);
    		}
    	}

    	return res;
    }
}
