package saru.domain

class Position(val row: Int, val column: Int) {

    internal fun moveRightDown(): Position {
        return Position(this.row + 1, this.column + 2)
    }

    internal fun moveLeftDown(): Position {
        return Position(this.row + 1, this.column - 2)
    }

    internal fun moveDown(): Position {
        return Position(this.row + 1, this.column)
    }
}
