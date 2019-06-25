package com.myapp.demo.dao;


import com.myapp.demo.entity.MyPrize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMyPrizeDao extends JpaRepository<MyPrize,Integer> {

    @Query(value="select prizeId from MyPrize where userId = ?1 order by prizeId")
    List<Integer> findAllByUserId(Integer userId);

    @Override
    <S extends MyPrize> S save(S s);

    @Override
    void deleteById(Integer integer);
}
