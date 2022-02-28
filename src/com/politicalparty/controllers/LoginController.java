package com.politicalparty.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import com.politicalparty.Main;
import com.politicalparty.Party;
import com.politicalparty.usersPkg.GeneralMember;
import com.politicalparty.usersPkg.User;
import com.politicalparty.util.PP_ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField usrField;

    @FXML
    private PasswordField pwField;

    @FXML
    private ComboBox<String> dsgSelector;
    
    @FXML
    private Button loginBtn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField nidField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField pwSignUp;

    @FXML
    private TextField phoneField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private Button signUpBtn;

    @FXML
    private Label jobApplyLbl;

    @FXML
    private Button jobApplicationSceneBtn;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        dsgSelector.getItems().addAll("NLC Member", "DLC Member", "General Member", "Manager", "Financial Manager");

        if (!Main.isJobWindowOpen) {
            jobApplyLbl.setVisible(false);
            jobApplicationSceneBtn.setVisible(false);
        }
       
    }

    @FXML
    void onLoginBtnClick(ActionEvent event) {
        System.out.println("fired");

        String username = usrField.getText();
        String password = pwField.getText();
        String userType = dsgSelector.getValue();

        System.out.println("Username: " + username + " Password: " + password);

        File loginDataFile = new File("./data/login credintials/" + userType + ".bin");
        File userDataFile = new File("./data/user data/" + userType + ".bin");

        DataInputStream loginCredData = null;
        ObjectInputStream userObjectData = null;

        if (loginDataFile.exists()) {
            try {
                loginCredData = new DataInputStream(new FileInputStream(loginDataFile));
                String _u, _p;

                try {
                    while (true) // iterating the user credential files to find available member
                    {
                        _u = loginCredData.readUTF();
                        _p = loginCredData.readUTF();

                        if (username.equals(_u) && password.equals(_p)) {
                            userObjectData = new ObjectInputStream(new FileInputStream(userDataFile));
                            User _user;

                            try {
                                while (true) // iterating through user data file for the matched user to login
                                {
                                    _user = (User) userObjectData.readObject();

                                    if (username.equals(_user.getNid())) {
                                        Main.activeUser = _user;
                                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                                        Parent homepage = FXMLLoader.load(getClass().getResource("../scenes/" + userType + "/" + userType + ".fxml"));

                                        window.setScene(new Scene(homepage));
                                        window.show();

                                        break;
                                    }
                                }
                            } catch (EOFException ex) {
                                ex.printStackTrace();
                            } catch (ClassNotFoundException ex) {
                                // TODO Auto-generated catch block
                                ex.printStackTrace();
                            }

                            break;
                        }
                    }
                } catch (EOFException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                    System.out.println("no match found");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    loginCredData.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void onSignUpBtnClick(ActionEvent event) {
        System.out.println("fired");

        File gmLoginCredFile = new File("./data/login credintials/General Member.bin");
        DataOutputStream gmLoginCredData = null;

        File gmUserDataFile = new File("./data/user data/General Member.bin");
        ObjectOutputStream gmUserData = null;

        String name, nid, location, emailAddress, phoneNumber, password;
        LocalDate dateOfBirth;

        name = nameField.getText();
        nid = nidField.getText();
        location = locationField.getText();
        emailAddress = emailField.getText();
        phoneNumber = phoneField.getText();
        password = pwSignUp.getText();
        dateOfBirth = dateOfBirthField.getValue();

        GeneralMember gm = new GeneralMember(
                name, nid, location, emailAddress,
                phoneNumber, Period.between(dateOfBirth, LocalDate.now()).getYears()
        );

        // added login username and password
        if (gmLoginCredFile.exists()) {
            try {
                gmLoginCredData = new DataOutputStream(new FileOutputStream(gmLoginCredFile, true));
                try {
                    gmLoginCredData.writeUTF(nid);
                    gmLoginCredData.writeUTF(password);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    gmLoginCredData.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            try {
                gmLoginCredData = new DataOutputStream(new FileOutputStream(gmLoginCredFile));
                try {
                    gmLoginCredData.writeUTF(nid);
                    gmLoginCredData.writeUTF(password);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    gmLoginCredData.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        // added new user data
        if (gmUserDataFile.exists()) {
            try {
                gmUserData = new PP_ObjectOutputStream(new FileOutputStream(gmUserDataFile, true));
                gmUserData.writeObject(gm);
                Party.generalMembers.add((GeneralMember) gm);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    gmUserData.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            try {
                gmUserData = new ObjectOutputStream(new FileOutputStream(gmUserDataFile));
                gmUserData.writeObject(gm);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    gmUserData.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void onJobApplicationSceneBtnClicked(ActionEvent event) {
        // to be implemented
    }

}
