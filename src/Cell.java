class Cell {
    int line;
    int col;
    CellType cellType;
    int distance = 0;
    boolean toCheck = true;

    public Cell(int line, int col, CellType cellType) {
        this.line = line;
        this.col = col;
        this.cellType = cellType;
    }
}
