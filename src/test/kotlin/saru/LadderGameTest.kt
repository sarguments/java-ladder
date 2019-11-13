package saru

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import saru.domain.Ladder
import saru.domain.LadderGame
import saru.domain.Line
import saru.view.LadderInput
import java.util.*

class LadderGameTest {
    private var line: Line? = null
    private var pointsList: MutableList<Boolean>? = null

    @Before
    fun setUp() {
        line = Line(10)
        pointsList = line!!.getPoints()
    }

    @Test
    fun checkColumnSize() {
        val size = pointsList!!.size
        assertThat(size, `is`(10))
    }

    // Line 객체에서 왼쪽에 이미 선이 있는 경우 못 그리는지
    @Test
    fun checkIsExistLineAfterFirstColumn() {
        pointsList!![1] = true // 첫째 컬럼 선이 있다고 가정
        assertTrue(line!!.checkPointHasLeftLine(5)) // 생성 가능
    }

    @Test
    fun checkIsNotExistLineAfterFirstColumn() {
        pointsList!![1] = true
        assertFalse(line!!.checkPointHasLeftLine(3)) // 그 다음줄에 생성 불가능
    }

    @Test
    fun checkIsExistLineAfterSecondColumn() {
        pointsList!![3] = true // 둘째 컬럼 선이 있다고 가정
        assertTrue(line!!.checkPointHasLeftLine(7)) // 생성 가능
    }

    @Test
    fun checkIsNotExistLineAfterSecondColumn() {
        pointsList!![3] = true
        assertFalse(line!!.checkPointHasLeftLine(5)) // 그 다음줄에 생성 불가능
    }

    // 글자 길이에 따른 체크 기능 테스트
    @Test
    fun inputTextCheckSuccess() {
        val strArr = arrayOf("pobi", "honux", "jk")
        val destination = arrayOf("꽝", "치킨", "햄버거")
        assertTrue(ladderInput.checkValid(strArr, destination, 10))
    }

    @Test
    fun inputTextCheckFail() {
        val strArr = arrayOf("pobiii", "honux", "jk")
        val destination = arrayOf("꽝", "치킨aaaa", "햄버거")
        assertFalse(ladderInput.checkValid(strArr, destination, 10))
    }

    // 사다리게임 초기화 시 높이와 폭이 제대로 맞게 생성이 되는지 테스트
    @Test
    fun ladderCreate() {
        val names = Arrays.asList("pobi", "honux", "jk")
        val destination = arrayOf("꽝", "치킨", "햄버거")
        val ladderGame = LadderGame(10, destination, names.toTypedArray() as Array<String>)

        assertThat(ladderGame.getUsers()[0].name, `is`<Any>(names[0]))
        assertThat(ladderGame.getLadderLines().size, `is`(10))
        assertThat(ladderGame.getLadderLines()[0].getPoints().size, `is`(5))
    }

    @Test
    fun ladderResult() {
        val lines = ArrayList<Line>()
        lines.add(Line(5))
        lines.add(Line(5))

        var pointList: MutableList<Boolean> = lines[0].getPoints()
        pointList[1] = true

        pointList = lines[1].getPoints()
        pointList[3] = true

        val ladder = Ladder(lines)
        val result = ladder.climbLadder()

        assertThat(result[0], `is`(4))
        assertThat(result[1], `is`(0))
        assertThat(result[2], `is`(2))
    }

    companion object {
        private val ladderInput = LadderInput()
    }
}