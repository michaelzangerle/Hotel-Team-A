package projekt.fhv.teama.controller.exeption;

public class LoginInExeption extends Exception {
	
	private String message;
	public LoginInExeption(String uid,String pw) {
		
		message="Falscher Username oder Passwort\nUsername: "+uid+"\nPasswort: "+pw;
	}
	
	public String getMessage()
	{
		return message;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		// TODO Auto-generated method stub
		return super.fillInStackTrace();
	}
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
	@Override
	public String toString() {
		return getMessage();
	}
}
