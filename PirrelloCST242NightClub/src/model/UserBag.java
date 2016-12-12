package model;

public class UserBag {
	private User[] userBag;
	private int nElems;
	public UserBag(int maxSize){
		userBag = new User[maxSize];
		nElems = 0;
	}
	public void add(User user){
		userBag[nElems++] = user;
	}
	public void display(){
		for(int i = 0;i < nElems;i++){
			System.out.print(userBag[i] + " ");
		}
	}
	public User find(String username){
		for(int i = 0;i < nElems;i++){
			if(userBag[i].getUsername().equals(username)){
				return userBag[i];
			}
		}
		return null;
	}
	public boolean correctLogin(String username,String password){
		for(int i = 0;i < nElems;i++){
			if(userBag[i].getUsername().equals(username) && userBag[i].getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	public User delete(String username){
		for(int i = 0;i < nElems;i++){
			if(username.equals(userBag[i].getUsername())){
				User deleted = userBag[i];
				userBag[i] = userBag[i+1];
				for(int k = i + 1;k < nElems - 1;k++){
					userBag[k] = userBag[k+1];
				}
				nElems--;
				return deleted;
			}
		}
		return null;
		
	}
}
