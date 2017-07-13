package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.sevice.MemberService;

public class MemberServiceImpl implements MemberService {
	int count;
	MemberBean member;
	List<MemberBean> list;

	public MemberServiceImpl() {
		count = 0;
		member = new MemberBean();
		list = new ArrayList<>();
	}

	@Override
	public void addMember(MemberBean member) {
		list.add(member);
		count++;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public List<MemberBean> list() {
		MemberBean bean= new MemberBean();
		List<MemberBean> list = new ArrayList<MemberBean>();
		MemberDAO dao = new MemberDAOImpl();
		list = dao.selectAll();
		return list;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		MemberDAO dao = new MemberDAOImpl();
		member = dao.selectById(id);
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		int count = 0;
		List<MemberBean> members = new ArrayList<MemberBean>(count);

		for (MemberBean m : list) {
			if (name.equals(m.getName())) {
				count++;
			}
		}
		int j = 0;
		for (MemberBean m : list) {
			if (name.equals(m.getName())) {
				members.add(m);
				j++;
			}
			if (count == j) {
				break;
			}
		}
		return members;
	}

	@Override
	public void modify(MemberBean bean) {
		for(MemberBean m:list){
			if(bean.getId().equals(m.getId())){
				if(!bean.getName().equals("")){
					m.setName(bean.getName());
				}if(!bean.getPassword().equals("")){
					m.setPassword(bean.getPassword());
				}if(!bean.getSsn().equals("")){
					m.setSsn(bean.getSsn());
				}
			}
		}
	}

	@Override
	public void remove(String deleteId) {
		for (int i=0;i<list.size();i++) {
			if (deleteId.equals(list.get(i).getId())) {
				list.remove(list.get(i));
			}
		}
	}
}