package kr.co.adela.depot;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepotMenu extends JPanel implements ActionListener {
	DepotMainFrame fMain;
	ImageIcon iLogo;
	JLabel lblName, lblWelcome;
	JButton btnLogo, btnAll, btnClothes, btnShoes, btnBag, btnAcc, btnHistory, btnManagerList, btnLogout;
	String managerId, managerName;
	String all = "res/all.png";
	String allClick = "res/allClick.png";
	String allMouse = "res/allMouse.png";
	String clotheClick = "res/clotheClick.png";
	String clotheMenu = "res/clotheMenu.png";
	String clotheMouse = "res/clotheMouse.png";
	String shoes = "res/shoes.png";
	String shoesMouse = "res/shoesMouse.png";
	String shoesClick = "res/shoesClick.png";
	String bag = "res/bag.png";
	String bagMouse = "res/bagMouse.png";
	String bagClick = "res/bagClick.png";
	String acc = "res/acc.png";
	String accClick = "res/accClick.png";
	String accMouse = "res/accMouse.png";
	String history = "res/history.png";
	String historyMouse = "res/historyMouse.png";
	String historyClick = "res/historyClick.png";
	String list = "res/list.png";
	String listMouse = "res/listMouse.png";
	String listClick = "res/listclick.png";
	String logout = "res/logout.png";
	String logoutMouse = "res/logoutMouse.png";
	String logoutClick = "res/logoutClick.png";

	public DepotMenu(DepotMainFrame fMain) {
		this.fMain = fMain;
		setLayout(null);
		setBackground(Color.decode("#BDBDBD"));
		
		// �ΰ� �ֱ�
		iLogo = new ImageIcon("res/logo.PNG");
		btnLogo = new JButton(iLogo);
		btnLogo.setSize(160, 120);
		btnLogo.setBorderPainted(false);
		btnLogo.setFocusPainted(false);
		btnLogo.setContentAreaFilled(false);
		btnLogo.setLocation(18, 10);
		add(btnLogo);
		
		//��ü��ǰ �̹���
		ImageIcon imgAll = new ImageIcon(all);
		ImageIcon imgAllclick = new ImageIcon(allClick);
		ImageIcon imgAllMouse = new ImageIcon(allMouse);
		//�Ƿ� �̹���
		ImageIcon imgClothe = new ImageIcon(clotheMenu);
		ImageIcon imgClotheClick = new ImageIcon(clotheClick);
		ImageIcon imgClotheMouse = new ImageIcon(clotheMouse);
		//�Ź� �̹���
		ImageIcon imgShoes = new ImageIcon(shoes);
		ImageIcon imgShoesMouse = new ImageIcon(shoesMouse);
		ImageIcon imgShoesClick = new ImageIcon(shoesClick);
		//���� �̹���
		ImageIcon imgBag = new ImageIcon(bag);
		ImageIcon imgBagMouse = new ImageIcon(bagMouse);
		ImageIcon imgBagClick = new ImageIcon(bagClick);
		//�Ǽ����� �̹���
		ImageIcon imgAcc = new ImageIcon(acc);
		ImageIcon imgAccMouse = new ImageIcon(accMouse);
		ImageIcon imgAccClick = new ImageIcon(accClick);
		//�̷���ȸ �̹���
		ImageIcon imgHistory = new ImageIcon(history);
		ImageIcon imgHistoryMouse = new ImageIcon(historyMouse);
		ImageIcon imgHistoryClick = new ImageIcon(historyClick);
		//������ ��� �̹���
		ImageIcon imgList = new ImageIcon(list);
		ImageIcon imgListMouse = new ImageIcon(listMouse);
		ImageIcon imgListClick = new ImageIcon(listClick);
		//�α׾ƿ� �̹���
		ImageIcon imgLogout = new ImageIcon(logout);
		ImageIcon imgLogoutMouse = new ImageIcon(logoutMouse);
		ImageIcon imgLogoutClick = new ImageIcon(logoutClick);
		// ��ư ���
		// ȸ�� ���� ����
		lblName = new JLabel();
		lblName.setBounds(25, 150, 55, 15);
		lblWelcome = new JLabel("�� ȯ���մϴ�");
		lblWelcome.setBounds(85, 150, 90, 15);
		btnLogout = new JButton(imgLogout);
		btnLogout.setBorderPainted(false);
		btnLogout.setFocusPainted(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setRolloverIcon(imgLogoutMouse);
		btnLogout.setPressedIcon(imgLogoutClick);
		btnLogout.setBounds(50, 175, 90, 20);
		add(lblName);
		add(lblWelcome);
		add(btnLogout);
		btnLogout.addActionListener(this);
		// ��ü ��ǰ ��ư
		btnAll = new JButton(imgAll);
		btnAll.setBounds(12, 213, 170, 60);
		btnAll.setBorderPainted(false);
		btnAll.setFocusPainted(false);
		btnAll.setContentAreaFilled(false);
		btnAll.setRolloverIcon(imgAllMouse);
		btnAll.setPressedIcon(imgAllclick);
		// �Ƿ� ��ư
		btnClothes = new JButton(imgClothe);
		btnClothes.setBorderPainted(false);
		btnClothes.setFocusPainted(false);
		btnClothes.setContentAreaFilled(false);
		btnClothes.setPressedIcon(imgClotheClick);
		btnClothes.setRolloverIcon(imgClotheMouse);
		btnClothes.setBounds(12, 283, 170, 60);
		//�Ź�
		btnShoes = new JButton(imgShoes);
		btnShoes.setBorderPainted(false);
		btnShoes.setFocusPainted(false);
		btnShoes.setContentAreaFilled(false);
		btnShoes.setPressedIcon(imgShoesClick);
		btnShoes.setRolloverIcon(imgShoesMouse);
		btnShoes.setBounds(12, 341, 170, 60);
		//����
		btnBag = new JButton(imgBag);
		btnBag.setBorderPainted(false);
		btnBag.setFocusPainted(false);
		btnBag.setContentAreaFilled(false);
		btnBag.setPressedIcon(imgBagClick);
		btnBag.setRolloverIcon(imgBagMouse);
		btnBag.setBounds(12, 398, 170, 60);
		//�Ǽ��縮
		btnAcc = new JButton(imgAcc);
		btnAcc.setBorderPainted(false);
		btnAcc.setFocusPainted(false);
		btnAcc.setContentAreaFilled(false);
		btnAcc.setPressedIcon(imgAccClick);
		btnAcc.setRolloverIcon(imgAccMouse);
		btnAcc.setBounds(12, 455, 170, 60);
		//�̷���ȸ
		btnHistory = new JButton(imgHistory);
		btnHistory.setBorderPainted(false);
		btnHistory.setFocusPainted(false);
		btnHistory.setContentAreaFilled(false);
		btnHistory.setPressedIcon(imgHistoryClick);
		btnHistory.setRolloverIcon(imgHistoryMouse);
		btnHistory.setBounds(12, 525, 170, 60);
		//�����ڸ��
		btnManagerList = new JButton(imgList);
		btnManagerList.setBorderPainted(false);
		btnManagerList.setFocusPainted(false);
		btnManagerList.setContentAreaFilled(false);
		btnManagerList.setPressedIcon(imgListClick);
		btnManagerList.setRolloverIcon(imgListMouse);
		btnManagerList.setBounds(12, 583, 170, 60);
		add(btnAll);
		add(btnClothes);
		add(btnShoes);
		add(btnBag);
		add(btnAcc);
		add(btnHistory);
		add(btnManagerList);
		
		btnAll.addActionListener(this);
		btnClothes.addActionListener(this);
		btnShoes.addActionListener(this);
		btnBag.addActionListener(this);
		btnAcc.addActionListener(this);
		btnHistory.addActionListener(this);
		btnManagerList.addActionListener(this);
	}
	
	public void setManagerName() {
		// ȸ�� �̸� ����
		lblName.setText(DepotMainFrame.managerName);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogout) {
			int isDelete = JOptionPane.showConfirmDialog(this, "�α׾ƿ� �Ͻðڽ��ϱ�?", "�α׾ƿ�", JOptionPane.YES_NO_OPTION);

			if (isDelete == 0) {
				fMain.remove(DepotMainFrame.pMenu);
				fMain.remove(DepotMainFrame.pSearch);
				fMain.remove(DepotMainFrame.pInit);
				fMain.remove(DepotMainFrame.pClothes);
				fMain.remove(DepotMainFrame.pShoes);
				fMain.remove(DepotMainFrame.pShoesInsert);
				fMain.remove(DepotMainFrame.pBag);
				fMain.remove(DepotMainFrame.pBagInsert);
				fMain.remove(DepotMainFrame.pAcc);
				fMain.remove(DepotMainFrame.pHistory);
				fMain.remove(DepotMainFrame.pManager);
				DepotMainFrame.pLogin.removeInputData();
				fMain.getContentPane().add(DepotMainFrame.pLogin);
				fMain.invalidate();
				fMain.validate();
				fMain.repaint();
			}
		} else if(e.getSource() == btnAll) {
			fMain.remove(DepotMainFrame.pClothes);
			fMain.remove(DepotMainFrame.pShoes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBag);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pAcc);
			fMain.remove(DepotMainFrame.pHistory);
			fMain.remove(DepotMainFrame.pManager);
			DepotMainFrame.searchCategory = "%";
			DepotMainFrame.pSearch.setVisible(true);
			DepotMainFrame.pInit.setBounds(200, 50, 1064, 632);
			fMain.getContentPane().add(DepotMainFrame.pInit);
			DepotMainFrame.pInit.showAll();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		} else if(e.getSource() == btnClothes) {
			fMain.remove(DepotMainFrame.pInit);
			fMain.remove(DepotMainFrame.pShoes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBag);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pAcc);
			fMain.remove(DepotMainFrame.pHistory);
			fMain.remove(DepotMainFrame.pManager);
			DepotMainFrame.searchCategory = "�Ƿ�";
			DepotMainFrame.pSearch.setVisible(true);
			DepotMainFrame.pClothes.setBounds(200, 50, 1064, 632);
			fMain.getContentPane().add(DepotMainFrame.pClothes);
			DepotMainFrame.pClothes.updateTable();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		} else if(e.getSource() == btnShoes) {
			fMain.remove(DepotMainFrame.pInit);
			fMain.remove(DepotMainFrame.pClothes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBag);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pAcc);
			fMain.remove(DepotMainFrame.pHistory);
			fMain.remove(DepotMainFrame.pManager);
			DepotMainFrame.searchCategory = "�Ź�";
			DepotMainFrame.pSearch.setVisible(true);
			DepotMainFrame.pShoes.setBounds(200, 50, 1064, 632);
			fMain.getContentPane().add(DepotMainFrame.pShoes);
			DepotMainFrame.pShoes.refreshTable();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		} else if (e.getSource() == btnBag) {
			fMain.remove(DepotMainFrame.pInit);
			fMain.remove(DepotMainFrame.pClothes);
			fMain.remove(DepotMainFrame.pShoes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pAcc);
			fMain.remove(DepotMainFrame.pHistory);
			fMain.remove(DepotMainFrame.pManager);
			DepotMainFrame.searchCategory = "����";
			DepotMainFrame.pSearch.setVisible(true);
			DepotMainFrame.pBag.setBounds(200,50,1064,632);
			fMain.getContentPane().add(DepotMainFrame.pBag);
			DepotMainFrame.pBag.showBag();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		} else if(e.getSource() == btnAcc) {
			fMain.remove(DepotMainFrame.pInit);
			fMain.remove(DepotMainFrame.pClothes);
			fMain.remove(DepotMainFrame.pShoes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBag);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pHistory);
			fMain.remove(DepotMainFrame.pManager);
			DepotMainFrame.searchCategory = "�Ǽ��縮";
			DepotMainFrame.pSearch.setVisible(true);
			DepotMainFrame.pAcc.setBounds(200,50,1064,632);
			fMain.getContentPane().add(DepotMainFrame.pAcc);
			DepotMainFrame.pAcc.updateTable();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		} else if (e.getSource() == btnHistory) {
			fMain.remove(DepotMainFrame.pInit);
			fMain.remove(DepotMainFrame.pClothes);
			fMain.remove(DepotMainFrame.pShoes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBag);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pAcc);
			fMain.remove(DepotMainFrame.pManager);
			DepotMainFrame.pSearch.setVisible(false);
			DepotMainFrame.pHistory.setBounds(200,0,1064,682);
			fMain.getContentPane().add(DepotMainFrame.pHistory);
			DepotMainFrame.pHistory.showHistory();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		} else if(e.getSource() == btnManagerList) {
			fMain.remove(DepotMainFrame.pInit);
			fMain.remove(DepotMainFrame.pClothes);
			fMain.remove(DepotMainFrame.pShoes);
			fMain.remove(DepotMainFrame.pShoesInsert);
			fMain.remove(DepotMainFrame.pBag);
			fMain.remove(DepotMainFrame.pBagInsert);
			fMain.remove(DepotMainFrame.pAcc);
			fMain.remove(DepotMainFrame.pHistory);
			DepotMainFrame.pSearch.setVisible(false);
			DepotMainFrame.pManager.setBounds(200,0,1064,682);
			fMain.getContentPane().add(DepotMainFrame.pManager);
			DepotMainFrame.pManager.showManager();
			fMain.invalidate();
			fMain.validate();
			fMain.repaint();
		}
	}
	
}
