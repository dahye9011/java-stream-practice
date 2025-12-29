package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import problem.hard.resources.Order;

public class Problem86 {

    /**
     * 주어진 주문(Order) 리스트에서 각 제품별 판매된 총 수량을 계산합니다.
     *
     * @param orders 주문 리스트
     * @return 제품별 판매된 총 수량
     */
    public static Map<String, Integer> calculateTotalQuantitySoldByProduct(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getProduct().getName(),
                        Collectors.summingInt(Order::getQuantity)
                ));
    }
}
