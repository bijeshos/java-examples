package io.github.bijeshos.javaexamples.streams;

import io.github.bijeshos.javaexamples.streams.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        StreamsDemo demo = new StreamsDemo();
        demo.startDemo();
    }


    public void startDemo() {
        collectorsOperations();
    }

    private void collectorsOperations() {
        List<Employee> employees = getEmployees();
        accumulateToList(employees);
        accumulateToSet(employees);
        join(employees);
        sum(employees);
        groupBy(employees);
        groupAndSum(employees);
        partitionBy(employees);
        // group by size
        /*Map<Long, List<FileMetadataDto>> fileSizeMap = metadataList.stream()
                                                                   .collect(Collectors.groupingBy(
                                                                           FileMetadataDto::getFileSize, TreeMap::new,
                                                                           Collectors.toList()));*/
        //keep only the ones  which are potential duplicates (by size)
        /*List<FileMetadataDto> filteredMetadataList = fileSizeMap.entrySet()
                                                                .stream()
                                                                .filter(entry -> entry.getValue()
                                                                                      .size() > 1)
                                                                .map(entry -> entry.getValue())
                                                                .flatMap(Collection::stream)
                                                                .sorted(Comparator.comparing(
                                                                        FileMetadataDto::getFileSize))
                                                                .collect(Collectors.toList());*/

        /*

        Map<Long, List<FileMetadataDto>> filteredMetadataMap = fileSizeMap.entrySet()
                                                                          .stream()
                                                                          .filter(entry -> entry.getValue()
                                                                                                .size() > 1)
                                                                          .collect(Collectors.toMap(
                                                                                  entry -> entry.getKey(),
                                                                                  entry -> entry.getValue()));

         filteredMetadataMap.forEach((key, value) -> updateDuplicateId(value));
         */
    }

    private void partitionBy(List<Employee> employees) {
        //example 7: Partition students into passing and failing
        Map<Boolean, List<Employee>> partitionBySalary = employees.stream()
                                                                  .collect(Collectors.partitioningBy(
                                                                          employee -> employee.getSalary() >= 50000));
        System.out.println("partition by salary: " + partitionBySalary);
    }

    private void groupAndSum(List<Employee> employees) {
        //example 6: Compute sum of salaries by department
        Map<Integer, Integer> totalSalaryByDept = employees.stream()
                                                           .collect(Collectors.groupingBy(Employee::getDepartmentId,
                                                                                          Collectors.summingInt(
                                                                                                  Employee::getSalary)));
        System.out.println("total by dept: " + totalSalaryByDept);
    }

    private void groupBy(List<Employee> employees) {
        //example 5: Group employees by department
        Map<Integer, List<Employee>> employeesByDept = employees.stream()
                                                                .collect(Collectors.groupingBy(
                                                                        Employee::getDepartmentId));
        System.out.println("employees by dept: " + employeesByDept);
    }

    private void sum(List<Employee> employees) {
        //example 4: Compute sum of salaries of employee
        int totalSalary = employees.stream()
                                   .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("total salary: " + totalSalary);
    }

    private void join(List<Employee> employees) {
        //example 3: Convert elements to strings and concatenate them, separated by commas
        String joinedLastNames = employees.stream()
                                          .map(Employee::getLastName)
                                          .collect(Collectors.joining(","));
        System.out.println("joined last names: " + joinedLastNames);
    }

    private void accumulateToSet(List<Employee> employees) {
        //example 2: Accumulate names into a TreeSet
        Set<String> nameSet = employees.stream()
                                       .map(Employee::getFirstName)
                                       .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("first name tree set: " + nameSet);
    }

    private void accumulateToList(List<Employee> employees) {
        //example 1: Accumulate names into a List
        List<String> firstNames = employees.stream()
                                           .map(Employee::getFirstName)
                                           .collect(Collectors.toList());
        System.out.println("first name list: " + firstNames);
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Raj", "M", "Kumar", 43, 10000, 1));
        employees.add(new Employee(2, "Abhinav", "M", "Patel", 43, 20000, 1));
        employees.add(new Employee(3, "Krishna", "M", "Patil", 43, 30000, 1));
        employees.add(new Employee(4, "Pavan", "M", "Chopra", 43, 40000, 1));
        employees.add(new Employee(5, "George", "M", "David", 43, 50000, 1));
        employees.add(new Employee(6, "Micheal", "M", "Hill", 43, 60000, 2));
        employees.add(new Employee(7, "Simon", "M", "Clayton", 43, 70000, 2));
        employees.add(new Employee(8, "David", "M", "King", 43, 80000, 2));
        employees.add(new Employee(9, "Bill", "M", "Prince", 43, 90000, 2));
        employees.add(new Employee(10, "George", "M", "King", 43, 100000, 2));
        return employees;
    }
}
