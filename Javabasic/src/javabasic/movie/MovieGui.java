package javabasic.movie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovieGui extends JFrame {

	private static final long serialVersionUID = 152161231231L;
	private JFrame jfrm;
	private JButton[][] seatButtons; // 좌석 버튼 배열
	Movie mv = new Movie();
	

	public MovieGui() {
		
				
	}

	private void MainMenuGui() {
		jfrm = new JFrame("영화 예매 프로그램");					// 영화 예매 프로그램 이름의 JFrame 생성
		jfrm.setLayout(new BorderLayout());					// 배치관리자 설정,BoderLayout은 기본제공레이아웃으로 상단, 하단, 위, 아래, 오른쪽, 왼쪽, 중앙 경게가 생긴다.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 입력시 종료
		
		JPanel controlPanel = new JPanel(new GridLayout(1, 4));	// JPanel인 controlPanel을 을 1행 4열로 분열
		
		JButton BSeeSeat = new JButton("1. 좌석보기");				// JButton - 1. 좌석보기 누르는 버튼
		controlPanel.add(BSeeSeat);								// controlPanel에 JButton(1. 좌석보기) 추가
		BSeeSeat.addActionListener(new ActionListener() {		// 버튼 눌렀을 시 이벤트 추가
			public void actionPerformed(ActionEvent e) {		// 버튼을 눌렀을 때 실행되는 메소드
				showSeatsGui();
			}
		});

		JButton BReservSeat = new JButton("2. 영화예매");			// JButton - 2. 영화예매 누르는 버튼
		controlPanel.add(BReservSeat);							// controlPanel에 JButton(2. 영화예매) 추가
		// 예약 버튼 이벤트 추가

		JButton BCancelSeat = new JButton("3. 영화예매취소");		// JButton - 3. 영화예매취소 누르는 버튼
		controlPanel.add(BCancelSeat);							// controlPanel에 JButton(3. 영화예매취소) 추가
		// 예매 취소 버튼 이벤트 추가

		JButton BCancelalSeat = new JButton("4. 예매일괄취소");		// JButton - 4. 예매일괄취소 누르는 버튼
		controlPanel.add(BCancelalSeat);						// controlPanel에 JButton(4. 예매일괄취소) 추가
		// 일괄 취소 버튼 이벤트 추가
		
		jfrm.add(controlPanel, BorderLayout.NORTH);

		jfrm.setSize(800, 600);		// JFrame 사이즈 (800, 600)
		jfrm.setVisible(true);		// 창을 화면에 띄울것인지
	}

	private void showSeatsGui() {											// 좌석 보여주는 메소드
		JPanel seatPanel = new JPanel(new GridLayout(8, 10));				// JPanel인 seatPanel을 8행 10열로 분열
		seatButtons = new JButton[8][10];									// seat

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {
				final int row = i;
				final int col = j;
				seatButtons[i][j] = new JButton(mv.seats[i][j].toString());
				if (mv.seats[i][j].isReserved()) {
					seatButtons[i][j].setBackground(Color.RED);
				} else {
					seatButtons[i][j].setBackground(Color.GREEN);
				}
				seatButtons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleSeatClick(row, col);
					}
				});
				seatPanel.add(seatButtons[i][j]);
			}
		}

		jfrm.add(seatPanel, BorderLayout.CENTER);
		jfrm.revalidate();
		jfrm.repaint();
	}

	private void handleSeatClick(int row, int col) {
		if (mv.seats[row][col].isReserved()) {
			int confirm = JOptionPane.showConfirmDialog(jfrm, "좌석을 취소하시겠습니까?", "예매 취소", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				String name = JOptionPane.showInputDialog(jfrm, "예약자 이름을 입력해주세요:");
				String id = JOptionPane.showInputDialog(jfrm, "예약자 주민번호를 입력해주세요:");
				if (name != null && id != null && mv.seats[row][col].getreserveName().equals(name)
						&& mv.seats[row][col].getuserID().equals(id)) {
					mv.seats[row][col].cancel();
					seatButtons[row][col].setText(mv.seats[row][col].toString());
					seatButtons[row][col].setBackground(Color.GREEN);
				} else {
					JOptionPane.showMessageDialog(jfrm, "예약자 정보가 일치하지 않습니다.");
				}
			}
		} else {
			String name = JOptionPane.showInputDialog(jfrm, "예약자 이름을 입력해주세요:");
			String id = JOptionPane.showInputDialog(jfrm, "예약자 주민번호를 입력해주세요:");
			if (name != null && id != null) {
				mv.seats[row][col].reserve(name, id);
				seatButtons[row][col].setText(mv.seats[row][col].toString());
				seatButtons[row][col].setBackground(Color.RED);
			}
		}
	}
}