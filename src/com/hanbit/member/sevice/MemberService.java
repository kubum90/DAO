package com.hanbit.member.sevice;
import java.util.List;
import com.hanbit.member.domain.MemberBean;
public interface MemberService {
	public void addMember(MemberBean member);
	public List<MemberBean> list(); //목록을 가져와서 보여주기
	public List<MemberBean> findByName(String name);
	public MemberBean findById(String id);
	public int count();
	public void modify(MemberBean member);
	public void remove(String id);
}