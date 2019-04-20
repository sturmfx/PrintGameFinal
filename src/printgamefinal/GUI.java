/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printgamefinal;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author lordstorm
 */
public class GUI extends VBox
{
    int time3 = 0;
    long time1 = System.currentTimeMillis();
    long time2 = System.currentTimeMillis();
    int correct = 0;
    int mistakes = 0;
    int index = 20;
    boolean continue1 = true;
    String words = "Historically, the fundamental role of pharmacists as a healthcare practitioner was to check and distribute drugs to doctors";
    HBox buttons = new HBox();
    Button startstop = new Button("Stop");
    
    Button reset = new Button("RESET");
    Label correct_l = new Label("Correct: " + correct);
    Label mistake_l = new Label("Mistakes: " + mistakes);
    Label time_l = new Label("Seconds gone: " + String.valueOf(((time2-time1)/1000) +time3));
    Label rate = new Label("Characters per minute: ");
    TextFlow text = new TextFlow();
    Text text_start = new Text();
    Text text_end = new Text();
    Text text_middle = new Text();
    ObservableList list = text.getChildren(); 
    
    public GUI()
    {
        startstop.setFocusTraversable(false);
        reset.setFocusTraversable(false);
        reset.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                time1 = System.currentTimeMillis();
                time2 = System.currentTimeMillis();
                time3 = 0;
                correct = 0;
                mistakes = 0;
                index = 0;
            }
        });
        startstop.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                if(continue1)
                {
                    continue1 = !continue1;
                    startstop.setText("START");
                    time3 += (int) (time2-time1)/1000;
                }
                else
                {
                    continue1 = !continue1;
                    startstop.setText("STOP");
                    time1 = System.currentTimeMillis();
                    time2 = System.currentTimeMillis();
                }
            }
        });
        buttons.getChildren().add(startstop);
        buttons.getChildren().add(reset);
        buttons.getChildren().add(correct_l);
        buttons.getChildren().add(mistake_l);
        buttons.getChildren().add(time_l);
        buttons.getChildren().add(rate);
        
        getChildren().add(buttons);
        getChildren().add(text);
        
        text_start.setText(words.substring(0, index));
        text_middle.setText(words.substring(index, index+1));
        text_middle.setFill(Color.RED);
        text_end.setText(words.substring(index+1, words.length()-1));
        text_start.setFont(new Font(30));
        text_middle.setFont(new Font(30));
        text_end.setFont(new Font(30));
        list.addAll(text_start, text_middle, text_end);
    }
    public void setText()
    {
        if(index < words.length()-1)
        {
        text_start.setText(words.substring(0, index));
        text_middle.setText(words.substring(index, index+1));
        text_middle.setFill(Color.RED);
        text_end.setText(words.substring(index+1, words.length()-1));
        //list.addAll(text_start, text_middle, text_end);
        }
        else
        {
            time1 = System.currentTimeMillis();
                time2 = System.currentTimeMillis();
                time3 = 0;
                correct = 0;
                mistakes = 0;
                index = 0;
        }
        
    }
}
