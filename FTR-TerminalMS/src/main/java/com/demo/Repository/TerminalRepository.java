package com.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 
import com.demo.entity.Terminal;

 
@Repository("terminalrepository")
public interface TerminalRepository extends JpaRepository<Terminal,String>{

	
	@Query("select t from Terminal t where t.itemType=?1")
	public List<Terminal> getByItemType(String itemType);
	
	@Query("select t from Terminal t where t.terminalId=?1")
	public Optional<Terminal> getByItemId(String itemId);
	
	@Query("select t from Terminal t where t.terminalId=?1")
	public List<Terminal>  getTermianlById1(String itemId);
	
	@Modifying
	@Query(value="DELETE from Terminal t where t.terminalId=?1")
	public void deleteById(String terminalId);
	
	 
}
