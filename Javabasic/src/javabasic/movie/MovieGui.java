package javabasic.movie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MovieGui extends JFrame {

	private static final long serialVersionUID = 152161231231L;
	private JFrame jfrm;
	private JButton[][] seatButtons;// 좌석 버튼 배열
	Movie mv = new Movie(); // Movie 객체 참조
	MovieDao md = new MovieDao();
//	private JLabel seatInfo; // setInfo 멤버 변수로 선언

	public MovieGui() {
		super("영화 좌석 예매 프로그램");
	}

	public void MainMenuGui() {

		jfrm = new JFrame("영화 좌석 예매 프로그램"); // 영화 예매 프로그램 이름의 JFrame 생성
		jfrm.setLayout(new BorderLayout()); // 배치관리자 설정,BoderLayout은 기본제공레이아웃으로 상단, 하단, 위, 아래, 오른쪽, 왼쪽, 중앙 경게가 생긴다.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 입력시 종료

		JPanel controlPanel = new JPanel(new GridLayout(1, 3)); // JPanel인 controlPanel을 을 1행 4열로 분열

		JButton BSeeSeat = new JButton("1. 좌석보기"); // JButton - 1. 좌석보기 누르는 버튼
		controlPanel.add(BSeeSeat); // controlPanel에 JButton(1. 좌석보기) 추가
		BSeeSeat.addActionListener(new ActionListener() { // 버튼 눌렀을 시 이벤트 추가
			public void actionPerformed(ActionEvent e) { // 버튼을 눌렀을 때 실행되는 메소드
				showSeatsGui();
			}
		});

		JButton BReservSeat = new JButton("2. 영화예매"); // JButton - 2. 영화예매 누르는 버튼
		controlPanel.add(BReservSeat); // controlPanel에 JButton(2. 영화예매) 추가
		// 예약 버튼 이벤트 추가
		BReservSeat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reserveSeat();
			}
		});

		JButton BCancelSeat = new JButton("3. 영화예매취소"); // JButton - 3. 영화예매취소 누르는 버튼
		controlPanel.add(BCancelSeat); // controlPanel에 JButton(3. 영화예매취소) 추가
		// 예매 취소 버튼 이벤트 추가
		BCancelSeat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelSeat();
			}

		});

		jfrm.add(controlPanel, BorderLayout.NORTH);

		jfrm.setSize(800, 600); // JFrame 사이즈 (800, 600)
		jfrm.setVisible(true); // 창을 화면에 띄울것인지
	}

	private void showSeatsGui() { // 좌석 보여주는 메소드
		JPanel seatPanel = new JPanel(new GridLayout(8, 10)); // 좌석을 배치할 JPanel을 8행 10열로 배치
		seatButtons = new JButton[8][10]; // 누를번호 8*10 JButton 선언

		int FRow = 'A';
		for (int i = 0; i < 8; i++, FRow++) {
			for (int j = 0; j < 10; j++) {
				int row = i;
				int col = j;
				seatButtons[i][j] = new JButton(Character.toString((char) (FRow)) + (j + 1)); // A1, A2, A3....... H10
																								// 까지 배열에 넣기
				if (mv.seats[i][j].isReserved()) { // 만약 mv.seats[i][j]가 예약되있으면 빨간색으로
					seatButtons[i][j].setBackground(Color.RED);
				} else {
					seatButtons[i][j].setBackground(Color.GREEN); // 만약 mv.seats[i][j]가 예약 안되있으면 초록색으로
				}
				seatButtons[i][j].addActionListener(new ActionListener() { // 각 좌석 버튼에 ActionListener 정의
					public void actionPerformed(ActionEvent e) { // 버튼 눌렀을 시
						SeatClick(row, col); // SeatClick(row, col); 이 메소드 실행
					}
				});
				seatPanel.add(seatButtons[i][j]); // 위에 8행 10열로 그리드형식으로 나눈 JPanel에 각 버튼을 넣는다.
			}
		}

		jfrm.add(seatPanel, BorderLayout.CENTER); // seatPanel 중앙에 넣는다.
		jfrm.revalidate(); // 컴포넌트 재배시 메소드
		jfrm.repaint(); // 컴포넌트 다시 그리는 메소드
	}

	private void SeatClick(int row, int col) { // 버튼 눌렀을 시 행하는 메소드
		// 좌석 선택 시 알파벳 행 값을 가져오는 코드
		String seatRow = String.valueOf((char) ('A' + row));

		if (mv.seats[row][col].isReserved()) { // 클릭햇을 시 좌석시 예매 되어 있다면
			// JOptionPane.showConfirmDialog는 확인 다이얼로그로 사용자로부터 Yes/NO 응답을 입력받는 다이얼로그이다.
			// 사용자가 Yes를 선택하면 아래의 YES_OPTION을 수행, NO를 선택하면 없음_미구현
			int confirm = JOptionPane.showConfirmDialog(jfrm, " 좌석을 취소하시겠습니까?", "예매 취소", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				// JOptionPane.showInputDialog는 한 줄을 입력받는 다이얼로그
				String name = JOptionPane.showInputDialog(jfrm, "예약자 이름을 입력해주세요:"); // 예약시 입력한 이름
				String id = JOptionPane.showInputDialog(jfrm, "예약자 아이디를 입력해주세요:"); // 예약시 입력한 회원가입 아이디
				if (name != null && id != null && !name.isEmpty() && !id.isEmpty() // 이름, 아이디가 null이 아니고 빈값도 아니며 입력한 이름과
						&& mv.seats[row][col].getreserveName().equals(name) // 아이디가 같은면
						&& mv.seats[row][col].getuserID().equals(id)) {
					mv.seats[row][col].cancel(); // cancel() 메소드 실행으로 예약을 false로, 이름과 id는 "" 값으로 변경
					seatButtons[row][col].setText((char) ('A' + row) + String.valueOf(col + 1)); // toString 메소드에 의해 예약이
																									// false 이므로 X 표시를
																									// 다시 숫자로 변경
					seatButtons[row][col].setBackground(Color.GREEN); // 색상 초록색으로 변경

					String seatNumber = (char) ('A' + row) + String.valueOf(col + 1);
					JOptionPane.showMessageDialog(jfrm, seatNumber + " 자리 예매가 취소되었습니다.");
					md.cancelSeat(seatRow, col + 1, name, id);
				} else {
					JOptionPane.showMessageDialog(jfrm, "예약자 정보가 일치하지 않습니다."); // 이름, 아이디 중 null이 있거나 이름 혹은 아이디가 일치하지
																				// 않으면 //
				}
			}
		} else { // 클릭했을 시 예약이 안되어 있다면
			String name = JOptionPane.showInputDialog(jfrm, "예약자 이름을 입력해주세요:"); // 예약할 이름
			String id = JOptionPane.showInputDialog(jfrm, "예약자 아이디를 입력해주세요:"); // 예약할 아이디
			if (name != null && id != null && !name.isEmpty() && !id.isEmpty()) { // 이름과 아이디가 null이 아니라면
				mv.seats[row][col].reserve(name, id); // 해당 좌석으로 reserve(name, id) 메소드 실행 / 예약을 true로, 이름과 id는 입력값으로 변경
				seatButtons[row][col].setText(mv.seats[row][col].toString()); // toString 메소드에 의해 예약이 true이므로 X로 표시
				seatButtons[row][col].setBackground(Color.RED); // 색상 빨강으로 변경
				String seatNumber = (char) ('A' + row) + String.valueOf(col + 1);
				JOptionPane.showMessageDialog(jfrm, seatNumber + " 자리 예매가 완료되었습니다.");
				md.reserveSeat(seatRow, (col + 1), name, id);
			} else {
				JOptionPane.showMessageDialog(jfrm, "예약자 이름 혹은 아이디가 잘못입력되었습니다."); // 이름 또는 아이디가 입력되지 않았을 때 안내 메시지 출력

			}
		}
	}

	// 영화예매 버튼의 동작 추가
	private void reserveSeat() {
		String name = JOptionPane.showInputDialog(jfrm, "예약자 이름을 입력해주세요:");
		String id = JOptionPane.showInputDialog(jfrm, "예약자 아이디를 입력해주세요:");
		if (name != null && id != null && !name.isEmpty() && !id.isEmpty()) {
			int choice = JOptionPane.showConfirmDialog(jfrm, "좌석을 직접 선택하시겠습니까?", "좌석 선택", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				showSeatsGui();
			} else {
				String seatNumber = JOptionPane.showInputDialog(jfrm, "예약할 좌석 번호를 입력해주세요 (예: A1):");
				if (seatNumber != null && !seatNumber.isEmpty()) {
					int row = seatNumber.charAt(0) - 'A';
					int col = Integer.parseInt(seatNumber.substring(1)) - 1;
					if (row >= 0 && row < 8 && col >= 0 && col < 10) {
						if (!mv.seats[row][col].isReserved()) {
							mv.seats[row][col].reserve(name, id);
							seatButtons[row][col].setText(mv.seats[row][col].toString());
							seatButtons[row][col].setBackground(Color.RED);
							JOptionPane.showMessageDialog(jfrm, seatNumber + " 자리 예매가 완료되었습니다.");
							// 데이터베이스에 좌석 예약 정보 저장
							md.reserveSeat(String.valueOf((char) ('A' + row)), (col + 1), name, id);
						} else {
							JOptionPane.showMessageDialog(jfrm, "이미 예약된 좌석입니다.");
						}
					} else {
						JOptionPane.showMessageDialog(jfrm, "좌석 번호가 올바르지 않습니다.");
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(jfrm, "예약자 이름 또는 아이디를 입력해주세요.");
		}
	}

	// 영화예매취소 버튼의 동작 추가
	private void cancelSeat() {
		String name = JOptionPane.showInputDialog(jfrm, "예약자 이름을 입력해주세요:");
		String id = JOptionPane.showInputDialog(jfrm, "예약자 아이디를 입력해주세요:");
		if (name != null && !name.isEmpty() && id != null && !id.isEmpty()) {
			String seatNumber = JOptionPane.showInputDialog(jfrm, "취소할 좌석 번호를 입력해주세요 (예: A1):");
			if (seatNumber != null && !seatNumber.isEmpty()) {
				int row = seatNumber.charAt(0) - 'A';
				int col = Integer.parseInt(seatNumber.substring(1)) - 1;
				if (row >= 0 && row < 8 && col >= 0 && col < 10) {
					if (mv.seats[row][col].isReserved() && mv.seats[row][col].getuserID().equals(id)) {
						mv.seats[row][col].cancel();
						seatButtons[row][col].setText((char) ('A' + row) + String.valueOf(col + 1));
						seatButtons[row][col].setBackground(Color.GREEN);
						JOptionPane.showMessageDialog(jfrm, seatNumber + " 자리 예매가 취소되었습니다.");

						String seatRow = String.valueOf((char) ('A' + row));
						md.cancelSeat(seatRow, col + 1, name, id);
					} else {
						JOptionPane.showMessageDialog(jfrm, "해당 좌석을 예약한 사용자가 아니거나 예약된 좌석이 아닙니다.");
					}
				} else {
					JOptionPane.showMessageDialog(jfrm, "좌석 번호가 올바르지 않습니다.");
				}
			}
		} else {
			JOptionPane.showMessageDialog(jfrm, "예약자 이름 및 아이디를 입력해주세요.");
		}
	}
}
