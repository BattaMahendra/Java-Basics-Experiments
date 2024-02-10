package basic.experiments.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
	
	String officeName;
	long pincode;
	String taluk;
	String districtName;
	String stateName;
	
}
