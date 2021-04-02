package com.mobiledocker.mobiledocker.service;

import com.mobiledocker.mobiledocker.entity.State;
import com.mobiledocker.mobiledocker.entity.co.StateCo;
import com.mobiledocker.mobiledocker.entity.co.StateEntity;
import com.mobiledocker.mobiledocker.entity.dto.StateDto;

import java.util.List;


public interface StateDaoService {
    public List<StateDto> findByCountry(int countryId);

    public List<StateEntity> findByCountryID(int countryId);

    public StateDto save(StateCo stateCo);

    public StateDto findByColumn(String countryId);

    public List<StateDto> findAll();

    /* for join result country or state brand series */
    public List<State> findByJoins();

    public List<StateDto> SearchKeyword(String query);

    public StateDto UpdateSeries(StateCo stateCo);

    public void updateFlag(int seriesId);
}
