
import java.util.List;
import java.util.Scanner;

import controller.petHelper;
import model.Cat;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static petHelper petH = new petHelper();

	private static void addPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter a Name: ");
		String name = in.nextLine();
		System.out.print("Enter a Breed: ");
		String breed = in.nextLine();

		Cat toAdd = new Cat(name, breed);
		petH.insertPet(toAdd);

	}

	private static void deletePet() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the Breed to delete: ");
		String breed = in.nextLine();

		Cat toDelete = new Cat(name, breed);
		petH.deleteCat(toDelete);

	}

	private static void editPet() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Breed");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Cat> foundCats;
		if (searchBy == 1) {
			System.out.print("Enter the name: ");
			String catName = in.nextLine();
			foundCats = petH.searchForCatByName(catName);

		} else {
			System.out.print("Enter the breed: ");
			String catBreed = in.nextLine();
			foundCats = petH.searchForCatByBreed(catBreed);

		}

		if (!foundCats.isEmpty()) {
			System.out.println("Found Results.");
			for (Cat c : foundCats) {
				System.out.println(c.getId() + " : " + c.returnCatDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Cat toEdit = petH.searchForCatById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getBreed());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Breed");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Breed: ");
				String newBreed = in.nextLine();
				toEdit.setBreed(newBreed);
			}

			petH.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to my pets list! ---");
		while (goAgain) {
			System.out.println("*  Select an pet:");
			System.out.println("*  1 -- Add an pet");
			System.out.println("*  2 -- Edit an pet");
			System.out.println("*  3 -- Delete an pet");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addPet();
			} else if (selection == 2) {
				editPet();
			} else if (selection == 3) {
				deletePet();
			} else if (selection == 4) {
				viewTheList();
			} else {
				petH.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Cat> allPets = petH.showAllPets();
		for (Cat pet : allPets) {
			System.out.println(pet.returnCatDetails());
		}

	}

}
