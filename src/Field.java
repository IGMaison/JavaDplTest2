import java.util.ArrayList;

class Field {

    Cell[][] fieldCells = new Cell[4][4];

    Field(String fieldString) throws ArrayIndexOutOfBoundsException {

        fieldString = fieldString.toUpperCase();

        if (fieldString.length() == 16) {
            char[] charArray = fieldString.toCharArray();

            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < 4; j++) {
                    try {
                        fieldCells[i][j] = new Cell(i, j, CellType.valueOf(String.valueOf(charArray[j + 4 * i])));
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Неверное описание поля: \"" +
                                charArray[j + 4 * i] + "\"");
                    }
                }
            }
        } else throw new ArrayIndexOutOfBoundsException("строка должна быть длиной 16 символов");
    }

    ArrayList<Cell> getNearest(Cell cell) {

        ArrayList<Cell> nearestCells = new ArrayList<>();
        int[][] nearestMatrix = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int i = 0; i < nearestMatrix.length; i++) {

            nearestMatrix[i] = new int[]{nearestMatrix[i][0] + cell.line, nearestMatrix[i][1] + cell.col};
        }

        for (int[] nrstCell : nearestMatrix) {

            if (nrstCell[0] >= 0 && nrstCell[0] < this.fieldCells.length &&
                    nrstCell[1] >= 0 && nrstCell[1] < this.fieldCells.length) {

                nearestCells.add(this.fieldCells[nrstCell[0]][nrstCell[1]]);
            }
        }
        return nearestCells;
    }
}
