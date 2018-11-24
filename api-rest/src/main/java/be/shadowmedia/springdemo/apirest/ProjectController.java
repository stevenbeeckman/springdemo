package be.shadowmedia.springdemo.apirest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.server.PathParam;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.LinkBuilderSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class ProjectController{

	
	@RequestMapping("/projects")
	public HttpEntity<ArrayList<Project>> listOfProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();
		
		Member steven = new Member(1, "Jos De Vos");
		Member bart = new Member(2, "Gert Verheulst");
		Member dirk = new Member(3, "De Flurk");
		Member mathieu = new Member(4, "Jeanne d'Arc");
		
		Project p1 = new Project(1, "Starship Enterprise");
		p1.addMember(steven);
		p1.addMember(bart);
		p1.addMember(mathieu);
		p1.add(linkTo(methodOn(ProjectController.class).project("Starship Enterprise")).withSelfRel());
		//p1.add(linkTo(methodOn(ProjectController.class).members("Starship Enterprise")).withRel("members"));
		
		Project p2 = new Project(2, "Spaceman");
		p2.addMember(steven);
		p2.addMember(dirk);
		p2.add(linkTo(methodOn(ProjectController.class).project("Spaceman")).withRel("details"));
		
		projects.add(p1);
		projects.add(p2);
		
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	@RequestMapping("/project/{name}/members")
	private HttpEntity<ArrayList<Member>> members(@PathVariable("name") String name) {
		Member steven = new Member(1, "Jos De Vos");
		Member bart = new Member(2, "Gert Verheulst");
		Member dirk = new Member(3, "De Flurk");
		Member mathieu = new Member(4, "Jeanne d'Arc");
		
		Project p1 = new Project(1, "Starship Enterprise");
		p1.addMember(steven);
		p1.addMember(bart);
		p1.addMember(mathieu);

		Project p2 = new Project(2, "Spaceman");
		p2.addMember(steven);
		p2.addMember(dirk);
	
		if(name.equals("Starship Enterprise")) {
			ArrayList<Member> members = new ArrayList<Member>();
			members.add(steven);
			members.add(bart);
			members.add(mathieu);
			return new ResponseEntity<>(members, HttpStatus.OK);
		}else if(name.equals("Spaceman")) {
			ArrayList<Member> members = new ArrayList<Member>();
			members.add(steven);
			members.add(dirk);
			return new ResponseEntity<>(members, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}		


	}

	@RequestMapping("/project/{name}")
	public HttpEntity<Project> project(@PathVariable("name") String name) {
		Member steven = new Member(1, "Jos De Vos");
		Member bart = new Member(2, "Gert Verheulst");
		Member dirk = new Member(3, "De Flurk");
		Member mathieu = new Member(4, "Jeanne d'Arc");
		
		Project p1 = new Project(1, "Starship Enterprise");
		p1.addMember(steven);
		p1.addMember(bart);
		p1.addMember(mathieu);
		p1.add(linkTo(methodOn(ProjectController.class).project("Starship Enterprise")).withSelfRel());
		
		Project p2 = new Project(2, "Spaceman");
		p2.addMember(steven);
		p2.addMember(dirk);
		p2.add(linkTo(methodOn(ProjectController.class).project("Spaceman")).withSelfRel());
		
		
		if(name.equals("Starship Enterprise")) {
			return new ResponseEntity<>(p1, HttpStatus.OK);
		}else if(name.equals("Spaceman")) {
			return new ResponseEntity<>(p2, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
}
