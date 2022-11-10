package com.uni.services;

import com.uni.dtos.PlayerCard;

public interface StatisticsService {

    PlayerCard getPlayerCardByUserId(int id);
}
