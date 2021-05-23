package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;

public class LottoMachineTest {

    List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void init() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(1, 7).forEach(i -> {
            lottoNumbers.add(LottoNumber.of(i));
        });
        lottos.add(new Lotto(lottoNumbers));
    }

    @ParameterizedTest(name = "결과 테스트")
    @CsvSource(value = {"1,2,3,10,11,12:5000", "1,2,3,4,11,12,3:50000", "1,2,3,4,5,11:1500000", "1,2,3,4,5,6:2000000000"}, delimiter = ':')
    public void result(String inputs, long expcted) {
        // given
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Lotto winLotto = new Lotto(inputs.split(","));

        // when
        LottoMachine lottoMachine = LottoMachine.of(lottos);
        long sum = lottoMachine.result(winLotto).sum();

        // then
        assertThat(sum).isEqualTo(expcted);
    }
}
