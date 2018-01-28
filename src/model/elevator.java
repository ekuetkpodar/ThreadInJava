package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * Elevator Program
 * 
 * @author Ekue Kpodar
 *
 */
public class elevator {
	private ArrayList<Integer> goingUp;
	private ArrayList<Integer> goingDown;
	private Thread wait;

	/**
	 * Create a New Elevator
	 * 
	 * @precondition none
	 * @postCondition a new Elevator is created with stair to stop loaded
	 * 
	 */
	public elevator() {
		this.goingUp = new ArrayList<Integer>();
		this.goingDown = new ArrayList<Integer>();
		wait = new Thread();
		this.FillAscendingFloor();
		this.FillDescendingFloor();
		
	}

	/**
	 * Print Element in the given array
	 * 
	 * @Pre numbers != null && numbers.size != 0
	 * @Post The Element in the array is printed out
	 * @param numbers
	 * @return true after printing
	 */
	public boolean printArrayList(ArrayList<Integer> numbers) {
		if (numbers == null || numbers.size() == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}

		System.out.println("******************");
		for (Integer current : numbers) {
			System.out.print(current + "\t");
		}

		System.out.println("\n");
		return true;
	}

	/**
	 * Filling The ELevator floor for the trip up
	 * 
	 * @Precondition none
	 * @Postcondition 8 Floor are filled for the trip up
	 * 
	 */
	private void FillAscendingFloor() {
		Random random = new Random();
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);

		while (num.size() <= 8) {
			int number = random.nextInt(11) + 1;

			if (!num.contains(number)) {
				num.add(number);
			}

		}

		this.printArrayList(num);
		Collections.sort(num);
		this.goingUp = num;
		this.printArrayList(this.goingUp);

	}

	/**
	 * Filling The ELevator floor for the trip down
	 * 
	 * @Precondition none
	 * @Postcondition 5 Floor are filled for the trip down
	 * 
	 */
	private void FillDescendingFloor() {
		Random random = new Random();
		ArrayList<Integer> num = new ArrayList<Integer>();

		while (num.size() <= 4) {
			int number = random.nextInt(11) + 1;

			if (!num.contains(number)) {
				num.add(number);
			}

		}

		this.printArrayList(num);

		Collections.sort(num);

		while (num.size() > 0) {
			int max = 100;
			int index = 0;
			int targer = -3;
			for (Integer current : num) {
				if (max > current) {
					targer = index;
				}
				index++;
			}
			this.goingDown.add(num.get(targer));
			num.remove(targer);

		}

		this.printArrayList(this.goingDown);

	}

	/**
	 * Print The information regarding the elevator trip up
	 * 
	 * @pre none
	 * @post information regarding the elevator trip up is printed
	 */
	public void goUp() {
		int index = 0;

		for (Integer current : goingUp) {
			try {
				wait.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (index <= 7 && index != 4) {
				int secondValue = index;
				secondValue++;
				String lineOne = String.format("Starting at floor %s", current);
				String lineTwo = String.format("   Going up: now at floor %s", goingUp.get(secondValue));
				String lineThree = String.format("Stopping at floor %s for 3 seconds 1, 2, 3 ",
						goingUp.get(secondValue));
				System.out.println(lineOne + "\n" + lineTwo + "\n" + lineThree);
			} else if (index == 4) {
				int other = 4;
				String lineOne = String.format("Starting at floor %s", current);
				String lineTwo = String.format("  Going Up: now at floor %s", goingUp.get(other++));
				String lineThree = String.format("  Going Up: now at floor %s", goingUp.get(other++));
				String lineFour = String.format("  Going Up: now at floor %s", goingUp.get(other++));
				String lineFive = String.format("Stopping at floor %s for 3 seconds  1, 2, 3 ", goingUp.get(7));
				System.out.println(lineOne + "\n" + lineTwo + "\n" + lineThree + "\n" + lineFour + "\n" + lineFive);
			} else {
				int other = 0;
				String lineOne = String.format("Starting at floor %s", current);
				String lineTwo = String.format("  Going down: now at floor %s", goingDown.get(0));
				String lineThree = String.format("  Going down: now at floor %s", goingDown.get(1));
				String lineFour = String.format("  Going down: now at floor %s", goingDown.get(2));
				String lineFive = String.format("Stopping at floor %s for 3 seconds  1, 2, 3 ", goingUp.get(2));
				System.out.println(lineOne + "\n" + lineTwo + "\n" + lineThree + "\n" + lineFour + "\n" + lineFive);
			}

			index++;
		}

	}

	/**
	 * Print The information regarding the elevator trip down
	 * 
	 * @pre none
	 * @post information regarding the elevator trip down is printed
	 */

	public void goDown() {
		int index = 0;
		for (Integer current : goingDown) {
			try {
				wait.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			int secondValue = index;
			switch (index) {
			case 0:
				String lineOne = String.format("Starting at floor %s", goingDown.get(index));
				String lineTwo = String.format("Going down: now at floor  %s", goingDown.get(secondValue++));
				String lineThree = String.format("Stopping at floor %s for 3 seconds  1, 2, 3 ",
						goingDown.get(secondValue));
				System.out.println(lineOne + "\n" + lineTwo + "\n" + lineThree);
				break;
			case 1:
			case 2:
				lineOne = String.format("Starting at floor %s", goingDown.get(index));
				lineTwo = String.format("Going down: now at floor  %s", goingDown.get(secondValue++));
				lineThree = String.format("Going down: now at floor  %s", goingDown.get(secondValue++));
				String lineFour = String.format("Going down: now at floor  %s", goingDown.get(secondValue++));
				secondValue--;
				secondValue--;
				String lineFive = String.format("Stopping at floor %s for 3 seconds  1, 2, 3 ",
						goingUp.get(secondValue));
				System.out.println(lineOne + "\n" + lineTwo + "\n" + lineThree + "\n" + lineFour);
				break;
			case 3:
				lineOne = String.format("Starting at floor %s", goingDown.get(index));
				lineTwo = String.format("Going down: now at floor  %s", goingDown.get(secondValue++));
				lineThree = String.format("Going down: now at floor  %s", goingDown.get(secondValue++));
				secondValue--;
				lineFour = String.format("Stopping at floor %s for 3 seconds  1, 2, 3 ", goingUp.get(secondValue));
				System.out.println(lineOne + "\n" + lineTwo + "\n" + lineThree + "\n" + lineFour);
				break;
			case 4:
				lineOne = String.format("Stopping at floor %s for 3 seconds  1, 2, 3 ", goingDown.get(index));
				System.out.println(lineOne);
				break;
			default:
				break;

			}
			index++;
		}
	}

}
