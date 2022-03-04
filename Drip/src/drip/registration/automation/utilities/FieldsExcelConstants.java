package drip.registration.automation.utilities;

import java.util.LinkedHashMap;

public class FieldsExcelConstants {

	public static final String FIELD_TYPE_TEXTBOX = "input";
	public static final String FIELD_TYPE_DROPDOWN = "select";

	public static final String EXCEL_FILE_PATH = "E:\\Drip_Irrigation";
	public static final String EXCEL_FILE_NAME = "DripRegistation.xlsx";
	public static final String EXCEL_FILE_FULL_PATH = EXCEL_FILE_PATH + "\\" + EXCEL_FILE_NAME;
	public static final String EXCEL_FILE_WORKSHEET_NAME = "Registration";

	public static final String EXCEL_EXTENSION_XLS = ".xls";
	public static final String EXCEL_EXTENSION_XLSX = ".xlsx";
	
	public static final String SURVEY_FORM_ADD_MORE_BUTTON_ID = "add_more_land";

	public static final String[] FIELDS_IDS_LIST = { "txtAadhar", "ddl_farmer_type", "ddlRegisteredBy", "ddlDepartment",
			"ddlMiCompany", "ddlLandOwnership", "ddlDistrict", "ddlBlock", "ddlVillage", "txtFarmerName",
			"txtFarmerMobile", "txtEmail", "ddlGender", "txtLandOwnerFatherName", "ddlSocialStatus", "txtLeaseRegNo",
			"txtRationCard", "ddlCropType", "ddlCropLandType", "ddlMiType", "txtSurveyNo", "txtSubDivisionNo",
			"txtTotalLandArea", "txtTotalMiLandArea", "ddlPrimaryCrop", "ddlInterCrop", "ddlMiCropType",
			"ddlCropSpacing", "txtMIArea", "ddlWaterSource", "ddlPowerSource", "ddlFig", "txtAccountName",
			"txtAccountNo", "ddlBank", "txtBranchName", "txtIfsc", "fl_passbook", "fl_farmer_photo", "fl_aadhar_photo",
			"fl_rc_photo", "fl_cc_photo", "fl_ac_photo", "fl_fmp_photo", "fl_wt_photo", "fl_sfmf_photo" };

	public static final String[] FIELDS_LABEL_LIST = { "Aadhaar ID Number", "Farmer Type", "Registered By",
			"Department", "MI Company", "Land Ownership", "District", "Block", "Village", "Farmer Name",
			"Mobile Number", "Email Id", "Gender", "Land Owner", "Social Status", "Ration Card Number", "Crop Type",
			"Crop / Land Type", "MI Type", "Survey Number", "Sub Division Number", "Total Land Area (Ha)",
			"Planned MI Area (Ha)", "Primary Crop", "Inter Crop", "Mi Crop", "Crop Spacing", "MI Area Splitup (Ha)",
			"Water Source", "Source of Power", "FIG/FPG/FPO/Others", "Account Holder Name", "Account Number",
			"Bank Name", "Branch Name", "Ifsc Code", "Passbook_photo", "Farmer_photo", "Aadhaar_photo",
			"RationCard_photo", "Chitta_photo", "Adangal_photo", "FMB_photo", "WaterSoilTest_photo", "SFMF_photo" };

	public static final String[] FIELDS_FOR_FILE_UPLOAD = { "Passbook_photo", "Farmer_photo", "Aadhaar_photo",
			"RationCard_photo", "Chitta_photo", "Adangal_photo", "FMB_photo", "WaterSoilTest_photo", "SFMF_photo" };

	public static final LinkedHashMap<String, FIELDS> FIELDS_MAP = createFieldsMap();
	
	public static final LinkedHashMap<String, FIELDS> FORMER_FORM_FIELDS_MAP = createFormerFieldsMap();
	public static final LinkedHashMap<String, FIELDS> LAND_FORM_FIELDS_MAP = createLandFieldsMap();
	public static final LinkedHashMap<String, FIELDS> SURVEY_FORM_FIELDS_MAP = createSurveyFieldsMap();
	public static final LinkedHashMap<String, FIELDS> CROP_FORM_FIELDS_MAP = createCropFieldsMap();
	public static final LinkedHashMap<String, FIELDS> ACCOUNT_FORM_FIELDS_MAP = createAccountFieldsMap();
	public static final LinkedHashMap<String, FIELDS> DOCUMENT_FORM_FIELDS_MAP = createDocumentProofFieldsMap();

	private static LinkedHashMap<String, FIELDS> createFieldsMap() {

		LinkedHashMap<String, FIELDS> fieldsMap = new LinkedHashMap<String, FIELDS>();

		// FORMER DETAILS fields
		fieldsMap.put("Aadhaar ID Number", new FIELDS("txtAadhar", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Farmer Type", new FIELDS("ddl_farmer_type", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Registered By", new FIELDS("ddlRegisteredBy", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Department", new FIELDS("ddlDepartment", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("MI Company", new FIELDS("ddlMiCompany", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Land Ownership", new FIELDS("ddlLandOwnership", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("District", new FIELDS("ddlDistrict", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Block", new FIELDS("ddlBlock", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Village", new FIELDS("ddlVillage", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Farmer Name", new FIELDS("txtFarmerName", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Mobile Number", new FIELDS("txtFarmerMobile", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Email Id", new FIELDS("txtEmail", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Gender", new FIELDS("ddlGender", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Land Owner", new FIELDS("txtLandOwnerFatherName", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Social Status", new FIELDS("ddlSocialStatus", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Ration Card Number", new FIELDS("txtRationCard", FIELD_TYPE_TEXTBOX));

		// SURVEY DETAILS fields
		fieldsMap.put("Survey Number", new FIELDS("txtSurveyNo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Sub Division Number", new FIELDS("txtSubDivisionNo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Total Land Area (Ha)", new FIELDS("txtTotalLandArea", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Planned MI Area (Ha)", new FIELDS("txtTotalMiLandArea", FIELD_TYPE_TEXTBOX));

		// CROP DETAILS
		fieldsMap.put("Primary Crop", new FIELDS("ddlPrimaryCrop", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Inter Crop", new FIELDS("ddlInterCrop", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Mi Crop", new FIELDS("ddlMiCropType", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Crop Spacing", new FIELDS("ddlCropSpacing", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("MI Area Splitup (Ha)", new FIELDS("txtMIArea", FIELD_TYPE_TEXTBOX));

		// MI LAND DETAILS fields
		fieldsMap.put("Crop Type", new FIELDS("ddlCropType", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Crop / Land Type", new FIELDS("ddlCropLandType", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("MI Type", new FIELDS("ddlMiType", FIELD_TYPE_DROPDOWN));

		// CROP DETAILS fields
		fieldsMap.put("Water Source", new FIELDS("ddlWaterSource", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Source of Power", new FIELDS("ddlPowerSource", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("FIG/FPG/FPO/Others", new FIELDS("ddlFig", FIELD_TYPE_DROPDOWN));

		// ACCOUNT DETAILS fields
		fieldsMap.put("Account Holder Name", new FIELDS("txtAccountName", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Account Number", new FIELDS("txtAccountNo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Bank Name", new FIELDS("ddlBank", FIELD_TYPE_DROPDOWN));
		fieldsMap.put("Branch Name", new FIELDS("txtBranchName", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Ifsc Code", new FIELDS("txtIfsc", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Passbook_photo", new FIELDS("fl_passbook", FIELD_TYPE_TEXTBOX));

		// DOCUMENT PROOF FILES Upload fields
		fieldsMap.put("Farmer_photo", new FIELDS("fl_farmer_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Aadhaar_photo", new FIELDS("fl_aadhar_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("RationCard_photo", new FIELDS("fl_rc_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Chitta_photo", new FIELDS("fl_cc_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("Adangal_photo", new FIELDS("fl_ac_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("FMB_photo", new FIELDS("fl_fmp_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("WaterSoilTest_photo", new FIELDS("fl_wt_photo", FIELD_TYPE_TEXTBOX));
		fieldsMap.put("SFMF_photo", new FIELDS("fl_sfmf_photo", FIELD_TYPE_TEXTBOX));

		return fieldsMap;
	}

	private static LinkedHashMap<String, FIELDS> createFormerFieldsMap() {
		LinkedHashMap<String, FIELDS> formerFieldsMap = new LinkedHashMap<String, FIELDS>();
		
		// FORMER DETAILS fields
		formerFieldsMap.put("Aadhaar ID Number", new FIELDS("txtAadhar", FIELD_TYPE_TEXTBOX));
		formerFieldsMap.put("Farmer Type", new FIELDS("ddl_farmer_type", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Registered By", new FIELDS("ddlRegisteredBy", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Department", new FIELDS("ddlDepartment", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("MI Company", new FIELDS("ddlMiCompany", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Land Ownership", new FIELDS("ddlLandOwnership", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("District", new FIELDS("ddlDistrict", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Block", new FIELDS("ddlBlock", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Village", new FIELDS("ddlVillage", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Farmer Name", new FIELDS("txtFarmerName", FIELD_TYPE_TEXTBOX));
		formerFieldsMap.put("Mobile Number", new FIELDS("txtFarmerMobile", FIELD_TYPE_TEXTBOX));
		formerFieldsMap.put("Email Id", new FIELDS("txtEmail", FIELD_TYPE_TEXTBOX));
		formerFieldsMap.put("Gender", new FIELDS("ddlGender", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Land Owner", new FIELDS("txtLandOwnerFatherName", FIELD_TYPE_TEXTBOX));
		formerFieldsMap.put("Social Status", new FIELDS("ddlSocialStatus", FIELD_TYPE_DROPDOWN));
		formerFieldsMap.put("Ration Card Number", new FIELDS("txtRationCard", FIELD_TYPE_TEXTBOX));
		
		return formerFieldsMap;
	}
	
	private static LinkedHashMap<String, FIELDS> createLandFieldsMap() {
		LinkedHashMap<String, FIELDS> landFieldsMap = new LinkedHashMap<String, FIELDS>();
		
		// MI LAND DETAILS fields
		landFieldsMap.put("Crop Type", new FIELDS("ddlCropType", FIELD_TYPE_DROPDOWN));
		landFieldsMap.put("Crop / Land Type", new FIELDS("ddlCropLandType", FIELD_TYPE_DROPDOWN));
		landFieldsMap.put("MI Type", new FIELDS("ddlMiType", FIELD_TYPE_DROPDOWN));
		
		return landFieldsMap;
	}

	private static LinkedHashMap<String, FIELDS> createSurveyFieldsMap() {
		LinkedHashMap<String, FIELDS> surveyFieldsMap = new LinkedHashMap<String, FIELDS>();
		
		// SURVEY DETAILS fields
		surveyFieldsMap.put("Survey Number", new FIELDS("txtSurveyNo", FIELD_TYPE_TEXTBOX));
		surveyFieldsMap.put("Sub Division Number", new FIELDS("txtSubDivisionNo", FIELD_TYPE_TEXTBOX));
		surveyFieldsMap.put("Total Land Area (Ha)", new FIELDS("txtTotalLandArea", FIELD_TYPE_TEXTBOX));
		surveyFieldsMap.put("Planned MI Area (Ha)", new FIELDS("txtTotalMiLandArea", FIELD_TYPE_TEXTBOX));
		
		return surveyFieldsMap;
	}

	private static LinkedHashMap<String, FIELDS> createCropFieldsMap() {
		LinkedHashMap<String, FIELDS> cropFieldsMap = new LinkedHashMap<String, FIELDS>();
		
		// CROP DETAILS fields
		cropFieldsMap.put("Primary Crop", new FIELDS("ddlPrimaryCrop", FIELD_TYPE_DROPDOWN));
		cropFieldsMap.put("Inter Crop", new FIELDS("ddlInterCrop", FIELD_TYPE_DROPDOWN));
		cropFieldsMap.put("Mi Crop", new FIELDS("ddlMiCropType", FIELD_TYPE_DROPDOWN));
		cropFieldsMap.put("Crop Spacing", new FIELDS("ddlCropSpacing", FIELD_TYPE_DROPDOWN));
		cropFieldsMap.put("MI Area Splitup (Ha)", new FIELDS("txtMIArea", FIELD_TYPE_TEXTBOX));

		// CROP DETAILS SoURCE fields
		cropFieldsMap.put("Water Source", new FIELDS("ddlWaterSource", FIELD_TYPE_DROPDOWN));
		cropFieldsMap.put("Source of Power", new FIELDS("ddlPowerSource", FIELD_TYPE_DROPDOWN));
		cropFieldsMap.put("FIG/FPG/FPO/Others", new FIELDS("ddlFig", FIELD_TYPE_DROPDOWN));
		
		return cropFieldsMap;
	}

	private static LinkedHashMap<String, FIELDS> createAccountFieldsMap() {
		LinkedHashMap<String, FIELDS> accountFieldsMap = new LinkedHashMap<String, FIELDS>();
		
		// ACCOUNT DETAILS fields
		accountFieldsMap.put("Account Holder Name", new FIELDS("txtAccountName", FIELD_TYPE_TEXTBOX));
		accountFieldsMap.put("Account Number", new FIELDS("txtAccountNo", FIELD_TYPE_TEXTBOX));
		accountFieldsMap.put("Bank Name", new FIELDS("ddlBank", FIELD_TYPE_DROPDOWN));
		accountFieldsMap.put("Branch Name", new FIELDS("txtBranchName", FIELD_TYPE_TEXTBOX));
		accountFieldsMap.put("Ifsc Code", new FIELDS("txtIfsc", FIELD_TYPE_TEXTBOX));
		accountFieldsMap.put("Passbook_photo", new FIELDS("fl_passbook", FIELD_TYPE_TEXTBOX));
		
		return accountFieldsMap;
	}

	private static LinkedHashMap<String, FIELDS> createDocumentProofFieldsMap() {
		LinkedHashMap<String, FIELDS> docProofFieldsMap = new LinkedHashMap<String, FIELDS>();
		
		// DOCUMENT PROOF FILES Upload fields
		docProofFieldsMap.put("Farmer_photo", new FIELDS("fl_farmer_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("Aadhaar_photo", new FIELDS("fl_aadhar_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("RationCard_photo", new FIELDS("fl_rc_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("Chitta_photo", new FIELDS("fl_cc_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("Adangal_photo", new FIELDS("fl_ac_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("FMB_photo", new FIELDS("fl_fmp_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("WaterSoilTest_photo", new FIELDS("fl_wt_photo", FIELD_TYPE_TEXTBOX));
		docProofFieldsMap.put("SFMF_photo", new FIELDS("fl_sfmf_photo", FIELD_TYPE_TEXTBOX));
		
		return docProofFieldsMap;
	}
	
}
