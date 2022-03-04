package drip.registration.automation;

import drip.registration.automation.utilities.FIELDS;
import drip.registration.automation.utilities.FieldsExcelConstants;

public class FormMapper {
	
	public static void copyFieldsValueToFormMaps() {
		mapFieldsToFormMap();
	}
	
	private static void fillSurveyDetailsForm(String[] surveyArr, String[] subDivArr, String[] TotalAreaArr,
			String[] miAreaArr) {
		String[] fieldsIdList = { "txtSurveyNo", "txtSubDivisionNo", "txtTotalLandArea", "txtTotalMiLandArea" };
		
		int size = (surveyArr.length == subDivArr.length && subDivArr.length == TotalAreaArr.length) ? surveyArr.length : 1;
		
		for (int i = 0; i < size; i++) {
			FIELDS surveyNo = new FIELDS(fieldsIdList[0], FieldsExcelConstants.FIELD_TYPE_TEXTBOX);
			surveyNo.setValue(surveyArr[i]);

			FIELDS subDivNo = new FIELDS(fieldsIdList[1], FieldsExcelConstants.FIELD_TYPE_TEXTBOX);
			subDivNo.setValue(subDivArr[i]);

			FIELDS totalArea = new FIELDS(fieldsIdList[2], FieldsExcelConstants.FIELD_TYPE_TEXTBOX);
			totalArea.setValue(TotalAreaArr[i]);

			FIELDS miArea = new FIELDS(fieldsIdList[3], FieldsExcelConstants.FIELD_TYPE_TEXTBOX);
			miArea.setValue(miAreaArr[i]);

			Registeration.passValueToField(surveyNo);
			Registeration.passValueToField(subDivNo);
			Registeration.passValueToField(totalArea);
			Registeration.passValueToField(miArea);

			fieldsIdList[0] = getNewFieldIdForSurveyForm(fieldsIdList[0], i);
			fieldsIdList[1] = getNewFieldIdForSurveyForm(fieldsIdList[1], i);
			fieldsIdList[2] = getNewFieldIdForSurveyForm(fieldsIdList[2], i);
			fieldsIdList[3] = getNewFieldIdForSurveyForm(fieldsIdList[3], i);

			if (i < (size - 1)) {
				Registeration.clickButton(FieldsExcelConstants.SURVEY_FORM_ADD_MORE_BUTTON_ID);
			}
		}
	}
	
	private static String getNewFieldIdForSurveyForm(String fieldId, int idx) {
		if(idx == 0) {
			return (fieldId + (idx + 1));
		} else {
			int lastStrIdx = fieldId.length() - 1;
			String newFieldId = fieldId.substring(0, lastStrIdx) + (idx + 1);
			return newFieldId;
		}
	}
	
	public static void checkForMultSurvey() {
		String[] surveyNumbersList = FieldsExcelConstants.SURVEY_FORM_FIELDS_MAP.get("Survey Number").getValue().split(",");

		String[] surveyDivNumbersList = FieldsExcelConstants.SURVEY_FORM_FIELDS_MAP.get("Sub Division Number").getValue()
				.split(",");
		if (surveyNumbersList.length != surveyDivNumbersList.length) {
			System.out.println("Error : Survey Number and Sub Division Numbers are not equal size");
		}

		String[] totalAreaList = FieldsExcelConstants.SURVEY_FORM_FIELDS_MAP.get("Total Land Area (Ha)").getValue()
				.split(",");
		if (surveyNumbersList.length != totalAreaList.length) {
			System.out.println("Error : Survey Number and Total Area Numbers are not equal size");
		}

		String[] plannedAreaList = FieldsExcelConstants.SURVEY_FORM_FIELDS_MAP.get("Planned MI Area (Ha)").getValue()
				.split(",");
		if (totalAreaList.length != plannedAreaList.length) {
			System.out.println("Error : Total Area Numbers and Planned Area Numbers are not equal size");
		}

		fillSurveyDetailsForm(surveyNumbersList, surveyDivNumbersList, totalAreaList, plannedAreaList);
	}

	private static void mapFieldsToFormMap() {
		for(String fieldName: FieldsExcelConstants.FORMER_FORM_FIELDS_MAP.keySet()) {
			if(FieldsExcelConstants.FIELDS_MAP.containsKey(fieldName)) {
				String fieldValue = FieldsExcelConstants.FIELDS_MAP.get(fieldName).getValue();
				FieldsExcelConstants.FORMER_FORM_FIELDS_MAP.get(fieldName).setValue(fieldValue);	
			} else {
				System.out.println(fieldName + ": FORMER_FORM_FIELDS_MAP Field name not fount in FIELDS_MAP");
			}
		}
		
		for(String fieldName: FieldsExcelConstants.LAND_FORM_FIELDS_MAP.keySet()) {
			if(FieldsExcelConstants.FIELDS_MAP.containsKey(fieldName)) {
				String fieldValue = FieldsExcelConstants.FIELDS_MAP.get(fieldName).getValue();
				FieldsExcelConstants.LAND_FORM_FIELDS_MAP.get(fieldName).setValue(fieldValue);	
			} else {
				System.out.println(fieldName + ": LAND_FORM_FIELDS_MAP Field name not fount in FIELDS_MAP");
			}
		}
		
		for(String fieldName: FieldsExcelConstants.SURVEY_FORM_FIELDS_MAP.keySet()) {
			if(FieldsExcelConstants.FIELDS_MAP.containsKey(fieldName)) {
				String fieldValue = FieldsExcelConstants.FIELDS_MAP.get(fieldName).getValue();
				FieldsExcelConstants.SURVEY_FORM_FIELDS_MAP.get(fieldName).setValue(fieldValue);	
			} else {
				System.out.println(fieldName + ": SURVEY_FORM_FIELDS_MAP Field name not fount in FIELDS_MAP");
			}
		}
		
		for(String fieldName: FieldsExcelConstants.CROP_FORM_FIELDS_MAP.keySet()) {
			if(FieldsExcelConstants.FIELDS_MAP.containsKey(fieldName)) {
				String fieldValue = FieldsExcelConstants.FIELDS_MAP.get(fieldName).getValue();
				FieldsExcelConstants.CROP_FORM_FIELDS_MAP.get(fieldName).setValue(fieldValue);	
			} else {
				System.out.println(fieldName + ": CROP_FORM_FIELDS_MAP Field name not fount in FIELDS_MAP");
			}
		}
		
		for(String fieldName: FieldsExcelConstants.ACCOUNT_FORM_FIELDS_MAP.keySet()) {
			if(FieldsExcelConstants.FIELDS_MAP.containsKey(fieldName)) {
				String fieldValue = FieldsExcelConstants.FIELDS_MAP.get(fieldName).getValue();
				FieldsExcelConstants.ACCOUNT_FORM_FIELDS_MAP.get(fieldName).setValue(fieldValue);	
			} else {
				System.out.println(fieldName + ": ACCOUNT_FORM_FIELDS_MAP Field name not fount in FIELDS_MAP");
			}
		}
		
		for(String fieldName: FieldsExcelConstants.DOCUMENT_FORM_FIELDS_MAP.keySet()) {
			if(FieldsExcelConstants.FIELDS_MAP.containsKey(fieldName)) {
				String fieldValue = FieldsExcelConstants.FIELDS_MAP.get(fieldName).getValue();
				FieldsExcelConstants.DOCUMENT_FORM_FIELDS_MAP.get(fieldName).setValue(fieldValue);	
			} else {
				System.out.println(fieldName + ": DOCUMENT_FORM_FIELDS_MAP Field name not fount in FIELDS_MAP");
			}
		}
	}
}
