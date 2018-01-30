package kr.co.adela.depot.clothes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import kr.co.adela.depot.DepotMainFrame;
import kr.co.adela.depot.model.DAOclothes;

public class HistoryPanel extends JPanel{
	private DepotMainFrame fMain;
	private JPanel pSearch, pHistoryList, pCenter;
	private Vector data,titles,selectData;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable tblHistory;
	private boolean isHistoryUpdate;

	public HistoryPanel(DepotMainFrame fMain) {
		this.fMain = fMain;
		this.isHistoryUpdate = isHistoryUpdate;
		setLayout(new BorderLayout());
		setBackground(Color.decode("#BDBDBD"));
		
		//borderlayout center
		pHistoryList = new JPanel(new BorderLayout());
		pHistoryList.setBackground(Color.decode("#BDBDBD"));
		//pHistoryList.setBackground(Color.PINK);
		add(pHistoryList,BorderLayout.CENTER);
		//�̷� ���̺� ���̱�
		tblHistory = new JTable(model);
		tblHistory.setOpaque(false);
		tblHistory.setShowGrid(false);
		scrollPane = new JScrollPane(tblHistory) {
			@Override
			public void setBorder(Border border) {}
		};
		scrollPane.setPreferredSize(new Dimension(1000, 590));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		pCenter = new JPanel();
		pCenter.setBackground(Color.decode("#BDBDBD"));
		pCenter.add(scrollPane);
		pHistoryList.add(pCenter);
			//vector titles �� ���빰 �߰�
		titles = new Vector();
		titles.add("No"); titles.add("��ǰ��");
		titles.add("�̷� ����"); titles.add("���� ����");
		titles.add("���� ��¥"); titles.add("������ ��");
			//@@ �ӽ� @@ vector data�� ���빰 �߰� 
		DAOclothes daoc = new DAOclothes();
		data = daoc.showHistory();
		
		model = new DefaultTableModel(data,titles) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblHistory.setModel(model);
	}
	
	public void showHistory() {
		DAOclothes daoc = new DAOclothes();
		data = daoc.showHistory();
		model = new DefaultTableModel(data, titles);
		tblHistory.setModel(model);
	}
}
