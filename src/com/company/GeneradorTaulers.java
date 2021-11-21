package com.company;

public class GeneradorTaulers {
    private int boardSize;
    private int row;
    private int column;
    private int fixedSize;
    private final String X_CHAR_EDGE= "-";
    private final String Y_CHAR_EDGE= "|";
    private final String whiteChess= " ";
    private final String blackChess= "#";
    private final int DEFAULT_SPACE = 1;


    public void init(int boardSize){
        this.boardSize = 8 * boardSize;
        this.row = 0;
        this.fixedSize = this.boardSize/8;
    }

    private String printRow(boolean isEdge) {
        return Y_CHAR_EDGE + createRow(isEdge) + Y_CHAR_EDGE + "\n";
    }

    private String createRow(boolean isEdge) {
        StringBuilder m = new StringBuilder();
        int currentSpace = this.DEFAULT_SPACE;
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
            }else if (currentSpace == getFixedSpace()){
                nextColumn();
                i++;
                currentSpace = 1;
            }else{
                currentSpace++;
            }
        }

        return m.toString();
    }

    public void print() {
        StringBuilder board = new StringBuilder();

        board.append(printRow(true));
        int currentSpace = this.DEFAULT_SPACE;
        int i = 0;
        while(i < boardSize){

            board.append(printRow(false));

            if (currentSpace == getFixedSpace()){
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

    public int getFixedSpace() {
        return fixedSize;
    }

    public int getRow() {
        return row;
    }
}

