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



    public void init(int sizeInput){
        this.boardSize = 8 * sizeInput;
        this.row = 0;
        this.cellInputSize = sizeInput;
    }

    public void print() {
        StringBuilder board = new StringBuilder();
        board.append(printRow(true));
        int currentSpace = DEFAULT_CELL_SPACE;
        int i = 0;
        while(i < boardSize){

            board.append(printRow(false));

            if (currentSpace == getCellInputSize()){
                nextRow();
                i++;
                currentSpace = 1;
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
        int i = 0;
        int size = getRowSize(isEdge);
        while (i < size){

            if (isEdge){
                m.append(X_CHAR_EDGE);
            }else if (getRow()%2 == 0){
                m.append(getColumn()%2 == 0?WHITE_CHESS: BLACK_CHESS);
            }else{
                m.append(getColumn()%2 == 0? BLACK_CHESS :WHITE_CHESS);
            }

            if(isEdge){
                i++;
            }else if (currentSpace == getCellInputSize()){
                nextColumn();
                i++;
                currentSpace = 1;
            }else{
                currentSpace++;
            }
        }

        return m.toString();
    }

    private int getRowSize(boolean isEdge) {
        return isEdge?getBoardSize():NUM_OF_CELL_PER_LINE;
    }

    private String printRow(boolean isEdge) {
        return Y_CHAR_EDGE + createRow(isEdge) + Y_CHAR_EDGE + "\n";
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

