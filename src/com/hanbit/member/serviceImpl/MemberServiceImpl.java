package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.sevice.MemberService;

public class MemberServiceImpl implements MemberService {
	int count;
	Map<String, MemberBean> map;
	MemberBean member;
	List<MemberBean> list;

	public MemberServiceImpl() {
		map = new HashMap<>();
		count = 0;
		member = new MemberBean();
		list = new ArrayList<>();
	}

	@Override
	public String addMember(MemberBean member) {
		return  (new MemberDAOImpl().insert(member)==1)?"success":"fail";
	}

	@Override
	public int count() {
		return new MemberDAOImpl().count();
	}

	@Override
	public List<MemberBean> list() {
		return new MemberDAOImpl().selectAll();
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
		
		return new MemberDAOImpl().selectByName(name);
	}

	@Override
	public String modify(MemberBean bean) {
		String msg ="";
		for (MemberBean m : list) {
			if (bean.getId().equals(m.getId())) {
				if (!bean.getName().equals("")) {
					m.setName(bean.getName());
				}
				if (!bean.getPassword().equals("")) {
					m.setPassword(bean.getPassword());
				}
				if (!bean.getSsn().equals("")) {
					m.setSsn(bean.getSsn());
				}
			}
		}
		return msg;
	}

	@Override
	public String remove(String deleteId) {
		String msg ="";
		for (int i = 0; i < list.size(); i++) {
			if (deleteId.equals(list.get(i).getId())) {
				list.remove(list.get(i));
			}
		}
		return msg;
	}
}