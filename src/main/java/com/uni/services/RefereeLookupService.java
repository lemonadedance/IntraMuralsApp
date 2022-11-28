package com.uni.services;

import com.uni.entities.Game;
import com.uni.entities.ImUser;
import com.uni.entities.RefereeLookup;

import java.util.List;

public interface RefereeLookupService {

    List<RefereeLookup> getAllGamesAndReferees();

}
