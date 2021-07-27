package lotto.auto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        List<Integer> tickets = new ArrayList<>();
        rangeClosed(1, 6).forEach(i -> tickets.add(i));
        lottoGame = LottoGame.from(tickets);
    }

    @Test
    @DisplayName("반복자가 제대로 생성되는지 테스트 한다")
    void iterator() {
        Iterator<Integer> iterator = lottoGame.iterator();
        Assertions.assertThat(iterator).isNotNull()
                  .hasNext()
                  .toIterable()
                  .contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 한 게임에 번호 6개가 제대로 들어있는지 테스트 한다")
    void size() {
        int size = lottoGame.size();
        Assertions.assertThat(size).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 한 게임에 속한 번호들을 출력한다")
    void display() {
        String actual = lottoGame.toString();
        Assertions.assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
