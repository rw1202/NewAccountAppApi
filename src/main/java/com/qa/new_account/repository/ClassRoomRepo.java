package com.qa.new_account.repository;

public interface ClassRoomRepo {

	String getAllRooms();

	String addRoom(String Account);

	String deleteRoom(Long Id);

	String getRoom(Long Id);

	String updateRoom(Long Id, String account);

	


}
