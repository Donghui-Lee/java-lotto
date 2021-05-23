package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.domain.generator.LottosGenerator;

public class LottoMachine {
    private final List<Lotto> lottos;

    private LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoMachine of(LottosGenerator generator, Money money) {
        return new LottoMachine(generator.generate(money));
    }

    public static LottoMachine of(List<Lotto> lottos) {
        return new LottoMachine(lottos);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoWin result(Lotto winLotto) {
        LottoWin lottoWin = new LottoWin();
        List<LottoNumber> lottoNumbers = winLotto.lottoNumbers();

        lottos.forEach(lotto -> {
            int matchCount = lotto.match(lottoNumbers);
            lottoWin.hit(matchCount);
        });
        return lottoWin;
    }
}
