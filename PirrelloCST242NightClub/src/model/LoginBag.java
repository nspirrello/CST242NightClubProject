package model;

public class LoginBag {
	private Login[] loginBag;
	private int nElems;
	public LoginBag(int maxSize){
		loginBag = new Login[maxSize];
		nElems = 0;
	}
	public void add(Login login){
		loginBag[nElems++] = login;
	}
	public void display(){
		for(int i = 0;i < nElems;i++){
			System.out.print(loginBag[i] + " ");
		}
	}
	public Login find(String username){
		for(int i = 0;i < nElems;i++){
			if(loginBag[i].getUsername().equals(username)){
				return loginBag[i];
			}
		}
		return null;
	}
	public boolean correctLogin(String username,String password){
		for(int i = 0;i < nElems;i++){
			if(loginBag[i].getUsername().equals(username) && loginBag[i].getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	public Login delete(String username){
		for(int i = 0;i < nElems;i++){
			if(username.equals(loginBag[i].getUsername())){
				Login deleted = loginBag[i];
				loginBag[i] = loginBag[i+1];
				for(int k = i + 1;k < nElems - 1;k++){
					loginBag[k] = loginBag[k+1];
				}
				nElems--;
				return deleted;
			}
		}
		return null;
		
	}
}
