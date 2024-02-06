package basic.experiments.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Names {
	
	List<String> female;
	List<String> male;
	List<String> surnames;

}
