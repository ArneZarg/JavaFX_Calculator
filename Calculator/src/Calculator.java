//Calculator Assignment
//Arne Zargarian
//1218735
//CSIS 139
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class Calculator extends Application {
	private TextField tfTotal = new TextField();
	private TextField tfNumbers = new TextField();
	private Label total = new Label("Total: ");
	private Label input = new Label("Input: ");
	private Button b1 = new Button("1");
	private Button b2 = new Button("2");
	private Button b3 = new Button("3");
	private Button b4 = new Button("4");
	private Button b5 = new Button("5");
	private Button b6 = new Button("6");
	private Button b7 = new Button("7");
	private Button b8 = new Button("8");
	private Button b9 = new Button ("9");
	private Button b0 = new Button("0");
	private Button decimal = new Button(".");
	private Button btClear = new Button ("C");
	private Button btEquals = new Button("=");
	private Button btPlus = new Button("+");
	private Button btMinus = new Button("-");
	private Button btDivide = new Button("/");
	private Button btMult = new Button("*");
	private String tempString = "";
	@Override
	public void start(Stage primaryStage) {
		
		//Text Boxes and Labels:
		input.setTranslateX(120);
		input.setTranslateY(15);
		
		total.setTranslateX(120);
		total.setTranslateY(80);
		
		tfNumbers.setEditable(false);
		tfNumbers.setMaxWidth(100);
		tfNumbers.setTranslateY(50);
		tfNumbers.setTranslateX(120);
		
		tfTotal.setTranslateX(120);
		tfTotal.setTranslateY(50);
		tfTotal.setEditable(false);
		tfTotal.setTranslateX(120);
		tfTotal.setTranslateY(110);
		tfTotal.setMaxWidth(100);
		
		
		//Numbers:
		
		b1.setTranslateX(15);
		b1.setTranslateY(80);
		b1.setOnAction(e -> inputNumbers(b1));
		
		b2.setTranslateX(40);
		b2.setTranslateY(80);
		b2.setOnAction(e -> inputNumbers(b2));
		
		b3.setTranslateX(65);
		b3.setTranslateY(80);
		b3.setOnAction(e -> inputNumbers(b3));
		
		b4.setTranslateX(15);
		b4.setTranslateY(50);
		b4.setOnAction(e -> inputNumbers(b4));
		
		b5.setTranslateX(40);
		b5.setTranslateY(50);
		b5.setOnAction(e -> inputNumbers(b5));
		
		b6.setTranslateX(65);
		b6.setTranslateY(50);
		b6.setOnAction(e -> inputNumbers(b6));
		
		b7.setTranslateX(15);
		b7.setTranslateY(20);
		b7.setOnAction(e -> inputNumbers(b7));
		
		b8.setTranslateX(40);
		b8.setTranslateY(20);
		b8.setOnAction(e -> inputNumbers(b8));
		
		b9.setTranslateX(65);
		b9.setTranslateY(20);
		b9.setOnAction(e -> inputNumbers(b9));
		
		b0.setTranslateX(15);
		b0.setTranslateY(110);
		b0.setOnAction(e -> inputNumbers(b0));
		
		//Clear Button
		btClear.setTranslateX(65);
		btClear.setTranslateY(110);
		btClear.setOnAction(e -> clearInput());
		
		//Math Function Buttons
		btEquals.setTranslateX(40);
		btEquals.setTranslateY(110);
		btEquals.setOnAction(e -> calculate());
		
		btPlus.setTranslateX(15);
		btPlus.setTranslateY(160);
		btPlus.setOnAction(e -> add());
		
		btMinus.setTranslateX(45);
		btMinus.setTranslateY(160);
		btMinus.setPrefSize(btPlus.getWidth() + 25, btPlus.getHeight());
		btMinus.setOnAction(e -> subtract());
		
		btDivide.setTranslateX(75);
		btDivide.setTranslateY(160);
		btDivide.setPrefSize(btMinus.getWidth() + 25, btPlus.getHeight());
		btDivide.setOnAction(e -> divide());

		btMult.setTranslateX(105);
		btMult.setTranslateY(160);
		btMult.setPrefSize(btMinus.getWidth() + 25, btPlus.getHeight());
		btMult.setOnAction(e -> multiply());
		
		//Decimal Button
		decimal.setTranslateX(135);
		decimal.setTranslateY(160);
		decimal.setPrefSize(btMinus.getWidth() + 25, btPlus.getHeight());
		decimal.setOnAction(e -> addDec(decimal));
		
		//Get Children
		GridPane pane = new GridPane();
		pane.getChildren().add(b1);
		pane.getChildren().add(b2);
		pane.getChildren().add(b3);
		pane.getChildren().add(b4);
		pane.getChildren().add(b5);
		pane.getChildren().add(b6);
		pane.getChildren().add(b7);
		pane.getChildren().add(b8);
		pane.getChildren().add(b9);
		pane.getChildren().add(b0);
		pane.getChildren().add(btClear);
		pane.getChildren().add(btEquals);
		pane.getChildren().add(btPlus);
		pane.getChildren().add(btMinus);
		pane.getChildren().add(btDivide);
		pane.getChildren().add(btMult);
		pane.getChildren().add(tfTotal);
		pane.getChildren().add(total);
		pane.getChildren().add(tfNumbers);
		pane.getChildren().add(input);
		pane.getChildren().add(decimal);
		
		// TODO Auto-generated method stub
		Scene scene = new Scene(pane, 250, 250);
	    primaryStage.setTitle("AZ Calculator"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	}
	public void addDec(Button bt)
	{
		String s = tfNumbers.getText();
		for(int i = 0; i <= s.length(); i++)
		{
			if(s.contains("."))
			{
				return;
			}
		}
		tfNumbers.setText(tfNumbers.getText() + bt.getText());
	}
	public void inputNumbers(Button bt)
	{
		tfNumbers.setText(tfNumbers.getText() + bt.getText());
	}
	public void clearInput()
	{
		tfNumbers.setText("");
		tfTotal.setText("");
		tempString = "";
	}
	public void add()
	{
		tempString = "+";
		if(tfTotal.getText().isEmpty())
		{
			tfTotal.setText(tfNumbers.getText());
			tfNumbers.setText("");
			return;
		}
		else if(tfNumbers.getText().isEmpty())
		{
			return;
		}
		else
		{
			double numTotal = Double.parseDouble(tfTotal.getText())+ Double.parseDouble(tfNumbers.getText());
			tfNumbers.setText("");
			tfTotal.setText(Double.toString(numTotal));
		}
	}
	public void subtract()
	{
		tempString = "-";
		if(tfTotal.getText().isEmpty())
		{
			tfTotal.setText(tfNumbers.getText());
			tfNumbers.setText("");
			return;
		}
		else if(tfNumbers.getText().isEmpty())
		{
			return;
		}
		else
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) - Double.parseDouble(tfNumbers.getText());
			tfNumbers.setText("");
			tfTotal.setText(Double.toString(numTotal));
		}
	}
	public void multiply()
	{
		tempString = "*";
		if(tfTotal.getText().isEmpty())
		{
			tfTotal.setText(tfNumbers.getText());
			tfNumbers.setText("");
			return;
		}
		else if(tfNumbers.getText().isEmpty())
		{
			return;
		}
		else
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) * Double.parseDouble(tfNumbers.getText());
			tfNumbers.setText("");
			tfTotal.setText(Double.toString(numTotal));
		}
	}
	public void divide()
	{
		tempString = "/";
		if(tfTotal.getText().isEmpty())
		{
			tfTotal.setText(tfNumbers.getText());
			tfNumbers.setText("");
			return;
		}
		else if(tfNumbers.getText().isEmpty())
		{
			return;
		}
		else
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) / Double.parseDouble(tfNumbers.getText());
			tfNumbers.setText("");
			tfTotal.setText(Double.toString(numTotal));
		}
	}
	public void calculate()
	{
		if(tempString == "+")
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) + Double.parseDouble(tfNumbers.getText());
			tfTotal.setText(Double.toString(numTotal));
			tfNumbers.setText("");
		}
		else if(tempString == "-")
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) - Double.parseDouble(tfNumbers.getText());
			tfTotal.setText(Double.toString(numTotal));
			tfNumbers.setText("");
		}
		else if(tempString == "*")
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) * Double.parseDouble(tfNumbers.getText());
			tfTotal.setText(Double.toString(numTotal));
			tfNumbers.setText("");
		}
		else if(tempString == "/")
		{
			double numTotal = Double.parseDouble(tfTotal.getText()) / Double.parseDouble(tfNumbers.getText());
			tfTotal.setText(Double.toString(numTotal));
			tfNumbers.setText("");
		}
		if(tfNumbers.getText() == null)
		{
			return;
		}
		if(tempString == "")
		{
			return;
		}
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
