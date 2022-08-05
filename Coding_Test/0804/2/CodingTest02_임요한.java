//단순 String로 정렬하는 방법 외에는 생각나질 않았습니다..
//사실상 틀린 문제같습니다.

import java.util.Objects;
import java.util.stream.IntStream;

class CodingTest02_임요한 {
    public int[] solution(int n) {

        return IntStream.range(1, n+1)
                .mapToObj(Objects::toString)
                .sorted().mapToInt(Integer::parseInt)
                .toArray();
    }
}