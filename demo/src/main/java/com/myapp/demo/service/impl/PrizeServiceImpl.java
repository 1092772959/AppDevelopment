package com.myapp.demo.service.impl;

import com.myapp.demo.dao.IMyPrizeDao;
import com.myapp.demo.dao.IPrizeDao;
import com.myapp.demo.entity.MyPrize;
import com.myapp.demo.entity.Prize;
import com.myapp.demo.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class PrizeServiceImpl implements IPrizeService {

    @Autowired
    private IPrizeDao prizeDao;

    @Autowired
    private IMyPrizeDao myPrizeDao;

    @Override
    public Prize getPrizeById(Integer id) {
        return prizeDao.findPrizeById(id);
    }

    @Override
    public List<Prize> getAllPrize() {
        return prizeDao.findAll();
    }

    @Override
    public List<Prize> getPrizeByUserId(Integer userId) {
        List<Prize> res = this.prizeDao.findAll();

        List<Integer> myPrizesId = this.myPrizeDao.findAllByUserId(userId);

        int curPrizeId = myPrizesId.get(0), ptr = 0,sz = myPrizesId.size();
        for(Prize pz: res){
            if(ptr>= sz){               //此时该用户的已取奖品列表遍历完
                pz.setRedeemed(false);
                continue;
            }
            int nowId = pz.getId();
            if(nowId == curPrizeId){        //此奖品对改用户已被兑换
                pz.setRedeemed(true);
                ptr++;
                if(ptr<sz){
                    curPrizeId = myPrizesId.get(ptr);
                }
            }else{
                pz.setRedeemed(false);
            }
        }
        return res;
    }

    @Override
    public void addPrize(Prize prize) {
        this.prizeDao.save(prize);
    }

    @Override
    public void updateTitleById(Integer id, String title) {
        Prize prize = prizeDao.findPrizeById(id);
        prize.setTitle(title);
        this.prizeDao.save(prize);
    }

    @Override
    public void updateStepNeedById(Integer id, Integer step) {
        Prize prize = prizeDao.findPrizeById(id);
        prize.setStepNeed(step);
        this.prizeDao.save(prize);
    }

    @Override
    public void updateContentById(Integer id, String content) {
        Prize prize = prizeDao.findPrizeById(id);
        prize.setContent(content);
        this.prizeDao.save(prize);
    }

    @Override
    public void delete(Integer id) {
        prizeDao.deleteById(id);
    }
}
