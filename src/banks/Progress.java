package banks;

public class Progress {
	int name;
	Resource MaxSource  =  new Resource();//一共需要总的资源数目
	Resource NeedSource = new Resource();//还需要的资源数目
	Resource AllocSource  = new Resource();//已经分配的资源数目
	
	/*设置进程的相关信息：名称、最大需求资源数目、还需资源数目、已经分配资源数目*/
	public void setName(int name){
		this.name = name;
	}
	
	public void setMaxSourceNumber(int A, int B, int C){
		System.out.println("Runnnig there!3");
		MaxSource.setResouceNumber(A, B, C);
	}
	public void setAllocSourceNumber(int A, int B, int C){
		AllocSource.setResouceNumber(A, B, C);
	}
	public void setNeedSourceNumber(){
		int NeedA = MaxSource.getResouceA() - AllocSource.getResouceA();
		int NeedB = MaxSource.getResouceB() - AllocSource.getResouceB();
		int NeedC = MaxSource.getResouceC() - AllocSource.getResouceC();
		NeedSource.setResouceNumber(NeedA, NeedB, NeedC);
	}
	
	

	
}
