public class PieceHandler {
    public static boolean promote(int xPos, int yPos, String promotionPiece, Piece[][] board) {
        promotionPiece = promotionPiece.toLowerCase().trim();
        if (board[yPos][xPos] != null) {

            if (board[yPos][xPos] instanceof WhitePiece) {
                switch (promotionPiece) {
                    case "knight":
                        board[yPos][xPos] = new WhiteKnight(xPos, yPos, true, board);
                        break;
                    case "rook":
                        board[yPos][xPos] = new WhiteRook(xPos, yPos, true, board);
                        break;
                    case "bishop":
                        board[yPos][xPos] = new WhiteBishop(xPos, yPos, true, board);
                        break;
                    case "queen":
                    default:
                        board[yPos][xPos] = new WhiteQueen(xPos, yPos, true, board);
                        break;
                }
                return true;
            } else if (board[yPos][xPos] instanceof BlackPiece) {
                switch (promotionPiece) {
                    case "knight":
                        board[yPos][xPos] = new BlackKnight(xPos, yPos, true, board);
                        break;
                    case "rook":
                        board[yPos][xPos] = new BlackRook(xPos, yPos, true, board);
                        break;
                    case "bishop":
                        board[yPos][xPos] = new BlackBishop(xPos, yPos, true, board);
                        break;
                    case "queen":
                    default:
                        board[yPos][xPos] = new BlackQueen(xPos, yPos, true, board);
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean castleKingSide(String player, Piece[][] board) {

        player = player.toLowerCase().trim();

        if (player.equals("white") && board[0][4] != null && board[0][7] != null) {
            if ((board[0][4] instanceof WhiteKing) && (board[0][7] instanceof WhiteRook)
                    && (board[0][5] == null) && (board[0][6] == null)) {
                if (!board[0][4].checkHasMoved() && !board[0][7].checkHasMoved()) {
                    board[0][4] = null;
                    new WhiteRook(5, 0, true, board);
                    new WhiteKing(6, 0, true, board);
                    board[0][7] = null;
                }
            }
        } else if (player.equals("black") && board [7][4] != null && board [7][7] != null) {
            if ((board[7][4] instanceof BlackKing) && (board[7][7] instanceof BlackRook)
                    && (board[7][5] == null) && (board[7][6] == null)) {

                if (!board[7][4].checkHasMoved() && !board[7][7].checkHasMoved()) {
                    board[7][4] = null;
                    new BlackRook(5, 7, true, board);
                    new BlackKing(6, 7, true, board);
                    board[7][7] = null;
                }
            }
        }

        return false;
    }

}
