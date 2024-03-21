package Assignments;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;

public class VisualDesignComponents extends Application {

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
	Button btEnterRecord = new Button("Enter a Record");
	Button btFindEditRecord = new Button("Find/Edit a Record");
	Button btDeleteRecord = new Button("Delete a Record");
	Button btEnterAccount = new Button("Enter Account");
	Button btFindEditAccount = new Button("Find/Edit Account");
	Button btDeleteAccount = new Button("Delete Account");
	//Record navigation buttons
	Button btManageRecords = new Button("Manage Records");
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
	Button btGenerateReport = new Button("Generate a Report");
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
        btClear.getStyleClass().add("small-buttons");
        btSubmit.getStyleClass().add("small-buttons");
        btLogout.getStyleClass().add("small-buttons");
        btExit.getStyleClass().add("small-buttons");
        btBack.getStyleClass().add("small-buttons");
        btLogin.getStyleClass().add("small-buttons");
        btDelete.getStyleClass().add("small-buttons");
        //Record management buttons
        btEnterRecord.getStyleClass().add("big-buttons");
        btFindEditRecord.getStyleClass().add("big-buttons");
        btDeleteRecord.getStyleClass().add("big-buttons");
        btEnterAccount.getStyleClass().add("big-buttons");
        btFindEditAccount.getStyleClass().add("big-buttons");
        btDeleteAccount.getStyleClass().add("big-buttons");
        //Record navigation buttons
        btManageRecords.getStyleClass().add("big-buttons");
        btVehicleRecords.getStyleClass().add("big-buttons");
        btDriverRecords.getStyleClass().add("big-buttons");
        btWarrants.getStyleClass().add("big-buttons");
        btVehicleWarrants.getStyleClass().add("big-buttons");
        btDriverWarrants.getStyleClass().add("big-buttons");
        btCitations.getStyleClass().add("big-buttons");
        btVehicleCitations.getStyleClass().add("big-buttons");
        btDriverCitations.getStyleClass().add("big-buttons");
        btTrafficSchool.getStyleClass().add("big-buttons");
        btEnrollment.getStyleClass().add("big-buttons");
        btAttendance.getStyleClass().add("big-buttons");
        btOfficers.getStyleClass().add("big-buttons");
        //Report navigation/management buttons
        btGenerateReport.getStyleClass().add("big-buttons");
        btVehicleInfo.getStyleClass().add("big-buttons");
        btDriverInfo.getStyleClass().add("big-buttons");
        btDrivingRecord.getStyleClass().add("big-buttons");
        btCitationSummary.getStyleClass().add("big-buttons");
        btOutstandingWarrants.getStyleClass().add("big-buttons");
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
        //Instruction labels    
        lbChoose.getStyleClass().add("big-label");
        lbManage.getStyleClass().add("big-label");
        lbReport.getStyleClass().add("big-label");
        lbEnter.getStyleClass().add("medium-label");
        lbEdit.getStyleClass().add("medium-label");
        lbFilter.getStyleClass().add("medium-label");
        lbDelete.getStyleClass().add("medium-label");
        //Labels for text fields
        lbEnterVin.getStyleClass().add("big-label");
        lbEnterLic.getStyleClass().add("big-label");
        lbStartDate.getStyleClass().add("small-label");
        lbEndDate.getStyleClass().add("small-label");
        lbEnterCitID.getStyleClass().add("big-label");
        lbEnterWarID.getStyleClass().add("big-label");
        lbEnterBadge.getStyleClass().add("big-label");
        lbEnterAcc.getStyleClass().add("big-label");
        lbVin.getStyleClass().add("small-label");
        lbPlate.getStyleClass().add("small-label");
        lbMake.getStyleClass().add("small-label");
        lbModel.getStyleClass().add("small-label");
        lbYear.getStyleClass().add("small-label");
        lbRegStat.getStyleClass().add("small-label");
        lbLic.getStyleClass().add("small-label");
        lbFirst.getStyleClass().add("small-label");
        lbLast.getStyleClass().add("small-label");
        lbPoints.getStyleClass().add("small-label");
        lbLicStat.getStyleClass().add("small-label");
        lbDate.getStyleClass().add("small-label");
        lbReason.getStyleClass().add("small-label");
        lbOutstanding.getStyleClass().add("small-label");
        lbCitID.getStyleClass().add("small-label");
        lbWarID.getStyleClass().add("small-label");
        lbFine.getStyleClass().add("small-label");
        lbIssuingOff.getStyleClass().add("small-label");
        lbPaid.getStyleClass().add("small-label");
        lbReportable.getStyleClass().add("small-label");
        lbSess1.getStyleClass().add("small-label");
        lbSess2.getStyleClass().add("small-label");
        lbSess3.getStyleClass().add("small-label");
        lbSess4.getStyleClass().add("small-label");
        lbSess1Att.getStyleClass().add("small-label");
        lbSess2Att.getStyleClass().add("small-label");
        lbSess3Att.getStyleClass().add("small-label");
        lbSess4Att.getStyleClass().add("small-label");
        lbBadge.getStyleClass().add("small-label");
        lbUsername.getStyleClass().add("small-label");
        lbPassword.getStyleClass().add("small-label");
        lbAgency.getStyleClass().add("small-label");
    //Styling text fields 
        tfStartDate.getStyleClass().add("text-fields");
        tfEndDate.getStyleClass().add("text-fields");
        tfEnterCitID.getStyleClass().add("text-fields");
        tfEnterWarID.getStyleClass().add("text-fields");
        tfEnterAcc.getStyleClass().add("text-fields");
        tfVin.getStyleClass().add("text-fields");
        tfPlate.getStyleClass().add("text-fields");
        tfMake.getStyleClass().add("text-fields");
        tfModel.getStyleClass().add("text-fields");
        tfYear.getStyleClass().add("text-fields");
        tfLic.getStyleClass().add("text-fields");
        tfFirst.getStyleClass().add("text-fields");
        tfLast.getStyleClass().add("text-fields");
        tfPoints.getStyleClass().add("text-fields");
        tfDate.getStyleClass().add("text-fields");
        tfReason.getStyleClass().add("text-fields");
        tfOutstanding.getStyleClass().add("text-fields");
        tfCitID.getStyleClass().add("text-fields");
        tfCitID.setEditable(false);
        tfWarID.getStyleClass().add("text-fields"); 
        tfWarID.setEditable(false);
        tfAccID.getStyleClass().add("text-fields");
        tfAccID.setEditable(false);
        tfFine.getStyleClass().add("text-fields");
        tfIssuingOff.getStyleClass().add("text-fields");
        tfSess1.getStyleClass().add("text-fields");
        tfSess2.getStyleClass().add("text-fields");
        tfSess3.getStyleClass().add("text-fields");
        tfSess4.getStyleClass().add("text-fields");
        tfBadge.getStyleClass().add("text-fields");
        tfUsername.getStyleClass().add("text-fields");
        tfPassword.getStyleClass().add("text-fields");
        pfPassword.getStyleClass().add("big-text-fields");
        pfPassword.setPromptText("Password");
      
    //Styling combo boxes
        cbAgency.getStyleClass().add("combo-boxes");
        cbAgencyLogin.getStyleClass().add("big-combo-boxes");
        cbAgencyLogin.setPromptText("Agency");
        cbRegStat.getStyleClass().add("combo-boxes");
        cbLicStat.getStyleClass().add("combo-boxes");
        cbOutstanding.getStyleClass().add("combo-boxes");
        cbReasonDriv.getStyleClass().add("combo-boxes");
        cbReasonVeh.getStyleClass().add("combo-boxes");
        cbPaid.getStyleClass().add("combo-boxes");
        cbReportable.getStyleClass().add("combo-boxes");
        cbSessAtt1.getStyleClass().add("combo-boxes");
        cbSessAtt2.getStyleClass().add("combo-boxes");
        cbSessAtt3.getStyleClass().add("combo-boxes");
        cbSessAtt4.getStyleClass().add("combo-boxes");
    //Styling report text
        taReport.getStyleClass().add("report-text");
        taReport.setWrapText(true);
    //Styling bottom rectangle 
        bottomRectangle.getStyleClass().add("bottom-rectangle");
    
	}
	
	public BorderPane createLoginPane() {
		
		styleVisualComponents();
		
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
		lbLoginError.setVisible(false);
		bottomRectangle.widthProperty().bind(pane.widthProperty());
		
		
		return pane;
	}
	
	public BorderPane createOptionPane(String centerContent) {
		
		styleVisualComponents();
		
	    HBox backLogoutHBox = new HBox(btBack, btLogout);
	    backLogoutHBox.setSpacing(40);
	    backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
	    backLogoutHBox.setPadding(new Insets(50));

	    VBox centerContentVBox=null;

	    switch (centerContent) {
	        case "Manage/Report":
	            centerContentVBox = new VBox(lbChoose, btManageRecords, btGenerateReport);
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
	        case "Vehicle/Driver Citation Summary":
				centerContentVBox = new VBox(lbReport, btVehicleCitations, btDriverCitations);
				centerContentVBox.setAlignment(Pos.CENTER);
				centerContentVBox.setSpacing(30);
				lbReport.setPadding(new Insets(100));
				centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
				break; 	 		                			                                        
	        case "Enter/Edit/Delete Record":
	            centerContentVBox = new VBox(lbChoose, btEnterRecord, btFindEditRecord, btDeleteRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "Enter/Edit/Delete Account":
	            centerContentVBox = new VBox(lbChoose, btEnterAccount, btFindEditAccount, btDeleteAccount);
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

	    return pane;
	}
	
	public BorderPane createSearchPane(String centerContent) {
		
		styleVisualComponents();
		HBox backLogoutHBox = new HBox(btBack, btLogout);
		backLogoutHBox.setSpacing(40);
		backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
		backLogoutHBox.setPadding(new Insets(50));
		
		StackPane feedbackStackSearch = new StackPane(lbEmptyFields, lbWrongFormat, lbNoRecord);
		lbEmptyFields.setVisible(false);
		lbWrongFormat.setVisible(false);
		lbNoRecord.setVisible(false);
		

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
		
		return pane;
	}
	public BorderPane createDataPane(String prompt, String fields) {
		
		styleVisualComponents();
		
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
		lbEmptyFields.setVisible(false);
		lbWrongFormat.setVisible(false);
		lbSuccessText.setVisible(false);
		
		HBox submitClearFeedbackHBox = new HBox(submitClearHBox, feedbackStackSubmit);
		submitClearFeedbackHBox.setPadding(new Insets(50));
		
	
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
				promptVBox = new VBox(lbDelete);
				promptVBox.setPadding(new Insets(0,0,0,50));
				StackPane feedbackStackDelete = new StackPane(lbSuccessText);
				feedbackStackDelete.setAlignment(Pos.CENTER_RIGHT);
				HBox deleteFeedbackHBox = new HBox(deleteHBox, feedbackStackDelete);
				deleteFeedbackHBox.setPadding(new Insets(50));
				lbSuccessText.setVisible(false);
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
			case("Driver Citation Summary"):
				lbStartDate.setText("Start Date (DD/MM/YYYY):");
				lbEndDate.setText("End Date (DD/MM/YYYY):");
				labelsVBox = new VBox(lbLic,  lbPlate, lbIssuingOff, lbStartDate, lbEndDate, lbReason, lbPaid);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfLic, tfPlate, tfIssuingOff,  tfStartDate, tfEndDate, cbReasonDriv, cbPaid);
				fieldsVBox.setSpacing(30);
				fieldsVBox.setAlignment(Pos.TOP_LEFT);
				break;
				
			case("Vehicle Citation Summary"):
				lbStartDate.setText("Start Date (DD/MM/YYYY):");
				lbEndDate.setText("End Date (DD/MM/YYYY):");
			
				labelsVBox = new VBox(lbVin,  lbPlate, lbIssuingOff, lbStartDate, lbEndDate, lbReason, lbPaid);
				labelsVBox.setSpacing(60);
				labelsVBox.setAlignment(Pos.TOP_RIGHT);
				labelsVBox.setPadding(new Insets(20));
				
				fieldsVBox = new VBox(tfVin, tfPlate, tfIssuingOff,  tfStartDate, tfEndDate, cbReasonVeh, cbPaid);
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
		
		return pane;
	}
	
	public BorderPane createReportPane() {
		styleVisualComponents();
		 
		HBox backLogoutHBox = new HBox(btBack, btLogout);
		backLogoutHBox.setSpacing(40);
		backLogoutHBox.setAlignment(Pos.CENTER_RIGHT);
		backLogoutHBox.setPadding(new Insets(50,50,5,50));
		
		ScrollPane reportScroll = new ScrollPane(taReport);
		reportScroll.setStyle("-fx-background-color: white;");
		reportScroll.setFitToWidth(true);
        reportScroll.setFitToHeight(true);
        reportScroll.setPrefViewportWidth(1440); 
        reportScroll.setPrefViewportHeight(1024);
        reportScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		reportScroll.setPadding(new Insets(20));
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: white;");
		pane.setTop(backLogoutHBox);
		pane.setCenter(reportScroll);
		
		
		return pane;
		
	}
	
	
	
	@Override
	public void start (Stage primaryStage) {
		
		primaryStage.setTitle("TrafficWatch");		
		primaryStage.setScene(new Scene	(createReportPane (), 1440,1024));
		primaryStage.getScene().getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
