package saru;

import org.junit.*;

import saru.domain.*;
import saru.view.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LadderGameTest {
    private static LadderInput ladderInput = new LadderInput();
    private Line line;
    private ArrayList<Boolean> pointsList;

    @Before
    public void setUp() throws Exception {
        line = new Line(10);
        pointsList = line.getPoints();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkColumnSize() {
        int size = pointsList.size();
        assertThat(size, is(10));
    }

    // Line 객체에서 왼쪽에 이미 선이 있는 경우 못 그리는지
    @Test
    public void checkIsExistLineAfterFirstColumn() {
        pointsList.set(1, true); // 첫째 컬럼 선이 있다고 가정
        assertTrue(line.checkPointHasInterLine(5)); // 생성 가능
    }

    @Test
    public void checkIsExisNotLineAfterFirstColumn() {
        pointsList.set(1, true);
        assertFalse(line.checkPointHasInterLine(3)); // 그 다음줄에 생성 불가능
    }

    @Test
    public void checkIsExistLineAfterSecondColumn() {
        pointsList.set(3, true); // 둘째 컬럼 선이 있다고 가정
        assertTrue(line.checkPointHasInterLine(7)); // 생성 가능
    }

    @Test
    public void checkIsNotExistLineAfterSecondColumn() {
        pointsList.set(3, true);
        assertFalse(line.checkPointHasInterLine(5)); // 그 다음줄에 생성 불가능
    }

    // 글자 길이에 따른 체크 기능 테스트
    @Test
    public void inputTextCheckSuccess() {
        String[] strArr2 = {"pobi", "honux", "jk"};
        assertTrue(ladderInput.checkValid(strArr2, 10));
    }

    @Test
    public void inputTextCheckFail() {
        String[] strArr = {"pobiii", "honux", "jk"};
        assertFalse(ladderInput.checkValid(strArr, 10));
    }

    // 사다리게임 초기화 시 높이와 폭이 제대로 맞게 생성이 되는지 테스트
    @Test
    public void ladderCreate() {
        List names = Arrays.asList("pobi", "honux", "jk");
        String[] strArr = (String[]) names.toArray();

        LadderGame ladderGame = new LadderGame(10, strArr);

        assertThat(ladderGame.getNames().get(0), is(names.get(0)));
        assertThat(ladderGame.getLadderLines().size(), is(10));
        assertThat(ladderGame.getLadderLines().get(0).getPoints().size(), is(5));
    }
}