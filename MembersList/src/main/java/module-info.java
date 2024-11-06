module com.memberlist.memberlist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.controllers to javafx.fxml;
    exports com.controllers;
}