package step14.ex07.client;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientApp extends Frame implements ActionListener {
  private static final long serialVersionUID = 1L;
  
  BoardPanel boardPanel;
  
  CardLayout cardLayout = new CardLayout();
  
  public ClientApp() {
    super("비트캠프 울트라 예제 v0.6 ");

    BoardDaoProxy boardDaoProxy = new BoardDaoProxy("localhost", 8888);
    boardPanel = new BoardPanel();
    boardPanel.setBoardDao(boardDaoProxy); // BoardPanel이 사용할 BoardDao 객체를 주입한다.
    boardPanel.loadList(); // BoardDao가 주입된 후에 목록을 가져와야 한다.
    
    setLayout(cardLayout); // 레이아웃 관리자 교체: BorderLayout --> CardLayout
    prepareMenu();
    preparePanels();

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    setSize(500, 600);
  }
  
  private void prepareMenu() {
    MenuBar menuBar = new MenuBar();
    setMenuBar(menuBar); // 메뉴바를 프레임 윈도우에 추가한다.

    Menu adminMenu = new Menu("관리");
    menuBar.add(adminMenu); // 관리 메뉴를 메뉴바에 추가한다.
    
    MenuItem boardMI = new MenuItem("게시판");
    boardMI.setActionCommand("board"); // 나중에 이벤트를 구분할 때 사용하기 위함.
    boardMI.addActionListener(this); // MainApp 자신이 ActionListener를 구현했다.
    adminMenu.add(boardMI); // 게시판 메뉴를 관리 메뉴에 추가한다.
    
    MenuItem projectMI = new MenuItem("프로젝트");
    projectMI.setActionCommand("project");// 나중에 이벤트를 구분할 때 사용하기 위함.
    projectMI.addActionListener(this);
    adminMenu.add(projectMI);
    
    MenuItem contactMI = new MenuItem("연락처");
    contactMI.setActionCommand("contact");// 나중에 이벤트를 구분할 때 사용하기 위함.
    contactMI.addActionListener(this);
    adminMenu.add(contactMI);
    
    MenuItem memberMI = new MenuItem("회원");
    memberMI.setActionCommand("member");// 나중에 이벤트를 구분할 때 사용하기 위함.
    memberMI.addActionListener(this);
    adminMenu.add(memberMI);
    
  }
  
  private void preparePanels() {
    add(boardPanel, "board"); 
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    cardLayout.show(this, e.getActionCommand());
    revalidate(); // 화면을 갱신하라!
  }
  
  public static void main(String[] args) {
    ClientApp app = new ClientApp();
    app.setVisible(true);
  }
  
}
