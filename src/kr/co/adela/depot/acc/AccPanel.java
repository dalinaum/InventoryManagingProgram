package kr.co.adela.depot.acc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import kr.co.adela.depot.DepotMainFrame;
import kr.co.adela.depot.model.GoodsDAO;
import kr.co.adela.depot.model.GoodsDTO;
import kr.co.adela.depot.model.MemberDTO;

public class AccPanel extends JPanel implements MouseListener, ActionListener {
	private DepotMainFrame mF;
	private UpdateDialog uD;
	private JButton btnCloth, btnBag, btnShoes, btnAcc, btnLog, btnManagerList;
	private JButton btnSearch, btnAdd, btnDelete, btnUpdate;
	private JPanel pWest, pNorth, pCenter, pSouth;
	private JTextField tfSearch;
	private JComboBox<String> cbSearch;
	private FlowLayout FlowLayout;
	public static JTable accTable;
	private DefaultTableModel model;
	private DataDialog dd;
	private UpdateDialog ud;
	private Vector data, titles, selectData;
	private JScrollPane pane;
	private String imgInsert = "res/btnInsert.png";
	private String imgInsertClick = "res/btnInsertClick.png";
	private String imgUpdate = "res/btnUpdate.png";
	private String imgUpdateClick = "res/btnUpdateClick.png";
	private String imgDelete = "res/btnDelete.png";
	private String imgDeleteClick = "res/btnDeleteClick.png";

	public AccPanel(DepotMainFrame mF) {
		this.mF = mF;
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		// pWest ����
		pWest = new JPanel();
		pWest.setBackground(Color.decode("#BDBDBD"));
		pWest.setBounds(0, 0, 200, 720);
		add(pWest, BorderLayout.WEST);
		pWest.setLayout(null);

		btnCloth = new JButton("�Ƿ�");
		btnCloth.setBounds(5, 5, 55, 23);
		btnCloth.setFont(new Font("�������,", Font.BOLD, 10));
		pWest.add(btnCloth);

		btnBag = new JButton("����");
		btnBag.setBounds(65, 5, 55, 23);
		btnBag.setFont(new Font("�������", Font.BOLD, 10));
		pWest.add(btnBag);

		btnShoes = new JButton("�Ź�");
		btnShoes.setBounds(125, 5, 55, 23);
		btnShoes.setFont(new Font("�������", Font.BOLD, 10));
		pWest.add(btnShoes);

		btnAcc = new JButton("�Ǽ��縮");
		btnAcc.setBounds(185, 5, 77, 23);
		btnAcc.setFont(new Font("�������", Font.BOLD, 10));
		pWest.add(btnAcc);

		btnLog = new JButton("�̷�");
		btnLog.setBounds(267, 5, 55, 23);
		btnLog.setFont(new Font("�������", Font.BOLD, 10));
		pWest.add(btnLog);

		btnManagerList = new JButton("������ ���");
		btnManagerList.setBounds(327, 5, 91, 23);
		btnManagerList.setFont(new Font("�������", Font.BOLD, 10));
		pWest.add(btnManagerList);

		// pNorth ����
		pNorth = new JPanel();
		pNorth.setBackground(Color.RED);
		// add(pNorth, BorderLayout.NORTH);

		String[] strCbSearch = new String[] { "�Ƿ�", "�Ź�", "����", "�Ǽ��縮" };
		cbSearch = new JComboBox<>(strCbSearch);
		pNorth.add(cbSearch);
		tfSearch = new JTextField();
		pNorth.add(tfSearch);
		tfSearch.setColumns(10);
		btnSearch = new JButton("�˻�");
		pNorth.add(btnSearch);

		btnSearch.setHorizontalAlignment(SwingConstants.RIGHT);

		// pCenter ����
		pCenter = new JPanel();

		 pCenter.setBackground(Color.decode("#BDBDBD"));
		add(pCenter, BorderLayout.CENTER);

		// Table ����
		GoodsDAO dao = new GoodsDAO();
		data = dao.showGoods();
		data = new Vector();
		titles = new Vector();
		titles.add("NO");
		titles.add("��ǰ��");
		titles.add("��ǰ����");
		titles.add("����");
		titles.add("����");
		titles.add("��ġ");
		titles.add("��¥");
		titles.add("ī�װ�");
		model = new DefaultTableModel(data, titles);
		accTable = new JTable(model);
		accTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accTable.addMouseListener(this);
		accTable.setOpaque(false);
		accTable.setShowGrid(false);
		pane = new JScrollPane(accTable) {
			@Override
			public void setBorder(Border border) {}
		};
		pane.setPreferredSize(new Dimension(1000, 590));
		pane.setOpaque(false);
		pane.getViewport().setOpaque(false);
		pCenter.add(pane);
		updateTable();

		// pSouth ����
		pSouth = new JPanel();
		pSouth.setBackground(Color.decode("#BDBDBD"));
		FlowLayout flowLayout = (FlowLayout) pSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		// pSouth.setBackground(Color.PINK);
		add(pSouth, BorderLayout.SOUTH);

		ImageIcon insert = new ImageIcon(imgInsert);
		ImageIcon insertClick = new ImageIcon(imgInsertClick);
		ImageIcon update = new ImageIcon(imgUpdate);
		ImageIcon updateClick = new ImageIcon(imgUpdateClick);
		ImageIcon delete = new ImageIcon(imgDelete);
		ImageIcon deleteClick = new ImageIcon(imgDeleteClick);
		
		btnAdd = new JButton(insert);
		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setPressedIcon(insertClick);
		btnAdd.addActionListener(this);
		
		btnUpdate = new JButton(update);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setFocusPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setPressedIcon(updateClick);
		btnUpdate.addActionListener(this);
		
		btnDelete = new JButton(delete);
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setPressedIcon(deleteClick);
		btnDelete.addActionListener(this);
		pSouth.add(btnAdd);
		pSouth.add(btnUpdate);
		pSouth.add(btnDelete);
	}

	public void showData() {
		GoodsDAO dao = new GoodsDAO();
		data = dao.showGoods();
	}

	public void updateTable() {
		showData();
		model = new DefaultTableModel(data, titles);
		accTable.setModel(model);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = accTable.getSelectedRow();
		//System.out.println("index = " + index);
		selectData = (Vector) data.get(index);
		//System.out.println("selectData = " + selectData);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			dd = new DataDialog(this, "��ǰ �߰�!", true);
			System.out.println("�߰�");
			MemberDTO dto = new MemberDTO();

		} else if (e.getSource() == btnUpdate) {
			System.out.println("������ư");
			int upNumber = (int) selectData.get(0);
			String upName = (String) selectData.get(1);
			String upDetail = (String) selectData.get(2);
			int upPrice = (int) selectData.get(3);
			int upAmount = (int) selectData.get(4);
			String upLocation = (String) selectData.get(5);
			String upCategory = (String) selectData.get(7);
			GoodsDTO dto = new GoodsDTO();
			dto.setGoodsNumber(upNumber);
			dto.setGoodsName(upName);
			dto.setGoodsDetail(upDetail);
			dto.setGoodsPrice(upPrice);
			dto.setGoodsAmount(upAmount);
			dto.setGoodsLocation(upLocation);
			dto.setFkCategoryName(upCategory);
			uD = new UpdateDialog(this, "��ǰ ����", true, dto);

		} else if (e.getSource() == btnDelete) {
			int result = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				System.out.println("Ȯ��");
				System.out.println("select Data = " + selectData);
				int deleteNum = (int) selectData.get(0);
				GoodsDTO dto = new GoodsDTO();
				dto.setGoodsNumber(deleteNum);
				GoodsDAO dao = new GoodsDAO();
				boolean ok = dao.delteGoods(deleteNum, dto);
				if (ok) {
					updateTable();
				}
			}

		}

	}
}
