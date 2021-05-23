package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers)
            .map(number -> LottoNumber.of(number.trim()))
            .collect(toList()));
    }

    public Lotto(List<LottoNumber> collect) {
        lottoNumbers = new TreeSet<>(collect);
        validate();
    }

    private void validate() {
        if(lottoNumbers.size() != LOTTO_SIZE ) {
            throw new IllegalArgumentException("로또 번호 수는 6개 입니다.");
        }
    }

    public int match(List<LottoNumber> winInput) {
        return (int)lottoNumbers.stream()
            .filter(lottoNumber -> winInput.contains(lottoNumber))
            .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Lotto lotto = (Lotto)o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
