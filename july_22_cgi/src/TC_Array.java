
public class TC_Array {
		int in1[];
		
		TC_Array(int i)
		{
			in1=new int[i];
			
		}
		
		void array1()
		{
			for(int i=0;i<in1.length;i++)
			{
				in1[i]=i;
			}
		}
		
		void dispay()
		{
			for(int i=0;i<in1.length;i++)
			{
				System.out.println("Number:"+in1[i]);
			}
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			TC_Array ad=new TC_Array(5);
			ad.array1();
			ad.dispay();
			
		}
	}






















