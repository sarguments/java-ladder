package saru;

import org.junit.*;

import saru.domain.LadderGame;
import saru.domain.Line;
import saru.view.LadderInput;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LadderGameTest {
    private static LadderInput ladderInput = new LadderInput();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lineTest() {
        Line line = new Line(10);
        ArrayList<Boolean> pointsList = line.getPoints();
        int size = pointsList.size();
        assertThat(size, is(10));

        // Line 객체에서 왼쪽에 이미 선이 있는 경우 못 그리는지
        pointsList.set(1, true); // 첫째 컬럼 선이 있다고 가정

        assertFalse(line.checkPointHasInterLine(3)); // 그 다음줄에 생성 불가능
        assertTrue(line.checkPointHasInterLine(5)); // 생성 가능
    }

    @Test
    public void middlLineTest() {
        Line line = new Line(10);
        ArrayList<Boolean> pointsList = line.getPoints();

        // Line 객체에서 왼쪽에 이미 선이 있는 경우 못 그리는지
        pointsList.set(3, true);

        assertFalse(line.checkPointHasInterLine(5)); // 그 다음줄에 생성 불가능
        assertTrue(line.checkPointHasInterLine(7)); // 생성 가능
    }

    @Test
    public void inputTextCheck() {
        // 글자 길이에 따른 체크 기능 테스트
        String[] strArr = {"pobiii", "honux", "jk"};
        assertFalse(ladderInput.checkValid(strArr, 10));

        String[] strArr2 = {"pobi", "honux", "jk"};
        assertTrue(ladderInput.checkValid(strArr2, 10));
    }

    @Test
    public void ladderCreate() {
        // 사다리게임 초기화 시 높이와 폭이 제대로 맞게 생성이 되는지 테스트
        String[] strArr = {"pobi", "honux", "jk"};
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strArr));

        LadderGame ladderGame = new LadderGame(10, strArr);

        assertThat(ladderGame.getNames().get(0), is(strList.get(0)));
        assertThat(ladderGame.getLadderLines().size(), is(10));
        assertThat(ladderGame.getLadderLines().get(0).getPoints().size(), is(5));
    }
}