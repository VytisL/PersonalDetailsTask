module com.example.personaldetails {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personaldetails to javafx.fxml;
    exports com.example.personaldetails;
}