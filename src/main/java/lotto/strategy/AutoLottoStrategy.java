package lotto.strategy;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static java.util.Collections.shuffle;
import static java.util.stream.IntStream.rangeClosed;

public class AutoLottoStrategy implements LottoRuleStrategy {
    private static final AutoLottoStrategy AUTO_LOTTO_STRATEGY = new AutoLottoStrategy();
    private static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        rangeClosed(1, 45).forEach(i -> NUMBERS.add(i));
    }

    private AutoLottoStrategy() {}

    public static AutoLottoStrategy getInstance() {
        return AUTO_LOTTO_STRATEGY;
    }

    @Override
    public Lotto ticketing() {
        shuffle(NUMBERS);
        return Lotto.from(new TreeSet<>(this.NUMBERS.subList(0, 6)));
    }
}
