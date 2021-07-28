package in.nareshit.raghu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
	@Column(name="eid")
	private Integer empId;
	
	@Column(
			name="ename",
			nullable = false, //do not accept null values
			unique = true, //do not accept duplicate values
			length = 12
			)
	private String empName;
	
	@Column(
			name="esal",
			nullable = false
			)
	private Double empSal;
	
	@Column(
			name="edept",
			nullable = false,
			length = 10
			)
	private String empDept;
	
	@Column(name="ehra")
	private Double empHra;
	
	@Column(name="eta")
	private Double empTa;
	
}
