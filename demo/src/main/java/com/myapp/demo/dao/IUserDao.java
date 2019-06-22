package com.myapp.demo.dao;

import com.myapp.demo.entity.User;
import com.myapp.demo.entity.indirect.UserStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserDao extends JpaRepository<User, Integer> {
    /**
     * 查找
     * @param id
     * @return
     */
    User findUserById(Integer id);

    //通过账号查找用户
    User findByNum(Integer num);

    List<User> findAll();

    List<User> findAllByTypeGreaterThanEqual(Integer type);

    List<User> findAllByTypeLessThanEqual(Integer type);

    /**
     * 增加用户
     */
    @Override
    <S extends User> S save(S s);

    /**
     * 删除用户
     */
    @Override
    void deleteById(Integer id);

    /**
     * 修改
     */
    @Modifying
    @Query(value="update User set username = ?2 where id = ?1")
    void updateUsernameById(Integer id, String username);

    @Modifying
    @Query(value="update User set iconPath = ?2 where id = ?1")
    void updateIconById(Integer id, String iconPath);

    @Modifying
    @Query(value="update User set bgPath = ?2 where id = ?1")
    void updateBackgroundById(Integer id, String bgPath);

    @Modifying
    @Query(value="update User set device = ?2 where id = ?1")
    void updateDeviceById(Integer id, String device);

    @Modifying
    @Query(value="update User set email = ?2 where id = ?1")
    void updateEmailById(Integer id, String email);




    /**
     * 计步相关
     */

    //计步排序
    @Query(value = "select new com.myapp.demo.entity.indirect.UserStep(X.num,X.username,X.todayStep,X.totalStep) " +
            "from User as X " +
            "order by X.todayStep desc ")
    List<UserStep> findTopOrderByTodayStep();

    @Query(value = "select new com.myapp.demo.entity.indirect.UserStep(X.num,X.username,X.weekStep,X.totalStep) " +
            "from User as X " +
            "order by X.weekStep desc ")
    List<UserStep> findTopOrderByWeekStep();

    @Query(value = "select new com.myapp.demo.entity.indirect.UserStep(X.num,X.username,X.monthStep,X.totalStep) " +
            "from User as X " +
            "order by X.monthStep desc ")
    List<UserStep> findTopOrderByMonthStep();

    @Query(value = "select new com.myapp.demo.entity.indirect.UserStep(X.num,X.username,X.seasonStep,X.totalStep) " +
            "from User as X " +
            "order by X.seasonStep desc ")
    List<UserStep> findTopOrderBySesonStep();

    @Query(value = "select new com.myapp.demo.entity.indirect.UserStep(X.num,X.username,0,X.totalStep) " +
            "from User as X " +
            "order by X.totalStep desc ")
    List<UserStep> findTopOrderByTotalStep();


    /**
     * 更新各时间段步数
     */

    @Modifying
    @Query(value="update User set todayStep = ?2 where id = ?1")
    void updateTodayStepById(Integer id, Integer step);

    @Modifying
    @Query(value="update User set weekStep = ?2 where id = ?1")
    void updateWeekStepById(Integer id, Integer step);

    @Modifying
    @Query(value="update User set monthStep = ?2 where id = ?1")
    void updateMonthStepById(Integer id, Integer step);

    @Modifying
    @Query(value="update User set seasonStep = ?2 where id = ?1")
    void updateSeasonStepById(Integer id, Integer step);

    @Modifying
    @Query(value="update User set totalStep = ?2 where id = ?1")
    void updateTotalStepById(Integer id, Long step);

}
