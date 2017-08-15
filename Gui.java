import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame
{
	private JTextField answerfiled;
	private JButton one,tow,three,four,five,six,seven,eight,nine,zero,add,sub,mul,div,equal,clear,dot;
	private String stemp1,stemp2;
	private JPanel contentPanel;
	
	public Gui()
	{
		super("Calculator");
		
		/*Set the answer filed, set size and font*/
		answerfiled=new JTextField(null,12);
		answerfiled.setPreferredSize(new Dimension(120,55));
		answerfiled.setEditable(false);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		answerfiled.setFont(font1);
		
		/*Set the Buttons*/
		one= new JButton("1");
		tow= new JButton("2");
		three= new JButton("3");
		four= new JButton("4");
		five= new JButton("5");
		six= new JButton("6");
		seven= new JButton("7");
		eight= new JButton("8");
		nine= new JButton("9");
		zero= new JButton("0");
		add= new JButton("+");
		sub= new JButton("-");
		mul= new JButton("*");
		div= new JButton("/");
		equal= new JButton("=");
		clear= new JButton("C");
		dot= new JButton(".");
		
		/*set size for the Buttons*/
		Dimension dim =new Dimension(65,55);
		one.setPreferredSize(dim);tow.setPreferredSize(dim);three.setPreferredSize(dim);four.setPreferredSize(dim);
		five.setPreferredSize(dim);six.setPreferredSize(dim);seven.setPreferredSize(dim);eight.setPreferredSize(dim);
		nine.setPreferredSize(dim);zero.setPreferredSize(dim);add.setPreferredSize(dim);sub.setPreferredSize(dim);
		mul.setPreferredSize(dim);div.setPreferredSize(dim);equal.setPreferredSize(dim);clear.setPreferredSize(dim);
		dot.setPreferredSize(dim);
		
		/*set font for the Buttons*/
		one.setFont(font1);tow.setFont(font1);three.setFont(font1);four.setFont(font1);
		five.setFont(font1);six.setFont(font1);seven.setFont(font1);eight.setFont(font1);
		nine.setFont(font1);zero.setFont(font1);add.setFont(font1);sub.setFont(font1);
		mul.setFont(font1);div.setFont(font1);equal.setFont(font1);clear.setFont(font1);
		dot.setFont(font1);
		
		Button n=new Button();
		/*set action for the buttons*/
		one.addActionListener(n);tow.addActionListener(n);three.addActionListener(n);four.addActionListener(n);
		five.addActionListener(n);six.addActionListener(n);seven.addActionListener(n);eight.addActionListener(n);
		nine.addActionListener(n);zero.addActionListener(n);add.addActionListener(n);sub.addActionListener(n);
		mul.addActionListener(n);div.addActionListener(n);dot.addActionListener(n);equal.addActionListener(n);
		clear.addActionListener(n);
		
		/*set the panel of the calculator*/
		contentPanel=new JPanel();
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setLayout(new FlowLayout());
		
		/*add the answer filed to the panel*/
		contentPanel.add(answerfiled,BorderLayout.BEFORE_LINE_BEGINS);
		
		/*add the buttons filed to the panel*/
		contentPanel.add(clear); contentPanel.add(one); contentPanel.add(tow); contentPanel.add(three);
		contentPanel.add(div);contentPanel.add(four); contentPanel.add(five); contentPanel.add(six);
		contentPanel.add(mul);contentPanel.add(seven); contentPanel.add(eight); contentPanel.add(nine);
		contentPanel.add(sub); contentPanel.add(zero);contentPanel.add(dot);contentPanel.add(equal);
		contentPanel.add(add);
		
		this.setContentPane(contentPanel);
	}
	
	private class Button implements ActionListener 
	{
		
		public void actionPerformed(ActionEvent event)
		{
			
			JButton src= (JButton) event.getSource();//src get the button that be pressed.
			
			if(src.equals(one))//1 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="1";
				}
				else
					stemp1+="1";	
			}
			
			if(src.equals(tow))//2 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="2";
				}
				else
					stemp1+="2";	
			}
			
			if(src.equals(three))//3 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="3";
				}
				else
					stemp1+="3";
			}
			
			if(src.equals(four))//4 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="4";
				}
				else
					stemp1+="4";
			}
			
			if(src.equals(five))//5 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="5";
				}
				else
					stemp1+="5";
			}
			
			if(src.equals(six))//6 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="6";
				}
				else
					stemp1+="6";
			}
			
			if(src.equals(seven))//7 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="7";
				}
				else
					stemp1+="7";
			}
			
			if(src.equals(eight))//8 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="8";
				}
				else
					stemp1+="8";
			}
			
			if(src.equals(nine))//9 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="9";
				}
				else
					stemp1+="9";
			}
			
			if(src.equals(zero))//0 was pressed.
			{
				if(stemp1==null)
				{
					stemp1="0";
				}
				else
					stemp1+="0";
			}
			
			if(src.equals(add))//+ was pressed.
			{
				if(stemp1==null)
				{
					stemp1="+";
				}
				else
					stemp1+="+";
			}
			
			if(src.equals(sub))//- was pressed.
			{
				if(stemp1==null)
				{
					stemp1="-";
				}
				else
					stemp1+="-";
			}
			
			if(src.equals(mul))//* was pressed.
			{
				if(stemp1==null)
				{
					stemp1="*";
				}
				else
					stemp1+="*";
			}
			
			if(src.equals(div))// / was pressed.
			{
				if(stemp1==null)
				{
					stemp1="/";
				}
				else
					stemp1+="/";
			}
			
			if(src.equals(dot))// . was pressed.
			{
				if(stemp1==null)
				{
					stemp1=".";
				}
				else
					stemp1+=".";
			}
			
			if(src.equals(equal)==false)// still don't press =.
			{
				answerfiled.setText(stemp1);
			}
			else if(src.equals(equal))// = was pressed.
			{
				if(stemp1==null)
					answerfiled.setText("Enter a number first");
				else
				{
				Calc c=new Calc(stemp1);
				stemp2=c.Calculator();
				stemp1=stemp2;
				answerfiled.setText(stemp2);
				}
			}
			
			if(src.equals(clear))// C was pressed.
			{
				stemp1=null;
				stemp2=null;
				answerfiled.setText(stemp1);
			}	
		}
	}
}
