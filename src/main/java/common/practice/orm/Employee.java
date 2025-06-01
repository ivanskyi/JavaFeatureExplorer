package common.practice.orm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Table(name = "employee")
public class Employee {

    @Id
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    private String lastName;

    private BigDecimal salary;
}
