//Ti-Yang Chang

package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import Containers.bigContainer;
import Containers.container;
import Containers.smallContainer;
import Items.cubic;
import Items.cylindrical;
import Items.pentagon;
import Methods.calculation;
import Methods.order;

public class Gui {
	private calculation cal0;
	private boolean newOrder;
	private int shape; //1:cylindrical, 2:cubic, 3:pentagon
	
	//GUI
    private JFrame frame;
    private JPanel panelM, panelItem, panelCy, panelCu, panelPe, panelResult;
    private JScrollPane panelResultS;
    
    //Image
    private ImageIcon imageFrame;
    
    //Menu bar
    private JMenuBar menuBar;
    private JPopupMenu menuPopup;
    private JMenu menuMain, menuPMain;
    private JMenuItem menuIMain, menuIResult, menuPIMain, menuPIResult;
    
    
    //Panel main
    private JButton buttonMNewOrder, buttonMNewItem, buttonMResult; 
	private int panelMButtonLocationStartX = 100;
	private int panelMButtonLocationStartY = 50;
	private int panelMButtonLocationVInterval = 150;
	private int panelMButtonSizeW = 300;
	private int panelMButtonSizeH = 100;
    
    //Panel item
    private JLabel itemNameLabel, weightLabel, itemNumberLabel;
    private JTextField itemName, weight, itemNumber;
    private JButton buttonICy, buttonICu, buttonIPe, buttonIBack; 
	private int panelItemLocationStartX = 50;
	private int panelItemLocationStartY = 50;
	private int panelItemLocationHInterval = 20;
	private int panelItemLocationVInterval = 100;
	private int panelItemSizeW = 200;
	private int panelItemSizeH = 50;
	private int panelItemButtonLocationHInterval = 20;
	private int panelItemButtonSizeW = 100;
	private int panelItemButtonSizeH = 50;
    
    
    //Panel Cylindrical
	private JLabel radiusCyLabel, heightCyLabel;
    private JTextField radiusCy, heightCy;
    private JButton buttonCyBack, buttonCyFin; 
    
    //Panel cubic
	private JLabel lengthCuLabel, widthCuLabel, heightCuLabel;
    private JTextField lengthCu, widthCu, heightCu;
    private JButton buttonCuBack, buttonCuFin;
    
    //Panel pentagon
	private JLabel lengthPeLabel, heightPeLabel;
    private JTextField lengthPe, heightPe;
    private JButton buttonPeBack, buttonPeFin;
    
    //Panel result
    private JTextArea resultArea;
    private JButton buttonRReset, buttonRBack; 
    
    
    
    
    
    //event listenser
	private ActionListener goPanelM = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setContentPane(panelM);
			frame.revalidate();
		}
		
	};
	
	private ActionListener goPanelItem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setContentPane(panelItem);
			frame.revalidate();
		}
		
	};
	
	private ActionListener goPanelItemNewOrder = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			newOrder = true;
			frame.setContentPane(panelItem);
			frame.revalidate();
		}
		
	};
	
	private ActionListener goPanelItemNewItem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			newOrder = false;
			frame.setContentPane(panelItem);
			frame.revalidate();
		}
		
	};
	
	
	private ActionListener goPanelCy = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			shape = 1;
			frame.setContentPane(panelCy);
			frame.revalidate();
		}
	};
	
	private ActionListener goPanelCu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			shape = 2;
			frame.setContentPane(panelCu);
			frame.revalidate();
		}
	};
	
	private ActionListener goPanelPe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			shape = 3;
			frame.setContentPane(panelPe);
			frame.revalidate();
		}
	};
    
	private ActionListener goPanelResult = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String resultStr = cal0.getOrderInfo();
			
			if(cal0.getOrders().isEmpty()) {

			}else {
				ArrayList<container> result = cal0.bestShippingMethod(new smallContainer(606, 243, 259, 0, 0), new bigContainer(1201, 243, 259, 0, 0));
				resultStr = resultStr + "the number of big containers:" + result.get(1).getNumber() + "\n";
				resultStr = resultStr + "shipping price:" + cal0.shippingPrice(result) + "\n";
				System.out.println("the number of big containers:" + result.get(1).getNumber() + "\n");
				System.out.println("shipping price:" + cal0.shippingPrice(result) + "\n");
			}

			resultArea.setText(resultStr);
			frame.setContentPane(panelResult);
			frame.revalidate();
		}
		
	};
	
	private ActionListener finish = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (newOrder == true) {
					order newOrder = new order();
					cal0.addOrder(newOrder);
				}
				
				switch (shape) {
				case 1:
					cal0.addItems(new cylindrical(itemName.getText(), Double.parseDouble(weight.getText()), Integer.parseInt(itemNumber.getText()), Double.parseDouble(radiusCy.getText()), Double.parseDouble(heightCy.getText())));
					break;
				case 2:
					cal0.addItems(new cubic(itemName.getText(), Double.parseDouble(weight.getText()), Integer.parseInt(itemNumber.getText()), Double.parseDouble(lengthCu.getText()), Double.parseDouble(widthCu.getText()), Double.parseDouble(heightCu.getText())));
					break;
				case 3:
					cal0.addItems(new pentagon(itemName.getText(), Double.parseDouble(weight.getText()), Integer.parseInt(itemNumber.getText()), Double.parseDouble(lengthPe.getText()), Double.parseDouble(heightPe.getText())));
					break;
				}
			} catch(Exception excep) {
				if (newOrder == true) {
					cal0.getOrders().remove(cal0.getOrders().size() - 1);
				}
				
				frame.setContentPane(panelM);
				frame.revalidate();
			}

			
			frame.setContentPane(panelM);
			frame.revalidate();
		}
		
	};
    
	private ActionListener resetOrder = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			cal0 = new calculation();
			
			String resultStr = cal0.getOrderInfo();
			
			if(cal0.getOrders().isEmpty()) {

			}else {
				ArrayList<container> result = cal0.bestShippingMethod(new smallContainer(606, 243, 259, 0, 0), new bigContainer(1201, 243, 259, 0, 0));
				resultStr = resultStr + "the number of big containers:" + result.get(1).getNumber() + "\n";
				resultStr = resultStr + "shipping price:" + cal0.shippingPrice(result) + "\n";
				System.out.println("the number of big containers:" + result.get(1).getNumber() + "\n");
				System.out.println("shipping price:" + cal0.shippingPrice(result) + "\n");
			}

			resultArea.setText(resultStr);
			frame.setContentPane(panelResult);
			frame.revalidate();
		}
		
	};
	
	
	
    public Gui(String frameName) {
    	cal0 = new calculation();
    	newOrder = true;
    	shape = 1;
    	
    	//GUI
    	frame = new JFrame(frameName);
    	
    	//Image
    	imageFrame = new ImageIcon("ship.png");

    	//Menu 
    	menuBar = new JMenuBar();
        menuPopup = new JPopupMenu();
        menuMain = new JMenu("Options");
        menuIMain = new JMenuItem("Main");
        menuIMain.addActionListener(goPanelM);
        menuIResult = new JMenuItem("Result");
        menuIResult.addActionListener(goPanelResult);
        
        menuMain.add(menuIMain);
        menuMain.add(menuIResult);
        menuBar.add(menuMain);
        
        menuPMain = new JMenu("Options");
        menuPIMain = new JMenuItem("Main");
        menuPIMain.addActionListener(goPanelM);
        menuPIResult = new JMenuItem("Result");
        menuPIResult.addActionListener(goPanelResult);
        
        menuPMain.add(menuPIMain);
        menuPMain.add(menuPIResult);
        menuPopup.add(menuPMain);
    	
    	//Panel main
    	panelM = new JPanel(null);
    	buttonMNewOrder = new JButton("Add new order");
    	buttonMNewItem = new JButton("Add new item");
    	buttonMResult = new JButton("Show result");
    	
    	buttonMNewOrder.addActionListener(goPanelItemNewOrder);
    	buttonMNewItem.addActionListener(goPanelItemNewItem);
    	buttonMResult.addActionListener(goPanelResult);
    	
    	panelM.add(buttonMNewOrder);
    	panelM.add(buttonMNewItem);
    	panelM.add(buttonMResult);
    	
    	buttonMNewOrder.setLocation(panelMButtonLocationStartX, panelMButtonLocationStartY);
    	buttonMNewItem.setLocation(panelMButtonLocationStartX, panelMButtonLocationStartY + panelMButtonLocationVInterval * 1);
    	buttonMResult.setLocation(panelMButtonLocationStartX, panelMButtonLocationStartY + panelMButtonLocationVInterval * 2);

    	buttonMNewOrder.setSize(panelMButtonSizeW, panelMButtonSizeH);
    	buttonMNewItem.setSize(panelMButtonSizeW, panelMButtonSizeH);
    	buttonMResult.setSize(panelMButtonSizeW, panelMButtonSizeH);
    	
    	//Panel item
    	panelItem = new JPanel(null);
        itemNameLabel = new JLabel("Item name:");
        weightLabel = new JLabel("Weight of the item:");
        itemNumberLabel = new JLabel("Item quantity:");
    	itemName = new JTextField("", 20);
    	weight = new JTextField("", 20);
    	itemNumber = new JTextField("", 20);
    	buttonICy = new JButton("Cylindrical");
    	buttonICu = new JButton("Cubic");
    	buttonIPe = new JButton("Pentagon");
    	buttonIBack = new JButton("Back");
    	
    	buttonICy.addActionListener(goPanelCy);
    	buttonICu.addActionListener(goPanelCu);
    	buttonIPe.addActionListener(goPanelPe);
    	buttonIBack.addActionListener(goPanelM);
    	
    	panelItem.add(itemNameLabel);
    	panelItem.add(itemName);
    	panelItem.add(weightLabel);
    	panelItem.add(weight);
    	panelItem.add(itemNumberLabel);
    	panelItem.add(itemNumber);
    	panelItem.add(buttonICy);
    	panelItem.add(buttonICu);
    	panelItem.add(buttonIPe);
    	panelItem.add(buttonIBack);
    	
    	itemNameLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY);
    	itemName.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY);
    	weightLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 1);
    	weight.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY + panelItemLocationVInterval * 1);
    	itemNumberLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 2);
    	itemNumber.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY + panelItemLocationVInterval * 2);
    	buttonICy.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 3);
    	buttonICu.setLocation(panelItemLocationStartX + panelItemButtonSizeW * 1 + panelItemButtonLocationHInterval * 1, panelItemLocationStartY + panelItemLocationVInterval * 3);
       	buttonIPe.setLocation(panelItemLocationStartX + panelItemButtonSizeW * 2 + panelItemButtonLocationHInterval * 2, panelItemLocationStartY + panelItemLocationVInterval * 3);
       	buttonIBack.setLocation(panelItemLocationStartX + panelItemButtonSizeW * 3 + panelItemButtonLocationHInterval * 3, panelItemLocationStartY + panelItemLocationVInterval * 3);
    	
    	
    	
    	itemNameLabel.setSize(panelItemSizeW, panelItemSizeH);
    	itemName.setSize(panelItemSizeW, panelItemSizeH);
    	weightLabel.setSize(panelItemSizeW, panelItemSizeH);
    	weight.setSize(panelItemSizeW, panelItemSizeH);
    	itemNumberLabel.setSize(panelItemSizeW, panelItemSizeH);
    	itemNumber.setSize(panelItemSizeW, panelItemSizeH);
    	buttonICy.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	buttonICu.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	buttonIPe.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	buttonIBack.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	
    	//Panel Cylindrical
    	panelCy = new JPanel(null);
    	radiusCyLabel = new JLabel("Radius:");
    	heightCyLabel = new JLabel("Height:");
    	radiusCy = new JTextField("", 20);
    	heightCy = new JTextField("", 20);
    	buttonCyBack = new JButton("Back");
    	buttonCyFin = new JButton("Finish");
    	
    	buttonCyBack.addActionListener(goPanelItem);
    	buttonCyFin.addActionListener(finish);
    	
    	panelCy.add(radiusCyLabel);
    	panelCy.add(heightCyLabel);
    	panelCy.add(radiusCy);
    	panelCy.add(heightCy);
    	panelCy.add(buttonCyBack);
    	panelCy.add(buttonCyFin);
    	
    	radiusCyLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY);
    	radiusCy.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY);
    	heightCyLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 1);
    	heightCy.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY + panelItemLocationVInterval * 1);
    	buttonCyBack.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 2);
    	buttonCyFin.setLocation(panelItemLocationStartX + panelItemButtonSizeW * 1 + panelItemButtonLocationHInterval * 1, panelItemLocationStartY + panelItemLocationVInterval * 2);   	
    	
    	radiusCyLabel.setSize(panelItemSizeW, panelItemSizeH);
    	radiusCy.setSize(panelItemSizeW, panelItemSizeH);
    	heightCyLabel.setSize(panelItemSizeW, panelItemSizeH);
    	heightCy.setSize(panelItemSizeW, panelItemSizeH);
    	buttonCyBack.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	buttonCyFin.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	
        //Panel cubic
    	panelCu = new JPanel(null);
    	lengthCuLabel = new JLabel("Length:");
    	widthCuLabel = new JLabel("Length:");
    	heightCuLabel = new JLabel("Length:");
    	lengthCu = new JTextField("", 20);
    	widthCu = new JTextField("", 20);
    	heightCu = new JTextField("", 20);
    	buttonCuBack = new JButton("Back");
    	buttonCuFin = new JButton("Finish");
        
    	buttonCuBack.addActionListener(goPanelItem);
    	buttonCuFin.addActionListener(finish);
        
    	panelCu.add(lengthCuLabel);
    	panelCu.add(widthCuLabel);
    	panelCu.add(heightCuLabel);
    	panelCu.add(lengthCu);
    	panelCu.add(widthCu);
    	panelCu.add(heightCu);
    	panelCu.add(buttonCuBack);
    	panelCu.add(buttonCuFin);
    	
    	lengthCuLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY);
    	lengthCu.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY);
    	widthCuLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 1);
    	widthCu.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY + panelItemLocationVInterval * 1);
    	heightCuLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 2);
    	heightCu.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY + panelItemLocationVInterval * 2);
    	buttonCuBack.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 3);
    	buttonCuFin.setLocation(panelItemLocationStartX + panelItemButtonSizeW * 1 + panelItemButtonLocationHInterval * 1, panelItemLocationStartY + panelItemLocationVInterval * 3);

    	
    	
    	lengthCuLabel.setSize(panelItemSizeW, panelItemSizeH);
    	lengthCu.setSize(panelItemSizeW, panelItemSizeH);
    	widthCuLabel.setSize(panelItemSizeW, panelItemSizeH);
    	widthCu.setSize(panelItemSizeW, panelItemSizeH);
    	heightCuLabel.setSize(panelItemSizeW, panelItemSizeH);
    	heightCu.setSize(panelItemSizeW, panelItemSizeH);
    	buttonCuBack.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	buttonCuFin.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	
        //Panel pentagon
    	panelPe = new JPanel(null);
    	lengthPeLabel = new JLabel("Length:");
        heightPeLabel = new JLabel("Height:");
    	lengthPe = new JTextField("", 20);
    	heightPe = new JTextField("", 20);
    	buttonPeBack = new JButton("Back");
    	buttonPeFin = new JButton("Finish");
        
    	buttonPeBack.addActionListener(goPanelItem);
    	buttonPeFin.addActionListener(finish);
        
    	panelPe.add(lengthPeLabel);
    	panelPe.add(heightPeLabel);
    	panelPe.add(lengthPe);
    	panelPe.add(heightPe);
    	panelPe.add(buttonPeBack);
    	panelPe.add(buttonPeFin);
    	
    	lengthPeLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY);
    	lengthPe.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY);
    	heightPeLabel.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 1);
    	heightPe.setLocation(panelItemLocationStartX + panelItemSizeW + panelItemLocationHInterval , panelItemLocationStartY + panelItemLocationVInterval * 1);
     	buttonPeBack.setLocation(panelItemLocationStartX, panelItemLocationStartY + panelItemLocationVInterval * 3);
    	buttonPeFin.setLocation(panelItemLocationStartX + panelItemButtonSizeW * 1 + panelItemButtonLocationHInterval * 1, panelItemLocationStartY + panelItemLocationVInterval * 3);

    	
    	
    	lengthPeLabel.setSize(panelItemSizeW, panelItemSizeH);
    	lengthPe.setSize(panelItemSizeW, panelItemSizeH);
    	heightPeLabel.setSize(panelItemSizeW, panelItemSizeH);
    	heightPe.setSize(panelItemSizeW, panelItemSizeH);
    	buttonPeBack.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	buttonPeFin.setSize(panelItemButtonSizeW, panelItemButtonSizeH);
    	
    	//Panel result
    	panelResult = new JPanel(new FlowLayout());
        resultArea = new JTextArea();
        panelResultS = new JScrollPane(resultArea);
        panelResultS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelResultS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	buttonRReset = new JButton("Reset orders");
    	buttonRBack = new JButton("Back");

    	buttonRReset.addActionListener(resetOrder);
    	buttonRBack.addActionListener(goPanelM);
    	
    	panelResult.add(panelResultS);
    	panelResult.add(buttonRReset);
    	panelResult.add(buttonRBack);
    	
    	
    	//Set frame
    	frame.setContentPane(panelM);
    	frame.setJMenuBar(menuBar);
    	frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
					menuPopup.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	frame.setIconImage(imageFrame.getImage());
    	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	frame.setSize(600, 600);
    	
    }
    
    
    



	public void showFrame() {
    	this.frame.setVisible(true);
    }
    
    
    
    
}
