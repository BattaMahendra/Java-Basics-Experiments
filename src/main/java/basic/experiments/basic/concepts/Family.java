package basic.experiments.basic.concepts;

/**
 * 
 * @author batta.chowdary
 * 
 * Enum may implement many interfaces but cannot extend any class because it internally extends Enum class
 *
 */
public enum Family {
	/**
	 * the constants of enum are by default static and final
	 * we can add values to this constants by having a constructor
	 */

	FATHER,
	MOTHER,
	CHILDREN,
	//using different constructor to have values to this constant
	GRANDPARENTS("the elder members and advisors of the family");
	
	private String role;

	/**
	 * 
	 * printing the constants of enum and also looping through them.
	 */

	static {
		//printing specific constant
		Family father = Family.FATHER;
		System.out.println(father);
		
		// looping through enum values
		for(Family f : Family.values()) {
			System.out.println(f);
		}
	}
	
	{
		System.out.println("hey , I am inside non static method");
	}
	
	/**
	 * up on running the application the constructor is always called for each constant , so 
	 * instance block executes every time constructor is clled
	 * 
	 */
	private Family() {
		System.out.println("hey , I am inside NO ARGS CONSTRUCTOR and constant invoked is "+this.name());
		
	}
	/**
	 * 
	 *up on running the app this constructor will be called for constant utilizing this constructor
	 */
	private Family(String role) {
		System.out.println("hey , I am inside ROLE ARGS CONSTRUCTOR and constant invoked is "+ this.name());
		this.role=role;
	}

	public static void main(String[] args) {
		System.out.println(GRANDPARENTS.role);
		
	}


}
