package model;

public class NightclubBag {
	private Nightclub[] nightclubBag;
	private int nElems;
	public NightclubBag(int maxSize){
		nightclubBag = new Nightclub[maxSize];
		nElems = 0;
	}
	public void add(Nightclub nightclub){
		nightclubBag[nElems++] = nightclub;
	}
	public void display(){
		for(int i = 0;i < nElems;i++){
			System.out.print(nightclubBag[i] + " ");
		}
	}
	public Nightclub find(String clubName){
		for(int i = 0;i < nElems;i++){
			if(clubName.equals(nightclubBag[i].getClubName())){
				return nightclubBag[i];
			}
		}
		return null;
	}
	public Nightclub delete(String username){
		for(int i = 0;i < nElems;i++){
			if(username.equals(nightclubBag[i].getClubName())){
				Nightclub deleted = nightclubBag[i];
				nightclubBag[i] = nightclubBag[i+1];
				for(int k = i + 1;k < nElems - 1;k++){
					nightclubBag[k] = nightclubBag[k+1];
				}
				nElems--;
				return deleted;
			}
		}
		return null;
		
	}
}
