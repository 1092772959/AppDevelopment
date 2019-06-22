package com.myapp.demo.dao;

import com.myapp.demo.entity.Article;
import com.myapp.demo.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFavoriteDao extends JpaRepository<Favorite,Integer> {

    @Override
    <S extends Favorite> S save(S s);

    @Override
    void deleteById(Integer integer);

    void deleteByUseridAndArticleId(Integer userId, Integer articleId);
}
