package com.company;

public class GeneradorTaulers {
    private int boardSize;
    private int row;
    private int column;
    private int cellSize;
    private final String X_CHAR_EDGE= "-";
    private final String Y_CHAR_EDGE= "|";
    private final String whiteChess= " ";
    private final String blackChess= "#";
    private final int DEFAULT_CELL_SPACE = 1;


    public void init(int sizeInput){
        this.boardSize = 8 * sizeInput;
        this.row = 0;
        this.cellSize = sizeInput;
    }

    public void print() {
        StringBuilder board = new StringBuilder();
        board.append(printRow(true));
        int currentSpace = this.DEFAULT_CELL_SPACE;
        int i = 0;
        while(i < boardSize){

            board.append(printRow(false));

            if (currentSpace == getCellSpace()){
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
        int currentSpace = this.DEFAULT_CELL_SPACE;
        int i = 0;
        int size = isEdge == true?getBoardSize():8;
        while (i < size){

            if (isEdge){
                m.append(X_CHAR_EDGE);
            }else if (getRow()%2 == 0){
                m.append(getColumn()%2 == 0?whiteChess:blackChess);
            }else{
                m.append(getColumn()%2 == 0?blackChess:whiteChess);
            }

            if(isEdge){
                i++;
            }else if (currentSpace == getCellSpace()){
                nextColumn();
                i++;
                currentSpace = 1;
            }else{
                currentSpace++;
            }
        }

        return m.toString();
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

    public int getColumn() {
        return column;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getCellSpace() {
        return cellSize;
    }

    public int getRow() {
        return row;
    }
}

