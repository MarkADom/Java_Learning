module app.userreggui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;

    opens application to javafx.fxml;
    exports application;
}