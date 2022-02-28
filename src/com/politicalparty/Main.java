package com.politicalparty;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.politicalparty.usersPkg.DLC;
import com.politicalparty.usersPkg.FinancialManager;
import com.politicalparty.usersPkg.GeneralMember;
import com.politicalparty.usersPkg.Manager;
import com.politicalparty.usersPkg.NLC;
import com.politicalparty.usersPkg.User;
import com.politicalparty.util.AlertBox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static User activeUser;
    public static boolean isJobWindowOpen;

    public static void main2(String[] args) {
//        try {
//            DataOutputStream dos = new DataOutputStream(new FileOutputStream("./data/login credintials/Financial Manager.bin"));
//            dos.writeUTF("5");
//            dos.writeUTF("5");
//            dos.close();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./data/user data/NLC Member.bin"));
            os.writeObject(new NLC("A", "1", "A", "a@xyz.com", "1", 1));
            os.close();
            
            os = new ObjectOutputStream(new FileOutputStream("./data/user data/DLC Member.bin"));
            os.writeObject(new DLC("B", "2", "B", "b@xyz.com", "2", 2));
            os.close();
            
            os = new ObjectOutputStream(new FileOutputStream("./data/user data/General Member.bin"));
            os.writeObject(new GeneralMember("C", "3", "C", "c@xyz.com", "3", 3));
            os.close();
            
            os = new ObjectOutputStream(new FileOutputStream("./data/user data/Manager.bin"));
            os.writeObject(new Manager("D", "4", "D", "d@xyz.com", "4", 4));
            os.close();
            
            os = new ObjectOutputStream(new FileOutputStream("./data/user data/Financial Manager.bin"));
            os.writeObject(new FinancialManager("E", "5", "E", "e@xyz.com", "5", 5));
            os.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {

        }
        System.out.println("FINISHED...");
    }

    public static void main(String[] args) {
        
        
        File dataFile = new File("./data/user data/NLC Member.bin");
        ObjectInputStream ois;

        // load all the nlc's
        try {
            ois = new ObjectInputStream(new FileInputStream(dataFile));

            try {
                while (true) {
                    try {
                        Party.nlcMembers.add((NLC) ois.readObject());
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (EOFException e) {
                ois.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // loading dlc's
        dataFile = new File("./data/user data/DLC Member.bin");

        try {
            ois = new ObjectInputStream(new FileInputStream(dataFile));

            try {
                while (true) {
                    try {
                        Party.dlcMembers.add((DLC) ois.readObject());
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (EOFException e) {
                ois.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // loading gm's
        dataFile = new File("./data/user data/General Member.bin");

        try {
            ois = new ObjectInputStream(new FileInputStream(dataFile));

            try {
                while (true) {
                    try {
                        Party.generalMembers.add((GeneralMember) ois.readObject());
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (EOFException e) {
                ois.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // loading manager
        dataFile = new File("./data/user data/Manager.bin");

        try {
            ois = new ObjectInputStream(new FileInputStream(dataFile));
            try {
                Party.manager = (Manager) ois.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                ois.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // loading Financial manager
        dataFile = new File("./data/user data/Financial Manager.bin");

        try {
            ois = new ObjectInputStream(new FileInputStream(dataFile));
            try {
                Party.finaciaManager = (FinancialManager) ois.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                ois.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./scenes/Login.fxml"));

        stage.setScene(new Scene(root));
        stage.setTitle("Login/Sign up Screen");
        stage.show();
    }

}
