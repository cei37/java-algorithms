package cei37.string;

public class DefangingAnIPAddress {

	public static void main(String[] args) {
		DefangingAnIPAddress dIP = new DefangingAnIPAddress();
		
		System.out.println(dIP.defangIPaddr("12.23.42.23"));

	}

    public String defangIPaddr(String address) {
        if (address == null || address.equals("")) return "";
        
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
