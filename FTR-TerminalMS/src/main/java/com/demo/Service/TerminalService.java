package com.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.demo.DTO.TerminalDTO;
import com.demo.Exception.ItemIdNotAvaliableException;
import com.demo.Exception.ItemNotAvaliableException;
import com.demo.Repository.TerminalRepository;
import com.demo.entity.Terminal;
 

 

@Service("terminalService")
@Transactional
public class TerminalService {
	Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private TerminalRepository terminalrepository;
	
	public String addTerminal(TerminalDTO dto)throws   MethodArgumentNotValidException{
		
		terminalrepository.save(TerminalDTO.convertDTOEntity(dto));
		return "new  Terminal recorded successfully Inserted";
	}
	
	public List<TerminalDTO> getAllTerminals(){
		List<Terminal> terminals=terminalrepository.findAll();
		List<TerminalDTO> terminalDTOs = new ArrayList<>();
		for (Terminal t : terminals) {
			TerminalDTO terminalDTO = TerminalDTO.valueOf(t);
			terminalDTOs.add(terminalDTO);
		}

		logger.info("Plan details : "+terminalDTOs);
		return terminalDTOs;
	}
	
	public List<TerminalDTO> getTerminalByItem(String itemType) throws  ItemNotAvaliableException{
		logger.info("Friend and family detailsfor customer "+ itemType);
		List<TerminalDTO> terminalDTOs= new ArrayList<>();
		List<Terminal> terminal=terminalrepository.getByItemType(itemType);
		
		if(terminal.isEmpty()) {
  			throw new ItemNotAvaliableException ("No such Item type exists.");
		}
		
		else {
		for (Terminal t : terminal) {
			TerminalDTO terminalDTO = TerminalDTO.valueOf(t);
			terminalDTOs.add(terminalDTO);
			
		}
		}
		logger.info("The friend list for customer  is "+terminalDTOs);
		return terminalDTOs;
	
	}
	
	public List<TerminalDTO> getTerminalById(String itemId) throws  ItemIdNotAvaliableException{
		logger.info("Friend and family detailsfor customer "+ itemId);
		List<TerminalDTO> terminalDTOs= new ArrayList<>();
		List<Terminal> terminal=terminalrepository.getTermianlById1(itemId);
		
		if(terminal.isEmpty()) {
  			throw new ItemIdNotAvaliableException ("Terminal details not found for ID:"+ itemId);
		}
		
		else {
		for (Terminal t : terminal) {
			TerminalDTO terminalDTO = TerminalDTO.valueOf(t);
			terminalDTOs.add(terminalDTO);
		}
		}
		logger.info("The friend list for customer  is "+terminalDTOs);
		return terminalDTOs;
	
	}
	
	public String deleteTerminalById(String terminalId)throws  ItemIdNotAvaliableException {
		 Optional<Terminal> terminal=terminalrepository.getByItemId(terminalId);
		if(terminal.isEmpty()) {
  			throw new ItemIdNotAvaliableException ("Terminal details not found for ID:"+ terminalId);
		}
		else {
			terminalrepository.deleteById(terminalId);
		}
		return " Terminal details are deleted";
	}
	
	public String updateCapacity(String terminalId,Integer newCapacity)throws ItemIdNotAvaliableException,Exception{
		 Optional<Terminal> terminal=terminalrepository.getByItemId(terminalId);
		 List<Terminal> te=terminalrepository. getTermianlById1(terminalId);
		 
		 Terminal t=terminal.get();
		if(te.isEmpty()) {
			throw new  Exception("Terminal details not found for ID:"+ terminalId);
		}
		  
		else if(t.getAvaliableCapicity()<newCapacity) {
			throw new ItemIdNotAvaliableException ("Available capacity is less than new capacity ");
		}
		else if(t.getAvaliableCapicity()==newCapacity) {
			t.setCapacity(t.getCapacity()+newCapacity);
			t.setStatus("NotAvaliable");
			t.setAvaliableCapacity(0);
			
			
		}
		else {
			t.setCapacity(t.getCapacity()+newCapacity);
			t.setAvaliableCapacity(t.getAvaliableCapicity()-newCapacity);
			
		}
	 terminalrepository.save(t);
	 
	return "Terminal Capacity successfully changed for ID :"+terminalId; 
}
	}
