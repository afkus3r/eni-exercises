module fr.eni.rockpaperscissors {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.eni.rockpaperscissors to javafx.fxml;
    exports fr.eni.rockpaperscissors;
}