package id.dicka.backend.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.dicka.backend.entity.ProjectTask;
import id.dicka.backend.service.ProjectTaskService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api/board")
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;
	
	@PostMapping(value = "")
	public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			Map<String, String> error = new HashMap<>();
			
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				error.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
		}
		
		ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);
		return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<ProjectTask> getAllPts(){
		return projectTaskService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProjectTask> getPTbyId(@PathVariable("id")Long id){
		ProjectTask projectTask = projectTaskService.findById(id);
		return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteProjectTask(@PathVariable("id")Long id){
		projectTaskService.delete(id);
		return new ResponseEntity<String>("Project task deleted", HttpStatus.OK);
	}
}
