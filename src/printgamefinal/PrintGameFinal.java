/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printgamefinal;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lordstorm
 */
public class PrintGameFinal extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        GUI g;
        g = new GUI();
        
        StackPane root = new StackPane();
        root.getChildren().add(g);
        
        Scene scene = new Scene(root, 600, 600);
        scene.setOnKeyReleased
        (
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                   if(g.continue1)
                   {
                       if(e.getText().toLowerCase().equals(g.words.substring(g.index, g.index+1).toLowerCase()))
                       {
                           g.correct++;
                           g.index++;
                           g.setText();
                           
                           
                       }
                       else
                       {
                           g.mistakes++;
                           g.index++;
                           g.setText();
                       }
                   }
                   e.consume();
                }
            }
        );
         new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                if(g.continue1)
                {
                g.time2 = System.currentTimeMillis();
                g.correct_l.setText("Correct: " + g.correct);
                g.mistake_l.setText("Mistakes: " + g.mistakes);
                g.time_l.setText("Elapsed time is " + (((g.time2 - g.time1)/1000)+g.time3) + " seconds.");
                g.rate.setText(String.valueOf(60*(g.index+1)/(((g.time2 - g.time1)/1000)+g.time3+1)));
                
                
                
                }
                
            }
        }.start();
        
        primaryStage.setTitle("Print Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
