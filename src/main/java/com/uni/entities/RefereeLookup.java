package com.uni.entities;

public class RefereeLookup {

    private int refereeLookUpId;
    private int gameRefereeId;
    private int gameId;

    public RefereeLookup(){
    }

    public RefereeLookup(int refereeLookUpId, int gameRefereeId, int gameId){
        this.refereeLookUpId = refereeLookUpId;
        this.gameRefereeId = gameRefereeId;
        this.gameId = gameId;
    }

    public void setRefereeLookUpId(int refereeLookUpId){ this.refereeLookUpId = refereeLookUpId; }

    public void setGameRefereeId(int gameRefereeId){ this.gameRefereeId = gameRefereeId; }
    public int getGameRefereeId(){ return gameRefereeId; }

    public int getGameId() { return gameId; }

    public void setGameId(int gameId) { this.gameId = gameId;}
}
