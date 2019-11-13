package saru.domain

import java.util.*

class Ladder(private val lines: List<Line>) {

    private val rotateNum: Int
        get() = (lines[0].pointsLength + 1) / 2

    fun climbLadder(): List<Int> {
        return loopClimbLadderProc()
    }

    private fun loopClimbLadderProc(): List<Int> {
        val result = ArrayList<Int>()

        for (i in 0 until rotateNum) {
            // 0, 2, 4... 순서로 구한다.
            var pos = Position(0, i * 2)
            pos = loopMovePosProc(pos)
            result.add(pos.column)
        }

        return result
    }

    private fun loopMovePosProc(pos: Position): Position {
        var returnPos = pos
        // 라인의 끝인지
        while (!checkEndRow(returnPos.row)) {
            returnPos = movePos(returnPos)
        }

        return returnPos
    }

    private fun movePos(pos: Position): Position {
        return when (checkDir(pos.row, pos.column)) {
            LadderDir.LEFT -> moveLeftDown(pos)
            LadderDir.RIGHT -> moveRightDown(pos)
            else -> pos.moveDown()
        }
    }

    private fun moveRightDown(pos: Position): Position {
        return pos.moveRightDown()
    }

    private fun moveLeftDown(pos: Position): Position {
        return pos.moveLeftDown()
    }

    private fun checkEndRow(rowIndex: Int): Boolean {
        return this.lines.size == rowIndex
    }

    private fun checkDir(nowLine: Int, nowColumn: Int): LadderDir {
        val line = lines[nowLine]

        // 어디로 갈지 판단
        if (line.checkSpecificPointHasLine(nowColumn - 1))
            return LadderDir.LEFT

        return if (line.checkSpecificPointHasLine(nowColumn + 1)) LadderDir.RIGHT else LadderDir.DOWN

    }

    private enum class LadderDir {
        LEFT,
        RIGHT,
        DOWN
    }
}

