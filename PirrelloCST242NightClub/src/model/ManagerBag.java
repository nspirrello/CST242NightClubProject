package model;

public class ManagerBag {
	private Manager[] managerBag;
	private int nElems;
	public ManagerBag(int maxSize){
		managerBag = new Manager[maxSize];
		nElems = 0;
	}
	public void add(Manager manager){
		managerBag[nElems++] = manager;
	}
	public void display(){
		for(int i = 0;i < nElems;i++){
			System.out.print(managerBag[i] + " ");
		}
	}
	public Manager find(String username){
		for(int i = 0;i < nElems;i++){
			if(username.equals(managerBag[i].getUsername())){
				return managerBag[i];
			}
		}
		return null;
	}
	public Manager delete(String username){
		for(int i = 0;i < nElems;i++){
			if(username.equals(managerBag[i].getUsername())){
				Manager deleted = managerBag[i];
				managerBag[i] = managerBag[i+1];
				for(int k = i + 1;k < nElems - 1;k++){
					managerBag[k] = managerBag[k+1];
				}
				nElems--;
				return deleted;
			}
		}
		return null;
		
	}
}
