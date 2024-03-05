
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		MyStack s3 = new StackArray();
		
		while (s1.size() > 1 && (!s2.isEmpty())) {
			int result = 0;
			int first = s1.top();
			s1.pop();
			int second = s1.top();
			s1.pop();
			int operator = s2.top();
			s2.pop();
			
			if (operator >= 0) {
				result = first + second;
				s3.push(result);
			} else {
				result = first - second;
				s3.push(result);
			}
		}
		String ans = "";
		while  (!s3.isEmpty()) {
			ans += alphabets.charAt(s3.top());
			s3.pop();
		}
		return ans;
	}
}
