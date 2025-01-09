import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static List<Flower> flowers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flowers.add(new Flower(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        flowers.sort(((o1, o2) -> {
            if (o1.startMonth == o2.startMonth) {
                if (o1.startDate == o2.startDate) {
                    if (o1.endMonth == o2.endMonth) {
                        return o1.endDate - o2.endDate;
                    } else {
                        return o1.endMonth - o2.endMonth;
                    }
                } else {
                    return o1.startDate - o2.startDate;
                }
            }
            return o1.startMonth - o2.startMonth;
        }));
        int currentMonth = 3, currentDate = 1; // 시작 날짜
        int endMonth = 11, endDate = 30; // 종료 날짜
        int maxEndMonth = 3, maxEndDate = 1; // 선택한 꽃들의 종료일 중 가장 늦은 날짜
        int index = 0; // flowers 리스트의 인덱스
        while (currentMonth < endMonth || (currentMonth == endMonth && currentDate <= endDate)) {
            boolean found = false;

            // 현재 구간에서 가장 긴 꽃 찾기
            while (index < flowers.size()) {
                Flower flower = flowers.get(index);
                if (flower.startMonth > currentMonth ||
                        (flower.startMonth == currentMonth && flower.startDate > currentDate)) {
                    break;
                }

                // 가장 늦게까지 피어있는 꽃 선택
                if (flower.endMonth > maxEndMonth ||
                        (flower.endMonth == maxEndMonth && flower.endDate > maxEndDate)) {
                    maxEndMonth = flower.endMonth;
                    maxEndDate = flower.endDate;
                    found = true;
                }
                index++;
            }

            if (!found) { // 덮을 수 없는 경우
                result = 0;
                break;
            }
            currentMonth = maxEndMonth;
            currentDate = maxEndDate;
            result++; // 선택한 꽃 수 증가
        }
        if (currentMonth < endMonth || (currentMonth == endMonth && currentDate < endDate)) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }

    private static class Flower {
        int startMonth;
        int startDate;
        int endMonth;
        int endDate;

        Flower(int startMonth, int startDate, int endMonth, int endDate) {
            this.startMonth = startMonth;
            this.startDate = startDate;
            this.endMonth = endMonth;
            this.endDate = endDate;
        }
    }
}