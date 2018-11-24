package be.shadowmedia.springdemo.apirest;

import java.util.ArrayList;

import org.springframework.hateoas.ResourceSupport;

public class Project extends ResourceSupport{
	private final long sid;
	private final String name;
	private ArrayList<Member> members;
	
	public Project(long id, String name) {
		this.sid = id;
		this.name = name;
		members = new ArrayList<Member>();
	}

	public long getSid() {
		return sid;
	}

	public String getName() {
		return name;
	}
	
	public void addMember(Member member) {
		members.add(member);
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}

}
