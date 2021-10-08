package Husniddin.service;


import Husniddin.entity.Chiqim;

import java.util.List;

public interface ChiqimService extends PublicService<Chiqim,Long>{
    public List<Chiqim> getAllBySanaBetween();
    public List<Chiqim> getAllBySanaBetween(String sana1,String sana2);
    public List<Chiqim> getAllBySanaBetweenAndPoliya(String sana1,String sana2,Long id);
    public List<Chiqim> getAllBySanaBetweenWeek();
    public List<Chiqim> getAllBySanaBetweenToday();

}