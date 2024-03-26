package Assignments;
import java.util.List;
import java.util.Arrays;
import java.util.Stack;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

class CreateScene {
	
	String methodName;
    String parameter1;
    String parameter2;

    public CreateScene(String methodName) {
    	this.methodName = methodName;
    }
    public CreateScene(String methodName, String parameter1) {
        this.methodName = methodName;
        this.parameter1 = parameter1;
    }

    public CreateScene (String methodName, String parameter1, String parameter2) {
        this.methodName = methodName;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

}

public class VisualDesignComponents extends Application {
	

	InputDataValidation formatValidator = new InputDataValidation();
	Stack<CreateScene> sceneStack = new Stack<>();
	Stage primaryStage;
	
//Buttons	
	//Basic buttons
	Button btClear = new Button ("Clear");
	Button btSubmit = new Button ("Submit");
	Button btLogout = new Button ("Logout");
	Button btExit = new Button ("Exit");
	Button btBack = new Button ("Back");
	Button btLogin = new Button("Login");
	Button btDelete = new Button("Delete");
	//Record management buttons
	Button btEnterAccount = new Button("Enter an Account");
	Button btViewEditAccount = new Button("View/Edit an Account");
	Button btDeleteAccount = new Button("Delete an Account");
		//Enter
	Button btEnterVehRecord = new Button("Enter a Record");
	Button btEnterDriRecord = new Button("Enter a Record");
	Button btEnterOffRecord = new Button("Enter a Record");
	Button btEnterDriCitRecord = new Button("Enter a Record");
	Button btEnterVehCitRecord = new Button("Enter a Record");
	Button btEnterDriWarRecord = new Button("Enter a Record");
	Button btEnterVehWarRecord = new Button("Enter a Record");
	Button btEnterEnrollmentRecord = new Button("Enter a Record");
		//View/Edit
	Button btViewEditVehRecord = new Button("View/Edit a Record");
	Button btViewEditDriRecord = new Button("View/Edit a Record");
	Button btViewEditOffRecord = new Button("View/Edit a Record");
	Button btViewEditDriCitRecord = new Button("View/Edit a Record");
	Button btViewEditVehCitRecord = new Button("View/Edit a Record");
	Button btViewEditDriWarRecord = new Button("View/Edit a Record");
	Button btViewEditVehWarRecord = new Button("View/Edit a Record");
	Button btViewEditEnrollmentRecord = new Button("View/Edit a Record");
		//Delete
	Button btDeleteVehRecord = new Button("Delete a Record");
	Button btDeleteDriRecord = new Button("Delete a Record");
	Button btDeleteOffRecord = new Button("Delete a Record");
	Button btDeleteDriCitRecord = new Button("Delete a Record");
	Button btDeleteVehCitRecord = new Button("Delete a Record");
	Button btDeleteDriWarRecord = new Button("Delete a Record");
	Button btDeleteVehWarRecord = new Button("Delete a Record");
	Button btDeleteEnrollmentRecord = new Button("Delete a Record");

	//Record navigation buttons
	Button btManageRecordsProvincial = new Button("Manage Records");
	Button btManageRecordsMunicipal = new Button("Manage Records");
	Button btVehicleRecords = new Button("Vehicle Records");
	Button btDriverRecords = new Button("Driver Records");
	Button btWarrants = new Button("Warrants");
	Button btVehicleWarrants = new Button("Vehicle Warrants");
	Button btDriverWarrants = new Button("Driver Warrants");
	Button btCitations = new Button("Citations");
	Button btVehicleCitations = new Button("Vehicle Citations");
	Button btDriverCitations = new Button("Driver Citations");
	Button btTrafficSchool = new Button("Traffic School");
	Button btEnrollment = new Button("Enrollment");
	Button btAttendance = new Button("Attendance");
	Button btOfficers = new Button("Officers");
	//Report navigation/management buttons
	Button btGenerateReportProvincial = new Button("Generate a Report");
	Button btGenerateReportMunicipal = new Button("Generate a Report");
	Button btVehicleInfo = new Button("Vehicle Information");
	Button btDriverInfo = new Button("Driver Information");
	Button btDrivingRecord = new Button("Driving Record");
	Button btCitationSummary = new Button("Citation Summary");
	Button btOutstandingWarrants = new Button("Outstanding Warrants");
//Labels
	//Login page labels
	Label lbTrafficWatch = new Label ("Traffic Watch: ");
	Label lbAppDescription = new Label ("The provincial and municipal system for traffic citations and reporting");
	//Feedback labels
	Label lbEmptyFields = new Label ("Please fill in all fields.");
	Label lbWrongFormat = new Label ("Incorrect format. Please try again.");
	Label lbNoRecord = new Label ("No record found.");
	Label lbLoginError = new Label("Invalid login. Please try again.");
	Label lbSuccessText = new Label("Successful submission.");
	//Instruction labels
	Label lbChoose = new Label ("Would you like to?");
	Label lbManage = new Label ("Which information would you like to manage?");
	Label lbReport = new Label ("Which information would you like to report?");
	Label lbEnter = new Label ("Enter information:");
	Label lbEdit = new Label ("View/Edit information:");
	Label lbFilter = new Label ("Filter information:");
	Label lbDelete = new Label ("Delete?");
	//Labels for text fields 
	Label lbEnterVin = new Label ("Enter the VIN:");
	Label lbEnterLic = new Label ("Enter the license number:");
	Label lbStartDate = new Label ("Enter the start date (DD/MM/YYYY):");
	Label lbEndDate = new Label ("Enter the end date (DD/MM/YYYY):");
	Label lbEnterCitID = new Label ("Enter the citation ID:");
	Label lbEnterWarID = new Label ("Enter the warrant ID:");
	Label lbEnterBadge = new Label ("Enter the badge number:");
	Label lbEnterAcc = new Label ("Enter the account ID:");
	Label lbVin = new Label ("VIN:");
	Label lbPlate = new Label ("License Plate:");
	Label lbMake = new Label ("Make:");
	Label lbModel = new Label ("Model:");
	Label lbYear = new Label ("Year:");
	Label lbRegStat = new Label ("Registration Status:");
	Label lbLic = new Label ("License Number:");
	Label lbFirst = new Label ("First Name:");
	Label lbLast = new Label ("Last Name:");
	Label lbPoints = new Label ("Demerit Points:");
	Label lbLicStat = new Label ("License Status:");
	Label lbDate = new Label ("Date (DD/MM/YYYY):");
	Label lbReason = new Label ("Reason:");
	Label lbOutstanding = new Label ("Outstanding:");
	Label lbCitID = new Label ("Citation ID:");
	Label lbWarID = new Label("Warrant ID:");
	Label lbFine = new Label ("Fine Amount (CAD):");
	Label lbIssuingOff = new Label ("Issuing Officer Badge Number:");
	Label lbPaid = new Label ("Payment Status:");
	Label lbReportable = new Label ("Reportable to Provincial Agency:");
	Label lbSess1 = new Label ("Session 1 (2h) date (DD/MM/YYYY):");
	Label lbSess2 = new Label ("Session 2 (2h) date (DD/MM/YYYY):");
	Label lbSess3 = new Label ("Session 3 (2h) date (DD/MM/YYYY):");
	Label lbSess4 = new Label ("Session 4 (2h) date (DD/MM/YYYY):");
	Label lbSess1Att = new Label ("Session 1 :");
	Label lbSess2Att = new Label ("Session 2 :");
	Label lbSess3Att = new Label ("Session 3 :");
	Label lbSess4Att = new Label ("Session 4 :");
	Label lbBadge = new Label ("Badge number:");
	Label lbUsername = new Label ("Username:");
	Label lbPassword = new Label ("Password:");
	Label lbAgency = new Label ("Agency:");	
//Text fields
	TextField tfVin = new TextField();
    TextField tfStartDate = new TextField();
    TextField tfEndDate = new TextField();
    TextField tfEnterCitID = new TextField();
    TextField tfEnterWarID = new TextField();
    TextField tfEnterAcc = new TextField();
    TextField tfPlate = new TextField();
    TextField tfMake = new TextField();
    TextField tfModel = new TextField();
    TextField tfYear = new TextField();
    TextField tfLic = new TextField();
    TextField tfFirst = new TextField();
    TextField tfLast = new TextField();
    TextField tfPoints = new TextField();
    TextField tfDate = new TextField();
    TextField tfReason = new TextField();
    TextField tfOutstanding = new TextField();
    TextField tfCitID = new TextField();
    TextField tfWarID = new TextField();
    TextField tfAccID = new TextField();
    TextField tfFine = new TextField();
    TextField tfIssuingOff = new TextField();
    TextField tfSess1 = new TextField();
    TextField tfSess2 = new TextField();
    TextField tfSess3 = new TextField();
    TextField tfSess4 = new TextField();
    TextField tfBadge = new TextField();
    TextField tfUsername = new TextField();
    TextField tfPassword = new TextField(); 
    PasswordField pfPassword = new PasswordField();
    
//Combo boxes
    ComboBox<String> cbAgencyLogin = new ComboBox<>(FXCollections.observableArrayList(
            "Provincial", "Municipal", "Administration"));
    ComboBox<String> cbAgency = new ComboBox<>(FXCollections.observableArrayList(
            "Provincial", "Municipal", "Administration"));
    ComboBox<String> cbRegStat = new ComboBox<>(FXCollections.observableArrayList(
            "Valid", "Stolen", "Wanted", "Expired"));
    ComboBox<String> cbLicStat = new ComboBox<>(FXCollections.observableArrayList(
            "Valid", "Suspended", "Revoked", "Expired"));
    ComboBox<String> cbOutstanding = new ComboBox<>(FXCollections.observableArrayList(
            "Yes", "No"));
    ComboBox<String> cbReasonDriv = new ComboBox<>(FXCollections.observableArrayList(
            "Speeding", "Reckless Driving", "Distracted Driving", "DUI", "Moving Vehicle Code Violation"));
    ComboBox<String> cbReasonVeh = new ComboBox<>(FXCollections.observableArrayList(
            "Paking Violation", "Fix-It Ticket"));
    ComboBox<String> cbReasonDrivVeh = new ComboBox<>(FXCollections.observableArrayList(
            "Speeding", "Reckless Driving", "Distracted Driving", "DUI", "Moving Vehicle Code Violation","Paking Violation", "Fix-It Ticket"));
    ComboBox<String> cbPaid = new ComboBox<>(FXCollections.observableArrayList(
            "Paid", "Unpaid"));
    ComboBox<String> cbReportable = new ComboBox<>(FXCollections.observableArrayList(
            "Yes", "No", "TBD"));
    ComboBox<String> cbSessAtt1 = new ComboBox<>(FXCollections.observableArrayList(
            "Yes", "No", "TBD"));
    ComboBox<String> cbSessAtt2 = new ComboBox<>(FXCollections.observableArrayList(
            "Yes", "No", "TBD"));
    ComboBox<String> cbSessAtt3 = new ComboBox<>(FXCollections.observableArrayList(
            "Yes", "No", "TBD"));
    ComboBox<String> cbSessAtt4 = new ComboBox<>(FXCollections.observableArrayList(
            "Yes", "No", "TBD"));  
//Report text 
    TextArea taReport = new TextArea();
//Bottom rectangle  
    Rectangle bottomRectangle = new Rectangle(100,100);
    
//Method to assign styles to components
	public void styleVisualComponents () {	
		
	//Adding warning icon to warning messages
		ImageView warningIcon = new ImageView(new Image(getClass().getResourceAsStream("icons8-warning-32.png")));
		lbEmptyFields.setGraphic(new ImageView(warningIcon.getImage()));
		lbWrongFormat.setGraphic(new ImageView(warningIcon.getImage()));
        lbNoRecord.setGraphic(new ImageView(warningIcon.getImage()));
        lbLoginError.setGraphic(new ImageView(warningIcon.getImage()));
    //Styling buttons 
        //Basic buttons
        Button[] basicButtons = { btClear, btSubmit, btLogout, btExit, btBack, btLogin, btDelete };

        for (Button basicButton : basicButtons) {
            basicButton.getStyleClass().add("small-buttons");
        }
        //Record management buttons
        Button[] recordManagementButtons = { btEnterAccount, btViewEditAccount, btDeleteAccount, 
        	    btEnterVehRecord, btEnterDriRecord, btEnterOffRecord, btEnterDriCitRecord,
        	    btEnterVehCitRecord, btEnterDriWarRecord, btEnterVehWarRecord, btEnterEnrollmentRecord,
        	    btViewEditVehRecord, btViewEditDriRecord, btViewEditOffRecord, btViewEditDriCitRecord,
        	    btViewEditVehCitRecord, btViewEditDriWarRecord, btViewEditVehWarRecord, btViewEditEnrollmentRecord,
        	    btDeleteVehRecord, btDeleteDriRecord, btDeleteOffRecord, btDeleteDriCitRecord,
        	    btDeleteVehCitRecord, btDeleteDriWarRecord, btDeleteVehWarRecord, btDeleteEnrollmentRecord };


        for (Button button : recordManagementButtons) {
            button.getStyleClass().add("big-buttons"); 
        }
        //Record navigation buttons
        Button[] navigationButtons = { 
        	    btManageRecordsProvincial, btManageRecordsMunicipal, btVehicleRecords, btDriverRecords, btWarrants, btVehicleWarrants,
        	    btDriverWarrants, btCitations, btVehicleCitations, btDriverCitations,
        	    btTrafficSchool, btEnrollment, btAttendance, btOfficers
        	};

        for (Button button : navigationButtons) {
        	    button.getStyleClass().add("big-buttons"); 
        	}
        //Report navigation/management buttons
        Button[] reportManagementButtons = { 
        	    btGenerateReportProvincial, btGenerateReportMunicipal, btVehicleInfo, btDriverInfo, btDrivingRecord, 
        	    btCitationSummary, btOutstandingWarrants
        	};

        	for (Button button : reportManagementButtons) {
        	    button.getStyleClass().add("big-buttons");
        	}
    //Styling labels
    	//Login page labels
        lbTrafficWatch.getStyleClass().add("title");
        lbAppDescription.getStyleClass().add("app-description");
        //Feedback labels
        lbEmptyFields.getStyleClass().add("warning-label");
        lbWrongFormat.getStyleClass().add("warning-label");
        lbNoRecord.getStyleClass().add("warning-label");
        lbLoginError.getStyleClass().add("warning-label");
        lbSuccessText.getStyleClass().add("success-label");

        //Big labels
        Label [] bigLabels = { lbChoose, lbManage, lbReport, lbEnterVin,lbEnterLic,lbEnterCitID, lbEnterWarID, lbEnterBadge, lbEnterAcc};
        
        for(Label label: bigLabels){
        	label.getStyleClass().add("big-label");
        }
        //Medium labels
        Label[] mediumLabels = {lbEnter,lbEdit,lbFilter,lbDelete};
        
        for (Label label:mediumLabels) {
        	label.getStyleClass().add("medium-label");
        }
        //Small labels
        Label[] smallLabels = { 
        	    lbVin, lbPlate, lbMake, lbModel, lbYear, lbRegStat, lbLic, lbFirst, lbLast, lbPoints, lbLicStat, lbDate,
        	    lbReason, lbOutstanding, lbCitID, lbWarID, lbFine, lbIssuingOff, lbPaid, lbReportable, lbSess1, lbSess2,
        	    lbSess3, lbSess4, lbSess1Att, lbSess2Att, lbSess3Att, lbSess4Att, lbBadge, lbUsername, lbPassword, lbAgency,
        	    lbStartDate, lbEndDate
        	};

        	for (Label label : smallLabels) {
        	    label.getStyleClass().add("small-label");
        	}

    //Styling text fields 
        TextField[] textFields = {
        	    tfStartDate, tfEndDate, tfEnterCitID, tfEnterWarID, tfEnterAcc,
        	    tfVin, tfPlate, tfMake, tfModel, tfYear, tfLic, tfFirst, tfLast,
        	    tfPoints, tfDate, tfReason, tfOutstanding, tfCitID, tfWarID, tfAccID,
        	    tfFine, tfIssuingOff, tfSess1, tfSess2, tfSess3, tfSess4, tfBadge,
        	    tfUsername, tfPassword
        	};

        	for (TextField textField : textFields) {
        	    textField.getStyleClass().add("text-fields"); // Add style class
        	}
        	
        pfPassword.getStyleClass().add("big-text-fields");
        pfPassword.setPromptText("Password");     
    //Styling combo boxes
   
        cbAgencyLogin.getStyleClass().add("big-combo-boxes");
        cbAgencyLogin.setPromptText("Agency");
     
        List<ComboBox<String>> stringComboBoxes = Arrays.asList(
        	    cbAgency, cbRegStat, cbLicStat, cbOutstanding, cbReasonDriv, cbReasonDrivVeh,
        	    cbReasonVeh, cbPaid, cbReportable, cbSessAtt1, cbSessAtt2,
        	    cbSessAtt3, cbSessAtt4
        	);

        	for (ComboBox<String> comboBox : stringComboBoxes) {
        	    comboBox.getStyleClass().add("combo-boxes"); // Add style class
        	}
    //Styling report text
        taReport.getStyleClass().add("report-text");
    //Styling bottom rectangle 
        bottomRectangle.getStyleClass().add("bottom-rectangle");
    
	}
	
	public void visualComponentSettings() {
		taReport.setWrapText(true);
		taReport.setEditable(false);
		
		//Text fields that should not be edited
		TextField[] uneditableTextFields={tfCitID,tfWarID,tfAccID};
		
		for (TextField textField: uneditableTextFields) {
			textField.setEditable(false);
		}

        //Feedback labels
        Label[] feedbackLabels = {lbLoginError, lbEmptyFields, lbWrongFormat, lbNoRecord, lbSuccessText};
        
        for (Label feedbackLabel : feedbackLabels) {
            feedbackLabel.setVisible(false);
        }
        //Reversing setFieldsUneditable
        TextField[] textFields = { 
			    tfStartDate, tfEndDate, tfEnterCitID, tfEnterWarID, tfEnterAcc, tfVin, tfPlate, tfMake, tfModel, 
			    tfYear, tfLic, tfFirst, tfLast, tfPoints, tfDate, tfReason, tfOutstanding, tfCitID, tfWarID, 
			    tfAccID, tfFine, tfIssuingOff, tfSess1, tfSess2, tfSess3, tfSess4, tfBadge, tfUsername, tfPassword, pfPassword
			};

			for (TextField textField : textFields) {
			    textField.setEditable(true); 
			   
			}

			
			ComboBox<?>[] comboBoxes = { 
			    cbAgency, cbRegStat, cbLicStat, cbOutstanding, cbReasonDriv, cbReasonVeh, 
			    cbPaid, cbReportable, cbSessAtt1, cbSessAtt2, cbSessAtt3, cbSessAtt4 
			};

			for (ComboBox<?> comboBox : comboBoxes) {
			    comboBox.setDisable(false); 
			}
        
	}
	
	public void setFieldsUneditable () {
			TextField[] textFields = { 
			    tfStartDate, tfEndDate, tfEnterCitID, tfEnterWarID, tfEnterAcc, tfVin, tfPlate, tfMake, tfModel, 
			    tfYear, tfLic, tfFirst, tfLast, tfPoints, tfDate, tfReason, tfOutstanding, tfCitID, tfWarID, 
			    tfAccID, tfFine, tfIssuingOff, tfSess1, tfSess2, tfSess3, tfSess4, tfBadge, tfUsername, tfPassword, pfPassword
			};

			for (TextField textField : textFields) {
			    textField.setEditable(false); 
			   
			}

			
			ComboBox<?>[] comboBoxes = { 
			    cbAgency, cbRegStat, cbLicStat, cbOutstanding, cbReasonDriv, cbReasonVeh, 
			    cbPaid, cbReportable, cbSessAtt1, cbSessAtt2, cbSessAtt3, cbSessAtt4 
			};

			for (ComboBox<?> comboBox : comboBoxes) {
			    comboBox.setDisable(true); 
			}
	}
	
	
	
	
	
	public Scene createLoginScene() {
		
		styleVisualComponents();
		visualComponentSettings();
		
		tfUsername.getStyleClass().remove("text-fields");
		tfUsername.getStyleClass().add("big-text-fields");
	    tfUsername.setPromptText("Username");
	  
		VBox loginTop = new VBox (lbTrafficWatch, lbAppDescription, cbAgencyLogin, tfUsername, pfPassword);	
		loginTop.setAlignment(Pos.CENTER);
		loginTop.setSpacing(30);
		loginTop.setPadding(new Insets(50));
		
		VBox loginBottom = new VBox (btLogin, lbLoginError);
		loginBottom.setAlignment(Pos.CENTER);
		loginBottom.setSpacing(30);
		loginBottom.setPadding(new Insets(20));
		
		VBox login = new VBox (loginTop, loginBottom);
		
		HBox exit = new HBox (btExit);
		exit.setAlignment(Pos.CENTER_RIGHT);
		exit.setPadding(new Insets(50));
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: white;");
		pane.setCenter(login);
		pane.setTop(exit);
		pane.setBottom(bottomRectangle);
		
		bottomRectangle.widthProperty().bind(pane.widthProperty());
		Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
		 Scene scene = new Scene (pane,bounds.getWidth(), bounds.getHeight());
		 scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		 sceneStack.push(new CreateScene("CreateLoginScene"));
		    
		 return scene;
	}
	
	public Scene createOptionScene(String centerContent) {
		
		styleVisualComponents();
		visualComponentSettings();
		
		HBox backLogoutHBox = new HBox(btBack, btLogout);
		backLogoutHBox.setSpacing(40);
		backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
		backLogoutHBox.setPadding(new Insets(50));

	    VBox centerContentVBox=null;

	    switch (centerContent) {
	        case "Manage/Report Provincial":
	            centerContentVBox = new VBox(lbChoose, btManageRecordsProvincial, btGenerateReportProvincial);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	           
	            break;
	        case "Manage/Report Municipal":
	            centerContentVBox = new VBox(lbChoose, btManageRecordsMunicipal, btGenerateReportMunicipal);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	           
	            break;

	        case "Vehicle/Driver":
	            centerContentVBox = new VBox(lbManage, btVehicleRecords, btDriverRecords);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "Vehicle/Driver Citations":
	            centerContentVBox = new VBox(lbManage, btVehicleCitations, btDriverCitations);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "Vehicle/Driver Warrants":
	            centerContentVBox = new VBox(lbManage, btVehicleWarrants, btDriverWarrants);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "Citation Summary/Outstanding Warrants":
	            centerContentVBox = new VBox(lbReport, btCitationSummary, btOutstandingWarrants);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbReport.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "Enrollment/Attendance":
	            centerContentVBox = new VBox(lbManage, btEnrollment, btAttendance);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;		                			                                        
	        case "Enter/Edit/Delete Vehicle Record":
	            centerContentVBox = new VBox(lbChoose, btEnterVehRecord, btViewEditVehRecord, btDeleteVehRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Driver Record":
	            centerContentVBox = new VBox(lbChoose, btEnterDriRecord, btViewEditDriRecord, btDeleteDriRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Officer Record":
	            centerContentVBox = new VBox(lbChoose, btEnterOffRecord, btViewEditOffRecord, btDeleteOffRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Vehicle Citation Record":
	            centerContentVBox = new VBox(lbChoose, btEnterVehCitRecord, btViewEditVehCitRecord, btDeleteVehCitRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;           
	        case "Enter/Edit/Delete Driver Citation Record":
	            centerContentVBox = new VBox(lbChoose, btEnterDriCitRecord, btViewEditDriCitRecord, btDeleteDriCitRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Vehicle Warrant Record":
	            centerContentVBox = new VBox(lbChoose, btEnterVehWarRecord, btViewEditVehWarRecord, btDeleteVehWarRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Driver Warrant Record":
	            centerContentVBox = new VBox(lbChoose, btEnterDriWarRecord, btViewEditDriWarRecord, btDeleteDriWarRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Enrollment Record":
	            centerContentVBox = new VBox(lbChoose, btEnterEnrollmentRecord, btViewEditEnrollmentRecord, btDeleteEnrollmentRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	        case "Enter/Edit/Delete Account":
	            centerContentVBox = new VBox(lbChoose, btEnterAccount, btViewEditAccount, btDeleteAccount);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "Vehicle/Driver/Driving Record Report":
	            centerContentVBox = new VBox(lbReport, btVehicleInfo, btDriverInfo, btDrivingRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbReport.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "Citations/Warrants/Officers/Traffic School":
	            centerContentVBox = new VBox(lbManage, btCitations, btWarrants, btOfficers, btTrafficSchool);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	    }

	    BorderPane pane = new BorderPane();
	    pane.setStyle("-fx-background-color: white;");
	    pane.setTop(backLogoutHBox);
	    pane.setCenter(centerContentVBox);
	    
	    Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
		 Scene scene = new Scene (pane, bounds.getWidth(), bounds.getHeight());
	    scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
	    sceneStack.push(new CreateScene("CreateOptionScene", centerContent));
	    
	    return scene;
	}
	
	public Scene createSearchScene(String centerContent) {
		
		styleVisualComponents();
		visualComponentSettings();
		
		HBox backLogoutHBox = new HBox(btBack, btLogout);
		backLogoutHBox.setSpacing(40);
		backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
		backLogoutHBox.setPadding(new Insets(50));
		
		StackPane feedbackStackSearch = new StackPane(lbEmptyFields, lbWrongFormat, lbNoRecord);
		
		

		VBox centerContentVBox=null;

		switch (centerContent) {
			case ("Enter License"):
				centerContentVBox = new VBox(lbEnterLic, tfLic, btSubmit, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setSpacing(60);
            	centerContentVBox.setPadding(new Insets(150, 0, 300, 0));
            	
            break;
            
			case ("Enter VIN"):
				centerContentVBox = new VBox(lbEnterVin, tfVin, btSubmit, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setSpacing(60);
            	centerContentVBox.setPadding(new Insets(150, 0, 300, 0));
            
            break;
            
			case ("Enter Warrant ID"):
				centerContentVBox = new VBox(lbEnterWarID, tfEnterWarID, btSubmit, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setSpacing(60);
            	centerContentVBox.setPadding(new Insets(150, 0, 300, 0));
            	
            break;
            
			case ("Enter Citation ID"):
				centerContentVBox = new VBox(lbEnterCitID, tfEnterCitID, btSubmit, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setSpacing(60);
            	centerContentVBox.setPadding(new Insets(150, 0, 300, 0));
            	
            break;
            
			case ("Enter Account ID"):
				centerContentVBox = new VBox(lbEnterAcc, tfEnterAcc, btSubmit, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setSpacing(60);
            	centerContentVBox.setPadding(new Insets(150, 0, 300, 0));
          
            break;
            
			case ("Enter Badge"):
				centerContentVBox = new VBox(lbEnterBadge, tfBadge, btSubmit, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setSpacing(60);
            	centerContentVBox.setPadding(new Insets(150, 0, 300, 0));
           
            break;
            
			case ("Enter Driving Record"):
				VBox btVBox = new VBox (btSubmit);
				btVBox.setAlignment(Pos.CENTER);
				centerContentVBox = new VBox(lbEnterLic, tfLic, lbStartDate, tfStartDate, lbEndDate, tfEndDate, btVBox, feedbackStackSearch);
            	centerContentVBox.setAlignment(Pos.CENTER);
            	centerContentVBox.setPadding(new Insets(0, 0, 200, 0));
            	lbEnterLic.getStyleClass().remove("big-label");
            	lbEnterLic.getStyleClass().add("medium-label");
            	lbEnterLic.setPadding(new Insets(60,0,30,0));
            	lbStartDate.setPadding(new Insets(60,0,30,0));
            	lbEndDate.setPadding(new Insets(60,0,30,0));
            	btVBox.setPadding(new Insets(60,0,0,0));
            	feedbackStackSearch.setPadding(new Insets(60,0,30,0));
           
            break;  
		    }
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: white;");
		pane.setTop(backLogoutHBox);
		pane.setCenter(centerContentVBox);
		
		Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
		 Scene scene = new Scene (pane,bounds.getWidth(), bounds.getHeight());
		    scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		    sceneStack.push(new CreateScene("CreateSearchScene", centerContent));
		    return scene;
	}
	public Scene createDataScene(String prompt, String fields) {
		
		styleVisualComponents();
		visualComponentSettings();
		
		HBox backLogoutHBox = new HBox(btBack, btLogout);
		backLogoutHBox.setSpacing(40);
		backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
		backLogoutHBox.setPadding(new Insets(50));
		
		HBox submitClearHBox = new HBox(btSubmit, btClear);
		submitClearHBox.setSpacing(40);
		submitClearHBox.setAlignment(Pos.CENTER_LEFT);
		
		HBox deleteHBox = new HBox(btDelete);
		
		
		StackPane feedbackStackSubmit = new StackPane(lbEmptyFields, lbWrongFormat, lbSuccessText);
		
		feedbackStackSubmit.setAlignment(Pos.CENTER_RIGHT);
	
	
		
		HBox submitClearFeedbackHBox = new HBox(submitClearHBox, feedbackStackSubmit);
		submitClearFeedbackHBox.setPadding(new Insets(50));
		submitClearFeedbackHBox.setSpacing(40);
		
	
		VBox promptVBox=null;
		VBox labelsVBox=null;
		VBox fieldsVBox=null;	
		HBox bottomHBox = null;
		
		switch (prompt) {
		
			case("Enter"):
				promptVBox = new VBox(lbEnter);
				promptVBox.setPadding(new Insets(0,0,0,50));
				bottomHBox = submitClearFeedbackHBox;
				break;
			case("View/Edit"):
				promptVBox = new VBox(lbEdit);
				promptVBox.setPadding(new Insets(0,0,0,50));
				bottomHBox = submitClearFeedbackHBox;
				break;
			case("Filter"):
				promptVBox = new VBox(lbFilter);
				promptVBox.setPadding(new Insets(0,0,0,50));
				bottomHBox = submitClearFeedbackHBox;
				break;
			case("Delete"):
				setFieldsUneditable();
				promptVBox = new VBox(lbDelete);
				promptVBox.setPadding(new Insets(0,0,0,50));
				StackPane feedbackStackDelete = new StackPane(lbSuccessText);
				feedbackStackDelete.setAlignment(Pos.CENTER_RIGHT);
				HBox deleteFeedbackHBox = new HBox(deleteHBox, feedbackStackDelete);
				deleteFeedbackHBox.setPadding(new Insets(50));
				bottomHBox = deleteFeedbackHBox;
				break;
		}
		
		switch (fields) {
			case("Vehicle Info"):
				
				labelsVBox = new VBox(lbVin, lbPlate, lbMake, lbModel, lbYear, lbRegStat);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfVin, tfPlate, tfMake, tfModel, tfYear, cbRegStat);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				
				break;
				
			case("Driver Info"):
				
				labelsVBox = new VBox(lbFirst, lbLast, lbLic, lbPlate, lbPoints, lbLicStat);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfFirst, tfLast, tfLic, tfPlate, tfPoints, cbLicStat);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				
				break;
				
			case("Officer Info"):
				labelsVBox = new VBox(lbBadge, lbLast, lbFirst);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfBadge, tfFirst, tfLast);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
			case("Account Info"):
				labelsVBox = new VBox(lbBadge, lbLast, lbFirst);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfBadge, tfFirst, tfLast);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
				
			case("Vehicle Citation Info"):
				labelsVBox = new VBox(lbCitID, lbDate, lbVin, lbPlate, lbReason, lbFine, lbPaid, lbIssuingOff);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfCitID, tfDate, tfVin, tfPlate, cbReasonVeh, tfFine, cbPaid, tfIssuingOff);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				
				break;
				
			case("Driver Citation Info"):
				labelsVBox = new VBox(lbCitID, lbDate, lbLic,  lbReason, lbFine, lbPaid, lbIssuingOff, lbReportable);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfCitID, tfDate, tfLic,  cbReasonDriv, tfFine, cbPaid, tfIssuingOff, cbReportable);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
			case("Vehicle Warrant Info"):
				labelsVBox = new VBox(lbWarID, lbDate, lbVin,  lbPlate, lbReason, lbOutstanding);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfWarID, tfDate, tfVin,  tfPlate, tfReason, cbOutstanding);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
			case("Driver Warrant Info"):
				labelsVBox = new VBox(lbWarID, lbDate, lbLic,  lbFirst, lbLast, lbReason, lbOutstanding);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfWarID, tfDate, tfLic,  tfFirst, tfLast, tfReason, cbOutstanding);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
			case("Traffic School Enrollment"):
				labelsVBox = new VBox(lbCitID, lbLic,  lbFirst, lbLast, lbSess1, lbSess2, lbSess3, lbSess4);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfCitID, tfLic,  tfFirst, tfLast, tfSess1, tfSess2, tfSess3, tfSess4);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
			case("Traffic School Attendance"):
				labelsVBox = new VBox(lbCitID, lbLic,  lbFirst, lbLast, lbSess1Att, lbSess2Att, lbSess3Att, lbSess4Att);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfCitID, tfLic,  tfFirst, tfLast, cbSessAtt1, cbSessAtt2, cbSessAtt3, cbSessAtt4);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
			case("Citation Summary"):
				lbStartDate.setText("Start Date (DD/MM/YYYY):");
				lbEndDate.setText("End Date (DD/MM/YYYY):");
				labelsVBox = new VBox(lbIssuingOff, lbStartDate, lbEndDate, lbReason, lbPaid);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfIssuingOff,  tfStartDate, tfEndDate, cbReasonDrivVeh, cbPaid);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;			
		}
		
		HBox labelsAndFieldsHBox=new HBox(labelsVBox, fieldsVBox);
		labelsAndFieldsHBox.setSpacing(30);
		labelsAndFieldsHBox.setPadding(new Insets(50, 200, 0, 0));
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: white;");
		pane.setTop(backLogoutHBox);
		pane.setLeft(promptVBox);
		pane.setRight(labelsAndFieldsHBox);
		pane.setBottom(bottomHBox);
		
		Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
		 Scene scene = new Scene (pane,bounds.getWidth(), bounds.getHeight());
		    scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		    sceneStack.push(new CreateScene("CreateDataScene", prompt, fields));
		    return scene;
	}
	
	public Scene createReportScene() {
		styleVisualComponents();
		visualComponentSettings();
		Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds(); 
		HBox backLogoutHBox = new HBox(btBack, btLogout);
		backLogoutHBox.setSpacing(40);
		backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
		backLogoutHBox.setPadding(new Insets(50,50,5,50));
		
		ScrollPane reportScroll = new ScrollPane(taReport);
		reportScroll.setStyle("-fx-background-color: white;");
		reportScroll.setFitToWidth(true);
        reportScroll.setFitToHeight(true);
        reportScroll.setPrefViewportWidth(bounds.getWidth()); 
        reportScroll.setPrefViewportHeight(bounds.getHeight());
        reportScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		reportScroll.setPadding(new Insets(20));
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: white;");
		pane.setTop(backLogoutHBox);
		pane.setCenter(reportScroll);
		
		
		 Scene scene = new Scene (pane,bounds.getWidth(), bounds.getHeight());
		    scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		    sceneStack.push(new CreateScene("CreateReportScene"));
		    return scene;
		
	}
	
	public void setButtonActions () {
		//Basic Buttons 
		btClear.setOnAction(event -> clearFields(primaryStage.getScene().getRoot()));
		 btExit.setOnAction(event->{
			 exit();
			 sceneStack.clear();});
		 btBack.setOnAction(event -> navigateBack());	 
		 btLogout.setOnAction(event -> {
			 primaryStage.setScene(createLoginScene());
			 sceneStack.clear();});
		 //Record Management Buttons
		 btEnterAccount.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Account Info")));
		 btViewEditAccount.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Account Info")));
		 btDeleteAccount.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Account Info")));

		 btEnterVehRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Vehicle Info")));
		 btEnterDriRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Driver Info")));
		 btEnterOffRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Officer Info")));
		 btEnterDriCitRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Driver Citation Info")));
		 btEnterVehCitRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Vehicle Citation Info")));
		 btEnterDriWarRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Driver Warrant Info")));
		 btEnterVehWarRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Vehicle Warrant Info")));
		 btEnterEnrollmentRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Enter", "Traffic School Enrollment")));
		 btViewEditVehRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Vehicle Info")));
		 btViewEditDriRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Driver Info")));
		 btViewEditOffRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Officer Info")));
		 btViewEditDriCitRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Driver Citation Info")));
		 btViewEditVehCitRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Vehicle Citation Info")));
		 btViewEditDriWarRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Driver Warrant Info")));
		 btViewEditVehWarRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Vehicle Warrant Info")));
		 btViewEditEnrollmentRecord.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Traffic School Enrollment")));
		 btDeleteVehRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Vehicle Info")));
		 btDeleteDriRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Driver Info")));
		 btDeleteOffRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Officer Info")));
		 btDeleteDriCitRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Driver Citation Info")));
		 btDeleteVehCitRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Vehicle Citation Info")));
		 btDeleteDriWarRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Driver Warrant Info")));
		 btDeleteVehWarRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Vehicle Warrant Info")));
		 btDeleteEnrollmentRecord.setOnAction(event -> primaryStage.setScene(createDataScene("Delete", "Traffic School Enrollment")));

		 // Record navigation Buttons
		 btManageRecordsProvincial.setOnAction(event -> primaryStage.setScene(createOptionScene("Vehicle/Driver")));
		 btManageRecordsMunicipal.setOnAction(event -> primaryStage.setScene(createOptionScene("Citations/Warrants/Officers/Traffic School")));
		 btGenerateReportProvincial.setOnAction(event -> primaryStage.setScene(createOptionScene("Vehicle/Driver/Driving Record Report")));
		 btGenerateReportMunicipal.setOnAction(event -> primaryStage.setScene(createOptionScene("Citation Summary/Outstanding Warrants")));

		 btWarrants.setOnAction(event -> primaryStage.setScene(createOptionScene("Vehicle/Driver Warrants")));
		 btCitations.setOnAction(event -> primaryStage.setScene(createOptionScene("Vehicle/Driver Citations")));
		 btTrafficSchool.setOnAction(event -> primaryStage.setScene(createOptionScene("Enrollment/Attendance")));

		 btVehicleRecords.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Vehicle Record")));
		 btDriverRecords.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Driver Record")));
		 btVehicleWarrants.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Vehicle Warrant Record")));
		 btDriverWarrants.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Driver Warrant Record")));
		 btVehicleCitations.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Vehicle Citation Record")));
		 btDriverCitations.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Driver Citation Record")));
		 btEnrollment.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Enrollment Record")));
		 btOfficers.setOnAction(event -> primaryStage.setScene(createOptionScene("Enter/Edit/Delete Officer Record")));

		 btAttendance.setOnAction(event -> primaryStage.setScene(createDataScene("View/Edit", "Traffic School Attendance")));

		 // Report navigation/management buttons
		 btCitationSummary.setOnAction(event -> primaryStage.setScene(createDataScene("Filter", "Citation Summary")));
		 btVehicleInfo.setOnAction(event -> primaryStage.setScene(createSearchScene("Enter VIN")));
		 btDriverInfo.setOnAction(event -> primaryStage.setScene(createSearchScene("Enter License")));
		 btDrivingRecord.setOnAction(event -> primaryStage.setScene(createSearchScene("Enter Driving Record")));

		
		 //testing
		 btSubmit.setOnAction(event -> fieldFormatTest(primaryStage.getScene().getRoot()));
		
	}
	
	public void clearFields (Node rootNode) {
		
		BorderPane currentPane = (BorderPane) rootNode;
		HBox LabelsAndFieldsHBox = (HBox) currentPane.getRight();
		VBox FieldsVBox = (VBox) LabelsAndFieldsHBox.getChildren().get(1);
		
	    for (Node node : FieldsVBox.getChildren()) {
	        if (node instanceof TextField ) {
	        	TextField textField = (TextField) node;
	        	 if (textField.isEditable()) {
	        		 textField.clear();	
	        	 }
	        }
	        
	        if (node instanceof ComboBox ) {
	        	ComboBox<?> comboBox = (ComboBox<?>) node;
	        	comboBox.setValue(null);
	        }
	    }    
	}      
	
           
            
     public void navigateBack() {
    	 if (!sceneStack.isEmpty()) {
             sceneStack.pop();
             if (!sceneStack.isEmpty()) {
                 CreateScene previousCreateScene = sceneStack.pop();
                 
                 switch (previousCreateScene.methodName) {
                 case "CreateLoginScene":
                	 primaryStage.setScene(createLoginScene());
                	 break;
                 case "CreateOptionScene":
                	 primaryStage.setScene(createOptionScene(previousCreateScene.parameter1));
                	 break;
                 case "CreateSearchScene":
                	 primaryStage.setScene(createSearchScene(previousCreateScene.parameter1));
                	 break;
                 case "CreateDataScene":
                	 primaryStage.setScene(createDataScene(previousCreateScene.parameter1, previousCreateScene.parameter2));
                	 break;
                 case "CreateReportScene":
                	 primaryStage.setScene(createReportScene());
                	 break;
                 }
             } else {
                primaryStage.setScene(createLoginScene());
             }
         }
     }
    public void exit() {
    	Platform.exit();
    }
    public Boolean emptyFieldsTest(Node rootNode) {
    	
    	boolean emptyTestPassed=true;
    	
    	BorderPane currentPane = (BorderPane) rootNode;
    	
    	//Data Scene
    	if (currentPane.getCenter()==null) {
    		
		HBox LabelsAndFieldsHBox = (HBox) currentPane.getRight();
		VBox FieldsVBox = (VBox) LabelsAndFieldsHBox.getChildren().get(1);
		HBox bottomHBox = (HBox) currentPane.getBottom();
		StackPane feedbackStack = (StackPane) bottomHBox.getChildren().get(1);
		Label lbEmptyFields = (Label) feedbackStack.getChildren().get(0);
		
	    for (Node node : FieldsVBox.getChildren()) {
	        if (node instanceof TextField ) {
	        	TextField textField = (TextField) node;
	        	 if (textField.getText().trim().isEmpty()) {
	        		textField.setStyle("-fx-border-color:#FA3E3E;");
	        		lbEmptyFields.setVisible(true);
	        		emptyTestPassed=false;
	        	 }
	        }
	        
	        if (node instanceof ComboBox ) {
	        	ComboBox<?> comboBox = (ComboBox<?>) node;
	        	if(comboBox.getSelectionModel().isEmpty()){
	        		comboBox.setStyle("-fx-border-color:#FA3E3E;");
	        		lbEmptyFields.setVisible(true);
	        		emptyTestPassed=false;
	        	}
	        }
	    }  //Search Scene 
    	} else {
    		
    	VBox centerContentVBox = (VBox) currentPane.getCenter();
    	int stackIndex = centerContentVBox.getChildren().size()-1;
    	StackPane feedbackStack = (StackPane) centerContentVBox.getChildren().get(stackIndex);
		Label lbEmptyFields = (Label) feedbackStack.getChildren().get(0);
		
		for (Node node : centerContentVBox.getChildren()) {
	        if (node instanceof TextField ) {
	        	TextField textField = (TextField) node;
	        	 if (textField.getText().trim().isEmpty()) {
	        		textField.setStyle("-fx-border-color:#FA3E3E;");
	        		lbEmptyFields.setVisible(true);
	        		emptyTestPassed=false;
	        	 }
	        }
	        
	        if (node instanceof ComboBox ) {
	        	ComboBox<?> comboBox = (ComboBox<?>) node;
	        	if(comboBox.getSelectionModel().isEmpty()){
	        		comboBox.setStyle("-fx-border-color:#FA3E3E;");
	        		lbEmptyFields.setVisible(true);
	        		emptyTestPassed=false;
	        	}
	        }
	    } 
    	}
    return emptyTestPassed;
    }

    public Boolean fieldFormatTest(Node rootNode) {
    	
    	boolean formatTestPassed=true;
    	
    	BorderPane currentPane = (BorderPane) rootNode;
    	
    	//Data Scene
    	if (currentPane.getCenter()==null) {
    		
		HBox LabelsAndFieldsHBox = (HBox) currentPane.getRight();
		VBox FieldsVBox = (VBox) LabelsAndFieldsHBox.getChildren().get(1);
		HBox bottomHBox = (HBox) currentPane.getBottom();
		StackPane feedbackStack = (StackPane) bottomHBox.getChildren().get(1);
		Label lbWrongFormat = (Label) feedbackStack.getChildren().get(1);
		
	    for (Node node : FieldsVBox.getChildren()) {
	        if (node instanceof TextField ) {
	        	TextField textField = (TextField) node;
	        	 if (textField==tfVin && !formatValidator.validateVIN(textField.getText())) {	        		
	        		textField.setStyle("-fx-border-color:#FA3E3E;");
	        		lbWrongFormat.setVisible(true);
	        		formatTestPassed=false;
	        	 }
	        	 if (textField==tfPlate && !formatValidator.validateLicensePlate(textField.getText())) {	        		
		        	textField.setStyle("-fx-border-color:#FA3E3E;");
		        	lbWrongFormat.setVisible(true);
		        	formatTestPassed=false;
	        	 }
	        	 if (textField==tfMake && !formatValidator.validateMake(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfModel && !formatValidator.validateModel(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfFirst && !formatValidator.validateFirstName(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfLast && !formatValidator.validateLastName(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfLic && !formatValidator.validateLicenseNumber(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if ((textField==tfStartDate||textField==tfEndDate||textField==tfSess1|| textField==tfSess2||textField==tfSess3||textField==tfSess4)&& !formatValidator.validateDate(textField.getText())) {	        		
		        		textField.setStyle("-fx-border-color:#FA3E3E;");
		        		lbWrongFormat.setVisible(true);
		        		formatTestPassed=false;
		        	 }
	        	 if (textField==tfYear && !formatValidator.validateYear(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfPoints && !formatValidator.validateDemeritPoints(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfBadge && !formatValidator.validateBadgeNumber(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfCitID && !formatValidator.validateCitationID(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfWarID && !formatValidator.validateWarrantID(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfFine && !formatValidator.validateFineAmount(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfAccID && !formatValidator.validateAccountID(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
	       }
	        
	       
	       }
	    }
	   
	    //Search Scene 
    	} else {
    		
    	VBox centerContentVBox = (VBox) currentPane.getCenter();
    	int stackIndex = centerContentVBox.getChildren().size()-1;
    	StackPane feedbackStack = (StackPane) centerContentVBox.getChildren().get(stackIndex);
		Label lbWrongFormat = (Label) feedbackStack.getChildren().get(1);
		
		for (Node node : centerContentVBox.getChildren()) {
	        if (node instanceof TextField ) {
	        	TextField textField = (TextField) node;
	        	if (textField==tfLic && !formatValidator.validateLicenseNumber(textField.getText())) {	        		
		        	textField.setStyle("-fx-border-color:#FA3E3E;");
		        	lbWrongFormat.setVisible(true);
		        	formatTestPassed=false;
	        	 }
	        	 if (textField==tfVin && !formatValidator.validateVIN(textField.getText())) {	        		
		        		textField.setStyle("-fx-border-color:#FA3E3E;");
		        		lbWrongFormat.setVisible(true);
		        		formatTestPassed=false;
	        	 }
	        	 if ((textField==tfStartDate||textField==tfEndDate) && !formatValidator.validateDate(textField.getText())) {	        		
		        		textField.setStyle("-fx-border-color:#FA3E3E;");
		        		lbWrongFormat.setVisible(true);
		        		formatTestPassed=false;
		        }
	        	 if (textField==tfBadge && !formatValidator.validateBadgeNumber(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }	
	        	 if (textField==tfCitID && !formatValidator.validateCitationID(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfWarID && !formatValidator.validateWarrantID(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
		        	 }
	        	 if (textField==tfAccID && !formatValidator.validateAccountID(textField.getText())) {	        		
			        	textField.setStyle("-fx-border-color:#FA3E3E;");
			        	lbWrongFormat.setVisible(true);
			        	formatTestPassed=false;
	        	 	}
	        	}
	        	
	    	} 
    	}
    return formatTestPassed;
    }

	@Override
	public void start (Stage primaryStage) {
		
		this.primaryStage=primaryStage;
		setButtonActions ();
		
		
		
		primaryStage.setTitle("TrafficWatch");	
		
	
		primaryStage.setScene(createOptionScene("Manage/Report Municipal"));
		primaryStage.getScene().getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		primaryStage.show();	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
