open module minesweeper.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.slf4j;

    exports com.mooney.minesweeper;
    exports com.mooney.minesweeper.ui;
}