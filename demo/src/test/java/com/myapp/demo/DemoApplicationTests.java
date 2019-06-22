package com.myapp.demo;

import com.myapp.demo.component.MailService;
import com.myapp.demo.dao.*;
import com.myapp.demo.entity.Article;
import com.myapp.demo.entity.User;
import com.myapp.demo.entity.indirect.UserStep;
import com.myapp.demo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

        @Autowired
        private IUserDao userDao;

        @Autowired
        private IAdministerDao adDao;

        @Autowired
        private IFavoriteDao favoriteDao;

        @Autowired
        private IArticleDao articleDao;

        @Autowired
        private ITicketDao ticketDao;

        /////////////////////////////////service test

        @Autowired
        private IUserService userService;

        @Autowired
        private IStepService stepService;

        @Autowired
        private IPrizeService prizeService;

        @Autowired
        private IArticleService articleService;

        @Autowired
        private ITicketService ticketService;



    @Test
    public void testSave(){
        //添加新用户
        User acc = new User();
        acc.setNum(1105);
        acc.setUsername("刘总");
        acc.setType(1);
        acc.setRegistTime(new Date());
        acc.setEmail("liuzong@qq.com");
    }

    @Transactional
    @Test
    @Rollback(false)
    public void testUpdate(){
        stepService.setTotalStepById(1,11111L);
    }

    @Test
    public void testUserService(){
        List<UserStep> res =stepService.getTopTotal(3);
        for(UserStep st:res){
            System.out.println(st);
        }
    }

    @Test
    public void testStepService(){
        List<Article> res = articleDao.findAllByOrderByReleaseTimeDesc();
        for(Article ss:res){
            System.out.println(ss);
        }
    }

    @Test
    public void test3(){
        List<Article> res = articleDao.findAllByTitleLike("%测试%");
        for(Article ss:res){
            System.out.println(ss);
        }
    }

    @Test
    public void test4() {
        articleService.addFavorite(2,4);
    }

    @Test
    public void test5(){
//        ticketService.addMyTicket(1,1);
//
//        List<Ticket> res = ticketService.getAccessibleTicket();
//        for(Ticket t :res){
//            System.out.println(t);
//        }
//
//        List<Ticket> res2 = ticketService.getMyTicket(1);
//        for(Ticket t :res2){
//            System.out.println(t);
//        }
        //ticketService.deleteMyTicket(1,2);
    }

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("1092772959@qq.com","test simple mail"," hello this is simple mail");
    }
}