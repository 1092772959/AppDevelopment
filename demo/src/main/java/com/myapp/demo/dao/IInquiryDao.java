package com.myapp.demo.dao;

import com.myapp.demo.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInquiryDao extends JpaRepository<Inquiry, Integer> {

    Inquiry findInquiryById(Integer id);

    @Override
    List<Inquiry> findAll();

    /**
     * 查找某一用户的询问
     * @param userid
     * @return
     */
    List<Inquiry> findByUserid(Integer userid);

    /**
     * 增加或更新
     */
    @Override
    <S extends Inquiry> S save(S s);

    /**
     *删除
     */
    @Override
    void deleteById(Integer integer);
}
