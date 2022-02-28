package com.politicalparty.util;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
	public static void showMessageBox(String msg, String title)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		window.setMinWidth(230);
		
		Label lb1 = new Label(msg);
		VBox layout = new VBox(lb1);
		window.setScene(new Scene(layout));
		window.show();
	}
	
	public static void showMessageBox(String msg1, String msg2, String title)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		window.setMinWidth(230);
		
		Label lb1 = new Label(msg1);
		Label lb2 = new Label(msg2);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(lb1, lb2);
		
		window.setScene(new Scene(layout));
		window.show();
	}
}
