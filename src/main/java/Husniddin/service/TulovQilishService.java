package Husniddin.service;


import Husniddin.entity.TulovQilish;

import java.util.List;

public interface TulovQilishService  extends PublicService<TulovQilish,Long>{
    public List<TulovQilish> getAllByBuyurtmaId(Long id);
}
