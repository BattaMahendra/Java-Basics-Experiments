package basic.experiments.basic.concepts;

/**
 * 
 * @author batta.chowdary
 * 
 * Enum may implement many interfaces but cannot extend any class because it internally extends Enum class
 *
 */
public enum FamilyEnum {
	/** 
	 * the constants of enum are by default static and final
	 * we can add values to this constants by having a constructor
	 */
	
	/**
	 * the below code is compiled as 
	 * public static final FamilyEnum FATHER = new FamilyEnum();
	 * this is the reason instance blocks and constructors are called even before the static blocks
	 * as static variables are loaded first
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
		System.out.println("Inside static block");
		FamilyEnum father = FamilyEnum.FATHER;
		System.out.println(father);
		
		// looping through enum values
		for(FamilyEnum f : FamilyEnum.values()) {
			System.out.println(f);
		}
		
		System.out.println("end of static block");
	}
	
	{
		System.out.println("hey , I am inside non static method");
	}
	
	/**
	 * up on running the application the constructor is always called for each constant , so 
	 * instance block executes every time constructor is clled
	 * 
	 */
	private FamilyEnum() {
		System.out.println("hey , I am inside NO ARGS CONSTRUCTOR and constant invoked is "+this.name());
		
	}
	/**
	 * 
	 *up on running the app this constructor will be called for constant utilizing this constructor
	 */
	private FamilyEnum(String role) {
		System.out.println("hey , I am inside ROLE ARGS CONSTRUCTOR and constant invoked is "+ this.name());
		this.role=role;
	}

	public static void main(String[] args) {
		System.out.println(GRANDPARENTS.role);
		
	}


}
