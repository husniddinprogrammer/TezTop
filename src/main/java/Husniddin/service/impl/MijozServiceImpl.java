package Husniddin.service.impl;

import Husniddin.entity.*;
import Husniddin.repository.MijozRepo;
import Husniddin.repository.UserRepository;
import Husniddin.repository.XabarRepo;
import Husniddin.repository.XabarTuriRepo;
import Husniddin.security.SecurityUtil;
import Husniddin.service.MijozService;
import Husniddin.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MijozServiceImpl implements MijozService {
    @Autowired
    private MijozRepo mijozRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private XabarRepo xabarRepo;
    @Autowired
    private XabarTuriRepo xabarTuriRepo;
    @Override
    public List<Mijoz> getAll() throws Exception {
        LocalDate sana1=LocalDate.now();
        LocalDateTime kun1=sana1.atTime(0,0,0,0);
        return mijozRepo.findAllByQushilganVaqtBetweenOrderByIdDesc(kun1.minusDays(7),kun1.plusDays(1));
    }

    @Override
    public Mijoz add(Mijoz mijoz) throws Exception {
        /*mijoz.setQushilganVaqt(LocalDateTime.now());
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        if(mijoz.getId() == null){
            User user=userRepository.findById(1l).get();
            XabarTuri xabarTuri=xabarTuriRepo.findById(14l).get();
            String qisqaXabar="Mijoz qushildi.";
            String tuliqXabar1="<b>Mijoz ismi:</b> "+mijoz.getIsm()+
                    "*+<b>Mijoz nomeri:</b> "+mijoz.getNomer();
            String tuliqXabar2 ="*+<b>Mijoz yozilgan izoh:</b> "+mijoz.getIzoh()+
                            "*+<b>Qo'shgan odam:</b> "+user1.getUsername();
            String tuliqXabar3="";
            String tuliqXabar4="";
            xabarRepo.save(new Xabar(null, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
            return mijozRepo.save(mijoz);
        }
            else{
            throw new RuntimeException("Yangi a'zo id bulmasligi kerak");
        }*/
        return null;
    }

    @Override
    public void update(Mijoz mijoz) throws Exception {
          mijozRepo.save(mijoz);
     }

    @Override
    public void delete(Mijoz mijoz) {
        deleteById(mijoz.getId());
    }

    @Override
    public void deleteById(Long id) {
        mijozRepo.deleteById(id);
    }

    @Override
    public Optional<Mijoz> getById(Long id) throws Exception {
        return mijozRepo.findById(id);
    }

    @Override
    public Mijoz getBekorQilish(Long id) {
        /*Mijoz mijoz=mijozRepo.getById(id);
        mijoz.setStatus(0);
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
            User user=userRepository.findById(1l).get();
            XabarTuri xabarTuri=xabarTuriRepo.findById(15l).get();
            String qisqaXabar="Mijoz o'chirildi.";
            String tuliqXabar1="<b>Mijoz ismi:</b> "+mijoz.getIsm()+
                    "*+<b>Mijoz nomeri:</b> "+mijoz.getNomer();
            String tuliqXabar2 ="*+<b>Mijoz yozilgan izoh:</b> "+mijoz.getIzoh()+
                            "*+<b>O'chirgan odam:</b> "+user1.getUsername();
            String tuliqXabar3="";
            String tuliqXabar4="";
            xabarRepo.save(new Xabar(null, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
        return  mijozRepo.save(mijoz);*/
        return null;
    }

    @Override
    public List<Mijoz> getAllByQushilganVaqtBetweenOrderByIdDesc(LocalDate sana1) {
        LocalDateTime kun1=sana1.atTime(0,0,0,0);
        return mijozRepo.findAllByQushilganVaqtBetweenOrderByIdDesc(kun1,kun1.plusDays(1));
    }

    @Override
    public List<Mijoz> getAllByQushilganVaqtBetweenOrderByIdDescWeek(LocalDate sana1) {
        LocalDateTime kun1=sana1.atTime(0,0,0,0);
        return mijozRepo.findAllByQushilganVaqtBetweenOrderByIdDesc(kun1.minusDays(7),kun1);
    }
}
