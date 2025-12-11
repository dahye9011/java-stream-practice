package problem.medium;

import java.util.List;
import java.util.OptionalInt;
import problem.medium.resources.Customer2;
import problem.medium.resources.Order;

public class Problem55 {

    /**
     * 주어진 고객(Customer2) 리스트에서 'Bread' 제품을 가장 많이 주문한 고객의 이름을 반환합니다.
     * 동일한 수량을 주문한 고객이 여럿이면, 그 중 하나의 이름을 반환합니다.
     *
     * @param customers 고객 리스트
     * @return 'Bread' 제품을 가장 많이 주문한 고객의 이름
     */
    public static String getCustomerWhoOrderedMostBread(List<Customer2> customers) {
        return customers.stream()
                .max((c1, c2) ->
                        Integer.compare(
                                c1.getOrders().stream()
                                        .filter(order -> order.getProduct().equals("Bread"))
                                        .mapToInt(Order::getQuantity)
                                        .sum(),
                                c2.getOrders().stream()
                                        .filter(order -> order.getProduct().equals("Bread"))
                                        .mapToInt(Order::getQuantity)
                                        .sum()
                        )
                )
                .map(Customer2::getName)
                .orElse("");
    }
}
