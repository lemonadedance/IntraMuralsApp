package com.uni.entities;

public class GameRequest {
    private int gameRequestId;
    private int gameId;
    private int userId;

    public GameRequest() {}

    public GameRequest(int gameRequestId, int gameId, int userId){
        this.gameRequestId = gameRequestId;
        this.gameId = gameId;
        this.userId = userId;

    }

    public int getGameRequestId() { return gameRequestId; }

    public void setGameRequestId(int gameRequestId) { this.gameRequestId = gameRequestId; }

    public int getGameId() { return gameId; }

    public void setGameId(int gameId) { this.gameId = gameId; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }


}
