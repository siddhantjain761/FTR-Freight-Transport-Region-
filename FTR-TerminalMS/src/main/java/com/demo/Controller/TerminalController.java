package com.demo.Controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DTO.TerminalDTO;
import com.demo.Exception.ItemIdNotAvaliableException;
import com.demo.Exception.ItemNotAvaliableException;
 
import com.demo.Service.TerminalService;
 

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

 
@Validated
@RestController
@CrossOrigin
@RequestMapping("/ftr/terminals")
public class TerminalController {
	Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private TerminalService terminalservice;
	
	@PostMapping 
	public ResponseEntity<Object> addTerminal(@RequestBody @Valid TerminalDTO terminaldetail) throws  MethodArgumentNotValidException{
		String message=terminalservice.addTerminal(terminaldetail);
		HashMap<String,Object> hm = new HashMap<>();
		hm.put("data",message);
		
		return ResponseEntity.ok(hm);
		
	}
	@GetMapping 
	public List<TerminalDTO> getAllTermianls() {
		logger.info("Fetching all plans");
		return terminalservice.getAllTerminals();
		
	}
	
	// Fetch  item of particular type
		@GetMapping(value = "/fetchTerminalByItemType/{itemType}", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<TerminalDTO> getTerminalByItem(@PathVariable String itemType)throws ItemNotAvaliableException {
			logger.info("Fetching details of plan "+ itemType);
			return terminalservice.getTerminalByItem(itemType);
		}
		
		// Fetch  item of particular ID
//		@CircuitBreaker(name="customerService",fallbackMethod="deleteFallback")
//		@GetMapping(value = "/fetchTerminalById/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
//		public List<TerminalDTO> getTerminalById(@PathVariable("itemId") String itemId)throws ItemIdNotAvaliableException{ 
		
		@GetMapping(value = "/fetchTerminalById/id", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<TerminalDTO> getTerminalById(@RequestParam("itemId")     String itemId)throws ItemIdNotAvaliableException{
			System.out.println("--------In Profile------");
			if(itemId.equals("T1")) {
				throw new RuntimeException();
				
			}
		logger.info("Fetching details of plan "+ itemId);
					return terminalservice.getTerminalById(itemId);
		}
		
		
		public ResponseEntity<String> deleteFallback(Throwable throwable){
			System.out.println("in fallback");
			return new ResponseEntity<>("Could not delete the vehicle WorkItem MS is not up",HttpStatus.OK);
		}
		
		
		
		
		
		
		//delete particular terminal by id
		@DeleteMapping(value="/{terminalId}")
		public String deleteEmployee(@PathVariable String terminalId)throws ItemIdNotAvaliableException{
			return terminalservice.deleteTerminalById(terminalId);
		} 
		
		//upadte capacity
		@PutMapping(value="/{terminalId}/{newCapacity}")
		 
		public String updateCapacity(@PathVariable String terminalId,@PathVariable Integer newCapacity) throws  ItemIdNotAvaliableException,Exception{
			String message=terminalservice.updateCapacity(terminalId,newCapacity);
			 
			return  message;
			}
}
