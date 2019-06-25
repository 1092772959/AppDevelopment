package com.myapp.demo.dao;

import com.myapp.demo.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrizeDao extends JpaRepository<Prize, Integer> {

    Prize findPrizeById(Integer id);

    @Override
    List<Prize> findAll();

    /**
     * 查询当前步数能够获取的奖品，并按照步数递增排序
     * @param step
     * @return
     */
    List<Prize> findByStepNeedLessThanEqualOrderByStepNeedAsc(Integer step);

    /**
     * 增加或更新
     */
    @Override
    <S extends Prize> S save(S s);

    /**
     * 根据ID删除
     * @param integer
     */
    @Override
    void deleteById(Integer integer);
}
