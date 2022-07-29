import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/*
* 떠올린 그리디 풀이: 가격이 큰거를 최대한 먹으면 가치 합이 크겠다 라고 생각을 했습니다.
* 고기를 누가 먹는지는 문제를 풀 때 아무런 영향이 없으므로 전체적인 stomach를 이용해 계산하는 방향으로 가닥을 잡았습니다.
* */
public class Solution {
    public int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;

        ArrayList<Food> foods = new ArrayList<>();

        for (int i = 0; i < amount.length; i++) {
            Food food = new Food(amount[i], value[i]);
            foods.add(food);
        }
        // value가 큰 순으로 먹기 위하여 정렬
        // 정렬기준은 Food의 compareTo 메소드에 작성 했습니다.
        Collections.sort(foods);

        int totalStomach = 0;
        for (int i = 0; i < stomach.length; i++) {
            totalStomach += stomach[i];
        }

        int people = stomach.length;

        // 갑어치가 가장 큰 고기는 모두 공평하게 먹어야 하기 때문에 따로 처리 했습니다.
        Food maxValueFood = foods.get(0);
        totalStomach -= maxValueFood.amount / people * people;
        answer += (maxValueFood.amount / people) * people * maxValueFood.value;

        for (int i = 1; i < foods.size(); i++) {
            Food curFood = foods.get(i);
            // 모두가 다 먹었다면 이미 최대이기 때문에 멈춥니다.
            if (totalStomach <= 0) break;

            // 현재 고기를 다 먹을 수 있다면 고기의 양과 고기의 가치를 더해줍니다.
            // 그리고 전체가 먹을 수 있는 양에서 고기의 양을 빼줍니다.
            if (curFood.amount <= totalStomach) {
                answer += curFood.amount * curFood.value;
                totalStomach -= curFood.amount;
            } else {
                // 고기를 다 먹을 수 없다면 totalStomach만큼만 먹어주고 0으로 만들어서 다음 반복때 자연스럽게 반복문이 종료됩니다.
                answer += curFood.value * totalStomach;
                totalStomach = 0;
            }
        }

        return answer;
    }
}

class Food implements Comparable<Food>{
    int amount;
    int value;

    public Food(int amount, int value) {
        this.amount = amount;
        this.value = value;
    }

    @Override
    public int compareTo(Food o) {
        return o.value - this.value;
    }
}