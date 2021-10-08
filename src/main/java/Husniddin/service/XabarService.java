package Husniddin.service;


import Husniddin.entity.Xabar;

import java.time.LocalDate;
import java.util.List;

public interface XabarService extends PublicService<Xabar,Long>{
    public List<Xabar> getAllByXabarTuriIdGreaterThanEqualAndXabarTuriIdLessThanEqualOrderByIdDesc();
    public List<Xabar> getAllByXabarVaqtiBetweenOrderByIdDesc(LocalDate sana1);
    public Xabar oqildi(Long id);
}
