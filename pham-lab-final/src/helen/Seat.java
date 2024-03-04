package helen;

public abstract class Seat {
	private String row;
	private Integer seatNumber;
	
	public Seat(String row, Integer seatNumber) {
		this.row = row; 
		this.seatNumber = seatNumber;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
