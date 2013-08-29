import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatrixManipulationWindow extends JFrame
{
	CardLayout card = new CardLayout();
	JPanel mainPnl = new JPanel();
	JPanel multiMatrix = new JPanel();
	JPanel echelonCheckScreen = new JPanel();
	JPanel rEchelonCheckScreen = new JPanel();
	JPanel tTEchelonScreen = new JPanel();
	JPanel result = new JPanel();
	JPanel cardPanel = new JPanel();
	JTextArea eMatrix = new JTextArea("The matrix goes here",12,42);
	JTextArea rEMatrix = new JTextArea("The matrix goes here",12,42);
	JTextArea eTMatrix = new JTextArea("The matrix goes here",12,41);
	JTextArea matrix1 = new JTextArea("Matrix 1 goes here",12,21);
	JTextArea matrix2 = new JTextArea("Matrix 2 goes here",12,21);
	JTextArea matrixOutput = new JTextArea("Matrix Operations",12,48);
	JButton matrixMultipication = new JButton("Multiply Matrices");
	JButton echelonCheck = new JButton("Echelon Check");
	JButton rEchelonCheck = new JButton("Reduced Echelon Check");
	JButton tTEchelon = new JButton("Transform to Echelon Form");
	JButton multiply = new JButton("Multiply");
	JButton ECheck = new JButton("Check");
	JButton RECheck = new JButton("Check");
	JButton matrixEchelonT = new JButton("Transfrom");
	public MatrixManipulationWindow()
	{
		super("Matrix Manipulation");
		setSize(575,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cardPanel.setLayout(card);
		mainPnl.add(matrixMultipication);
		mainPnl.add(echelonCheck);
		//mainPnl.add(rEchelonCheck);
		mainPnl.add(tTEchelon);
		multiMatrix.add(multiply);
		multiMatrix.add(matrix1);
		multiMatrix.add(matrix2);
		echelonCheckScreen.add(ECheck);
		echelonCheckScreen.add(eMatrix);
		rEchelonCheckScreen.add(RECheck);
		rEchelonCheckScreen.add(rEMatrix);
		tTEchelonScreen.add(matrixEchelonT);
		tTEchelonScreen.add(eTMatrix);
		result.add(matrixOutput);
		cardPanel.add(result,"1");
		cardPanel.add(multiMatrix,"2");
		cardPanel.add(echelonCheckScreen,"3");
		cardPanel.add(rEchelonCheckScreen,"4");
		cardPanel.add(tTEchelonScreen,"5");
		setVisible(true);
		getContentPane().add(mainPnl,BorderLayout.NORTH);
		getContentPane().add(cardPanel,BorderLayout.SOUTH);
		matrixMultipication.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
                card.show(cardPanel,"2");
            }
        });
		echelonCheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				card.show(cardPanel, "3");
			}
		});
		rEchelonCheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				card.show(cardPanel, "4");
			}
		});
		tTEchelon.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				card.show(cardPanel, "5");
			}
		});
		multiply.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String matrixString1 = matrix1.getText();
				String matrixString2 = matrix2.getText();
				double [][] matrix1 = MatrixStringOperations.stringToMatrix(matrixString1);
				double [][] matrix2 = MatrixStringOperations.stringToMatrix(matrixString2);
				double [][] matrixFinal = MatrixOperations.matrixMultiplier(matrix1, matrix2);
				String matrixStringFinal = MatrixStringOperations.matrixToString(matrixFinal);
				matrixOutput.setText(matrixStringFinal);
				card.show(cardPanel, "1");
			}
		});
		ECheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String matrixString = eMatrix.getText();
				double [][] matrix = MatrixStringOperations.stringToMatrix(matrixString);
				boolean check = MatrixOperations.echelonCheck(matrix);
				matrixOutput.setText(Boolean.toString(check));
				card.show(cardPanel, "1");
			}
		});
		RECheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String matrixString = rEMatrix.getText();
				double [][] matrix = MatrixStringOperations.stringToMatrix(matrixString);
				boolean check = MatrixOperations.reducedEchelonCheck(matrix);
				matrixOutput.setText(Boolean.toString(check));
				card.show(cardPanel, "1");
			}
		});
		matrixEchelonT.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String matrixString1 = eTMatrix.getText();
				double [][] matrix = MatrixStringOperations.stringToMatrix(matrixString1);
				double [][] matrixFinal = MatrixOperations.echelonTransform(matrix);
				String matrixStringFinal = MatrixStringOperations.matrixToString(matrixFinal);
				matrixOutput.setText(matrixStringFinal);
				card.show(cardPanel, "1");
			}
		});
	}
	public static void main(String args[])
	{
		MatrixManipulationWindow gui = new MatrixManipulationWindow();
	}
}
