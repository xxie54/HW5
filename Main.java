//this file creates a picture form of a calculator, and abstract user inputs and math operation , then display result to the user. 
//with calculate methods called from the file Calculator.java

	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	//Declarations
	TextField tfNum1;
	TextField tfNum2;
	Button btnAddition;
	Button btnSubtraction;
	Button btnMultiply;
	Button btnDivide;
	Button btnSqrtrt;
 	Button btnFactorial;

	Button btnClear;
	Label lblAnswer;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Initializations
			 tfNum1 = new TextField();
			 tfNum2 = new TextField();
			 btnAddition = new Button("+");
			 btnSubtraction = new Button("-");
			 btnMultiply = new Button("*");
			 btnDivide = new Button("/");
			 btnClear = new Button("Clear");
			 btnSqrtrt = new Button("√");
			 btnFactorial = new Button("Factorial");
			 lblAnswer = new Label("?");
			 
			 //Layout using a GridPane
			 GridPane root = new GridPane();
			 root.setAlignment(Pos.CENTER);
			 root.setHgap(10);
			 root.setVgap(10);
			 
			 root.add(btnDivide, 0, 0);
			 root.add(btnMultiply, 1,0);
			 root.add(btnAddition, 0, 1);
			 root.add(btnSubtraction, 1, 1);
			 root.add(btnSqrtrt, 0, 2);
			 root.add(btnFactorial, 1,2 );
			 
			 root.add(btnClear, 0, 4, 2, 15);
			 
			 root.add(tfNum1, 0, 3);
			 root.add(tfNum2, 1, 3);
			 root.add(lblAnswer, 0, 3, 2, 10);
			 setWidths();
			 attachCode();
			 Scene scene = new Scene(root, 300, 250);
			 primaryStage.setTitle("Calculator FX 1.0");
			 primaryStage.setScene(scene);
			 primaryStage.show();
					 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void setWidths() {
		tfNum1.setPrefWidth(70);
		tfNum2.setPrefWidth(70);
		btnDivide.setPrefWidth(70);
		btnMultiply.setPrefWidth(70);
		btnAddition.setPrefWidth(70);
		btnSubtraction.setPrefWidth(70);
		btnSqrtrt.setPrefWidth(70);
		btnFactorial.setPrefWidth(90);
		

		btnClear.setPrefWidth(150);
		lblAnswer.setPrefWidth(150);
		lblAnswer.setAlignment(Pos.CENTER);
		lblAnswer.setStyle("-fx-border-color: #0000; -fx-padding: 5px;");
	}
	//associate a function with a button
	public void attachCode() {
		btnAddition.setOnAction(e-> btncode(e));
		btnSubtraction.setOnAction(e-> btncode(e));
		btnMultiply.setOnAction(e-> btncode(e));
		btnDivide.setOnAction(e-> btncode(e));
		btnSqrtrt.setOnAction(e-> btncode(e));
		btnFactorial.setOnAction(e-> btncode(e));
		

		btnClear.setOnAction(e-> btncode(e));
	}
	
	//do specific operations for each button
	public void btncode(ActionEvent e) {
		 
		int num1, num2=0;
		double answer=0;
		char symbol=' ';
		
		Calculator john = new Calculator();

		//read the number from the text box
		num1 = Integer.parseInt(tfNum1.getText());
		num2 = Integer.parseInt(tfNum2.getText());
		 
		if(e.getSource() == btnAddition) {
			symbol = '+';
			john.addNumbers(num1, num2);
			answer=john.result;

		} else if (e.getSource() == btnSubtraction) {
			symbol = '-';
			john.subtractNumbers(num1,num2);
			answer=john.result;

		} else if (e.getSource() == btnMultiply) {
			symbol = '*';
			john.multiplyNumbers(num1,num2);
			answer=john.result;

		} else if (e.getSource() == btnDivide) {
			symbol = '/';
			john.divideNumbers(num1,num2);
			answer=john.result;
		}
	
		  else if (e.getSource() == btnSqrtrt){
			symbol = '√';
			john.squarerootNumber(num1);
			answer=john.result;
		  }
		  else if (e.getSource() == btnFactorial) {
			symbol = 'f';
			john.factorialNumber(num1);
			answer=john.result;
		}


		  else {
			tfNum1.setText("");
			tfNum2.setText("");
			lblAnswer.setText("?");
			tfNum1.requestFocus();
			return;
		}
		

		lblAnswer.setText("" + num1 + symbol + num2 + "=" + answer);
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
