package saru.domain

import java.util.*

class Line(columnNum: Int) {
    private val points: MutableList<Boolean>

    internal val pointsLength: Int
        get() = points.size

    init {
        points = ArrayList(columnNum)
        for (i in 0 until columnNum) {
            points.add(false)
        }
    }

    fun getPoints(): MutableList<Boolean> {
        return points
    }

    // 오른쪽 방향으로 진행하면서 왼쪽에 없으면 생성하도록
    fun checkPointHasLeftLine(index: Int): Boolean {
        if (index < 2) {
            // 1은 무조건 만들 수 있음
            return true
        }

        // 인덱스 범위 체크
        return if (index < points.size - 1) {
            // 기준 선 사이를 확인해야 하므로 - 2
            // 왼쪽에 선이 이미 있으면 false, 없으면 true
            !points[index - 2]
        } else false

        // 범위에 맞지 않으면 false
    }

    internal fun checkSpecificPointHasLine(index: Int): Boolean {
        // 인덱스 범위 체크
        return if (index < 0 || index > points.size - 1) {
            false
        } else points[index]

    }

    internal fun canDrawLine(randNum: Int): Boolean {
        return randNum == 1
    }

    internal fun drawPoint(index: Int, isLine: Boolean) {
        // 범위가 잘못 되었거나 왼쪽에 선이 이미 있을 경우 그냥 return
        if (!checkPointHasLeftLine(index)) {
            return
        }

        points[index] = isLine
    }
}
