package com.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import module.Member;

import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements Initializable {

    @FXML
    private TableView<Member> tbVMembers;

    @FXML
    private TableColumn<Member, String> tcName;

    @FXML
    private TableColumn<Member, String> tcPhone;

    @FXML
    private TableColumn<Member, String> tcEmail;

    @FXML
    private TableColumn<Member, String> tcAction;


    private ObservableList<Member> data = FXCollections.observableArrayList();
    private final ExecutorService executorService = Executors.newCachedThreadPool();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcAction.setCellValueFactory(new PropertyValueFactory<>("Action"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        data = FXCollections.observableArrayList(
                new Member("mark","96548532","mark@mail.com","call")
        );

        tbVMembers.setItems(data);
    }

}