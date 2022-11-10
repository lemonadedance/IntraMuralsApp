package com.uni.services;

import com.uni.daos.StatBasketballDAO;
import com.uni.daos.UserDAO;
import com.uni.dtos.PlayerCard;
import com.uni.entities.ImUser;
import com.uni.entities.StatBasketball;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticsServiceImpl implements StatisticsService{


    private StatBasketballDAO statBasketballDAO;
    private UserDAO userDAO;

    public StatisticsServiceImpl(StatBasketballDAO statBasketballDAO, UserDAO userDAO) {
        this.statBasketballDAO = statBasketballDAO;
        this.userDAO = userDAO;
    }

    @Override
    public PlayerCard getPlayerCardByUserId(int id) {
        ImUser user = this.userDAO.findById(id);
        List<StatBasketball> basketballStat = this.statBasketballDAO.findAll().stream().filter(t -> t.getUserId() == id).collect(Collectors.toList());

        PlayerCard playerCard = new PlayerCard();
        playerCard.setId(user.getUserId());
        playerCard.setUsername(user.getUsername());
        playerCard.setHeightInches(user.getHeightInches());
        playerCard.setWeightLbs(user.getWeightLbs());
        playerCard.setProfilePic(user.getProfilePic());
        playerCard.setHideBiometrics(user.isHideBiometrics());
        playerCard.setBasketballStats(basketballStat);

        return playerCard;
    }
}
