package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.PersonalizadoException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		// PROGRAMAÇÃO DEFENSIVA, COLOCAR A CHECAGEM DA EXCEÇÃO NO INÍCIO
		// AQUI ESTAMOS CHECANDO NO MOMENTO DA INSTANCIAÇÃO DO OBJETO, NO CONSTRUTOR, SE OS DADOS SÃO VÁLIDOS
		if (!checkOut.after(checkIn)) {
			throw new PersonalizadoException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Reservation dates for update must be future dates");
			// ESSA É UMA EXCEÇÃO JÁ PADRÃO DO JAVA! 
		}
		if (!checkOut.after(checkIn)) {
			throw new PersonalizadoException("Check-out date must be after check-in date");
			// ESSA É UMA EXCEÇÃO QUE EU CRIEI!
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}
}