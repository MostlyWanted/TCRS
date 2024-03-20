package VisualDesign;

// import Assignments;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VisualDesignComponents extends Application {


	//Buttons	
	//Basic buttons
	public Button btClear = new Button ("Clear");
	public Button btSubmit = new Button ("Submit");
	public Button btLogout = new Button ("Logout");
	public Button btExit = new Button ("Exit");
	public Button btBack = new Button ("Back");
	public Button btLogin = new Button("Login");
	public Button btDelete = new Button("Delete");
	//Record management buttons
	public Button btEnterRecord = new Button("Enter a Record");
	public Button btFindEditRecord = new Button("Find/Edit a Record");
	public Button btDeleteRecord = new Button("Delete a Record");
	public Button btEnterAccount = new Button("Enter Account");
	public Button btFindEditAccount = new Button("Find/Edit Account");
	public Button btDeleteAccount = new Button("Delete Account");
	//Record navigation buttons
	public Button btManageRecords = new Button("Manage Records");
	public Button btVehicleRecords = new Button("Vehicle Records");
	public Button btDriverRecords = new Button("Driver Records");
	public Button btWarrants = new Button("Warrants");
	public Button btVehicleWarrants = new Button("Vehicle Warrants");
	public Button btDriverWarrants = new Button("Driver Warrants");
	public Button btCitations = new Button("Citations");
	public Button btVehicleCitations = new Button("Vehicle Citations");
	public Button btDriverCitations = new Button("Driver Citations");
	public Button btTrafficSchool = new Button("Traffic School");
	public Button btEnrollment = new Button("Enrollment");
	public Button btAttendance = new Button("Attendance");
	public Button btOfficers = new Button("Officers");
	//Report navigation/management buttons
	public Button btGenerateReport = new Button("Generate a Report");
	public Button btVehicleInfo = new Button("Vehicle Information");
	public Button btDriverInfo = new Button("Driver Information");
	public Button btDrivingRecord = new Button("Driving Record");
	public Button btCitationSummary = new Button("Citation Summary");
	public Button btOutstandingWarrants = new Button("Outstanding Warrants");
	public Button btBoth = new Button("Both");
	
	//Labels
	//Login page labels
	Label lbTrafficWatch = new Label ("Traffic Watch: ");
	Label lbAppDescription = new Label ("The provincial and municipal system for traffic citations and reporting");
	//Feedback labels
	public Label lbEmptyFields = new Label ("Please fill in all fields.");
	public Label lbWrongFormat = new Label ("Incorrect format. Please try again.");
	public Label lbNoRecord = new Label ("No record found.");
	public Label lbLoginError = new Label("Invalid login. Please try again.");
	public Label lbSuccessText = new Label("Successful submission.");
	//Instruction labels
	Label lbChoose = new Label ("Would you like to?");
	Label lbManage = new Label ("Which information would you like to manage?");
	Label lbReport = new Label ("Which information would you like to report?");
	Label lbEnter = new Label ("Enter information:");
	Label lbEdit = new Label ("Edit information:");
	Label lbFilter = new Label ("Filter information:");
	Label lbDelete = new Label ("Delete?");
	//Labels for text fields 
	Label lbEnterVin = new Label ("Enter the VIN:");
	Label lbEnterLic = new Label ("Enter the license number:");
	Label lbEnterStart = new Label ("Enter the start date (DD/MM/YYYY):");
	Label lbEnterEnd = new Label ("Enter the end date (DD/MM/YYYY):");
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
	TextField tfEnterVin = new TextField();
    TextField tfEnterLic = new TextField();
    TextField tfEnterStart = new TextField();
    TextField tfEnterEnd = new TextField();
    TextField tfEnterCitID = new TextField();
    TextField tfEnterWarID = new TextField();
    TextField tfEnterBadge = new TextField();
    TextField tfEnterAcc = new TextField();
    TextField tfVin = new TextField();
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
    TextField tfFine = new TextField();
    TextField tfIssuingOff = new TextField();
    TextField tfSess1 = new TextField();
    TextField tfSess2 = new TextField();
    TextField tfSess3 = new TextField();
    TextField tfSess4 = new TextField();
    TextField tfBadge = new TextField();
    TextField tfUsername = new TextField();
    TextField tfPassword = new TextField(); 
    TextField tfUsernameLogin = new TextField();
    PasswordField tfPasswordLogin = new PasswordField();
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
            "Yes", "No"));
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
		lbEmptyFields.setGraphic(warningIcon);
		lbWrongFormat.setGraphic(warningIcon);
        lbNoRecord.setGraphic(warningIcon);
        lbLoginError.setGraphic(warningIcon);
        lbSuccessText.setGraphic(warningIcon);
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
        btBoth.getStyleClass().add("big-buttons");
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
        lbEnterStart.getStyleClass().add("big-label");
        lbEnterEnd.getStyleClass().add("big-label");
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
        tfEnterVin.getStyleClass().add("text-fields");
        tfEnterLic.getStyleClass().add("text-fields");
        tfEnterStart.getStyleClass().add("text-fields");
        tfEnterEnd.getStyleClass().add("text-fields");
        tfEnterCitID.getStyleClass().add("text-fields");
        tfEnterWarID.getStyleClass().add("text-fields");
        tfEnterBadge.getStyleClass().add("text-fields");
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
        tfFine.getStyleClass().add("text-fields");
        tfIssuingOff.getStyleClass().add("text-fields");
        tfSess1.getStyleClass().add("text-fields");
        tfSess2.getStyleClass().add("text-fields");
        tfSess3.getStyleClass().add("text-fields");
        tfSess4.getStyleClass().add("text-fields");
        tfBadge.getStyleClass().add("text-fields");
        tfUsername.getStyleClass().add("text-fields");
        tfPassword.getStyleClass().add("text-fields");
        tfUsernameLogin.getStyleClass().add("big-text-fields");
        tfUsernameLogin.setPromptText("Username");
        tfPasswordLogin.getStyleClass().add("big-text-fields");
        tfPasswordLogin.setPromptText("Password");
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
        taReport.getStyleClass().add("small-label");
        //Styling bottom rectangle 
        bottomRectangle.getStyleClass().add("bottom-rectangle");
    
	}




	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	public BorderPane createLoginPane() {
		
		VBox loginTop = new VBox (lbTrafficWatch, lbAppDescription, cbAgencyLogin, tfUsernameLogin, tfPasswordLogin);	
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
		
	    HBox backLogoutB = new HBox(btBack, btLogout);
	    backLogoutB.setSpacing(40);
	    backLogoutB.setAlignment(Pos.CENTER_RIGHT);
	    backLogoutB.setPadding(new Insets(50));

	    VBox centerContentVBox=null;

	    switch (centerContent) {
	        case "manageReport":
	            centerContentVBox = new VBox(lbChoose, btManageRecords, btGenerateReport);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "vehDriv":
	            centerContentVBox = new VBox(lbManage, btVehicleRecords, btDriverRecords);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "vehDrivCit":
	            centerContentVBox = new VBox(lbManage, btVehicleCitations, btDriverCitations);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "vehDrivWar":
	            centerContentVBox = new VBox(lbManage, btVehicleWarrants, btDriverWarrants);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "CitSumOutWar":
	            centerContentVBox = new VBox(lbReport, btCitationSummary, btOutstandingWarrants);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbReport.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "EnrolAtt":
	            centerContentVBox = new VBox(lbManage, btEnrollment, btAttendance);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(100));
	            centerContentVBox.setPadding(new Insets(100, 0, 300, 0));
	            break;

	        case "enterEditDeleteRecord":
	            centerContentVBox = new VBox(lbChoose, btEnterRecord, btFindEditRecord, btDeleteRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "enterEditDeleteAccount":
	            centerContentVBox = new VBox(lbChoose, btEnterAccount, btFindEditAccount, btDeleteAccount);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbChoose.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "vehDriRecRep":
	            centerContentVBox = new VBox(lbReport, btVehicleInfo, btDriverInfo, btDrivingRecord);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbReport.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "vehDriBothRep":
	            centerContentVBox = new VBox(lbReport, btVehicleCitations, btDriverCitations, btBoth);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbReport.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;

	        case "citWarOffTraff":
	            centerContentVBox = new VBox(lbManage, btCitations, btWarrants, btOfficers, btTrafficSchool);
	            centerContentVBox.setAlignment(Pos.CENTER);
	            centerContentVBox.setSpacing(30);
	            lbManage.setPadding(new Insets(80));
	            centerContentVBox.setPadding(new Insets(50, 0, 400, 0));
	            break;
	    }

	    BorderPane pane = new BorderPane();
	    pane.setStyle("-fx-background-color: white;");
	    pane.setTop(backLogoutB);
	    pane.setCenter(centerContentVBox);

	    return pane;
	}

	
	
	@Override
	public void start (Stage primaryStage) {
		
		styleVisualComponents();
		
		//Login containers
		
		VBox loginTopB = new VBox (lbTrafficWatch, lbAppDescription, cbAgencyLogin, tfUsernameLogin, tfPasswordLogin);	
		loginTopB.setAlignment(Pos.CENTER);
		loginTopB.setSpacing(30);
		loginTopB.setPadding(new Insets(50));
		VBox loginBottomB = new VBox (btLogin, lbLoginError);
		loginBottomB.setAlignment(Pos.CENTER);
		loginBottomB.setSpacing(30);
		loginBottomB.setPadding(new Insets(20));
		VBox loginB = new VBox (loginTopB, loginBottomB);
		HBox exitB = new HBox (btExit);
		exitB.setAlignment(Pos.CENTER_RIGHT);
		exitB.setPadding(new Insets(50));
		lbLoginError.setVisible(false);
		//Login border pane
		BorderPane loginPane = new BorderPane();
		loginPane.setStyle("-fx-background-color: white;");
		loginPane.setCenter(loginB);
		loginPane.setTop(exitB);
		loginPane.setBottom(bottomRectangle);
		bottomRectangle.widthProperty().bind(loginPane.widthProperty());
	
		//Repetitive containers
		//submit clear
		HBox submitClearB = new HBox(btClear, btSubmit);
		submitClearB.setSpacing(40);
		submitClearB.setPadding(new Insets(50));
		//delete
		HBox deleteB = new HBox(btDelete);
		deleteB.setPadding(new Insets(50));
		//back logout
		HBox backLogoutB = new HBox (btBack, btLogout);
		backLogoutB.setSpacing(40);
		backLogoutB.setAlignment(Pos.CENTER_RIGHT);
		backLogoutB.setPadding(new Insets(50));
		
	
	    
	    //2 option option pages
		VBox manageReportB = new VBox (lbChoose, btManageRecords, btGenerateReport);
		manageReportB.setAlignment(Pos.CENTER);
		manageReportB.setSpacing(30);
		lbChoose.setPadding(new Insets(100));
		manageReportB.setPadding(new Insets(100,0,300,0));
		// Enroll Attend button
		VBox EnrolAttB = new VBox(lbManage, btEnrollment, btAttendance);
		EnrolAttB.setAlignment(Pos.CENTER);
		EnrolAttB.setSpacing(30);
        lbManage.setPadding(new Insets(100));
        EnrolAttB.setPadding(new Insets(100, 0, 300, 0));
				
		//Main options pane
		BorderPane proMainPane = new BorderPane();
		proMainPane.setStyle("-fx-background-color: white;");
		proMainPane.setTop(backLogoutB);
		proMainPane.setCenter(manageReportB);
		//manage options pane
		BorderPane proManagePane = new BorderPane();
		proManagePane.setStyle("-fx-background-color: white;");
		proManagePane.setTop(backLogoutB);
		proManagePane.setCenter(EnrolAttB);
		
	
		Scene scene = new Scene	(proManagePane, 1440,1024);
		scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());

		primaryStage.setTitle("TrafficWatch");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

}
