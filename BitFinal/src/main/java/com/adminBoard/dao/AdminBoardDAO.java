package com.adminBoard.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adminBoard.bean.AdminBoardDTO;

@Repository
public interface AdminBoardDAO  extends JpaRepository<AdminBoardDTO,String>{
	
//	@Transactional
//	@Query(value = "delete from adminboard where adminBoardSeq=:adminBoardSeq",nativeQuery = true)
//	public void deleteByadminBoardSeq(@Param("adminBoardSeq")int adminBoardSeq);

//	@Query("select adminBoardDTO from AdminBoardDTO adminBoardDTO where adminBoardDTO.adminBoardSeq=:adminBoardSeq")
//	public Optional<AdminBoardDTO> findByGetAdminBoard(@Param("adminBoardSeq") String adminBoardSeq);
	//관리자 게시판 글 수정 전 찾기

	@Query("select adminBoardDTO from AdminBoardDTO adminBoardDTO where adminBoardDTO.title like '%' || :adminKeyword || '%'") 
	public List<AdminBoardDTO> getAdminSearchTitle(@Param("adminKeyword") String adminKeyword);

	@Query("select adminBoardDTO from AdminBoardDTO adminBoardDTO where adminBoardDTO.content like '%' || :adminKeyword || '%'") 
	public List<AdminBoardDTO> getAdminSearchContent(@Param("adminKeyword") String adminKeyword);

	@Transactional
	@Modifying
	@Query(value = "delete from adminboard where adminBoardSeq=:adminBoardSeq",nativeQuery = true)
//	@Query("delete from AdminBoardDTO adminBoardDTO where adminBoardDTO.adminBoardSeq=:adminBoardSeq")
	public void deleteById(@Param("adminBoardSeq") String adminBoardSeq);

	@Query("select adminBoardDTO from AdminBoardDTO adminBoardDTO where adminBoardDTO.adminBoardSeq=:adminBoardSeq")
	public Optional<AdminBoardDTO> findBygetAdminBoard(@Param("adminBoardSeq") int adminBoardSeq);
}


