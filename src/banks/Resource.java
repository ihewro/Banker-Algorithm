package banks;

public class Resource {
	private int A;
	private int B;
	private int C;
	
	public int getResouceA(){
		return this.A;
	}
	public int getResouceB(){
		return this.B;
	}
	public int getResouceC(){
		return this.C;
	}
	
	public String gerResouceNumber(){
		String SourceNumber = new String();
		SourceNumber = "A:" + this.A + " B:" + this.B
		 + " C:" + this.C;
		return SourceNumber;
	}
	
	public void setResouceNumber(int A, int B, int C){
		this.A = A;
		this.B = B;
		this.C = C;
	}
}
