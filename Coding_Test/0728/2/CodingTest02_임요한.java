// solution 함수에서는 num의 자릿수만큼 for문을 돌리면서 각 자릿수에 있는 숫자 하나하나를 changeNum 메서드로 보냈습니다.
// changeNum 메서드는 num의 각 자리에 있는 숫자를 받아 해당 숫자의 index부터 마지막까지 위치를 바꿔가며 최댓값을 찾았습니다.
// linkNum 메서드는 String 배열로 쪼갰던 num을 다시 연결하여 숫자로 바꿔주는 부분을 담당했습니다.


class CodingTest02_임요한 {
    public int solution(int num) {
        int answer = 0;
        String str = String.valueOf(num);
        String[] arr = str.split(""); // num의 각 자리를 String 배열에 담았습니다.
        int idx = 0;    // num의 인덱스

        for (int i = 0; i < arr.length - 1; i++) {
            // 0번 인덱스부터 각 자릿수와 바꿔가며 최댓값을 찾는 changeNum
            int curNum = changeNum(arr, idx, str, num);
            idx++;
            answer = Math.max(answer , curNum);
        }
        return answer;
    }

    public int linkNum(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public int changeNum(String[] arr, int idx, String str, int num) {

        for (int i = 1; i < arr.length - idx; i++) {
            String tmp = arr[idx];
            arr[idx] = arr[idx+i];
            arr[idx+i] = tmp;
            num = Math.max(num, linkNum(arr)); // 배열의 각 숫자를 연결해주는 linkNum
            arr = str.split(""); // 한번만 교환 가능하므로 배열 초기화
        }
        return num;
    }
}