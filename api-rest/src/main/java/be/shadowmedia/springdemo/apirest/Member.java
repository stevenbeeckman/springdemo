package be.shadowmedia.springdemo.apirest;

import org.springframework.hateoas.ResourceSupport;

public class Member extends ResourceSupport{
	private final long sid;
	private final String name;
	
	public Member(long id, String name) {
		this.sid = id;
		this.name = name;
	}

	public long getSid() {
		return sid;
	}

	public String getName() {
		return name;
	}

}
