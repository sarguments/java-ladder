package saru.domain

import java.util.*

class LadderGame(ladderHeight: Int, destination: Array<String>, nameArray: Array<String>) {

    private val users = ArrayList<User>()
    val destinations: MutableList<String> = mutableListOf()
    private val ladderLines = mutableListOf<Line>()
    var result: List<Int>? = null
        private set

    init {
        inputNames(nameArray)
        inputDestination(destination)
        initLadder(ladderHeight, nameArray.size)
        run()
    }

    private fun run() {
        result = Ladder(ladderLines).climbLadder()
    }

    fun getUsers(): List<User> {
        return users
    }

    fun getLadderLines(): List<Line> {
        return ladderLines
    }

    private fun inputNames(nameArr: Array<String>) {
        // TODO User 객체 생성
        for (aNameArr in nameArr) {
            users.add(User(aNameArr))
        }
    }

    private fun inputDestination(destination: Array<String>) {
        destinations.addAll(destination)
    }

    private fun initLadder(ladderHeight: Int, columnNum: Int) {
        val realColumnNum = getRealColumnNum(columnNum)
        for (i in 0 until ladderHeight) {
            ladderLines.add(Line(realColumnNum))
        }

        initLadderRowProc()
    }

    // 유저가 3명일 경우 5 (3 * 2 - 1) .. 식 자체를 상수화 하기는 어려울 것 같음.
    private fun getRealColumnNum(userNum: Int): Int {
        return userNum * 2 - 1
    }

    private fun initLadderRowProc() {
        for (ladderLine in ladderLines) {
            initLadderColumnProc(ladderLine)
        }
    }

    private fun initLadderColumnProc(colLine: Line) {
        for (i in 0 until colLine.pointsLength) {
            drawLineProc(colLine, i)
        }
    }

    private fun drawLineProc(colLine: Line, index: Int) {
        if (index % 2 == 1) {
            drawRowLine(colLine, index)
        }
    }

    private fun drawRowLine(colLine: Line, index: Int) {
        val randNum = LadderGameUtil.getRand(LIMIT)
        if (colLine.canDrawLine(randNum)) {
            colLine.drawPoint(index, true)
            return
        }

        colLine.drawPoint(index, false)
    }

    companion object {
        private const val LIMIT = 4
    }
}