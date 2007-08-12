package org.moreunit.preferences;

public interface PreferenceConstants {
	
	String PREF_JUNIT_PATH 						= "org.moreunit.junit_path";
	String PREF_JUNIT_PATH_DEFAULT 				= "junit";
	String SHOW_REFACTORING_DIALOG 				= "org.moreunit.show_refactoring_dialog";

	String	PREFIXES							= "org.moreunit.prefixes";
	String	SUFFIXES							= "org.moreunit.suffixes";
	String	USE_WIZARDS							= "org.moreunit.use_wizards";
	String	SWITCH_TO_MATCHING_METHOD			= "org.moreunit.switch_to_matching_method";
	String	TEST_PACKAGE_PREFIX					= "org.moreunit.package_prefix";
	String	TEST_PACKAGE_SUFFIX					= "org.moreunit.package_suffix";
	String	FLEXIBEL_TESTCASE_NAMING			= "org.moreunit.flexiblenaming";
	
	String TEST_TYPE							= "org.moreunit.test_type";
	String TEST_TYPE_VALUE_JUNIT_3				= "junit3";
	String TEST_TYPE_VALUE_JUNIT_4				= "junit4";
	String TEST_TYPE_VALUE_TESTNG				= "testng";
	
	boolean DEFAULT_CREATE_TESTNG				= false;
	String	DEFAULT_QUALIFIERS					= "Test";
	boolean	DEFAULT_USE_WIZARDS					= true;
	boolean	DEFAULT_SWITCH_TO_MATCHING_METHOD	= true;
	String	DEFAULT_TEST_PACKAGE_PREFIX			= "";
	String	DEFAULT_TEST_PACKAGE_SUFFIX			= "";
	boolean DEFAULT_FLEXIBLE_TESTCASE_NAMING	= false;
	String	DEFAULT_TEST_TYPE					= TEST_TYPE_VALUE_JUNIT_3;
}
