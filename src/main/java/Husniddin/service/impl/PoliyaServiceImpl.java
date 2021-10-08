package Husniddin.service.impl;


import Husniddin.entity.Poliya;
import Husniddin.repository.PoliyaRepo;
import Husniddin.repository.UserRepository;
import Husniddin.repository.XabarRepo;
import Husniddin.repository.XabarTuriRepo;
import Husniddin.security.SecurityUtil;
import Husniddin.service.PoliyaService;
import Husniddin.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliyaServiceImpl implements PoliyaService {
    @Autowired
    private PoliyaRepo poliyaRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private XabarRepo xabarRepo;
    @Autowired
    private XabarTuriRepo xabarTuriRepo;
    @Override
    public List<Poliya> getAll() throws Exception {
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        List<Poliya> poliya1=null;
        if(user1!=null){
            if(user1.getId()==1 || user1.getId()==19){
                poliya1=poliyaRepo.findAllByOrderById();
            }
            if(user1.getId()!=1 && user1.getId()!=19){
                poliya1=poliyaRepo.findAllByBoshliqId(user1.getId());
            }
        }
        else {
            poliya1=null;
        }
        return poliya1;
    }
    @Override
    public List<Poliya> getAllPeople() throws Exception {
        List<Poliya> poliya1=poliyaRepo.findAll();
        return poliya1;
    }

    @Override
    public Poliya add(Poliya poliya) throws Exception {
/*        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
            User user=userRepository.findById(1l).get();
            XabarTuri xabarTuri=xabarTuriRepo.findById(17l).get();
            User poliyaUser=userRepository.findById(poliya.getUser().getId()).get();
            String qisqaXabar="";
                qisqaXabar="Poliyaga oid.";
            String tuliqXabar1="<b>Poliya nomi:</b> "+poliya.getNomi()+
                    "*+<b>Poliya narxi:</b> "+poliya.getNarxi()+
                    "*+<b>Poliya manzili:</b> "+poliya.getManzil();
            String tuliqXabar2 ="*+<b>Poliya admini:</b> "+poliyaUser.getUsername()+
                            "*+<b>Poliya admin nomeri:</b> "+poliyaUser.getNumber()+
                            "*+<b>Poliya qo'shgan odam:</b> "+user1.getUsername();
            String tuliqXabar3="";
            String tuliqXabar4="";
            xabarRepo.save(new Xabar(null, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
            return poliyaRepo.save(poliya);*/
        return null;
    }

    @Override
    public void update(Poliya poliya){
         poliyaRepo.save(poliya);
    }

    @Override
    public void delete(Poliya poliya) {
        deleteById(poliya.getId());
    }

    @Override
    public void deleteById(Long id) {
        poliyaRepo.deleteById(id);
    }

    @Override
    public Optional<Poliya> getById(Long id) throws Exception {
        return poliyaRepo.findById(id);
    }

    @Override
    public Poliya getBekorQilish(Long id) {
        /*Poliya poliya=poliyaRepo.findById(id).get();
        poliya.setStatus(0);
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        User user=userRepository.findById(1l).get();
        XabarTuri xabarTuri=xabarTuriRepo.findById(17l).get();
        User poliyaUser=userRepository.findById(poliya.getUser().getId()).get();
        String qisqaXabar="Poliya o'chirildi.";
        String tuliqXabar1="<b>Poliya nomi:</b> "+poliya.getNomi()+
                "*+<b>Poliya narxi:</b> "+poliya.getNarxi()+
                "*+<b>Poliya manzili:</b> "+poliya.getManzil();
        String tuliqXabar2 = "*+<b>Poliya admini:</b> "+poliyaUser.getUsername()+
                "*+<b>Poliya admin nomeri:</b> "+poliyaUser.getNumber()+
                "*+<b>Poliya o'chirgan odam:</b> "+user1.getUsername();
        String tuliqXabar3="";
        String tuliqXabar4="";
        xabarRepo.save(new Xabar(null, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
        return  poliyaRepo.save(poliya);*/
        return null;
    }
}
