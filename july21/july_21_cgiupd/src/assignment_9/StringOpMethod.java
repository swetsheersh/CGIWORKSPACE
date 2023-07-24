package assignment_9;

public class StringOpMethod {
	StringOp op=new StringOp();
	public StringOp addItself(String str) {
		op.setStr(str.concat(str));
		return op;
	}
	public StringOp oddpos(String str) {
		StringBuilder builder=new StringBuilder(str);
		for(int i=0;i<str.length();i++) {
			if((i+1)%2!=0) {
				builder.setCharAt(i, '#');
			}
		}
		op.setStr(builder.toString());
		return op;
	}
	public StringOp removedup(String str) {
		String str1="";
		for(int i=0;i<str.length();i++) {
			if(str1.indexOf(str.charAt(i))<0) {
				str1+=str.charAt(i);
			}
		}
		op.setStr(str1);
		return  op;
	}
	public StringOp oddUpper(String str) {
		StringBuilder builder=new StringBuilder(str);
		for(int i=0;i<str.length();i++) {
			if((i+1)%2!=0) {
				String str1="";
				str1+=str.charAt(i);
				str1=str1.toUpperCase();
				builder.setCharAt(i, str1.charAt(0));
			}
		}
		op.setStr(builder.toString());
		return op;
	}
}
