package study.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Lotto {
    private TreeSet<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(List<LottoNumber> collect) {
        lottoNumbers = new TreeSet<>(collect);
    }

    public Lotto(String[] numbers) {
        for(String number : numbers) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(number.trim())));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public int match(List<LottoNumber> winInput) {
        int matchCount = lottoNumbers.stream()
            .mapToInt(number -> winInput.contains(number) ? 1 : 0).sum();
        return matchCount;
    }
}
