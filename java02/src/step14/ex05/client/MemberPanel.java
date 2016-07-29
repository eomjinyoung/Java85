package step14.ex05.client;

import java.awt.Label;
import java.awt.Panel;

import step14.ex05.MemberDao;

public class MemberPanel extends Panel {
  private static final long serialVersionUID = 1L;

  MemberDao memberDao;
  
  public MemberPanel() {
    Label label = new Label("회원관리 화면");
    add(label);
  }

  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  
}