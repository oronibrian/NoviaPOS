/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.novia.dao.pos.stock;

import java.util.List;
import ke.novia.dao.BaseRepository;
import ke.novia.model.pos.stock.Stockitem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface StockDao  extends BaseRepository<Stockitem, Long>  {
    /*
	@Modifying
	@Query("UPDATE LoanTransaction s SET s.isdeleted=1 WHERE id=:id")
    public int markAsDeleted(@Param("id") long id);
	
	@Query("SELECT s FROM LoanTransaction s WHERE s.isdeleted=0 ORDER BY s.transactiondate DESC")
    public List<Stockitem> findAll();
	
	@Query("SELECT s FROM LoanTransaction s WHERE s.transactiondate>=:startdate AND s.transactiondate<=:enddate AND s.isdeleted=0 ORDER BY s.transactiondate DESC")
    public List<Stockitem> findByDateRange(@Param("startdate") java.sql.Date startdate,@Param("enddate") java.sql.Date enddate, Pageable pageable);
	
	@Query("SELECT s FROM LoanTransaction s WHERE s.member_id=:member_id ORDER BY s.member_id DESC")
    public List<Stockitem> findLastMemberLoanTransaction(@Param("member_id") long member_id, Pageable pageable);
    */
}