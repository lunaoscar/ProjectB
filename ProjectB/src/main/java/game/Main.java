package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	private static RoomManager manager = new RoomManager(6);

	private static Player player = new Player();

	private static boolean running;

	public static void main(String[] args) {
		manager.init();

		running = true;

		System.out.println("Welcome Player! " + "In this game you will explore a famous Townhouse." + "\n"
				+ "To move on to the next room in the townhouse simply type 'go' follow by 'north,east,south,west'  depending "
				+ "where you would like to explore then press the enter button. " + "\n"
				+ "When you are done exploring all the rooms simply type 'quit' to exit the game. " + "\n"
				+ "Did you know this spacious townhome with access to a lake once belong to famous American actor Amy Sedaris! ");
		player.setCurrentRoom(manager.getStartingRoom());

		while (running) {
			printRoom();
			String[] input = collectInput();
			parse(input);
		}
		System.out.println("Thanks for Visiting!");
	}

	private static void printRoom() {
		System.out.println(":::: CURRENT ROOM ::::");
		System.out.println(player.getCurrentRoom());
	}

	private static String[] collectInput() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		String[] phrase = input.split(" ");
		return phrase;
	}

	private static void parse(String[] input) {
		String command = input[0].toLowerCase().intern();
		String direction = "";
		if (input.length > 1) {
			direction = input[1].toLowerCase().intern();
		}
		if (command == "go" || command == "move") {
			System.out.println("Moving: " + direction);
			Room move = player.getCurrentRoom().getExitByDirection(direction);
			player.setCurrentRoom(move);
		} else if (command == "quit" || command == "exit") {
			running = false;

		}

	}

}