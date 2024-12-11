package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.entity.MtResort;

import java.util.List;

public interface MtResortDAO {
    void addMtResort(MtResort MtResort);

    List<MtResort> getMtResorts();

    void updateMtResort(MtResort MtResort);

    void deleteMtResort(int MtResortId);
}
