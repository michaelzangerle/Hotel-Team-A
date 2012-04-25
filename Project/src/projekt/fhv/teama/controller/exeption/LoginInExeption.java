package projekt.fhv.teama.controller.exeption;


/**
 * Exception für den fall eines Login Fehlers
 * @author Team-A
 * @version 1.5
 */
public class LoginInExeption extends Exception {
	
	private static final long serialVersionUID = 1L;
	
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
		
		return super.fillInStackTrace();
	}
	@Override
	public void printStackTrace() {
		
		super.printStackTrace();
	}
	@Override
	public String toString() {
		return getMessage();
	}
}
