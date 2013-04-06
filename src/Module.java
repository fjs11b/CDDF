

abstract class Module {

	String modulecode;
	
	boolean loaded = false;
	String[] errors = {};
	/**
	 * Constructor
	 */
	Module(){
		
		this.setModuleCode("BASE");
	}
	
	/**
	 * Sets module code
	 * @param value
	 */
	void setModuleCode(String value){
		this.modulecode = value;
	}
	
	/**
	 * Returns module code
	 * @return String
	 */
	String getModuleCode(){
		return this.modulecode;
	}
	
	/**
	 * Sets if record was loaded
	 * @param value
	 */
	void setLoaded(boolean value){
		this.loaded = value;
	}
	
	/**
	 * Return true if information was loaded 
	 * @return
	 */
	boolean isLoaded(){
		return this.loaded;
	}
	
	/**
	 * Builds Module form
	 */
	void formEdit()
	{
		
		
		
	}//end method
	
	/**
	 * Build Module Display Form
	 */
	void formView()
	{	
	}
	
	/**
	 * This method should allow the user to search for a record
	 */
	void searchRecord(){

	}
	
	/**
	 * This method should be called on form validation prior to 
	 * storing the information.
	 * @return boolean
	 */
	boolean validateRecord(){
		return true;	
	}
	
	/**
	 * Loads default values to module.
	 * This should be called before the form
	 * is loaded in creation
	 */
	void initRecord(){
		
	}
	
	/**
	 * Reads storage and loads a record into object
	 * this method should be loaded with the information 
	 * to display in the form while modifiying
	 */
	void loadRecord(){
		
	}
	
	/**
	 * Writes record to permanent storage.
	 */
	void saveRecord(){
		
	}
	
	/**
	 * Just a method to debug
	 */
	void dump(){
		System.out.println("The debug method for Module: "+this.getModuleCode());
	}
}//end class
