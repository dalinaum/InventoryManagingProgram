package kr.co.adela.depot.clothes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.co.adela.depot.DepotMainFrame;
import kr.co.adela.depot.model.DAOclothes;
import kr.co.adela.depot.model.DTOclothes;

public class DataDialog extends JDialog implements ActionListener{
//	private MainFrame mF;
	private ClothesMain cM;
	private JTextField textField;
	private JPanel pCenter,pNorth, pSouth, pTitle, pName, pDetail, pPriceAmount,
					pLocation, pCategory;
	private JLabel lblName,lblDetail,lblPrice,
				   lblAmount,lblLocation,lblCategory,
				   lblTitle;
	private JTextField tfName,tfDetail,tfPrice,
					   tfAmount,tfLocation,tfCategory;
	private JButton btnOk, btnCancel;
	private JComboBox<String> cbCategory;
	public DataDialog(ClothesMain cM, String string, boolean b) {
		this.cM = cM;
		setSize(600,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setBackground(Color.decode("#BDBDBD"));
		//label ���̹�
		lblName = new JLabel("�� ǰ ��");
		lblDetail = new JLabel("��ǰ ����");
		lblDetail.setBounds(95, 8, 52, 15);
		lblPrice = new JLabel("�� ��");
		lblAmount = new JLabel("�� ��");
		lblLocation = new JLabel("���� ��ġ ");
		lblCategory = new JLabel("ī�� �� ");
		//textfield 
		tfName = new JTextField(30);
		tfDetail = new JTextField(30);
		tfDetail.setBounds(152, 5, 336, 21);
		tfPrice = new JTextField(10);
		//���ڸ� �Է��� �� �ְ� ����
		tfPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		tfAmount = new JTextField(10);
		tfAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		tfLocation = new JTextField(10);
		tfCategory = new JTextField(10);
		String[] strCategory = {"�Ƿ�", "����", "�Ź�","�Ǽ��縮"};
		cbCategory = new JComboBox<>(strCategory);
		//dialog ����
		pCenter = new JPanel();
		pCenter.setBackground(Color.decode("#BDBDBD"));
		getContentPane().add(pCenter,BorderLayout.CENTER);
		pCenter.setLayout(null);
		//dialog ����
		pSouth = new JPanel();
		getContentPane().add(pSouth,BorderLayout.SOUTH);
		pSouth.setBackground(Color.decode("#BDBDBD"));
		//dialog ���Ϳ� Ÿ��Ʋ �� �ٿ�����
		pTitle = new JPanel();
		pTitle.setBackground(Color.decode("#BDBDBD"));
		pTitle.setBounds(12, 2, 560, 41);
		pCenter.add(pTitle);
		lblTitle = new JLabel("�߰� Dialog!!!!");
		lblTitle.setFont(new Font("���� ���", Font.BOLD, 20));
		pTitle.add(lblTitle);
		
		
		//dialog ���Ϳ� ��ǰ�� �г� ����
		pName = new JPanel(new FlowLayout());
		pName.setBounds(12, 41, 560, 41);
		pName.setBackground(Color.decode("#BDBDBD"));
		pCenter.add(pName);
//		pName.setBackground(Color.RED);
		pName.add(lblName); pName.add(tfName);
		//dialog ���Ϳ� ��ǰ���� �г� ����
		pDetail = new JPanel(new FlowLayout());
		pDetail.setBackground(Color.decode("#BDBDBD"));
		pDetail.setBounds(12, 80, 560, 41);
		pCenter.add(pDetail);
		pDetail.add(lblDetail); pDetail.add(tfDetail);
		//dialog ���Ϳ� ���� �� ���� �г� ����
		pPriceAmount = new JPanel(new FlowLayout());
		pPriceAmount.setBackground(Color.decode("#BDBDBD"));
		pPriceAmount.setBounds(12, 119, 560, 41);
		pCenter.add(pPriceAmount);
		pPriceAmount.add(lblPrice); pPriceAmount.add(tfPrice);
		pPriceAmount.add(lblAmount); pPriceAmount.add(tfAmount);
		//dialog ���Ϳ� ������ġ �г� ����
		pLocation = new JPanel(new FlowLayout());
		pLocation.setBackground(Color.decode("#BDBDBD"));
		pLocation.setBounds(12, 159, 560, 41);
		pCenter.add(pLocation);
		pLocation.add(lblLocation); pLocation.add(tfLocation);
		//dialog ���Ϳ� ī�װ� �г� ����
		pCategory = new JPanel(new FlowLayout());
		pCategory.setBackground(Color.decode("#BDBDBD"));
		pCategory.setBounds(12, 198, 560, 41);
		pCenter.add(pCategory);
		pCategory.add(lblCategory); pCategory.add(cbCategory);
		//button ����
		btnOk = new JButton("Ȯ��");
		btnCancel = new JButton("���");
		pSouth.add(btnOk); pSouth.add(btnCancel);
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				dispose();
			}
		});
		setVisible(true);
	}//constructor
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancel) {
			this.setVisible(false);
			dispose();
		}else if(e.getSource() == btnOk) {
			checkValue();
			String name = tfName.getText();
			String detail = tfDetail.getText();
			int price = Integer.parseInt(tfPrice.getText());
			int amount = Integer.parseInt(tfAmount.getText());
			String location = tfLocation.getText();
			String category = (String) cbCategory.getSelectedItem();
			//DTO�� ������ ����
			DTOclothes dtoc = new DTOclothes();
			dtoc.setName(name);
			dtoc.setDetail(detail);
			dtoc.setPrice(price);
			dtoc.setAmount(amount);
			dtoc.setLocation(location);
			dtoc.setCategory(category);
			dtoc.setManagerId(DepotMainFrame.managerId);
			dtoc.setManagerName(DepotMainFrame.managerName);
			//�߰� 
			DAOclothes daoc = new DAOclothes();
			boolean ok = daoc.insertGoods(dtoc);
			if(ok) {
				daoc.realignment();
				cM.updateTable();
				this.setVisible(false);
				dispose();
			}
			String history = "��ǰ �߰�";
			dtoc.setHistoryDetail(history);
			System.out.println("@@@@datadialog history" + history);
			daoc.insertHistory(dtoc);
		}//if-btnok
	}//actionperform
	public void checkValue() {
		if(tfName.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "��ǰ���� �Է��ϼ���^^");
				tfName.requestFocus();
			}
		if(tfDetail.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "��ǰ ������ �Է��ϼ���^^");
			tfDetail.requestFocus();
		}
		if(tfPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���^^");
			tfPrice.requestFocus();
		}
		if(tfAmount.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���^^");
			tfAmount.requestFocus();
		}
		if(tfLocation.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "��ǰ ��ġ�� �Է��ϼ���^^");
			tfLocation.requestFocus();
		}
	}//checkValue

}//end
