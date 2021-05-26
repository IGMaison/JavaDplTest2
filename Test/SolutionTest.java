import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getResultTest() throws NoSuchFieldException, IllegalAccessException {

        assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "human"));
        assertEquals(6, Solution.getResult("PPPPPSSPPSSPPPPP", "HUMAN"));
        assertEquals(6, Solution.getResult("PPPPPPSPPSPPPPPP", "HumaN"));
        assertEquals(6, Solution.getResult("ppSSSPPSSSPPSSSP", "human"));
        assertEquals(12, Solution.getResult("wwwpttswwpppsttw", "Swamper"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getResultFieldErrTest() throws NoSuchFieldException, IllegalAccessException {

        assertEquals(12, Solution.getResult("qwwpttswwpppsttw", "Swamper"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getResultPeopleErrTest() throws NoSuchFieldException, IllegalAccessException {

        assertEquals(12, Solution.getResult("wwwpttswwpppsttw", "wamper"));
    }


    @Test
    public void FieldTest() {
        Field field = new Field("PPPPPSSPPSSPPPPP");
        assertNotNull(field);

        Cell cell_1 = new Cell(0, 3, CellType.S);
        Cell cell_2 = new Cell(3, 0, CellType.S);
        Cell cell_3 = new Cell(0, 0, CellType.S);
        Cell cell_4 = new Cell(3, 3, CellType.S);
        Cell cell_5 = new Cell(1, 1, CellType.S);
        ArrayList<Cell> cells1 = new ArrayList<>();
        cells1.add(field.fieldCells[0][2]);
        cells1.add(field.fieldCells[1][3]);
        ArrayList<Cell> cells2 = new ArrayList<>();
        cells2.add(field.fieldCells[2][0]);
        cells2.add(field.fieldCells[3][1]);
        ArrayList<Cell> cells3 = new ArrayList<>();
        cells3.add(field.fieldCells[0][1]);
        cells3.add(field.fieldCells[1][0]);
        ArrayList<Cell> cells4 = new ArrayList<>();
        cells4.add(field.fieldCells[2][3]);
        cells4.add(field.fieldCells[3][2]);
        ArrayList<Cell> cells5 = new ArrayList<>();
        cells5.add(field.fieldCells[0][1]);
        cells5.add(field.fieldCells[1][0]);
        cells5.add(field.fieldCells[1][2]);
        cells5.add(field.fieldCells[2][1]);
        assertArrayEquals(cells1.toArray(), field.getNearest(cell_1).toArray());
        assertArrayEquals(cells2.toArray(), field.getNearest(cell_2).toArray());
        assertArrayEquals(cells3.toArray(), field.getNearest(cell_3).toArray());
        assertArrayEquals(cells4.toArray(), field.getNearest(cell_4).toArray());
        assertArrayEquals(cells5.toArray(), field.getNearest(cell_5).toArray());


    }

    @Test
    public void PeopleTypeTest() {

        assertEquals(PeopleType.HUMAN.peopleClass, Human.class);
        assertEquals(PeopleType.SWAMPER.peopleClass, Swamper.class);
        assertEquals(PeopleType.WOODMAN.peopleClass, Woodman.class);
    }

    @Test
    public void PeopleSpeedTableTest() throws NoSuchFieldException, IllegalAccessException {

        StringBuilder speedTtable = new StringBuilder();

        for (PeopleType people : PeopleType.values()) {

            HashMap<CellType, Integer> speed =
                    (HashMap<CellType, Integer>) people.peopleClass.getDeclaredField("speed").get(null);

            for (char aChar : "SWTP".toCharArray()) {

                speedTtable.append(speed.get(CellType.valueOf(String.valueOf(aChar))));
            }
        }

        assertEquals("523122523322", speedTtable.toString());
    }
}