package com.uni.services;

import com.uni.entities.GameRequest;
import java.util.*;

public interface GameRequestService {

    GameRequest createRequest(GameRequest gameRequest);
    List<GameRequest> getAllGamesAndReferees();
}
