import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {

	@Test
	public void rover_direction_postion_init() {
		Rover rover = new Rover();
		rover.setPosition(1, 2, Rover.N);

		// position check
		assertEquals(Integer.valueOf(1), Integer.valueOf(rover.x));
		assertEquals(Integer.valueOf(2), Integer.valueOf(rover.y));

		// direction check
		assertEquals(Integer.valueOf(Rover.N), Integer.valueOf(rover.facing));

	}

	@Test
	public void rover_move() {
		Rover rover = new Rover();
		rover.setPosition(1, 2, Rover.N);

		rover.process("LM");
		rover.printPosition();

		// moves 1 grid from North direction - current coordinate (0,2,W)
		assertEquals(getDirection(rover), 'W');
		assertEquals(Integer.valueOf(0), Integer.valueOf(rover.x));
		assertEquals(Integer.valueOf(2), Integer.valueOf(rover.y));
	}

	@Test
	public void rover_move_to_new_coordinate() {
		Rover rover = new Rover();
		rover.setPosition(1, 2, Rover.N);
		rover.process("LMLMLMLMM");
		rover.printPosition();

		// moves 1 grid from North direction - current coordinate (1,3,N)
		assertEquals(getDirection(rover), 'N');
		assertEquals(Integer.valueOf(1), Integer.valueOf(rover.x));
		assertEquals(Integer.valueOf(3), Integer.valueOf(rover.y));
	}

	private char getDirection(Rover rover) {
		char dir = 'N';
		if (rover.facing == 1) {
			dir = 'N';
		} else if (rover.facing == 2) {
			dir = 'E';
		} else if (rover.facing == 3) {
			dir = 'S';
		} else if (rover.facing == 4) {
			dir = 'W';
		}
		return dir;
	}
}
