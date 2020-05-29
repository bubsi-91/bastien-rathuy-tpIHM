package application;

import java.io.File;
import java.util.ArrayList;


import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Controller 
{
    private Line line = null;
    private Rectangle rec = null;
    private Ellipse el = null;
    private Shape selectedShape = null;
	
	@FXML
    private RadioButton rbSelectMove;

	@FXML
    private RadioButton rbEllipse;

	@FXML
    private RadioButton rbRectangle;

	@FXML
    private RadioButton rbLine;
	
	@FXML
    private ColorPicker cp;
	
	@FXML
    private Button bClone;
	
	@FXML
    private Button bDelete;
	
	@FXML
    private Pane drawArea;
    
    @FXML
    public void initialize()
    {	
    
    	ArrayList<Shape> listeFigures = new ArrayList<Shape>();
    	
    	cp.setValue(Color.BLACK);
    	
    	
    	//DESSIN
	    drawArea.setOnMousePressed(e->{
	    		
	    	if (rbRectangle.isSelected()) {
	    		rec = new Rectangle(e.getX(), e.getY(), 1, 1);
	    		rec.setFill(cp.getValue());
			    drawArea.getChildren().add(rec);
	       	} else {
	       		
	       		//SELECTION 
	       		/* NE FONCTIONNE PAS
			    drawArea.setOnMouseClicked(e1->{
			    	if (rbSelectMove.isSelected()) {
			    	 	selectedShape = (Shape) e1.getSource();
			    		selectedShape.setStroke(Color.RED);
			    	}
			    });*/
	       	}	
	    	    
	       	if (rbEllipse.isSelected()) {
	       		el = new Ellipse(e.getX(), e.getY(), 1, 1);
	        	el.setFill(cp.getValue());
	        	drawArea.getChildren().add(el);
	        } 
	        	
	        if (rbLine.isSelected()) {
	        	line = new Line(e.getX(), e.getY(), e.getX(), e.getY());
	        	line.setStroke(cp.getValue());
	        	drawArea.getChildren().add(line);
	        } 
	    });
	    
	  
	    	
	    drawArea.setOnMouseDragged(e -> {
	    	if (rbRectangle.isSelected()) {
	    		if (rec != null) {
	    			rec.setWidth(e.getX()-rec.getX());
	    			rec.setHeight(e.getY()-rec.getY());
	        	}
	       	}  
	        	
	       	if (rbEllipse.isSelected()) {
	       		if (el != null) {
	       			el.setRadiusX(e.getX()-el.getCenterX());
	       			el.setRadiusY(e.getY()-el.getCenterY());
	        	}
	        } 
	        	
	        if (rbLine.isSelected()) {
	        	if (line != null) {
		        	line.setEndX(e.getX());
	            	line.setEndY(e.getY());
	        	}
	        } 
	        
	        /*   NON IMPLEMENTE
	        if (rbSelectMove.isSelected()) {
	        	move(selectedShape);
	        }*/
	         
	    });
	     
	    
	    drawArea.setOnMouseReleased(e -> {
	    	if (rbRectangle.isSelected()) {
	    		listeFigures.add(rec);
	    		rec = null;
	        } 
	    	
	    	if (rbEllipse.isSelected()) {
	    		listeFigures.add(el);
	    		el = null;
	        } 
	    	
	    	if (rbLine.isSelected()) {
	    		listeFigures.add(line);
	    		line = null;
	        } 
	    	
	    });
    	
	    
    		/*  NON IMPLEMENTE
	  //COLOR PICKER
    	cp.setOnAction(e->{
    		if (selectedShape!=null && selectedShape instanceof Line) {
    			selectedShape.setStroke(cp.getValue());
    		} else if (selectedShape!=null) {
    			selectedShape.setFill(cp.getValue());
    		}
    		
    	});
	    
	    bDelete.setOnAction(e-> {
	    	if (selectedShape!=null && rbSelectMove.isSelected()) {
	    		canvas.getChildren().remove(selectedShape);
	    	}
	    });
	    
	    bClone.setOnAction(e-> {
	    	if (selectedShape!=null && rbSelectMove.isSelected()) {
	    		Shape c = clone(selectedShape);
	    		c.translate(5,5);
	    	}
	    })
	    */
	    
    }


private void move () {}

//public Shape clone () {}

}
