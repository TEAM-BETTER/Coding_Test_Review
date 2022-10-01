package CodingTest19;

public class CodingTest5_김우진 {

    /**
     * 총 파일 종류는 4개 -> answer 배열길이는 4
     * strings[i]은 공백을 기준으로 split으로 나눠줌
     * tmp[0] 에는 파일종류, tmp[1]에는 용량
     * 조건문으로 확장자 확인 후 맞는 파일 종류에 따라 answer에 용량 더해줌
     */

    public int[] solution(String[] strings) {
        int[] answer = new int[4];
        String[] tmp = new String[2];

        for (int i = 0; i < strings.length; i++) {
            tmp = strings[i].split(" ", 2);
            tmp[1] = tmp[1].substring(0, tmp[1].length() - 1);

            if (tmp[0].contains("mp3") || tmp[0].contains("aac") || tmp[0].contains("flac")) {
                int sum = Integer.parseInt(tmp[1]);
                answer[0] += sum;
            } else if (tmp[0].contains("jpg") || tmp[0].contains("bmp") || tmp[0].contains("gif")) {
                int sum = Integer.parseInt(tmp[1]);
                answer[1] += sum;
            } else if (tmp[0].contains("mp4") || tmp[0].contains("avi") || tmp[0].contains("mkv")) {
                int sum = Integer.parseInt(tmp[1]);
                answer[2] += sum;
            } else {
                int sum = Integer.parseInt(tmp[1]);
                answer[3] += sum;
            }
        }
        return answer;
    }
}