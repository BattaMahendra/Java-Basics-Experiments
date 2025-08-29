package basic.experiments.basic.concepts;

import java.util.EnumSet;

/**
 * 
 * @author batta.chowdary
 *
 * An enum in Java is a special data type that enables for a variable to be a set of predefined constants.
 * It's introduced in Java 5 and is implemented as a class type.
 *
 * Enum may implement many interfaces but cannot extend any class because it internally extends Enum class
 *
 */
public enum FamilyEnum {
	/** 
	 * the constants of enum are by default static and final
	 * Constructors in enums are always private by default
	 * we can add values to these constants by having a constructor
	 */
	
	/**
	 * the below code is compiled as 
	 * public static final FamilyEnum FATHER = new FamilyEnum();
	 * this is the reason instance blocks and constructors are called even before the static blocks
	 * as static variables are loaded first
	 */

	/*
	* Unlike public static final keywords the enum constants have added behaviour
	* 	1. It can have private methods(which can be overridden)
	* */

	FATHER{

		// here we are overriding the method description
		// if we don't override then default method is executed when it is called
		@Override
		public String description(){ return " Guardian and Provider of family";}
	},
	MOTHER,
	CHILDREN,

	//using different constructor to have values to this constant
	// here this sentence will go as private instance variable role
	GRANDPARENTS("the elder members and advisors of the family");
	
	private String role;

	/**
	 * 
	 * printing the constants of enum and also looping through them.
	 */

	// static block
	static {
		//printing specific constant
		System.out.println("Inside static block");
		FamilyEnum father = FamilyEnum.FATHER;
		System.out.println(father);
		
		// looping through enum values ( here we are using special method called values() )
		for(FamilyEnum e : FamilyEnum.values()) {
			System.out.println("Name of enum "+e+" is "+e.name());

			// ordinal() is special method in enum which prints 0 based index number of enums (chek out below result)
			System.out.println("Length of enum "+ e+ " is  "+ e.ordinal());

		}
		
		System.out.println("end of static block");
	}


	// instance block
	{
		System.out.println("hey , I am inside non static method");
	}
	
	/**
	 * Constructors in enums are always private by default
	 *
	 * up on running the application the constructor is always called for each constant , so 
	 * instance block executes every time constructor is clled
	 */
	// enum constructor - cannot be public or protected (they can private and package private)
	 FamilyEnum() {
		System.out.println("hey , I am inside NO ARGS CONSTRUCTOR and constant invoked is "+this.name());
		
	}
	/**
	 * 
	 *up on running the app this constructor will be called for constant utilizing this constructor
	 */
	private FamilyEnum(String role) {
		System.out.println("hey , I am inside ROLE ARGS CONSTRUCTOR and constant invoked is "+ this.name()+
				" and role is "+ role);
		this.role=role;
	}

	// enums can have normal methods as well and they can be overrided with constants
	public String description(){
		return "";
	}

	public static void main(String[] args) {
		System.out.println(GRANDPARENTS.role);

		System.out.println(FATHER.description());

		EnumSet<FamilyEnum> elderGroup = EnumSet.of(GRANDPARENTS);
		// we can also use EnumMap - learn about it in chatgpt



		
	}



}

/*
*
* Learn about EnumSet and EnumMap especially for enums
*
* Important tricky questions
*
* Can enums have mutable fields?
* Expected Answer: Yes, but it’s risky because constants should be immutable — otherwise they break the whole purpose of enums.
*
*
* Why is enum singleton considered better than normal singleton pattern?
* Expected Answer:
*		1. Thread-safe by default.
*		2. Guaranteed against reflection attacks.
*		3. Guaranteed against serialization attacks.
* */
