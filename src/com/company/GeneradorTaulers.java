package com.company;

public class GeneradorTaulers {
    private int boardSize;
    private int row;
    private int column;
    private int cellInputSize;
    private static final String X_CHAR_EDGE= "-";
    private static final String Y_CHAR_EDGE= "|";
    private static final String WHITE_CHESS= " ";
    private static final String BLACK_CHESS = "#";
    private static final int DEFAULT_CELL_SPACE = 1;
    private static final int NUM_OF_CELL_PER_LINE = 8;
    private static final int INIT_ROW_POSITION = 0;


    public void init(int sizeInput){
        this.boardSize = NUM_OF_CELL_PER_LINE * sizeInput;
        this.row = INIT_ROW_POSITION;
        this.cellInputSize = sizeInput;
    }

    public void print() {
        StringBuilder board = new StringBuilder();
        board.append(printRow(true));
        int currentSpace = DEFAULT_CELL_SPACE;
        int i = INIT_ROW_POSITION;
        while(i < boardSize){

            board.append(printRow(false));

            if (currentSpace == getCellInputSize()){
                nextRow();
                i++;
                currentSpace = DEFAULT_CELL_SPACE;
            }else{
                currentSpace++;
            }

        }

        board.append(printRow(true));
        System.out.println(board);
    }

    private String createRow(boolean isEdge) {
        StringBuilder m = new StringBuilder();
        int currentSpace = DEFAULT_CELL_SPACE;
        int i = INIT_ROW_POSITION;
        int size = getRowSize(isEdge);
        while (i < size){

            if (isEdge){
                m.append(X_CHAR_EDGE);
            }else if (isEven(getRow())){
                m.append(isEven(getColumn())? WHITE_CHESS : BLACK_CHESS);
            }else{
                m.append(isEven(getColumn())? BLACK_CHESS : WHITE_CHESS);
            }

            if(isEdge){
                i++;
            }else if (currentSpace == getCellInputSize()){
                nextColumn();
                i++;
                currentSpace = DEFAULT_CELL_SPACE;
            }else{
                currentSpace++;
            }
        }

        return m.toString();
    }

    private String printRow(boolean isEdge) {
        return Y_CHAR_EDGE + createRow(isEdge) + Y_CHAR_EDGE + "\n";
    }

    private boolean isEven(int n) {
        return n%2 == 0;
    }

    private int getRowSize(boolean isEdge) {
        return isEdge?getBoardSize():NUM_OF_CELL_PER_LINE;
    }



    private void nextRow(){
        this.row++;
    }

    private void nextColumn(){
        this.column++;
    }

    /**
     * GETTERS
     */

    public int getColumn() {
        return column;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getCellInputSize() {
        return cellInputSize;
    }

    public int getRow() {
        return row;
    }
}

