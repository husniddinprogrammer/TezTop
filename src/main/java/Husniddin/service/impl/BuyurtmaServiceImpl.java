package Husniddin.service.impl;


import Husniddin.service.BuyurtmaService;
import Husniddin.entity.*;
import Husniddin.repository.*;
import Husniddin.security.SecurityUtil;
import Husniddin.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BuyurtmaServiceImpl implements BuyurtmaService {
    @Autowired
    private BuyurmaRepo buyurtmaRepo;
    @Autowired
    private XabarRepo xabarRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private XabarTuriRepo xabarTuriRepo;
    @Autowired
    private PoliyaRepo poliyaRepo;
    @Autowired
    private MijozRepo mijozRepo;
    @Override
    public List<Buyurtma> getAll() {
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        List<Buyurtma> buyurtma1=null;
        if(user1!=null){
            if(user1.getId()==1 || user1.getId()==19){
                buyurtma1=buyurtmaRepo.findAllByOrderByIdDesc();
            }
            if(user1.getId()!=1  && user1.getId()!=19){
                buyurtma1=buyurtmaRepo.findAllByPoliyaBoshliqIdOrderByIdDesc(user1.getId());
            }
        }
        else {
            buyurtma1=null;
        }
        return buyurtma1;
    }
    @Override
    public Buyurtma add(Buyurtma buyurtma) throws Exception {
        /*String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        Buyurtma buyurtma1=null;
        buyurtma.setBuyurtmaBerilganVaqti(LocalDateTime.now());
        if(user1!=null){
                buyurtma1=buyurtmaRepo.save(buyurtma);
                Buyurtma buyurtma2=buyurtmaRepo.findById(buyurtma1.getId()).get();
                User user=userRepository.findById(1l).get();
                Mijoz mijoz = mijozRepo.findById(buyurtma2.getMijoz().getId()).get();
                Poliya poliya = poliyaRepo.findById(buyurtma2.getPoliya().getId()).get();
                User poliyaUser=userRepository.findById(poliya.getUser().getId()).get();
                XabarTuri xabarTuri=null;
                String qisqaXabar="";
                if(buyurtma2.getNarxi().equals(poliya.getNarxi())){
                    xabarTuri=xabarTuriRepo.findById(2l).get();
                    qisqaXabar="Buyurtma to'liq qabul qilindi.";
                }
                if(buyurtma2.getNarxi().equals(0)){
                    xabarTuri=xabarTuriRepo.findById(3l).get();
                    qisqaXabar="Buyurtma bepul qabul qilindi.";
                }
                if((buyurtma2.getNarxi()<poliya.getNarxi()) && buyurtma2.getNarxi()!=0){
                    xabarTuri=xabarTuriRepo.findById(4l).get();
                    Integer masofasi=poliya.getNarxi()-buyurtma2.getNarxi();
                    qisqaXabar="Buyurtma poliya narxidan"+masofasi+" so'm kam qabul qilindi.";
                }

                if((buyurtma2.getNarxi()>poliya.getNarxi()) && buyurtma2.getNarxi()!=0){
                    Integer masofasi=buyurtma2.getNarxi()-poliya.getNarxi();
                    xabarTuri=xabarTuriRepo.findById(5l).get();
                    qisqaXabar="Buyurtma poliya narxidan"+masofasi+" so'm ko'p qabul qilindi.";
                }
                String tuliqXabar1="<b>Admin:</b> "+poliyaUser.getUsername()+
                        "*+<b>Poliya:</b> "+poliya.getNomi()+
                        "*+<b>Mijoz ism:</b> "+mijoz.getIsm()+
                        "*+<b>Mijoz nomeri:</b> "+mijoz.getNomer();
                String tuliqXabar2= "*+<b>Poliya narxi:</b> "+poliya.getNarxi()+
                                "*+<b>Buyurtma berilgan narxi:</b> "+buyurtma2.getNarxi()+
                                "*+<b>Buyurtma berilgan sana:</b> "+buyurtma2.getSana();
                String tuliqXabar3 = "*+<b>Boshlanish vaqti:</b> "+buyurtma2.getBoshlanishVaqti()+
                        ":00*+<b>Tugash vaqti:</b> "+buyurtma2.getTugashVaqti()+
                        ":00*+<b>Buyurtma qabul qilingan vaqt:</b> "+buyurtma2.getBuyurtmaBerilganVaqti()+
                        "*+<b>Admin nomeri:</b> "+poliyaUser.getNumber();
                String tuliqXabar4="*+<b>Buyurtmaga izoh:</b> "+buyurtma2.getIzoh()+
                                "*+<b>Buyurtmaga bergan:</b> "+user1.getUsername();
                Date date = new Date();
                xabarRepo.save(new Xabar(buyurtma1, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
        }
        else {
            buyurtma1=null;
        }
                return buyurtma1;*/
        return null;
    }

    @Override
    public void update(Buyurtma buyurtma) throws Exception {
        buyurtmaRepo.save(buyurtma);
    }

    @Override
    public void delete(Buyurtma buyurtma) {
        deleteById(buyurtma.getId());
    }

    @Override
    public void deleteById(Long id) {
        buyurtmaRepo.deleteById(id);
    }


    @Override
    public Optional<Buyurtma> getById(Long id) throws Exception {
                return buyurtmaRepo.findById(id);
    }

    @Override
    public List<Buyurtma> getAllByPoliyaAndAktivAndSana(Long poliya, LocalDate sana, LocalDate sana7Next) {
        return buyurtmaRepo.findAllByPoliyaIdAndStatusGreaterThanEqualAndStatusLessThanEqualAndSanaBetween(poliya,1,2,sana,sana7Next);
    }

    @Override
    public List<Buyurtma> getAllBySanaBetween() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.setTime(date);
        c1.setTime(date);
        c.add(Calendar.MONTH,-1);
        return  buyurtmaRepo.findAllBySanaBetween(LocalDate.parse(formatter.format(c.getTime())),LocalDate.parse(formatter.format(c1.getTime())));
    }

    @Override
    public List<Buyurtma> getAllBySanaBetween(String sana1, String sana2) {
        return  buyurtmaRepo.findAllBySanaBetween(LocalDate.parse(sana1),LocalDate.parse(sana2));
    }

    @Override
    public List<Buyurtma> getAllBySanaBetweenAndPoliyaId(String sana1, String sana2, Long id) {
        return buyurtmaRepo.findAllBySanaBetweenAndPoliyaId(LocalDate.parse(sana1), LocalDate.parse(sana2),id);
    }

    @Override
    public List<Buyurtma> getAllBySanaBetweenWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.setTime(date);
        c1.setTime(date);
        c.add(Calendar.DATE,-7);
        return  buyurtmaRepo.findAllBySanaBetween(LocalDate.parse(formatter.format(c.getTime())),LocalDate.parse(formatter.format(c1.getTime())));
    }
    @Override
    public List<Buyurtma> getAllBySanaBetweenToday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.setTime(date);
        c1.setTime(date);
        return  buyurtmaRepo.findAllBySanaBetween(LocalDate.parse(formatter.format(c.getTime())),LocalDate.parse(formatter.format(c1.getTime())));
    }

    @Override
    public Buyurtma getBekorQilish(Long id) {
        /*String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        Buyurtma buyurtma1=null;
        if(user1!=null){
            Buyurtma buyurtma2=buyurtmaRepo.findById(id).get();
            Poliya poliya=poliyaRepo.findById(buyurtma2.getPoliya().getId()).get();
            User user33=poliya.getUser();
            if(user1.getId()==1 || user1.getId()==19){
                buyurtma1=buyurtma2;
                buyurtma1.setStatus(0);
                buyurtma1=buyurtmaRepo.save(buyurtma1);
            }
            if(user1.getId().equals(user33.getId())){
                buyurtma1=buyurtma2;
                buyurtma1.setStatus(0);
                buyurtma1=buyurtmaRepo.save(buyurtma1);
            }
            User user=userRepository.findById(1l).get();
            Mijoz mijoz = mijozRepo.findById(buyurtma2.getMijoz().getId()).get();
            User poliyaUser=userRepository.findById(poliya.getUser().getId()).get();
            XabarTuri xabarTuri=xabarTuriRepo.findById(16l).get();
            String qisqaXabar="Buyurtma bekor qilindi.";
            String tuliqXabar1="<b>Admin:</b> "+poliyaUser.getUsername()+
                    "*+<b>Poliya:</b> "+poliya.getNomi()+
                    "*+<b>Mijoz ism:</b> "+mijoz.getIsm()+
                    "*+<b>Mijoz nomeri:</b> "+mijoz.getNomer();
            String tuliqXabar2="*+<b>Poliya narxi:</b> "+poliya.getNarxi()+
                    "*+<b>Buyurtma berilgan narxi:</b> "+buyurtma2.getNarxi()+
                    "*+<b>Buyurtma berilgan sana:</b> "+buyurtma2.getSana();
            String tuliqXabar3 = "*+<b>Boshlanish vaqti:</b> "+buyurtma2.getBoshlanishVaqti()+
                    ":00*+<b>Tugash vaqti:</b> "+buyurtma2.getTugashVaqti()+
                    ":00*+<b>Buyurtma qabul qilingan vaqt:</b> "+buyurtma2.getBuyurtmaBerilganVaqti();
            String tuliqXabar4="*+<b>Admin nomeri:</b> "+poliyaUser.getNumber()+
                    "*+<b>Buyurtmaga izoh:</b> "+buyurtma2.getIzoh()+
                    "*+<b>Buyurtmaga bergan:</b> "+user1.getUsername();
            xabarRepo.save(new Xabar(buyurtma1, qisqaXabar, user, xabarTuri, tuliqXabar1,tuliqXabar2,tuliqXabar3,tuliqXabar4, 1, LocalDateTime.now()));
        }
        else {
            buyurtma1=null;
        }
        return  buyurtma1;*/
        return null;
    }

    @Override
    public List<Buyurtma> getAllByBuyurtmaBerilganVaqtiBetweenOrderByIdDesc(LocalDate sana1) {
        LocalDateTime kun1=sana1.atTime(0,0,0,0);
        String username = SecurityUtil.getCurrentUserLogin();
        UserDTO user1=userRepository.findByUsername(username).map(UserDTO::new).orElse(null);
        List<Buyurtma> buyurtma1=null;
        if(user1!=null){
            if(user1.getId()==1 || user1.getId()==19){
                buyurtma1=buyurtmaRepo.findAllByBuyurtmaBerilganVaqtiBetweenOrderByIdDesc(kun1,kun1.plusDays(1));;
            }
            if(user1.getId()!=1  && user1.getId()!=19){
                buyurtma1=buyurtmaRepo.findAllByBuyurtmaBerilganVaqtiBetweenAndPoliyaBoshliqIdOrderByIdDesc(kun1,kun1.plusDays(1),user1.getId());
            }
        }
        else {
            buyurtma1=null;
        }
        return buyurtma1;
    }
}
