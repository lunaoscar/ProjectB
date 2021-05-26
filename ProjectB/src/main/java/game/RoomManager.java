package game;

import fixtures.Room;

public class RoomManager {
	private Room startingRoom;
	
	private Room[] house;
	
	public RoomManager(int houseSize) {
		house = new Room[houseSize];
	}
	
	public void init() {
		Room entranceHall = new Room(
				"Entrance Hall",
				"A short hallway",
				"This small hallway is filled with large mirror and a large coat rack on the opposite side, the room feels tidy and organized. A dining room "
				+ "is open to the south, where a large table can be seen. The room to the north is the living room, where unique home decor can be seen." +
						"\n" + "The room to the north seems to be the living Room." + "\n" + "The room to the south seems to be the dining room." );
		
		this.house[0] = entranceHall;
		
		Room diningRoom = new Room(
				"Dining Room",
				"A large Dining Room",
				"This large dining Room has one table seated for 6. The room is well lit thanks to the large windows facing the room. You also see a large door"
				+ "that seems to lead outside. " +
				"\n" + "To the west seems to be the back yard.");
		this.house[1] = diningRoom;
		
		Room livingRoom = new Room(
				"Living Room",
				"A spacious room with a large telelvison in it.",
				"This room has a super comfortable couch a small coffe table and a large flat screen television. Mutliple large frames on the wall full of family photos."
				+ "\n" + "You see a brightly lit room to the north." + "\n" + "The room to the to the north seems to be the bedroom.");
		this.house[2] = livingRoom;
		
		Room bedRoom = new Room(
				"Bedroom",
				"Main bedroom",
				"Large bedroom with a large bed with lots of pillows on top of it. The room is well lit with the large floor to celing window in the room. Looking "
				+ "out the window you have a great view of the nearby lake!" + "\n" + "No other entrance to a new room here.");
		this.house[3] = bedRoom;
		
		Room backYard = new Room(
				"BackYard",
				"Limitless back yard.",
				"This outstanding backyard seems to expand forever with no end in sight. The sounds of the nearby lake can be heard out here. Looking at the garden "
				+ "one can tell that sun provides it with adequate sunlight." + "\n" + "Looking west one can spot the nearby by lake.");
		this.house[4] = backYard;
		
		Room lakeArea = new Room(
				"Lake area",
				"A great lake.",
				"This breath taking lake seems to calm any anxious thoughts. Looking east towards the townhouse you remeber that you left your camera at the entrancehall. It would be "
				+ "nice if you could get a picture of this stunning view up close." + "\n" + "Head east to return to the backyard.");
		this.house[5] = lakeArea;
		
		
		
		this.startingRoom = entranceHall;
		
		Room[] entranceHallExits = {livingRoom, diningRoom, null, null};
		entranceHall.setExits(entranceHallExits);
		

		diningRoom.setExitByIndex(entranceHall, 0);
		livingRoom.setExitByIndex(entranceHall, 1);
		
		
		Room[] diningRoomExits = {entranceHall,null,null,backYard};
		diningRoom.setExits(diningRoomExits);
		
		Room[] livingRoomExits = {bedRoom,entranceHall,null,null};
		livingRoom.setExits(livingRoomExits);
		
		
		Room[] backYardExits = {null,null,diningRoom,lakeArea};
		backYard.setExits(backYardExits);
		
		
		Room[] bedRoomExits = {null, livingRoom, null,null};
		bedRoom.setExits(bedRoomExits);
		
		Room[] lakeAreaExits = {null, null, backYard,null};
		lakeArea.setExits(lakeAreaExits);
		
		}
	
	
	
	public Room getRoom(int index) {
		if (index < 0) {
			System.out.println("I did not recognize that");
			return null;
		}
		return house[index];
		}
	public Room getRoom(String roomName) {
		int index = -1;
		for (int i = 0; i < house.length; i++) {
			if(roomName.toLowerCase() == house[i].getName().toLowerCase()) {
				index = i;
			}
		}
		return getRoom(index);
	}

	public Room getStartingRoom() {
		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}

	public Room[] getHouse() {
		return house;
	}

	public void setHouse(Room[] house) {
		this.house = house;
	}
	

}