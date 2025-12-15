package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import problem.medium.resources.Customer2;
import problem.medium.resources.Employee;
import problem.medium.resources.Product;

public class Problem60 {

    public static double calculateTotalPriceOfElectronicsOrderedByITEmployees(
            List<Customer2> customers,
            List<Employee> employees,
            List<Product> products) {

        Set<String> itEmployeeNames = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toSet());

        Map<String, Double> productPrices = products.stream()
                .collect(Collectors.toMap(Product::getName, Product::getPrice));

        return customers.stream()
                .filter(c -> itEmployeeNames.contains(c.getName()))
                .flatMap(c -> c.getOrders().stream())
                .filter(o ->
                        "Laptop".equals(o.getProduct())
                                || "Smartphone".equals(o.getProduct()))
                .mapToDouble(o ->
                        productPrices.get(o.getProduct()) * o.getQuantity())
                .sum();
    }
}
