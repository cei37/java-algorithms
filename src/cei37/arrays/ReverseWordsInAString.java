package cei37.arrays;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		ReverseWordsInAString re = new ReverseWordsInAString();
		System.out.println(re.reverseWords("   a good   example "));
	}

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) 
            return "";
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1; i>=0; i--) {
        	if (arr[i].trim().length() > 0) {
	            sb.append(arr[i]);
	            if (i != 0) {
	                sb.append(" ");   
	            }
        	}
        }
        return sb.toString();
    }
}
