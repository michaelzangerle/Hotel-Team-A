package projekt.fhv.teama.view;

public class NotEnoughRoomsException extends Exception {
	private int roomsRequired;
	
	
	public NotEnoughRoomsException(int roomsRequired) {
		this.roomsRequired = roomsRequired;
	}


	public int getRoomsRequired() {
		return roomsRequired;
	}
}
