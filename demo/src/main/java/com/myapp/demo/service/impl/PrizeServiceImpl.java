package com.myapp.demo.service.impl;

import com.myapp.demo.dao.IPrizeDao;
import com.myapp.demo.entity.Prize;
import com.myapp.demo.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class PrizeServiceImpl implements IPrizeService {

    @Autowired
    private IPrizeDao prizeDao;

    @Override
    public Prize getPrizeById(Integer id) {
        return prizeDao.findPrizeById(id);
    }

    @Override
    public List<Prize> getAllPrize() {
        return prizeDao.findAll();
    }

    @Override
    public List<Prize> getAccessiblePrize(Integer step) {
        return prizeDao.findByStepNeedLessThanEqualOrderByStepNeedAsc(step);
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
