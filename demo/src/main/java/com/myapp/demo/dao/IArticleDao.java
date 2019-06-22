package com.myapp.demo.dao;

import com.myapp.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IArticleDao extends JpaRepository<Article,Integer> {

    Article findArticleById(Integer id);

    /**
     * 多表查询：根据用户id查询其收藏的文章
     * @param userId
     * @return
     */
    @Query(value="select * from article as X " +
            "where X.id in (" +
                "select article_id from favorite " +
                "where userid = ?1)" +
            "order by X.release_time desc",
            nativeQuery = true)
    List<Article> findArticleByUserId(Integer userId);

    /**
     * 获取所有文章，按发布时间倒排
     * @return
     */
    List<Article> findAllByOrderByReleaseTimeDesc();

    //模糊查询
    List<Article> findAllByTitleLike(String titleLike);


    /**
     * 增加或更新文章
     */
    @Override
    <S extends Article> S save(S s);

    /**
     * 根据id删文章
     */
    @Override
    void deleteById(Integer integer);
}
