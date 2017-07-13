package com.hanbit.member.dao;
import java.util.List;
import com.hanbit.member.domain.MemberBean;
public interface MemberDAO {
	public void insert(MemberBean bean);
	public List<MemberBean> selectAll(); 
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(String id);
	public int count();
	public void update(MemberBean member);
	public void delete(String id);
}
