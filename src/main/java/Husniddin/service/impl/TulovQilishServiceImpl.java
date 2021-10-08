package Husniddin.service.impl;

import Husniddin.entity.*;
import Husniddin.repository.*;
import Husniddin.security.SecurityUtil;
import Husniddin.service.TulovQilishService;
import Husniddin.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TulovQilishServiceImpl implements TulovQilishService {
    @Autowired
    private TulovQilishRepo tulovQilishRepo;
    @Autowired
    private XabarRepo xabarRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private XabarTuriRepo xabarTuriRepo;
    @Autowired
    private BuyurmaRepo buyurmaRepo;
    @Autowired
    private PoliyaRepo poliyaRepo;
    @Autowired
    private MijozRepo mijozRepo;

    @Override
    public List<TulovQilish> getAll() throws Exception {
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        List<TulovQilish> tulovQilish1=null;
        if(user1!=null){
            if(user1.getId()==1){
                tulovQilish1=tulovQilishRepo.findAllByOrderByIdDesc();
            }
            if(user1.getId()!=1){
                tulovQilish1=tulovQilishRepo.findAllByOrderByIdDesc();
            }
        }
        else {
            tulovQilish1=null;
        }
        return tulovQilish1;
    }

    @Override
    public TulovQilish add(TulovQilish tulovQilish) throws Exception {
        /*String username = SecurityUtil.getCurrentUserLogin();
        List<TulovQilish> tulovBor= tulovQilishRepo.findAllByBuyurtmaId(tulovQilish.getBuyurtma().getId());
        Buyurtma buyurtma2=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
        User user=userRepository.findById(1l).get();
        Mijoz mijoz = mijozRepo.findById(buyurtma2.getMijoz().getId()).get();
        Poliya poliya = poliyaRepo.findById(buyurtma2.getPoliya().getId()).get();
        User poliyaUser=userRepository.findById(poliya.getUser().getId()).get();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        TulovQilish tulovQilish1=null;
        if(user1!=null){
                XabarTuri xabarTuri=null;
                String qisqaXabar="";
                if(tulovBor.toArray().length!=0){
                    TulovQilish oldingiTulov=tulovBor.get(0);
                    Buyurtma buyurtma1=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
                    Integer plastik=tulovQilish.getPlastik();
                    Integer naqd=tulovQilish.getNaqd();
                    Integer jami=plastik+naqd;
                    oldingiTulov.setNaqd(naqd);
                    oldingiTulov.setPlastik(plastik);
                    if(jami.equals(buyurtma1.getNarxi())){
                        Buyurtma buyurtmaOldingi=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
                        buyurtmaOldingi.setStatus(2);
                        buyurmaRepo.save(buyurtmaOldingi);
                        xabarTuri=xabarTuriRepo.findById(9l).get();
                        Date date = new Date();
                        qisqaXabar="To'lov to'liq qabul qilindi";
                        String tuliqXabar1="<b>Admin nomi:</b> "+poliyaUser.getUsername()+
                                "*+<b>Poliya nomi:</b> "+poliya.getNomi()+
                                "*+<b>Mijoz ismi:</b> "+mijoz.getIsm()+
                                "*+<b>Admin raqami:</b> "+poliyaUser.getNumber();
                        String tuliqXabar2="*+<b>To'langan summa:</b> "+jami+
                                " so'm*+<b>Naqd:</b> "+naqd+
                                " so'm*+<b>Plastik:</b> "+plastik+
                                "*+<b>Tulov vaqti:</b> "+date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        String tuliqXabar3 = "*+<b>Buyurtma haqida{</b> "+
                                "*+<b>Buyurtma sanasi:</b> "+buyurtmaOldingi.getSana()+
                                "*+<b>Boshlanish vaqti:</b> "+buyurtmaOldingi.getBoshlanishVaqti()+
                                ":00*+<b>Tugash vaqti:</b> "+buyurtmaOldingi.getTugashVaqti();
                        String tuliqXabar4 =":00*+<b>Buyurtma qabul qilingan vaqt:</b> "+buyurtmaOldingi.getBuyurtmaBerilganVaqti()+
                                "*+<b>Buyurtmaga izoh:</b> "+buyurtmaOldingi.getIzoh()+
                                "*+<b>Buyurtmaga bergan:</b> "+user1.getUsername();
                        xabarRepo.save(new Xabar(buyurtmaOldingi, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
                    }
                    else{
                        Buyurtma buyurtmaOldingi=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
                        buyurmaRepo.save(buyurtmaOldingi);
                        xabarTuri=xabarTuriRepo.findById(10l).get();
                        Date date = new Date();
                        qisqaXabar="Buyurtmaga "+jami+" so'm qabul qilindi";
                        String tuliqXabar1="<b>Admin nomi:</b> "+poliyaUser.getUsername()+
                                "*+<b>Poliya nomi:</b> "+poliya.getNomi()+
                                "*+<b>Mijoz ismi:</b> "+mijoz.getIsm()+
                                "*+<b>Admin raqami:</b> "+poliyaUser.getNumber();
                        String tuliqXabar2="*+<b>To'langan summa:</b> "+jami+
                                " so'm*+<b>Naqd:</b> "+naqd+
                                " so'm*+<b>Plastik:</b> "+plastik+
                                "*+<b>Tulov vaqti:</b> "+date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        String tuliqXabar3 = "*+<b>Buyurtma haqida{</b> "+
                                "*+<b>Buyurtma sanasi:</b> "+buyurtmaOldingi.getSana()+
                                "*+<b>Boshlanish vaqti:</b> "+buyurtmaOldingi.getBoshlanishVaqti()+
                                ":00*+<b>Tugash vaqti:</b> "+buyurtmaOldingi.getTugashVaqti();
                        String tuliqXabar4 =":00*+<b>Buyurtma qabul qilingan vaqt:</b> "+buyurtmaOldingi.getBuyurtmaBerilganVaqti()+
                                "*+<b>Buyurtmaga izoh:</b> "+buyurtmaOldingi.getIzoh()+
                                "*+<b>Buyurtmaga bergan:</b> "+user1.getUsername();
                        xabarRepo.save(new Xabar(buyurtmaOldingi, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1,LocalDateTime.now()));
                    }
                    tulovQilish1= tulovQilishRepo.save(oldingiTulov);
                }
                else{
                    Buyurtma buyurtma1=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
                    Integer jami=tulovQilish.getNaqd()+tulovQilish.getPlastik();
                    Integer plastik=tulovQilish.getPlastik();
                    Integer naqd=tulovQilish.getNaqd();
                    if(jami.equals(buyurtma1.getNarxi())){
                        Buyurtma buyurtmaOldingi=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
                        buyurtmaOldingi.setStatus(2);
                        buyurmaRepo.save(buyurtmaOldingi);
                        xabarTuri=xabarTuriRepo.findById(9l).get();
                        Date date = new Date();
                        qisqaXabar="To'lov to'liq qabul qilindi";
                        String tuliqXabar1="<b>Admin nomi:</b> "+poliyaUser.getUsername()+
                                "*+<b>Poliya nomi:</b> "+poliya.getNomi()+
                                "*+<b>Mijoz ismi:</b> "+mijoz.getIsm()+
                                "*+<b>Admin raqami:</b> "+poliyaUser.getNumber();
                        String tuliqXabar2="*+<b>To'langan summa:</b> "+jami+
                                " so'm*+<b>Naqd:</b> "+naqd+
                                " so'm*+<b>Plastik:</b> "+plastik+
                                "*+<b>Tulov vaqti:</b> "+date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        String tuliqXabar3 = "*+<b>Buyurtma haqida{:</b> "+
                                "*+<b>Buyurtma sanasi:</b> "+buyurtmaOldingi.getSana()+
                                 "*+<b>Boshlanish vaqti:</b> "+buyurtmaOldingi.getBoshlanishVaqti()+
                                ":00*+<b>Tugash vaqti:</b> "+buyurtmaOldingi.getTugashVaqti();
                        String tuliqXabar4 =":00*+<b>Buyurtma qabul qilingan vaqt:</b> "+buyurtmaOldingi.getBuyurtmaBerilganVaqti()+
                                "*+<b>Buyurtmaga izoh:</b> "+buyurtmaOldingi.getIzoh()+
                        "*+<b>Buyurtmaga bergan:</b> "+user1.getUsername();
                        ;
                        xabarRepo.save(new Xabar(buyurtmaOldingi, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
                    }
                    else{
                        Buyurtma buyurtmaOldingi=buyurmaRepo.findById(tulovQilish.getBuyurtma().getId()).get();
                        buyurmaRepo.save(buyurtmaOldingi);
                        xabarTuri=xabarTuriRepo.findById(10l).get();
                        Date date = new Date();
                        qisqaXabar="Buyurtmaga "+jami+" so'm qabul qilindi";
                        String tuliqXabar1="<b>Admin nomi:</b> "+poliyaUser.getUsername()+
                                "*+<b>Poliya nomi:</b> "+poliya.getNomi()+
                                "*+<b>Mijoz ismi:</b> "+mijoz.getIsm()+
                                "*+<b>Admin raqami:</b> "+poliyaUser.getNumber();
                        String tuliqXabar2="*+<b>To'langan summa:</b> "+jami+
                                " so'm*+<b>Naqd:</b> "+naqd+
                                " so'm*+<b>Plastik:</b> "+plastik+
                                "*+<b>Tulov vaqti:</b> "+date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        String tuliqXabar3= "*+<b>Buyurtma haqida{</b> "+
                                "*+<b>Buyurtma sanasi:</b> "+buyurtmaOldingi.getSana()+
                                "*+<b>Boshlanish vaqti:</b> "+buyurtmaOldingi.getBoshlanishVaqti()+
                                ":00*+<b>Tugash vaqti:</b> "+buyurtmaOldingi.getTugashVaqti();
                        String tuliqXabar4=":00*+<b>Buyurtma qabul qilingan vaqt:</b> "+buyurtmaOldingi.getBuyurtmaBerilganVaqti()+
                                "*+<b>Buyurtmaga izoh:</b> "+buyurtmaOldingi.getIzoh()+
                                "*+<b>Buyurtmaga bergan:</b> "+user1.getUsername();
                        xabarRepo.save(new Xabar(buyurtmaOldingi, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
                    }
                    tulovQilish1= tulovQilishRepo.save(tulovQilish);
                }
        }
        else {
            tulovQilish1=null;
        }
*/
        return null;
    }

    @Override
    public void update(TulovQilish tulovQilish) throws Exception {

    }

    @Override
    public void delete(TulovQilish tulovQilish) {
        deleteById(tulovQilish.getId());
    }

    @Override
    public void deleteById(Long aLong) {
       tulovQilishRepo.deleteById(aLong);
    }

    @Override
    public Optional<TulovQilish> getById(Long aLong) throws Exception {
        /*String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        Optional<TulovQilish> tulovQilish1=null;
        TulovQilish tulovQilish2=tulovQilishRepo.findById(aLong).get();
        Buyurtma buyurtma1=buyurmaRepo.findById(tulovQilish2.getBuyurtma().getId()).get();
        Poliya poliya1=poliyaRepo.findById(buyurtma1.getPoliya().getId()).get();
        if(user1!=null){
            if(user1.getId()==1 || user1.getId()==19){
                tulovQilish1=tulovQilishRepo.findById(aLong);
            }
            if(user1.getId().equals(poliya1.getUser().getId())){
                tulovQilish1=tulovQilishRepo.findById(aLong);
            }
        }
        else {
            tulovQilish1=null;
        }
        return tulovQilishRepo.findById(aLong);*/
        return null;
    }

    @Override
    public List<TulovQilish> getAllByBuyurtmaId(Long id) {
        return tulovQilishRepo.findAllByBuyurtmaId(id);
    }
}
