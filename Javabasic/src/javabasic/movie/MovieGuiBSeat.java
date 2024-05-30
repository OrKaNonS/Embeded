package javabasic.movie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MovieGuiBSeat implements ActionListener {

	public static void main(String[] args) {

		Movie mv = new Movie();

		mv.seats = new MovieSeat[8][10];

		JFrame f = new JFrame("좌석 표시");

		String column[] = { "열1", "열2", "열3", "열4", "열5", "열6", "열7", "열8", "열9", "열10" };

		JTable jt = new JTable(mv.seats, column);
		jt.setCellSelectionEnabled(true);
		ListSelectionModel select = jt.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		select.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String Data = null;
				int[] row = jt.getSelectedRows();
				int[] columns = jt.getSelectedColumns();

				for (int i = 0; i < row.length; i++) {
					for (int j = 0; j < columns.length; j++) {
						Data = (String) jt.getValueAt(row[i], columns[j]);
					}
				}
				// System.out.println("Table element selected is: " + Data);
				JOptionPane.showMessageDialog(f, "선택된 테이블은 " + Data + " 입니다");
			}
		});
		
		
		
		JScrollPane sp = new JScrollPane(jt);
		f.add(sp);
		f.setSize(300, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
