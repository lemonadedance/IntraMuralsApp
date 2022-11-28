package com.uni.services;

import com.uni.daos.RefereeLookupDAO;
import com.uni.entities.RefereeLookup;

import java.util.List;

public class RefereeLookupImpl implements RefereeLookupService {

    private RefereeLookupDAO refereeLookupDAO;

    public RefereeLookupImpl(RefereeLookupDAO refereeLookupDAO){
       this.refereeLookupDAO = refereeLookupDAO;
    }


    @Override
    public List<RefereeLookup> getAllGamesAndReferees() { return this.refereeLookupDAO.findAll(); }
}
